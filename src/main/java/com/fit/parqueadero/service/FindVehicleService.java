package com.fit.parqueadero.service;

import com.fit.parqueadero.dto.findvehicle.VehicleDto;

import java.util.Optional;

public interface FindVehicleService {

    Optional<VehicleDto> getVehicleByPatente(String patente);

}
