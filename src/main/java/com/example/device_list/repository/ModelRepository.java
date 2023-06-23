package com.example.device_list.repository;

import com.example.device_list.entity.Model;

import java.math.BigDecimal;
import java.util.List;

public interface ModelRepository<T extends Model> {

    List<T> findAllByName(String name);

    List<T> findAllBySerial(String serial);

    List<T> findAllByColor(String color);

    List<T> findAllBySize(BigDecimal size);

    List<T> findAllByPrice(BigDecimal price);

    List<T> findAllByAvailability();
}
