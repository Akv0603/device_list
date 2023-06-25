package com.example.device_list.mapper.models;

import com.example.device_list.dto.modelsDto.FridgeDeviceDto;
import com.example.device_list.dto.modelsDto.FridgeModelDto;
import com.example.device_list.entity.Device;
import com.example.device_list.entity.Model;

import java.util.stream.Collectors;

public class FridgeMapper {
    public static Device fromDeviceDto(FridgeDeviceDto fridgeDeviceDto) {
        Device device = new Device();
        device.setCountry(fridgeDeviceDto.getCountry());
        device.setManufacturer(fridgeDeviceDto.getManufacturer());
        device.setOnlineOrder(fridgeDeviceDto.isOnlineOrder());
        device.setInstallment(fridgeDeviceDto.isInstallment());
        device.setModels(fridgeDeviceDto.getModels()
                .stream()
                .map(FridgeMapper::fromModelDto)
                .collect(Collectors.toList()));
        return device;
    }

    private static Model fromModelDto(FridgeModelDto fridgeModelDto) {
        Model model = new Model();
        model.setName(fridgeModelDto.getName());
        model.setSerial(fridgeModelDto.getSerial());
        model.setColor(fridgeModelDto.getColor());
        model.setSize(fridgeModelDto.getSize());
        model.setPrice(fridgeModelDto.getPrice());
        model.setAvailability(fridgeModelDto.isAvailability());
        model.setDoorCount(fridgeModelDto.getDoorCount());
        model.setCompressor(fridgeModelDto.getCompressor());
        return model;
    }
}
