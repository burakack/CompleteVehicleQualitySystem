package com.BurakAciker.DefectListService.dao;

import com.BurakAciker.DefectListService.domain.VehicleDefect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDefectRepository extends JpaRepository<VehicleDefect, Long> {
}
