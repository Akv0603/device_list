package com.example.device_list.mapper.models;

import com.example.device_list.dto.modelsDto.VacuumCleanerDeviceDto;
import com.example.device_list.dto.modelsDto.VacuumCleanerModelDto;
import com.example.device_list.entity.Device;
import com.example.device_list.entity.Model;

import java.util.stream.Collectors;

public class VacuumCleanerMapper {
    public static Device fromDeviceDto(VacuumCleanerDeviceDto vacuumCleanerDeviceDto) {
        Device device = new Device();
        device.setCountry(vacuumCleanerDeviceDto.getCountry());
        device.setManufacturer(vacuumCleanerDeviceDto.getManufacturer());
        device.setOnlineOrder(vacuumCleanerDeviceDto.isOnlineOrder());
        device.setInstallment(vacuumCleanerDeviceDto.isInstallment());
        device.setModels(vacuumCleanerDeviceDto.getModels()
                .stream()
                .map(VacuumCleanerMapper::fromModelDto)
                .collect(Collectors.toList()));
        return device;
    }

    private static Model fromModelDto(VacuumCleanerModelDto vacuumCleanerModelDto) {
        Model model = new Model();
        model.setName(vacuumCleanerModelDto.getName());
        model.setSerial(vacuumCleanerModelDto.getSerial());
        model.setColor(vacuumCleanerModelDto.getColor());
        model.setSize(vacuumCleanerModelDto.getSize());
        model.setPrice(vacuumCleanerModelDto.getPrice());
        model.setAvailability(vacuumCleanerModelDto.isAvailability());
        model.setCapacity(vacuumCleanerModelDto.getCapacity());
        model.setMode(vacuumCleanerModelDto.getMode());
        return model;
    }
}
