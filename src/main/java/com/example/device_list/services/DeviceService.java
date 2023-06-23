package com.example.device_list.services;

import com.example.device_list.entity.Device;
import com.example.device_list.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeviceService {

    private DeviceRepository deviceRepository;

    public List<Device> findAll(){
        return deviceRepository.findAll();
    }
}
