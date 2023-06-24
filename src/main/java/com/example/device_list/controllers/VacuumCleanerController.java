package com.example.device_list.controllers;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.dto.ModelDto;
import com.example.device_list.dto.modelsDto.VacuumCleanerDeviceDto;
import com.example.device_list.services.VacuumCleanerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vacuum")
public class VacuumCleanerController {

    private VacuumCleanerService service;

    @GetMapping("/name")
    public ResponseEntity<List<ModelDto>> findAllByName(@RequestParam String name){
        List<ModelDto> names = service.findAllByName(name);
        if(names.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пылесос не найден.");
        }
        return new ResponseEntity<>(names, HttpStatus.OK);
    }

    @GetMapping("/serial")
    public ResponseEntity<List<ModelDto>> findAllBySerial(@RequestParam String serial){
        List<ModelDto> serialList = service.findAllBySerial(serial);
        if(serialList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пылесос не найден.");
        }
        return new ResponseEntity<>(serialList, HttpStatus.OK);
    }

    @GetMapping("/color")
    public ResponseEntity<List<ModelDto>> findAllByColor(@RequestParam String color){
        List<ModelDto> colorList = service.findAllByColor(color);
        if(colorList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пылесос не найден.");
        }
        return new ResponseEntity<>(colorList, HttpStatus.OK);
    }

    @GetMapping("/size")
    public ResponseEntity<List<ModelDto>> findAllBySize(@RequestParam BigDecimal size){
        List<ModelDto> sizeList = service.findAllBySize(size);
        if(sizeList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пылесос не найден.");
        }
        return new ResponseEntity<>(sizeList, HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<List<ModelDto>> findAllByPrice(@RequestParam BigDecimal price){
        List<ModelDto> priceList = service.findAllByPrice(price);
        if(priceList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пылесосы по данной цене не найдены.");
        }
        return new ResponseEntity<>(priceList, HttpStatus.OK);
    }

    @GetMapping("/availability")
    public ResponseEntity<List<ModelDto>> findAllByAvailability(){
        List<ModelDto> avaList = service.findAllByAvailability();
        return new ResponseEntity<>(avaList, HttpStatus.OK);
    }

    @GetMapping("/capacity")
    public ResponseEntity<List<ModelDto>> findAllByCapacity(@RequestParam BigDecimal capacity){
        List<ModelDto> capacityList = service.findAllByCapacity(capacity);
        if(capacityList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пылесос не найден.");
        }
        return new ResponseEntity<>(capacityList, HttpStatus.OK);
    }

    @GetMapping("/mode")
    public ResponseEntity<List<ModelDto>> findAllByMode(@RequestParam Integer mode){
        List<ModelDto> modeList = service.findAllByMode(mode);
        if(modeList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пылесос не найден.");
        }
        return new ResponseEntity<>(modeList, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DeviceDto>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VacuumCleanerDeviceDto> saveTV(@RequestBody VacuumCleanerDeviceDto vacuumCleanerDeviceDto){
        return new ResponseEntity<>(service.saveVacuum(vacuumCleanerDeviceDto), HttpStatus.OK);
    }
}
