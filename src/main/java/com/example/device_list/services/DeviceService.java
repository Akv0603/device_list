package com.example.device_list.services;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.dto.ModelDto;
import com.example.device_list.entity.Device;
import com.example.device_list.mapper.DeviceMapper;
import com.example.device_list.mapper.ModelMapper;
import com.example.device_list.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeviceService {

    private DeviceRepository deviceRepository;

//показать весь реестр
    public List<DeviceDto> findAll(){
        return deviceRepository.findAll()
                .stream()
                .map(DeviceMapper::toDto)
                .collect(Collectors.toList());
    }
//поиск по названию, игноря регистр
    public List<ModelDto> findAllByNameIgnoreCase(String name){
        return deviceRepository.findAllByNameIgnoreCase(name)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }
//поиск по цвету
    public List<ModelDto> findAllByColor(String color){
        return deviceRepository.findAllByColor(color)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }
//сортировка названия по алфавиту
    public List<ModelDto> findAllSortByName(){
        return deviceRepository.findAllSortByName()
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }
//сортировка по цене по возрастанию
    public List<ModelDto> findAllSortByPrice(){
        return deviceRepository.findAllSortByPrice()
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }
//сортировка по цене по убыванию
    public List<ModelDto> findAllSortByPriceDesc(){
        return deviceRepository.findAllSortByPriceDesc()
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }
//поиск по ценам в диапазоне значений
    public List<ModelDto> findAllByPriceBetween (BigDecimal x, BigDecimal y){
        return deviceRepository.findAllByPriceBetween(x, y)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }
}
