package com.example.device_list.services;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.entity.Device;
import com.example.device_list.mapper.DeviceMapper;
import com.example.device_list.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeviceService {

    private DeviceRepository deviceRepository;

    public List<DeviceDto> findAll(){
        return deviceRepository.findAll()
                .stream()
                .map(DeviceMapper::toDto)
                .collect(Collectors.toList());
    }
}
