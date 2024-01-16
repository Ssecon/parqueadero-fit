package com.fit.parqueadero.controller;

import com.fit.parqueadero.dto.createvehicle.CreateVehicleRequest;
import com.fit.parqueadero.dto.createvehicle.CreateVehicleResponse;
import org.springframework.http.ResponseEntity;

public interface CreateVehicleController {

    ResponseEntity<CreateVehicleResponse> createVehicle(CreateVehicleRequest createVehicleRequest);
}
