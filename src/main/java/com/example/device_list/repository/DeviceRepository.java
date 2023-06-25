package com.example.device_list.repository;

import com.example.device_list.entity.Device;
import com.example.device_list.entity.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface DeviceRepository extends CrudRepository<Device, Integer> {

    List<Device> findAll();

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE LOWER(m.name) = LOWER(:name)")
    List<Model> findAllByNameIgnoreCase(String name);

    @Query("SELECT m FROM Model m JOIN FETCH m.device d ORDER BY m.name")
    List<Model> findAllSortByName();

    @Query("SELECT m FROM Model m JOIN FETCH m.device d ORDER BY m.price")
    List<Model> findAllSortByPrice();

    @Query("SELECT m FROM Model m JOIN FETCH m.device d ORDER BY m.price DESC")
    List<Model> findAllSortByPriceDesc();

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE m.price BETWEEN :x AND :y ORDER BY m.price")
    List<Model> findAllByPriceBetween (BigDecimal x, BigDecimal y);

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE m.color = :color")
    List<Model> findAllByColor(String color);
}
