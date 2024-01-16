package com.fit.parqueadero.service;

import com.fit.parqueadero.repository.VehiculoInfoRepository;
import com.fit.parqueadero.service.impl.CreateVehicleServiceImpl;
import com.fit.parqueadero.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateVehicleServiceTest {

    @InjectMocks
    CreateVehicleServiceImpl createVehicleService;

    @Mock
    VehiculoInfoRepository vehiculoInfoRepository;

    @DisplayName("Create Vehicle - Happy path")
    @Test
    void createVehicleHappyPath(){
        assertEquals(TestUtils.getCreateVehicleResponse(),createVehicleService.createVehicle(TestUtils.getCreateVehicleRequest()));
    }


    @DisplayName("Create Vehicle - Exception")
    @Test
    void createVehicleException(){
        when(vehiculoInfoRepository.save(any())).thenThrow(new RuntimeException());
        assertEquals(TestUtils.getCreateVehicleErrorResponse(),createVehicleService.createVehicle(TestUtils.getCreateVehicleRequest()));
    }
}
