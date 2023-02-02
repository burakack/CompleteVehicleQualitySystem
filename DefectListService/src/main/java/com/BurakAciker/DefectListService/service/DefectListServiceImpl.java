package com.BurakAciker.DefectListService.service;

import com.BurakAciker.DefectListService.dao.VehicleRepository;
import com.BurakAciker.DefectListService.domain.Vehicle;
import com.BurakAciker.DefectListService.resource.DefectListServiceController;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefectListServiceImpl implements DefectListService {
    private final VehicleRepository repository;
    private final Logger logger = LogManager.getLogger(DefectListServiceController.class);

    public List<Vehicle> findAll(){
        return repository.findAll();
    }

    public List<Vehicle> findVehiclesWithSorting(String field){
        logger.info("All vehicles with sorting method field:"+field);
        return  repository.findAll(Sort.by(Sort.Direction.ASC,field));
    }


    public Page<Vehicle> findVehiclesWithPagination(int offset, int pageSize){
        logger.info("All vehicles with pagination method page:"+offset+" pageSize:"+pageSize);
        Page<Vehicle> products = repository.findAll(PageRequest.of(offset, pageSize));
        return  products;
    }

    public Page<Vehicle> findVehiclesWithPaginationAndSorting(int offset,int pageSize,String field){
        logger.info("All vehicles with pagination and sorting method page:"+offset+" pageSize:"+pageSize+" field:"+field);
        Page<Vehicle> products = repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return  products;
    }
}
