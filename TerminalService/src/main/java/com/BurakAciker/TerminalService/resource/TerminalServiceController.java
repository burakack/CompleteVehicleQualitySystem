package com.BurakAciker.TerminalService.resource;

import com.BurakAciker.TerminalService.domain.Terminal;
import com.BurakAciker.TerminalService.repository.TerminalRepository;
import com.BurakAciker.TerminalService.service.TerminalService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/terminal")
public class TerminalServiceController {
    private final Logger logger = LogManager.getLogger(TerminalServiceController.class);
    private final TerminalService service;
    private final TerminalRepository repository;




    @GetMapping("/all")
    public List<Terminal> getAll(){

        logger.info("All terminals request received token:");
        return service.findAll();
    }
    @GetMapping("/{page}/{pageSize}")
    public Page<Terminal> getAllWithPagination(@PathVariable int page, @PathVariable int pageSize){
        logger.info("All terminals with pagination request received page:"+page+" pageSize:"+pageSize );
        return service.findTerminalsWithPagination(page,pageSize);
    }
    @GetMapping("/{page}/{pageSize}/{field}")
    public Page<Terminal> getAllWithPaginationAndSorting(@PathVariable int page, @PathVariable int pageSize,
                                                        @PathVariable String field ){
        logger.info("All terminals with pagination and sorting request received page:"+page+" pageSize:"+pageSize+" field:"+field);
        return service.findTerminalsWithPaginationAndSorting(page,pageSize,field);
    }
    @GetMapping("/all/{field}")
    public List<Terminal> getAllWithSorting(@PathVariable String field){
        logger.info("All terminals with sorting request received field:"+field);
        return service.findTerminalsWithSorting(field);
    }
}
