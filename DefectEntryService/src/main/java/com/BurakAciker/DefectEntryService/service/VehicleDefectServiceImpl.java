package com.BurakAciker.DefectEntryService.service;

import com.BurakAciker.DefectEntryService.dao.LocationRepository;
import com.BurakAciker.DefectEntryService.dao.VehicleDefectRepository;
import com.BurakAciker.DefectEntryService.dao.VehicleRepository;
import com.BurakAciker.DefectEntryService.domain.Location;
import com.BurakAciker.DefectEntryService.domain.Vehicle;
import com.BurakAciker.DefectEntryService.domain.VehicleDefect;
import com.BurakAciker.DefectEntryService.dto.NewVehicleRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Transactional
public class VehicleDefectServiceImpl implements VehicleDefectService{
    private final VehicleDefectRepository vehicleDefectRepository;
    private final VehicleRepository vehicleRepository;
    private final LocationRepository locationRepository;

    public Vehicle newVehicle(NewVehicleRequest newVehicleRequest){
        return vehicleRepository.save(new Vehicle(newVehicleRequest.getModel()));
    }

    public VehicleDefect newVehicleDefect(String defectName, String defectDescription){
        return vehicleDefectRepository.save(new VehicleDefect(defectName,defectDescription));

    }
    public Location newLocation(Location location){

       return locationRepository.save(location);

    }
    public void addVehicleDefectToVehicle(Long vehicleId, Long vehicleDefectId){
        vehicleRepository.findById(vehicleId).ifPresent(vehicle -> {
        vehicleDefectRepository.findById(vehicleDefectId).ifPresent(vehicleDefect -> {
                vehicle.getDefects().add(vehicleDefect);
            });
        });
    }
    public void addLocationToVehicleDefect(Long vehicleDefectId, Long x,Long y,String image){
        vehicleDefectRepository.findById(vehicleDefectId).ifPresent(vehicleDefect -> {
            Location lc=newLocation(new Location(x,y,image));
                vehicleDefect.getLocations().add(lc);
        });
    }
}