package com.fit.parqueadero.dto.createvehicle;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CreateVehicleRequest {

    private String patente;
    private String color;
    private String marca;
    private String dueño;
    private String modelo;

}
