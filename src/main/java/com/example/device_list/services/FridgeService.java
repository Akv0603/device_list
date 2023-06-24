package com.example.device_list.services;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.dto.ModelDto;
import com.example.device_list.dto.modelsDto.FridgeDeviceDto;
import com.example.device_list.dto.modelsDto.VacuumCleanerDeviceDto;
import com.example.device_list.entity.Device;
import com.example.device_list.mapper.DeviceMapper;
import com.example.device_list.mapper.ModelMapper;
import com.example.device_list.mapper.models.FridgeMapper;
import com.example.device_list.mapper.models.VacuumCleanerMapper;
import com.example.device_list.repository.FridgeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FridgeService implements GeneralModelService<ModelDto> {

    private FridgeRepository fridgeRepository;

    //поиск по названию, игнорирует регистр
    @Override
    public List<ModelDto> findAllByName(String name) {
        return fridgeRepository.findAllByName(name)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //поиск по серийному номеру, игнор регистра
    @Override
    public List<ModelDto> findAllBySerial(String serial) {
        return fridgeRepository.findAllBySerial(serial)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //поиск по цвету, игнор регистра
    @Override
    public List<ModelDto> findAllByColor(String color) {
        return fridgeRepository.findAllByColor(color)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по габаритам
    @Override
    public List<ModelDto> findAllBySize(BigDecimal size) {
        return fridgeRepository.findAllBySize(size)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по цене
    @Override
    public List<ModelDto> findAllByPrice(BigDecimal price) {
        return fridgeRepository.findAllByPrice(price)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр о наличию
    @Override
    public List<ModelDto> findAllByAvailability() {
        return fridgeRepository.findAllByAvailability()
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по количеству дверей
    public List<ModelDto> findAllByDoorCount(Integer doorCount){
        return fridgeRepository.findAllByDoorCount(doorCount)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по типу компрессора
    public List<ModelDto> findAllByCompressor(String compressor){
        return fridgeRepository.findAllByCompressor(compressor)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }
    //показать все
    public List<DeviceDto> findAll(){
        return fridgeRepository.findAll()
                .stream()
                .map(DeviceMapper::toDto)
                .collect(Collectors.toList());
    }
    //добавить холодильник
    @Transactional
    public FridgeDeviceDto saveFridge(FridgeDeviceDto fridgeDeviceDto){
        Device fridge = FridgeMapper.fromDeviceDto(fridgeDeviceDto);
        fridge.setName("Пылесос");
        fridgeRepository.save(fridge);
        return fridgeDeviceDto;
    }
}
