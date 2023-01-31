package com.BurakAciker.DefectEntryService.service;

import com.BurakAciker.DefectEntryService.domain.Location;
import com.BurakAciker.DefectEntryService.domain.Vehicle;
import com.BurakAciker.DefectEntryService.domain.VehicleDefect;
import com.BurakAciker.DefectEntryService.dto.NewVehicleRequest;

public interface VehicleDefectService {
    public Vehicle newVehicle(NewVehicleRequest newVehicleRequest);
    public VehicleDefect newVehicleDefect(String defectName, String defectDescription);
    public Location newLocation(Location location);
    public void addVehicleDefectToVehicle(Long vehicleId, Long vehicleDefectId);
    public void addLocationToVehicleDefect(Long vehicleDefectId, Long x,Long y,String image);
}
