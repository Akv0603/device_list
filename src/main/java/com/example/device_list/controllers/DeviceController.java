package com.example.device_list.controllers;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.entity.Device;
import com.example.device_list.services.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/device")
public class DeviceController {

    private DeviceService deviceService;

    @GetMapping
    public ResponseEntity<List<DeviceDto>> findAll(){
        return new ResponseEntity<>(deviceService.findAll(), HttpStatus.OK);
    }
}
