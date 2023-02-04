package com.BurakAciker.TerminalService.repository;

import com.BurakAciker.TerminalService.domain.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Long>{

}
