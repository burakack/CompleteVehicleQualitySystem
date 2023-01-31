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
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String model;
    @ManyToMany(fetch = FetchType.EAGER)
    List<VehicleDefect> defects=new ArrayList<>();

    public Vehicle(String model) {
        this.model = model;
    }
}
