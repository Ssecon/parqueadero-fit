package com.fit.parqueadero.service;

import com.fit.parqueadero.dto.createvehicle.CreateVehicleRequest;
import com.fit.parqueadero.dto.createvehicle.CreateVehicleResponse;

public interface CreateVehicleService {

    CreateVehicleResponse createVehicle(CreateVehicleRequest createVehicleRequest);

}
