package com.BurakAciker.DefectEntryService.dao;


import com.BurakAciker.DefectEntryService.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>
{

}
