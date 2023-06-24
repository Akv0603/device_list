package com.example.device_list.services;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.dto.ModelDto;
import com.example.device_list.dto.modelsDto.VacuumCleanerDeviceDto;
import com.example.device_list.entity.Device;
import com.example.device_list.mapper.DeviceMapper;
import com.example.device_list.mapper.ModelMapper;
import com.example.device_list.mapper.models.VacuumCleanerMapper;
import com.example.device_list.repository.VacuumCleanerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VacuumCleanerService implements GeneralModelService<ModelDto> {

    private VacuumCleanerRepository repository;

    //поиск по названию, игнорирует регистр
    @Override
    public List<ModelDto> findAllByName(String name) {
        return repository.findAllByName(name)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //поиск по серийному номеру, игнор регистра
    @Override
    public List<ModelDto> findAllBySerial(String serial) {
        return repository.findAllBySerial(serial)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //поиск по цвету, игнор регистра
    @Override
    public List<ModelDto> findAllByColor(String color) {
        return repository.findAllByColor(color)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по габаритам
    @Override
    public List<ModelDto> findAllBySize(BigDecimal size) {
        return repository.findAllBySize(size)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по цене
    @Override
    public List<ModelDto> findAllByPrice(BigDecimal price) {
        return repository.findAllByPrice(price)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр о наличию
    @Override
    public List<ModelDto> findAllByAvailability() {
        return repository.findAllByAvailability()
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по обьему мешка
    public List<ModelDto> findAllByCapacity(BigDecimal capacity){
        return repository.findAllByCapacity(capacity)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по режимам
    public List<ModelDto> findAllByMode(Integer mode){
        return repository.findAllByMode(mode)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }
//показать все
    public List<DeviceDto> findAll(){
        return repository.findAll()
                .stream()
                .map(DeviceMapper::toDto)
                .collect(Collectors.toList());
    }
    //добавить пылесос
    @Transactional
    public VacuumCleanerDeviceDto saveVacuum(VacuumCleanerDeviceDto deviceDto){
        Device vacuum = VacuumCleanerMapper.fromDeviceDto(deviceDto);
        vacuum.setName("Пылесос");
        repository.save(vacuum);
        return deviceDto;
    }
}
