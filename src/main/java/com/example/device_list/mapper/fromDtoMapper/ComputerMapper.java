package com.example.device_list.mapper.fromDtoMapper;

import com.example.device_list.dto.modelsDto.ComputerDeviceDto;
import com.example.device_list.dto.modelsDto.ComputerModelDto;
import com.example.device_list.entity.Device;
import com.example.device_list.entity.Model;

import java.util.stream.Collectors;

public class ComputerMapper {

    public static Device fromDeviceDto(ComputerDeviceDto computerDeviceDto) {
        Device device = new Device();
        device.setCountry(computerDeviceDto.getCountry());
        device.setManufacturer(computerDeviceDto.getManufacturer());
        device.setOnlineOrder(computerDeviceDto.isOnlineOrder());
        device.setInstallment(computerDeviceDto.isInstallment());
        device.setModels(computerDeviceDto.getModels()
                .stream()
                .map(ComputerMapper::fromModelDto)
                .collect(Collectors.toList()));
        return device;
    }

    private static Model fromModelDto(ComputerModelDto computerModelDto) {
        Model model = new Model();
        model.setName(computerModelDto.getName());
        model.setSerial(computerModelDto.getSerial());
        model.setColor(computerModelDto.getColor());
        model.setSize(computerModelDto.getSize());
        model.setPrice(computerModelDto.getPrice());
        model.setAvailability(computerModelDto.isAvailability());
        model.setCategory(computerModelDto.getCategory());
        model.setProcessor(computerModelDto.getProcessor());
        return model;
    }
}
