package com.fit.parqueadero.service;

import com.fit.parqueadero.dto.updatevehicle.UpdateVehicleRequest;
import com.fit.parqueadero.dto.updatevehicle.UpdateVehicleResponse;

public interface UpdateVehicleService {

    UpdateVehicleResponse updateVehicle(UpdateVehicleRequest updateVehicleRequest, String patente);
}
