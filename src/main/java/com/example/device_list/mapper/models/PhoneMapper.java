package com.example.device_list.mapper.models;

import com.example.device_list.dto.modelsDto.PhoneDeviceDto;
import com.example.device_list.dto.modelsDto.PhoneModelDto;
import com.example.device_list.entity.Device;
import com.example.device_list.entity.Model;

import java.util.stream.Collectors;

public class PhoneMapper {
    public static Device fromDeviceDto(PhoneDeviceDto phoneDeviceDto) {
        Device device = new Device();
        device.setCountry(phoneDeviceDto.getCountry());
        device.setManufacturer(phoneDeviceDto.getManufacturer());
        device.setOnlineOrder(phoneDeviceDto.isOnlineOrder());
        device.setInstallment(phoneDeviceDto.isInstallment());
        device.setModels(phoneDeviceDto.getModels()
                .stream()
                .map(PhoneMapper::fromModelDto)
                .collect(Collectors.toList()));
        return device;
    }

    private static Model fromModelDto(PhoneModelDto phoneModelDto) {
        Model model = new Model();
        model.setName(phoneModelDto.getName());
        model.setSerial(phoneModelDto.getSerial());
        model.setColor(phoneModelDto.getColor());
        model.setSize(phoneModelDto.getSize());
        model.setPrice(phoneModelDto.getPrice());
        model.setAvailability(phoneModelDto.isAvailability());
        model.setMemory(phoneModelDto.getMemory());
        model.setCamera(phoneModelDto.getCamera());
        return model;
    }
}
