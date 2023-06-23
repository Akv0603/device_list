package com.example.device_list.mapper.models;

import com.example.device_list.dto.modelsDto.TVDeviceDto;
import com.example.device_list.dto.modelsDto.TVModelDto;
import com.example.device_list.entity.Device;
import com.example.device_list.entity.Model;

import java.util.stream.Collectors;

public class TVMapper {
    public static Device fromDeviceDto(TVDeviceDto tvDeviceDto) {
        Device device = new Device();
        device.setCountry(tvDeviceDto.getCountry());
        device.setManufacturer(tvDeviceDto.getManufacturer());
        device.setOnlineOrder(tvDeviceDto.isOnlineOrder());
        device.setInstallment(tvDeviceDto.isInstallment());
        device.setModels(tvDeviceDto.getModels()
                .stream()
                .map(TVMapper::fromModelDto)
                .collect(Collectors.toList()));
        return device;
    }

    private static Model fromModelDto(TVModelDto tvModelDto) {
        Model model = new Model();
        model.setName(tvModelDto.getName());
        model.setSerial(tvModelDto.getSerial());
        model.setColor(tvModelDto.getColor());
        model.setSize(tvModelDto.getSize());
        model.setPrice(tvModelDto.getPrice());
        model.setAvailability(tvModelDto.isAvailability());
        model.setCategory(tvModelDto.getCategory());
        model.setTechnology(tvModelDto.getTechnology());
        return model;
    }
}
