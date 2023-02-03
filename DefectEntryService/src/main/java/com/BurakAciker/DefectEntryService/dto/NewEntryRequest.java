package com.BurakAciker.DefectEntryService.dto;

import lombok.Data;

@Data
public class NewEntryRequest {
    Long vehicleId;
    String defectName;
    String description;
    String operatorName;
    Long x;
    Long y;
    String image;
}
