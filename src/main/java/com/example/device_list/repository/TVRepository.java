package com.example.device_list.repository;

import com.example.device_list.entity.Device;
import com.example.device_list.entity.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface TVRepository extends CrudRepository<Device, Integer>, ModelRepository<Model> {

    @Query("SELECT d FROM Device d WHERE d.name = 'Телевизор'")
    List<Device> findAll();

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE d.name = 'Телевизор' AND LOWER(m.name) = LOWER(:name)")
    @Override
    List<Model> findAllByName(String name);

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE d.name = 'Телевизор' AND LOWER(m.serial) = LOWER(:serial)")
    @Override
    List<Model> findAllBySerial(String serial);

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE d.name = 'Телевизор' AND LOWER(m.color) = LOWER(:color)")
    @Override
    List<Model> findAllByColor(String color);

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE d.name = 'Телевизор' AND m.size = :size")

    @Override
    List<Model> findAllBySize(BigDecimal size);

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE d.name = 'Телевизор' AND m.price = :price")
    @Override
    List<Model> findAllByPrice(BigDecimal price);

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE d.name = 'Телевизор' AND m.availability = true")
    @Override
    List<Model> findAllByAvailability();

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE d.name = 'Телевизор' AND LOWER(m.category) = LOWER(:category)")
    List<Model> findAllByCategory(String category);

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE d.name = 'Телевизор' AND LOWER(m.technology) = LOWER(:technology)")
    List<Model> findAllByTechnology(String technology);
}
