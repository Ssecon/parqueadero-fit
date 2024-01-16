package com.fit.parqueadero.service.impl;

import com.fit.parqueadero.dto.deletevehicle.DeleteVehicleRequest;
import com.fit.parqueadero.dto.deletevehicle.DeleteVehicleResponse;
import com.fit.parqueadero.repository.VehiculoInfoRepository;
import com.fit.parqueadero.service.DeleteVehicleService;
import com.fit.parqueadero.service.FindVehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class DeleteVehicleServiceImpl implements DeleteVehicleService {

    public DeleteVehicleServiceImpl(VehiculoInfoRepository vehiculoInfoRepository,
                                    FindVehicleService findVehicleService) {
        this.vehiculoInfoRepository = vehiculoInfoRepository;
        this.findVehicleService = findVehicleService;
    }

    private final String OK_MESSAGE = "Se eliminó el vehiculo correctamente.";
    private final String NOT_FOUND_MESSAGE = "No se encontro el vehiculo que desea eliminar.";

    VehiculoInfoRepository vehiculoInfoRepository;
    FindVehicleService findVehicleService;
    @Override
    public DeleteVehicleResponse deleteVehicle(DeleteVehicleRequest deleteVehicleRequest) {
        log.info("Comienza la ejecucion del metodo deleteVehicle. Request: {}", deleteVehicleRequest);
        var vehiculo = findVehicleService.getVehicleByPatente(deleteVehicleRequest.getPatente());
        if (vehiculo.isPresent()){
            try{
                vehiculoInfoRepository.deleteById(vehiculo.get().getId());
                log.info("Se elimino el vehiculo correctamente.");
            } catch (Exception e) {
                log.error("Ocurrio un error al eliminar el registro en la base de datos. Error: {}",e.getMessage());
            }
            return new DeleteVehicleResponse(OK_MESSAGE);
        }else {
            log.error("El vehiculo que se intenta eliminar no se encuentra en nuestra base de datos.");
            return new DeleteVehicleResponse(NOT_FOUND_MESSAGE);
        }
    }
}
