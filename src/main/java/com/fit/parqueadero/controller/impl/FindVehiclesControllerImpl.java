package com.fit.parqueadero.controller.impl;

import com.fit.parqueadero.controller.FindVehiclesController;
import com.fit.parqueadero.dto.findvehicle.VehicleDto;
import com.fit.parqueadero.service.FindVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class FindVehiclesControllerImpl implements FindVehiclesController {

    public FindVehiclesControllerImpl(FindVehicleService findVehicleService) {
        this.findVehicleService = findVehicleService;
    }

    FindVehicleService findVehicleService;
    @Override
    @GetMapping(value = "/get-all-vehicles")
    public ResponseEntity<List<VehicleDto>> findAllVehicles() {
        return new ResponseEntity<>(findVehicleService.findAllVehicles(), HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/find-vehicle/{patente}")
    public ResponseEntity<Optional<VehicleDto>> getVehicleByPatente(@PathVariable(value = "patente") String patente) {
        return new ResponseEntity<>(findVehicleService.getVehicleByPatente(patente), HttpStatus.OK);
    }
}
