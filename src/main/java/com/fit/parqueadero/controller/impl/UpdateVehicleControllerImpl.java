package com.fit.parqueadero.controller.impl;

import com.fit.parqueadero.controller.UpdateVehicleController;
import com.fit.parqueadero.dto.updatevehicle.UpdateVehicleRequest;
import com.fit.parqueadero.dto.updatevehicle.UpdateVehicleResponse;
import com.fit.parqueadero.service.UpdateVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateVehicleControllerImpl implements UpdateVehicleController {

    public UpdateVehicleControllerImpl(UpdateVehicleService updateVehicleService) {
        this.updateVehicleService = updateVehicleService;
    }

    UpdateVehicleService updateVehicleService;
    @Override
    @PatchMapping(value = "/update-vehicle/{patente}")
    public ResponseEntity<UpdateVehicleResponse> updateVehicle(@RequestBody UpdateVehicleRequest updateVehicleRequest,
                                                               @PathVariable(value = "patente") String patente) {
        return new ResponseEntity<>(updateVehicleService.updateVehicle(updateVehicleRequest,patente), HttpStatus.OK);
    }
}
