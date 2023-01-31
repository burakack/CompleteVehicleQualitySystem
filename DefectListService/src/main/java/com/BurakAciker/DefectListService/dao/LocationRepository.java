package com.BurakAciker.DefectListService.dao;

import com.BurakAciker.DefectListService.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
