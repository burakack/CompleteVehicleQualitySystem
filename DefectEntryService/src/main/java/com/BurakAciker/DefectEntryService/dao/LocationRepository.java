package com.BurakAciker.DefectEntryService.dao;

import com.BurakAciker.DefectEntryService.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
