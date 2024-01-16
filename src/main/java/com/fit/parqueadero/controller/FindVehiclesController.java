package com.fit.parqueadero.controller;

import com.fit.parqueadero.dto.findvehicle.VehicleDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface FindVehiclesController {
    ResponseEntity<List<VehicleDto>> findAllVehicles();

    ResponseEntity<Optional<VehicleDto>> getVehicleByPatente(String patente);
}
