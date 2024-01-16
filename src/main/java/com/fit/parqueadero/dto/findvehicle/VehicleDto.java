package com.fit.parqueadero.dto.findvehicle;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VehicleDto {


    private Long id;
    private String patente;
    private String color;
    private String marca;
    private String dueño;
    private String modelo;
    private LocalDateTime horaEntrada;

}
