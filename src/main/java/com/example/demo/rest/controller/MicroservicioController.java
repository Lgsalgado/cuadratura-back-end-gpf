package com.example.demo.rest.controller;

import com.example.demo.dto.OrdenDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.rest.service.KeycloakServiceImpl;
import com.example.demo.rest.service.MicroservicioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;




@RestController
@RequestMapping("/api")
public class MicroservicioController {

    private final MicroservicioService microservicioService;
    //private final KeycloakProvider keycloakProvider;

    @Autowired
    private KeycloakServiceImpl keycloakService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserDTO userDTO) {
        return keycloakService.loginUser(userDTO);
    }

    @PostMapping("/searchOrdersError")
    public String buscarOrdenesError(@RequestParam   String fechaInicio
                                           //@RequestBody  String fechaFin
                                           ) {
        System.out.println("Ingreso aqui a buscar");
        return "microservicioService.cuadratura();";}
    @GetMapping("/hello-1")
    @PreAuthorize("hasRole('admin_client_role')")
    public String helloAdmin(){

        return "Hello Sprig Boot With Keycloak with ADMIN";
    }

    @Autowired
    public MicroservicioController(MicroservicioService microservicioService) {
        this.microservicioService = microservicioService;
    }

    @PostMapping("/procesar-archivos")
    public List<String> procesarArchivos() {return microservicioService.cuadratura();}


    @GetMapping("/loginFacturador")
    public Object hacerSolicitud() {
        return microservicioService.loginFacturador();
    }

    @GetMapping("/servidor")
    //@PreAuthorize("hasRole('admin_client_role')")
    public Object servidor() {
        return microservicioService.servidor();
    }
    //buscar orden

    @PostMapping ("/search")
    public Object search(@RequestBody  String numeroOrden) throws JsonProcessingException {

        UserDTO login= microservicioService.loginFacturador();
        if(login != null){
           login.setOrden(numeroOrden);
        }
        return microservicioService.search(login);}

    // cuadratura OMS vs Salesforce

    @PostMapping("/procesar-orden")
    public ResponseEntity<List<String>> procesarOrdenFacturador(@RequestPart("orden") MultipartFile orden){List<String> resultado = microservicioService.cuadratura();
        return ResponseEntity.ok(resultado);}

    //procesar ordenes quedadas facturador
    @PostMapping("/reinject")
    public String reinject(@RequestBody OrdenDTO orden) {
        return microservicioService.reinject(orden.getNumeroOrden(),orden.getIdEvent());}
}