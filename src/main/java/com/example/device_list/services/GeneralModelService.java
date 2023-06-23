package com.example.device_list.services;

import com.example.device_list.dto.ModelDto;

import java.math.BigDecimal;
import java.util.List;

public interface GeneralModelService<T extends ModelDto> {

    List<ModelDto> findAllByName(String name);

    List<ModelDto> findAllBySerial(String serial);

    List<ModelDto> findAllByColor(String color);

    List<ModelDto> findAllBySize(BigDecimal size);

    List<ModelDto> findAllByPrice(BigDecimal price);

    List<ModelDto> findAllByAvailability();
}
