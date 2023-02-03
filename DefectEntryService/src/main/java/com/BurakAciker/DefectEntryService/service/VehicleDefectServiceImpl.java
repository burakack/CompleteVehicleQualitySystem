package com.BurakAciker.DefectEntryService.service;

import com.BurakAciker.DefectEntryService.dao.LocationRepository;
import com.BurakAciker.DefectEntryService.dao.VehicleDefectRepository;
import com.BurakAciker.DefectEntryService.dao.VehicleRepository;
import com.BurakAciker.DefectEntryService.domain.Location;
import com.BurakAciker.DefectEntryService.domain.Vehicle;
import com.BurakAciker.DefectEntryService.domain.VehicleDefect;
import com.BurakAciker.DefectEntryService.dto.NewVehicleRequest;
import com.BurakAciker.DefectEntryService.resource.DefectEntryServiceController;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Transactional
public class VehicleDefectServiceImpl implements VehicleDefectService{
    private final VehicleDefectRepository vehicleDefectRepository;
    private final VehicleRepository vehicleRepository;
    private final LocationRepository locationRepository;
    private final Logger logger = LogManager.getLogger(VehicleDefectServiceImpl.class);

    public Vehicle newVehicle(NewVehicleRequest newVehicleRequest){
        logger.info("New vehicle method parameters:"+newVehicleRequest.toString());
        return vehicleRepository.save(new Vehicle(newVehicleRequest.getModel()));
    }

    public VehicleDefect newVehicleDefect(String defectName, String defectDescription,String OperatorName){
        logger.info("New vehicle defect method parameters: Defectname:"+defectName+"   DefectnameDescription"+defectDescription);
        return vehicleDefectRepository.save(new VehicleDefect(defectName,defectDescription,OperatorName));

    }
    public Location newLocation(Location location){
        logger.info("New location method parameters: Location:"+location.toString());

       return locationRepository.save(location);

    }
    public void addVehicleDefectToVehicle(Long vehicleId, Long vehicleDefectId){
        logger.info("Add vehicle defect to vehicle method parameters: VehicleId:"+vehicleId+"   VehicleDefectId"+vehicleDefectId);
        vehicleRepository.findById(vehicleId).ifPresent(vehicle -> {
        vehicleDefectRepository.findById(vehicleDefectId).ifPresent(vehicleDefect -> {
                vehicle.getDefects().add(vehicleDefect);
            });
        });
    }
    public void addLocationToVehicleDefect(Long vehicleDefectId, Long x,Long y,String image){
        logger.info("Add location to vehicle defect method parameters: VehicleDefectId:"+vehicleDefectId+"   X:"+x+"   Y:"+y+"   Image:"+image);
        vehicleDefectRepository.findById(vehicleDefectId).ifPresent(vehicleDefect -> {
            Location lc=newLocation(new Location(x,y,image));
                vehicleDefect.getLocations().add(lc);
        });
    }
}