package com.example.Seguimiento_Reguimen.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class FacturaDTO {

    private Long Id;

    private LocalDateTime fecha;
}
