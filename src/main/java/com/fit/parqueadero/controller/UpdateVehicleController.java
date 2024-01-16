package com.fit.parqueadero.controller;

import com.fit.parqueadero.dto.updatevehicle.UpdateVehicleRequest;
import com.fit.parqueadero.dto.updatevehicle.UpdateVehicleResponse;
import org.springframework.http.ResponseEntity;

public interface UpdateVehicleController {

    ResponseEntity<UpdateVehicleResponse> updateVehicle(UpdateVehicleRequest updateVehicleRequest, String patente);
}
