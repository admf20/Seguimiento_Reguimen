package com.example.Seguimiento_Reguimen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/factura")
public class FacturaController {

    @GetMapping("/example")
    public String example(){
        return "Ruta de prueba";
    }
}
