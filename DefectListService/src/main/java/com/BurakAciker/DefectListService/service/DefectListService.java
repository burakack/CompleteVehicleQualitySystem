package com.BurakAciker.DefectListService.service;

import com.BurakAciker.DefectListService.domain.Vehicle;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DefectListService {
    public List<Vehicle> findAll();
    public List<Vehicle> findVehiclesWithSorting(String field);
    public Page<Vehicle> findVehiclesWithPagination(int offset, int pageSize);
    public Page<Vehicle> findVehiclesWithPaginationAndSorting(int offset,int pageSize,String field);

}
