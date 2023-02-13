package com.BurakAciker.TerminalService.service;

import com.BurakAciker.TerminalService.domain.Terminal;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TerminalService {


    /**
     * Tüm terminalleri getirir.
     * @return List<Terminal>
     *     Tüm terminal
     */
    public List<Terminal> findAll();
    /**
     * Terminalin bir alanına göre sıralayarak terminalleri getirir.
     * @param field
     * @return List<Terminal>
     *     Terminalin modeline göre terminal
     */
    public List<Terminal> findTerminalsWithSorting(String field);
    /**
     * Terminalleri Sayfalama yaparak getirir.
     * @param offset
     * @param pageSize
     * @return Page<Terminal>
     */
    public Page<Terminal> findTerminalsWithPagination(int offset, int pageSize);
    /**
     * Terminalin bir alanına göre terminalleri Sıralama ve Sayfalama yaparak getirir.
     * @param offset
     * @param pageSize
     * @param field
     * @return Page<Terminal>
     */
    public Page<Terminal> findTerminalsWithPaginationAndSorting(int offset,int pageSize,String field);
}
