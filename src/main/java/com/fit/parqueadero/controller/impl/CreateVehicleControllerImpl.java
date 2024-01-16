package com.fit.parqueadero.controller.impl;

import com.fit.parqueadero.controller.CreateVehicleController;
import com.fit.parqueadero.dto.createvehicle.CreateVehicleRequest;
import com.fit.parqueadero.dto.createvehicle.CreateVehicleResponse;
import com.fit.parqueadero.service.CreateVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CreateVehicleControllerImpl implements CreateVehicleController {

    public CreateVehicleControllerImpl(CreateVehicleService createVehicleService) {
        this.createVehicleService = createVehicleService;
    }

    CreateVehicleService createVehicleService;

    @Override
    @PostMapping(path = "/create-vehicle")
    public ResponseEntity<CreateVehicleResponse> createVehicle(@RequestBody CreateVehicleRequest createVehicleRequest) {
        return new ResponseEntity<>(createVehicleService.createVehicle(createVehicleRequest), HttpStatus.OK);
    }
}
