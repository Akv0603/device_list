package com.example.device_list.mapper;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.dto.ModelDto;
import com.example.device_list.entity.Device;
import com.example.device_list.entity.Model;

public class ModelMapper {
    private static DeviceDto toDto(Device device) {
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setName(device.getName());
        deviceDto.setCountry(device.getCountry());
        deviceDto.setManufacturer(device.getManufacturer());
        deviceDto.setOnlineOrder(device.isOnlineOrder());
        deviceDto.setInstallment(device.isInstallment());
        return deviceDto;
    }

    public static ModelDto toModelDto(Model model){
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
        modelDto.setMemory(model.getMemory());
        modelDto.setCamera(model.getCamera());
        modelDto.setProcessor(model.getProcessor());
        return modelDto;
    }
}
