package com.BurakAciker.DefectListService.resource;

import com.BurakAciker.DefectListService.domain.Vehicle;
import com.BurakAciker.DefectListService.service.DefectListService;
import com.BurakAciker.DefectListService.service.DefectListServiceImpl;
import com.BurakAciker.DefectListService.service.RestRequestsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/defect-list")
@RequiredArgsConstructor
public class DefectListServiceController {

    private final DefectListService service;
    private final RestRequestsService restService;

    @GetMapping("/all")
    public String test(){
        return "TEST";
    }

    @GetMapping("")
    public List<Vehicle> getAll(@RequestHeader("Authorization") String token){
        restService.roleCheck("TEAMLEAD",token);
        return service.findAll();
    }
    @GetMapping("/{page}/{pageSize}")
    public Page<Vehicle> getAllWithPagination(@PathVariable int page, @PathVariable int pageSize,
                                              @RequestHeader("Authorization") String token){
        restService.roleCheck("TEAMLEAD",token);
        return service.findVehiclesWithPagination(page,pageSize);
    }
    @GetMapping("/{page}/{pageSize}/{field}")
    public Page<Vehicle> getAllWithPaginationAndSorting(@PathVariable int page, @PathVariable int pageSize,
                                                        @PathVariable String field,
                                                        @RequestHeader("Authorization") String token){
        restService.roleCheck("TEAMLEAD",token);
        return service.findVehiclesWithPaginationAndSorting(page,pageSize,field);
    }
    @GetMapping("/all/:field")
    public List<Vehicle> getAllWithSorting(@PathVariable String field, @RequestHeader("Authorization") String token){
        restService.roleCheck("TEAMLEAD",token);
        return service.findVehiclesWithSorting(field);
    }

}
