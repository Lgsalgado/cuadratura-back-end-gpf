package com.example.demo.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {

    @GetMapping("/prueba")
    public String retornaMensaje()
    {
        return "Mensaje de Prueba";

    }

}
