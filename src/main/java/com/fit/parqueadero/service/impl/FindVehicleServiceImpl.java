package com.fit.parqueadero.service.impl;

import com.fit.parqueadero.converter.VehiculoConverter;
import com.fit.parqueadero.dto.findvehicle.VehicleDto;
import com.fit.parqueadero.entity.VehiculoEntity;
import com.fit.parqueadero.repository.VehiculoInfoRepository;
import com.fit.parqueadero.service.FindVehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FindVehicleServiceImpl implements FindVehicleService {

    public FindVehicleServiceImpl(VehiculoInfoRepository vehiculoInfoRepository) {
        this.vehiculoInfoRepository = vehiculoInfoRepository;
    }

    VehiculoInfoRepository vehiculoInfoRepository;
    @Override
    public Optional<VehicleDto> getVehicleByPatente(String patente) {
        log.info("Comienza la ejecución del metodo getVehicleByPatente. Patente: {}", patente);

        Optional<VehiculoEntity> vehicle = vehiculoInfoRepository.findByPatente(patente);
        if (vehicle.isPresent()){
            var response = VehiculoConverter.generateVehiculoDto(vehicle.get());
            return Optional.of(response);
        } else {
            log.info("No se encontro ningun vehiculo con patente {}", patente);
            return Optional.empty();
        }
    }

    @Override
    public List<VehicleDto> findAllVehicles() {
        log.info("Comienza la ejecución del metodo findAllVehicles.");
        List<VehiculoEntity> vehicles = null;
        try {
            vehicles = vehiculoInfoRepository.findAll();
        } catch (Exception e){
            log.error("Ocurrio un error al consultar la base de datos. Error: {}",e.getMessage());
        }
        return VehiculoConverter.generateVehiculoDtoList(vehicles);
    }
}
