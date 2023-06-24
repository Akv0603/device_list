package com.example.device_list.services;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.dto.ModelDto;
import com.example.device_list.dto.modelsDto.FridgeDeviceDto;
import com.example.device_list.dto.modelsDto.PhoneDeviceDto;
import com.example.device_list.entity.Device;
import com.example.device_list.mapper.DeviceMapper;
import com.example.device_list.mapper.ModelMapper;
import com.example.device_list.mapper.models.FridgeMapper;
import com.example.device_list.mapper.models.PhoneMapper;
import com.example.device_list.repository.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PhoneService implements GeneralModelService {

    private PhoneRepository phoneRepository;

    //поиск по названию, игнорирует регистр
    @Override
    public List<ModelDto> findAllByName(String name) {
        return phoneRepository.findAllByName(name)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //поиск по серийному номеру, игнор регистра
    @Override
    public List<ModelDto> findAllBySerial(String serial) {
        return phoneRepository.findAllBySerial(serial)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //поиск по цвету, игнор регистра
    @Override
    public List<ModelDto> findAllByColor(String color) {
        return phoneRepository.findAllByColor(color)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по габаритам
    @Override
    public List<ModelDto> findAllBySize(BigDecimal size) {
        return phoneRepository.findAllBySize(size)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по цене
    @Override
    public List<ModelDto> findAllByPrice(BigDecimal price) {
        return phoneRepository.findAllByPrice(price)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр о наличию
    @Override
    public List<ModelDto> findAllByAvailability() {
        return phoneRepository.findAllByAvailability()
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по количеству памяти
    public List<ModelDto> findAllByMemory(Integer memory){
        return phoneRepository.findAllByMemory(memory)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }

    //фильтр по количеству камер
    public List<ModelDto> findAllByCamera(Integer camera){
        return phoneRepository.findAllByCamera(camera)
                .stream()
                .map(ModelMapper::toModelDto)
                .collect(Collectors.toList());
    }
    //показать все
    public List<DeviceDto> findAll(){
        return phoneRepository.findAll()
                .stream()
                .map(DeviceMapper::toDto)
                .collect(Collectors.toList());
    }
    //добавить смарт
    @Transactional
    public PhoneDeviceDto savePhone(PhoneDeviceDto phoneDeviceDto){
        Device phone = PhoneMapper.fromDeviceDto(phoneDeviceDto);
        phone.setName("Смартфон");
        phoneRepository.save(phone);
        return phoneDeviceDto;
    }
}
