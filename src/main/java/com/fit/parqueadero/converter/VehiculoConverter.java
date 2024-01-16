package com.fit.parqueadero.converter;

import com.fit.parqueadero.dto.createvehicle.CreateVehicleRequest;
import com.fit.parqueadero.dto.findvehicle.VehicleDto;
import com.fit.parqueadero.entity.VehiculoEntity;

import java.time.LocalDateTime;

public class VehiculoConverter {

    public static VehiculoEntity generateVehiculoEntity(CreateVehicleRequest createVehicleRequest,
                                                        LocalDateTime horaEntrada){
        VehiculoEntity response =  new VehiculoEntity();
        response.setColor(createVehicleRequest.getColor());
        response.setDueño(createVehicleRequest.getDueño());
        response.setPatente(createVehicleRequest.getPatente());
        response.setMarca(createVehicleRequest.getMarca());
        response.setModelo(createVehicleRequest.getModelo());
        response.setHoraEntrada(horaEntrada);
        return response;
    }

    public static VehicleDto generateVehiculoDto(VehiculoEntity vehiculoEntity){
        VehicleDto response = new VehicleDto();
        response.setColor(vehiculoEntity.getColor());
        response.setDueño(vehiculoEntity.getDueño());
        response.setPatente(vehiculoEntity.getPatente());
        response.setMarca(vehiculoEntity.getMarca());
        response.setModelo(vehiculoEntity.getModelo());
        response.setHoraEntrada(vehiculoEntity.getHoraEntrada());
        response.setId(vehiculoEntity.getId());

        return response;
    }

}
