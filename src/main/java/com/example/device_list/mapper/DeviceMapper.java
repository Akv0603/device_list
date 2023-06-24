package com.example.device_list.mapper;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.dto.ModelDto;
import com.example.device_list.entity.Device;
import com.example.device_list.entity.Model;

import java.util.stream.Collectors;

public class DeviceMapper {
    private static ModelDto toModelDto(Model model){
        ModelDto modelDto = new ModelDto();
        modelDto.setName(model.getName());
        modelDto.setSerial(model.getSerial());
        modelDto.setColor(model.getColor());
        modelDto.setSize(model.getSize());
        modelDto.setPrice(model.getPrice());
        modelDto.setAvailability(model.isAvailability());
        modelDto.setCategory(model.getCategory());
        modelDto.setTechnology(model.getTechnology());
        modelDto.setCapacity(model.getCapacity());
        modelDto.setMode(model.getMode());
        modelDto.setDoorCount(model.getDoorCount());
        modelDto.setCompressor(model.getCompressor());
        return modelDto;
    }

    public static DeviceDto toDto(Device device){
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setName(device.getName());
        deviceDto.setCountry(device.getCountry());
        deviceDto.setManufacturer(device.getManufacturer());
        deviceDto.setOnlineOrder(device.isOnlineOrder());
        deviceDto.setInstallment(device.isInstallment());
        deviceDto.setModels(device.getModels()
                .stream()
                .map(DeviceMapper::toModelDto)
                .collect(Collectors.toList()));
        return deviceDto;
    }
}
