package com.fit.parqueadero.controller.impl;

import com.fit.parqueadero.controller.DeleteVehicleController;
import com.fit.parqueadero.dto.deletevehicle.DeleteVehicleRequest;
import com.fit.parqueadero.dto.deletevehicle.DeleteVehicleResponse;
import com.fit.parqueadero.service.DeleteVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteVehicleControllerImpl implements DeleteVehicleController {

    public DeleteVehicleControllerImpl(DeleteVehicleService deleteVehicleService) {
        this.deleteVehicleService = deleteVehicleService;
    }

    DeleteVehicleService deleteVehicleService;
    @Override
    @DeleteMapping(path = "/delete-vehicle")
    public ResponseEntity<DeleteVehicleResponse> deleteVehicle(@RequestBody DeleteVehicleRequest deleteVehicleRequest) {
        return new ResponseEntity<>(deleteVehicleService.deleteVehicle(deleteVehicleRequest), HttpStatus.OK);
    }
}
