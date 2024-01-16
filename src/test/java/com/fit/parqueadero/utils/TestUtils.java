package com.fit.parqueadero.utils;

import com.fit.parqueadero.dto.createvehicle.CreateVehicleRequest;
import com.fit.parqueadero.dto.createvehicle.CreateVehicleResponse;
import com.fit.parqueadero.dto.deletevehicle.DeleteVehicleRequest;
import com.fit.parqueadero.dto.deletevehicle.DeleteVehicleResponse;
import com.fit.parqueadero.dto.findvehicle.VehicleDto;

import java.util.Optional;

public class TestUtils {


    public static String OK_MESSAGE = "Se creó el vehiculo correctamente.";
    public static String DELETE_OK_MESSAGE = "Se eliminó el vehiculo correctamente.";

    public static String CREATION_ERROR = "Ocurrio un error al insertar el registro en la base de datos.";

    public static Long ID = 1L;
    public static String COLOR = "rojo";
    public static String MARCA = "BMW";
    public static String MODELO = "M3";
    public static String DUEÑO = "rojo";
    public static String PATENTE = "aa123aa";



    public static CreateVehicleResponse getCreateVehicleResponse(){
        return new CreateVehicleResponse(OK_MESSAGE);
    }

    public static CreateVehicleResponse getCreateVehicleErrorResponse(){
        return new CreateVehicleResponse(CREATION_ERROR);
    }

    public static CreateVehicleRequest getCreateVehicleRequest(){
        CreateVehicleRequest createVehicleRequest =  new CreateVehicleRequest();

        createVehicleRequest.setColor(COLOR);
        createVehicleRequest.setDueño(DUEÑO);
        createVehicleRequest.setPatente(PATENTE);
        createVehicleRequest.setModelo(MODELO);
        createVehicleRequest.setMarca(MARCA);

        return createVehicleRequest;
    }

    public static DeleteVehicleRequest getDeleteVehicleRequest() {
        DeleteVehicleRequest deleteVehicleRequest = new DeleteVehicleRequest();
        deleteVehicleRequest.setPatente(PATENTE);
        return deleteVehicleRequest;
    }

    public static Optional<VehicleDto> getOptionalVehicleDto() {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId(ID);
        vehicleDto.setColor(COLOR);
        vehicleDto.setModelo(MODELO);
        vehicleDto.setMarca(MARCA);
        vehicleDto.setDueño(DUEÑO);
        return Optional.of(vehicleDto);

    }

    public static DeleteVehicleResponse getDeleteVehicleResponse(){
        DeleteVehicleResponse response = new DeleteVehicleResponse(DELETE_OK_MESSAGE);
        return response;
    }
}
