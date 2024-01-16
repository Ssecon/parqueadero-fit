package com.fit.parqueadero.converter;

import com.fit.parqueadero.dto.createvehicle.CreateVehicleRequest;
import com.fit.parqueadero.entity.VehiculoEntity;

import java.time.LocalDateTime;

public class VehiculoConverter {

    public static VehiculoEntity generateVehiculoEntity(CreateVehicleRequest createVehicleRequest,
                                                        LocalDateTime horaEntrada){
        VehiculoEntity response = VehiculoEntity.builder()
                .color(createVehicleRequest.getColor())
                .dueño(createVehicleRequest.getDueño())
                .patente(createVehicleRequest.getPatente())
                .marca(createVehicleRequest.getMarca())
                .modelo(createVehicleRequest.getModelo())
                .horaEntrada(horaEntrada)
                .build();

        return response;
    }
}
