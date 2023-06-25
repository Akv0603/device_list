package com.example.device_list.services;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.dto.ModelDto;
import com.example.device_list.dto.modelsDto.TVDeviceDto;
import com.example.device_list.entity.Device;
import com.example.device_list.mapper.DeviceMapper;
import com.example.device_list.mapper.ModelMapper;
import com.example.device_list.mapper.fromDtoMapper.TVMapper;
import com.example.device_list.repository.TVRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TVService implements GeneralModelService<ModelDto> {

    private TVRepository tvRepository;

    //поиск по названию, игнорирует регистр
    @Override
    public List<ModelDto> findAllByName(String name) {
        return tvRepository.findAllByName(name)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //поиск по серийному номеру, игнор регистра
    @Override
    public List<ModelDto> findAllBySerial(String serial) {
        return tvRepository.findAllBySerial(serial)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //поиск по цвету, игнор регистра
    @Override
    public List<ModelDto> findAllByColor(String color) {
        return tvRepository.findAllByColor(color)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по габаритам
    @Override
    public List<ModelDto> findAllBySize(BigDecimal size) {
        return tvRepository.findAllBySize(size)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по цене
    @Override
    public List<ModelDto> findAllByPrice(BigDecimal price) {
        return tvRepository.findAllByPrice(price)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр о наличию
    @Override
    public List<ModelDto> findAllByAvailability() {
        return tvRepository.findAllByAvailability()
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по категории
    public List<ModelDto> findAllByCategory(String category){
        return tvRepository.findAllByCategory(category)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по технологии
    public List<ModelDto> findAllByTechnology(String technology){
        return tvRepository.findAllByTechnology(technology)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //показать все
    public List<DeviceDto> findAll(){
        return tvRepository.findAll()
                .stream()
                .map(DeviceMapper::toDto)
                .collect(Collectors.toList());
    }

    //добавить новую модель
    @Transactional
    public TVDeviceDto saveTV(TVDeviceDto tvDeviceDto){
        Device tv = TVMapper.fromDeviceDto(tvDeviceDto);
        tv.setName("Телевизор");
        tvRepository.save(tv);
        return tvDeviceDto;
    }
}
