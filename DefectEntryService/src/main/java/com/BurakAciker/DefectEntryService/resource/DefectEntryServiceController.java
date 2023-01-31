package com.BurakAciker.DefectEntryService.resource;


import com.BurakAciker.DefectEntryService.domain.VehicleDefect;
import com.BurakAciker.DefectEntryService.dto.NewEntryRequest;
import com.BurakAciker.DefectEntryService.dto.NewVehicleRequest;
import com.BurakAciker.DefectEntryService.service.RestRequestsService;
import com.BurakAciker.DefectEntryService.service.VehicleDefectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/defect-entry")
@RequiredArgsConstructor
public class DefectEntryServiceController {
    private final VehicleDefectService service;
    private final RestRequestsService restService;

    @PostMapping("/new-entry")
    public void addEntry(@RequestBody NewEntryRequest request, @RequestHeader("Authorization") String token){

        restService.roleCheck("OPERATOR",token);

        VehicleDefect vd= service.newVehicleDefect(request.getDefectName(),request.getDescription());

        service.addLocationToVehicleDefect(vd.getId(), request.getX(), request.getY(), request.getImage());

        service.addVehicleDefectToVehicle(request.getVehicleId(), vd.getId());
    }
    @PostMapping("/new-vehicle")
    public void addVehicle(@RequestBody NewVehicleRequest newVehicleRequest, @RequestHeader("Authorization") String token){
        restService.roleCheck("OPERATOR",token);
        service.newVehicle(newVehicleRequest);
    }

}
