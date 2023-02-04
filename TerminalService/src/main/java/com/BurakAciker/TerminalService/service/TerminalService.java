package com.BurakAciker.TerminalService.service;

import com.BurakAciker.TerminalService.domain.Terminal;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TerminalService {


    public List<Terminal> findAll();
    public List<Terminal> findTerminalsWithSorting(String field);
    public Page<Terminal> findTerminalsWithPagination(int offset, int pageSize);
    public Page<Terminal> findTerminalsWithPaginationAndSorting(int offset,int pageSize,String field);
}
