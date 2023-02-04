package com.BurakAciker.TerminalService.service;

import com.BurakAciker.TerminalService.domain.Terminal;
import com.BurakAciker.TerminalService.repository.TerminalRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TerminalServiceImpl implements TerminalService {

    private final Logger logger = LogManager.getLogger(TerminalServiceImpl.class);
    @Autowired
    private final TerminalRepository repository;

    public List<Terminal> findAll(){
        return repository.findAll();
    }

    public List<Terminal> findTerminalsWithSorting(String field){
        logger.info("All terminals with sorting method field:"+field);
        return  repository.findAll(Sort.by(Sort.Direction.ASC,field));
    }


    public Page<Terminal> findTerminalsWithPagination(int offset, int pageSize){
        logger.info("All vehicles with pagination method page:"+offset+" pageSize:"+pageSize);
        Page<Terminal> products = repository.findAll(PageRequest.of(offset, pageSize));
        return  products;
    }

    public Page<Terminal> findTerminalsWithPaginationAndSorting(int offset,int pageSize,String field){
        logger.info("All terminals with pagination and sorting method page:"+offset+" pageSize:"+pageSize+" field:"+field);
        Page<Terminal> terminals = repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return  terminals;
    }

}
