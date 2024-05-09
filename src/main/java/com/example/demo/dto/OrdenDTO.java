package com.example.demo.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class OrdenDTO {
    private String numeroOrden;
    private Integer idEvent;

    public OrdenDTO() {
        // Constructor por defecto necesario para la deserialización de Jackson
    }
}
