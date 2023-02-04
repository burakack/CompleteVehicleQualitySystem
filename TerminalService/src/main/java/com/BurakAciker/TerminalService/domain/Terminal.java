package com.BurakAciker.TerminalService.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Terminal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String terminalName;
    private Boolean isAvailable;

    public Terminal(String terminalName, boolean isAvailable) {
        this.terminalName = terminalName;
        this.isAvailable = isAvailable;
    }
}
