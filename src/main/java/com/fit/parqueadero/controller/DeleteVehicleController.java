package com.fit.parqueadero.controller;

import com.fit.parqueadero.dto.deletevehicle.DeleteVehicleRequest;
import com.fit.parqueadero.dto.deletevehicle.DeleteVehicleResponse;
import org.springframework.http.ResponseEntity;

public interface DeleteVehicleController {

    ResponseEntity<DeleteVehicleResponse> deleteVehicle(DeleteVehicleRequest deleteVehicleRequest);
}
