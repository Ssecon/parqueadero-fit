package com.fit.parqueadero.service.impl;

import com.fit.parqueadero.converter.VehiculoConverter;
import com.fit.parqueadero.dto.createvehicle.CreateVehicleRequest;
import com.fit.parqueadero.dto.createvehicle.CreateVehicleResponse;
import com.fit.parqueadero.entity.VehiculoEntity;
import com.fit.parqueadero.repository.VehiculoInfoRepository;
import com.fit.parqueadero.service.CreateVehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Slf4j
@Service
public class CreateVehicleServiceImpl implements CreateVehicleService {

    private final String OK_MESSAGE = "Se creó el vehiculo correctamente.";
    private final String CREATION_ERROR = "Ocurrio un error al insertar el registro en la base de datos.";
    public CreateVehicleServiceImpl(VehiculoInfoRepository vehiculoInfoRepository) {
        this.vehiculoInfoRepository = vehiculoInfoRepository;
    }

    VehiculoInfoRepository vehiculoInfoRepository;
    @Override
    public CreateVehicleResponse createVehicle(CreateVehicleRequest createVehicleRequest) {
        log.info("Comienza la ejecucion del metodo createVehicle. Request: {}", createVehicleRequest);
        LocalDateTime horaEntrada = LocalDateTime.now();
        VehiculoEntity vehiculoEntity = VehiculoConverter.generateVehiculoEntity(createVehicleRequest, horaEntrada);
        log.info("Se genera el siguiente vehiculoEntity: {}", vehiculoEntity);
        try {
            vehiculoInfoRepository.save(vehiculoEntity);
            log.info("Se inserto el vehiculo de patente {} correctamente!", createVehicleRequest.getPatente());
        } catch (Exception e){
            log.error("Ocurrio un error al insertar el registro en la base de datos. Error: {}",e.getMessage());
            return new CreateVehicleResponse(CREATION_ERROR);
        }
        return new CreateVehicleResponse(OK_MESSAGE);
    }
}
