package com.fit.parqueadero.service;

import com.fit.parqueadero.repository.VehiculoInfoRepository;
import com.fit.parqueadero.service.impl.DeleteVehicleServiceImpl;
import com.fit.parqueadero.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeleteVehicleServiceTest {

    @InjectMocks
    DeleteVehicleServiceImpl deleteVehicleService;
    @Mock
    VehiculoInfoRepository vehiculoInfoRepository;
    @Mock
    FindVehicleService findVehicleService;

    @Test
    @DisplayName("Delete Vehicle - Happy path")
    void deleteVehicleHappyPath() {
        when(findVehicleService.getVehicleByPatente(TestUtils.getDeleteVehicleRequest().getPatente())).thenReturn(TestUtils.getOptionalVehicleDto());
        assertEquals(TestUtils.getDeleteVehicleResponse(),deleteVehicleService.deleteVehicle(TestUtils.getDeleteVehicleRequest()));
    }


}
