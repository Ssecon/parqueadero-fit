package com.fit.parqueadero.service.impl;

import com.fit.parqueadero.dto.updatevehicle.UpdateVehicleRequest;
import com.fit.parqueadero.dto.updatevehicle.UpdateVehicleResponse;
import com.fit.parqueadero.entity.VehiculoEntity;
import com.fit.parqueadero.repository.VehiculoInfoRepository;
import com.fit.parqueadero.service.FindVehicleService;
import com.fit.parqueadero.service.UpdateVehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class UpdateVehicleServiceImpl implements UpdateVehicleService {

    public UpdateVehicleServiceImpl(VehiculoInfoRepository vehiculoInfoRepository) {

        this.vehiculoInfoRepository = vehiculoInfoRepository;
    }


    VehiculoInfoRepository vehiculoInfoRepository;
    @Override
    public UpdateVehicleResponse updateVehicle(UpdateVehicleRequest updateVehicleRequest, String patente) {
        log.info("Comienza la ejecucion del metodo updateVehicle.Patente: {}. Request: {}", patente, updateVehicleRequest);
        Optional<VehiculoEntity> vehiculoEntity = vehiculoInfoRepository.findByPatente(patente);
        if (vehiculoEntity.isPresent()){
            try{
                applyPatch(updateVehicleRequest, vehiculoEntity.get());
                vehiculoInfoRepository.save(vehiculoEntity.get());
            } catch (Exception e){
                log.error("Ocurrio un error al consultar la base de datos. Error: {}",e.getMessage());
                return new UpdateVehicleResponse("Ocurrio un error al consultar la base de datos.");
            }

        }else {
            log.error("No se encontro registrada la patente solicitada: {}", patente);
            return new UpdateVehicleResponse(("No se encontro registrada la patente solicitada."));
        }
        return new UpdateVehicleResponse(("Se actualizó el vehiculo correctamente."));
    }

    /**
     * Aplica los cambios proporcionados en la solicitud de actualización de vehículo a la entidad de vehículo,
     * copiando solo las propiedades no nulas desde la solicitud a la entidad.
     *
     * @param updateVehicleRequest Solicitud de actualización de vehículo que contiene los cambios a aplicar.
     * @param vehiculoEntity       Entidad de vehículo que se actualizará con los cambios.
     */
    private void applyPatch(UpdateVehicleRequest updateVehicleRequest, VehiculoEntity vehiculoEntity){
        BeanUtils.copyProperties(updateVehicleRequest, vehiculoEntity, getNullPropertyNames(updateVehicleRequest));
    }


    /**
     * Obtiene los nombres de las propiedades que tienen valores nulos en el objeto fuente.
     *
     * @param source Objeto fuente del cual se obtendrán los nombres de las propiedades nulas.
     * @return Un array de cadenas que representa los nombres de las propiedades con valores nulos.
     */
    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
