package com.example.demo.rest.service;
import com.example.demo.util.csv.CsvUtil;
import com.example.demo.dto.DocumentoDTO;
import com.example.demo.dto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class MicroservicioService {
    @Value("${var.reinject}")
    private String reinject;
    @Value("${var.user}")
    private String user;
    @Value("${var.password}")
    private String password;
    @Value("${var.token}")
    private String token;
    @Value("${var.archivo1}")
    private String prueba1;
    @Value("${var.archivo2}")
    private String prueba2;
    @Value("${var.ruta-cuadratura-salesforce}")
    private String ruta;
    private final String URL_DEL_OTRO_MICROSERVICIO = "https://facturadorbackend.socoomni.com/MTDServices/";

    private final RestTemplate restTemplate;
    @Autowired
    private SshService sshService;

    public MicroservicioService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    //Procesar Orden Facturador


    //cuadratura Salesforce vs OMS
    public List<String> cuadratura(){
        // 1. Especifica el directorio donde se encuentran los archivos
        String directorioPath = ruta;
        System.out.println(ruta);
        // 4. Obtener los archivos correspondientes
        File archivo1 = new File(directorioPath, prueba1);
        File archivo2 = new File(directorioPath, prueba2);
        // 2. Leer y procesar los archivos CSV
        List<String> lista1 = CsvUtil.leerArchivo(archivo1);
        List<String> lista2 = CsvUtil.leerArchivo(archivo2);
        // 3. Comparar las listas y encontrar elementos que no se encuentran en la segunda lista
        List<String> busqueda = compararListas(lista1, lista2);
        // 4. Enviar la respuesta al frontend de Angular
        return busqueda;
    }
    //función para comparar las dos listas
    private List<String> compararListas(List<String> lista1, List<String> lista2) {
        Set<String> conjuntoLista2 = new HashSet<>(lista2);
        // Lista para almacenar los elementos no encontrados
        List<String> noEncontrados = new ArrayList<>();

        // Itera sobre la lista1 y verifica si cada elemento está en el conjuntoLista2
        for (String elemento : lista1) {
            if (!conjuntoLista2.contains(elemento)) {
                noEncontrados.add(elemento);
            }
        }
        System.out.println(noEncontrados.size());
        return noEncontrados;
    }
    //REinyectar ordenes quedadas
    public String reinject(String orden, Integer idEvent){
        String jsonBody = "{\n" +
                "  \"trxHdr\": {\n" +
                "    \"version\": \"1.0\",\n" +
                "    \"context\": {\n" +
                "      \"idCompany\": \"DIFARMA\",\n" +
                "      \"idCountry\": \"EC\",\n" +
                "      \"idStore\": \"FYBECA\",\n" +
                "      \"idChannel\": \"OMS\"\n" +
                "    },\n" +
                "    \"trxClientExecDate\": \"{{CURRENT_TIME}}\"\n" +
                "  },\n" +
                "  \"trxIdentify\": {\n" +
                "    \"orderType\": 1,\n" +
                "    \"idOrder\": \"" + orden + "\",\n" +
                "    \"idEvent\": " + (idEvent!=null? idEvent:"null") + "\n" +
                "  },\n" +
                "  \"trxInject\": {\n" +
                "    \"type\": \"CONTINUE\",\n" +
                "    \"origin\": \"Informar_POS\"\n" +
                "  }\n" +
                "}";
        // Configurar el encabezado para indicar que estamos enviando JSON
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("8f2c4087cd5d9ba126c6be31a3dcf575", "");
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);
        String respuesta = restTemplate.postForObject(reinject, requestEntity, String.class);
        return respuesta;
    }
    //conectar servidor
    public Object servidor(){
        //sshService.establishSshConnection();
        // Ejecutar un comando remoto (por ejemplo, obtener el nombre del sistema)
        String result = sshService.executeRemoteCommand("uname -a");
        return result;
    }
    //login facturador digital
    public UserDTO loginFacturador() {
        // Configurar el encabezado para indicar que estamos enviando JSON
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // Crear el cuerpo de la solicitud con el JSON
        String jsonBody = "{ \"user\": \""+user+"\", \"password\": \""+password+"\", \"cadena\": \"4\" }";
        //{ "user": "lgsalgados", "password": "Zarita2013", "cadena": "4" }
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);

        // Realizar la solicitud POST al otro microservicio
        UserDTO respuesta = restTemplate.postForObject(URL_DEL_OTRO_MICROSERVICIO+"auth", requestEntity, UserDTO.class);
        // Puedes procesar la respuesta según tus necesidades
        // Por ahora, simplemente la devolveremos
        return respuesta;
    }
    //buscar orden
    public Object search(UserDTO user) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Configurar el encabezado para indicar que estamos enviando JSON
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Auth", user.getToken());
        // Objeto JSON que se enviará en el cuerpo de la solicitud
        String jsonRequest = "{ \"idStore\": \"4\", \"dni\": \"\", \"orderNumber\": \""+user.getOrden()+"\", \"documentType\": \"todos\", \"documentNumber\": \"\", \"customer\": \"\", \"status\": \"todos\", \"sinceDate\": null, \"untilDate\": null }";
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequest, headers);
        UserDTO respuesta = restTemplate.postForObject(URL_DEL_OTRO_MICROSERVICIO+"orders/search", requestEntity, UserDTO.class);
        //System.out.println(respuesta.getMessage());
        DocumentoDTO[] invoices = objectMapper.readValue(respuesta.getMessage(), DocumentoDTO[].class);
        // Assuming there's only one element in the array
        int idPrcinstance = invoices[0].getLastInvoice().getIdPrcinstance();

        return idPrcinstance;
    }
    //

}