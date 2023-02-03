package com.BurakAciker.DefectEntryService.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDefect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String defectName;
    String defectDescription;
    String Operator;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Location> locations=new ArrayList<>();

    public VehicleDefect(String defectName, String description, String operator) {
        this.Operator = operator;
        this.defectName = defectName;
        this.defectDescription = description;
    }
}
