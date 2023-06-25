package com.example.device_list.services;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.dto.ModelDto;
import com.example.device_list.dto.modelsDto.ComputerDeviceDto;
import com.example.device_list.entity.Device;
import com.example.device_list.mapper.DeviceMapper;
import com.example.device_list.mapper.ModelMapper;
import com.example.device_list.mapper.fromDtoMapper.ComputerMapper;
import com.example.device_list.repository.ComputerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ComputerService implements GeneralModelService<ModelDto> {

    private ComputerRepository computerRepository;

    //поиск по названию, игнорирует регистр
    @Override
    public List<ModelDto> findAllByName(String name) {
        return computerRepository.findAllByName(name)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //поиск по серийному номеру, игнор регистра
    @Override
    public List<ModelDto> findAllBySerial(String serial) {
        return computerRepository.findAllBySerial(serial)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //поиск по цвету, игнор регистра
    @Override
    public List<ModelDto> findAllByColor(String color) {
        return computerRepository.findAllByColor(color)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по габаритам
    @Override
    public List<ModelDto> findAllBySize(BigDecimal size) {
        return computerRepository.findAllBySize(size)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по цене
    @Override
    public List<ModelDto> findAllByPrice(BigDecimal price) {
        return computerRepository.findAllByPrice(price)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр о наличию
    @Override
    public List<ModelDto> findAllByAvailability() {
        return computerRepository.findAllByAvailability()
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по категории
    public List<ModelDto> findAllByCategory(String category){
        return computerRepository.findAllByCategory(category)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по процессору
    public List<ModelDto> findAllByProcessor(String processor){
        return computerRepository.findAllByProcessor(processor)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //показать все
    public List<DeviceDto> findAll(){
        return computerRepository.findAll()
                .stream()
                .map(DeviceMapper::toDto)
                .collect(Collectors.toList());
    }

    //добавить новую модель
    @Transactional
    public ComputerDeviceDto saveComputer(ComputerDeviceDto computerDeviceDto){
        Device computer = ComputerMapper.fromDeviceDto(computerDeviceDto);
        computer.setName("Компьютер");
        computerRepository.save(computer);
        return computerDeviceDto;
    }

}
