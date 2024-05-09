package com.example.demo.util.csv;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class CsvUtil {
    public static List<String> leerArchivo(File archivo) {
        List<String> lista = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(archivo)))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // procesar cada línea según la estructura de tu CSV
                // Aquí, simplemente agregamos la línea completa a la lista
                lista.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
