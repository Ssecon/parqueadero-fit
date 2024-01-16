package com.fit.parqueadero.dto.updatevehicle;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class UpdateVehicleRequest {

    private String color;

    private String marca;

    private String dueño;

    private String modelo;
}
