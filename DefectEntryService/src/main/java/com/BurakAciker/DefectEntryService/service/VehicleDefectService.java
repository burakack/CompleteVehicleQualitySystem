package com.BurakAciker.DefectEntryService.service;

import com.BurakAciker.DefectEntryService.domain.Location;
import com.BurakAciker.DefectEntryService.domain.Vehicle;
import com.BurakAciker.DefectEntryService.domain.VehicleDefect;
import com.BurakAciker.DefectEntryService.dto.NewVehicleRequest;

public interface VehicleDefectService {
    /**
     * Yeni bir araç oluşturur.
     * @param newVehicleRequest
     * @return Vehicle
     */
    public Vehicle newVehicle(NewVehicleRequest newVehicleRequest);

    /**
     * Yeni bir araç hatası oluşturur.
     * @param defectName
     * @param defectDescription
     * @param OperatorName
     * @return VehicleDefect
     */
    public VehicleDefect newVehicleDefect(String defectName, String defectDescription,String OperatorName);

    /**
     * Yeni bir konum oluşturur.
     * @param location
     * @return Location
     */
    public Location newLocation(Location location);

    /**
     * Bir araca bir araç hatası ekler.
     * @param vehicleId
     * @param vehicleDefectId
     */
    public void addVehicleDefectToVehicle(Long vehicleId, Long vehicleDefectId);

    /**
     * Bir araç hatasına bir konum ekler.
     * @param vehicleDefectId
     * @param x
     * @param y
     * @param image
     */
    public void addLocationToVehicleDefect(Long vehicleDefectId, Long x,Long y,String image);
}
