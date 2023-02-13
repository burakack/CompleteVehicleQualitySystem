package com.BurakAciker.DefectListService.service;

import com.BurakAciker.DefectListService.domain.Vehicle;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DefectListService {

    /**
     * Tüm araçları getirir.
     * @return List<Vehicle>
     *     Tüm araçlar
     *
     */
    public List<Vehicle> findAll();

    /**
     * Aracın bir alanına göre sıralayarak araçları getirir.
     * @param field
     * @return List<Vehicle>
     *     Aracın modeline göre araçlar
     */
    public List<Vehicle> findVehiclesWithSorting(String field);

    /**
     * Araçları Sayfalama yaparak getirir.
     * @param offset
     * @param pageSize
     * @return Page<Vehicle>
     */
    public Page<Vehicle> findVehiclesWithPagination(int offset, int pageSize);

    /**
     * Aracın bir alanına göre araçları Sıralama ve Sayfalama yaparak getirir.
     * @param offset
     * @param pageSize
     * @param field
     * @return Page<Vehicle>
     */
    public Page<Vehicle> findVehiclesWithPaginationAndSorting(int offset,int pageSize,String field);

}
