package com.fit.parqueadero.service;

import com.fit.parqueadero.dto.deletevehicle.DeleteVehicleRequest;
import com.fit.parqueadero.dto.deletevehicle.DeleteVehicleResponse;

public interface DeleteVehicleService {
    DeleteVehicleResponse deleteVehicle(DeleteVehicleRequest deleteVehicleRequest);
}
