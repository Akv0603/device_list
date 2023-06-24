package com.example.device_list.repository;

import com.example.device_list.entity.Device;
import com.example.device_list.entity.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface PhoneRepository extends CrudRepository<Device, Integer>, ModelRepository<Model> {

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE d.name = 'Смартфон' AND LOWER(m.name) = LOWER(:name)")
    @Override
    List<Model> findAllByName(String name);

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE d.name = 'Смартфон' AND LOWER(m.serial) = LOWER(:serial)")
    @Override
    List<Model> findAllBySerial(String serial);

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE d.name = 'Смартфон' AND LOWER(m.color) = LOWER(:color)")
    @Override
    List<Model> findAllByColor(String color);

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE d.name = 'Смартфон' AND m.size = :size")
    @Override
    List<Model> findAllBySize(BigDecimal size);

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE d.name = 'Смартфон' AND m.price = :price")
    @Override
    List<Model> findAllByPrice(BigDecimal price);

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE d.name = 'Смартфон' AND m.availability = true")
    @Override
    List<Model> findAllByAvailability();

    @Query("SELECT d FROM Device d WHERE d.name = 'Смартфон'")
    @Override
    List<Device> findAll();

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE d.name = 'Смартфон' AND m.memory = :memory")
    List<Model> findAllByMemory(Integer memory);

    @Query("SELECT m FROM Model m JOIN FETCH m.device d WHERE d.name = 'Смартфон' AND m.camera = :camera")
    List<Model> findAllByCamera(Integer camera);
}
