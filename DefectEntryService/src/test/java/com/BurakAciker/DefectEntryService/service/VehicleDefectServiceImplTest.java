package com.BurakAciker.DefectEntryService.service;

import com.BurakAciker.DefectEntryService.dao.LocationRepository;
import com.BurakAciker.DefectEntryService.dao.VehicleDefectRepository;
import com.BurakAciker.DefectEntryService.dao.VehicleRepository;
import com.BurakAciker.DefectEntryService.domain.Location;
import com.BurakAciker.DefectEntryService.domain.Vehicle;
import com.BurakAciker.DefectEntryService.domain.VehicleDefect;
import com.BurakAciker.DefectEntryService.dto.NewVehicleRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class VehicleDefectServiceImplTest {
    private  VehicleDefectRepository vehicleDefectRepository;
    private  VehicleRepository vehicleRepository;
    private  LocationRepository locationRepository;
    private VehicleDefectServiceImpl service;

    @BeforeEach
    void setUp() {
        vehicleRepository=mock(VehicleRepository.class);
        vehicleDefectRepository=mock(VehicleDefectRepository.class);
        locationRepository=mock(LocationRepository.class);
        service = new VehicleDefectServiceImpl(vehicleDefectRepository,vehicleRepository,locationRepository);
    }

    @Test
    void newVehicleWithValidParameters() {
        NewVehicleRequest newVehicleRequest=new NewVehicleRequest();
        when(vehicleRepository.save(new Vehicle(newVehicleRequest.getModel()))).thenReturn(null);
        assertDoesNotThrow(()->service.newVehicle(newVehicleRequest));
        Mockito.verify(vehicleRepository).save(new Vehicle(newVehicleRequest.getModel()));
    }

    @Test
    void newVehicleDefectWithValidParameters() {
        VehicleDefect vehicleDefect=new VehicleDefect("test","sdf","dfg");
        when(vehicleDefectRepository.save(vehicleDefect)).thenReturn(null);
        assertDoesNotThrow(()->service.newVehicleDefect("test","sdf","dfg"));
        Mockito.verify(vehicleDefectRepository).save(vehicleDefect);
    }

    @Test
    void newLocationWithValidParameters() {
        Location location=new Location(1L,1L,"image");
        when(locationRepository.save(location)).thenReturn(null);
        assertDoesNotThrow(()->service.newLocation(location));
    }

    @Test
    void addVehicleDefectToVehicleWithValidParameters() {
        when(vehicleRepository.findById(1L)).thenReturn(java.util.Optional.of(new Vehicle("BMW")));
        when(vehicleDefectRepository.findById(1L)).thenReturn(java.util.Optional.of(new VehicleDefect("test","sdf","dfg")));
        assertDoesNotThrow(()->service.addVehicleDefectToVehicle(1L,1L));
        Mockito.verify(vehicleRepository).findById(1L);
        Mockito.verify(vehicleDefectRepository).findById(1L);
    }

    @Test
    void addLocationToVehicleDefectWithValidParameters() {
        when(vehicleDefectRepository.findById(1L)).thenReturn(java.util.Optional.of(new VehicleDefect("test","sdf","dfg")));
        assertDoesNotThrow(()->service.addLocationToVehicleDefect(1L,1L,1L,"image"));
        Mockito.verify(vehicleDefectRepository).findById(1L);

    }
}