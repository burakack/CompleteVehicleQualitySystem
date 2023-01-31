package com.BurakAciker.DefectEntryService.dao;

import com.BurakAciker.DefectEntryService.domain.VehicleDefect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDefectRepository extends JpaRepository<VehicleDefect, Long> {
}
