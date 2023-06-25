package com.example.device_list.controllers;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.dto.ModelDto;
import com.example.device_list.dto.modelsDto.PhoneDeviceDto;
import com.example.device_list.services.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/phone")
public class PhoneController {

    private PhoneService phoneService;

    @GetMapping("/name")
    public ResponseEntity<List<ModelDto>> findAllByName(@RequestParam String name){
        List<ModelDto> names = phoneService.findAllByName(name);
        if(names.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Смартфон не найден.");
        }
        return new ResponseEntity<>(names, HttpStatus.OK);
    }

    @GetMapping("/serial")
    public ResponseEntity<List<ModelDto>> findAllBySerial(@RequestParam String serial){
        List<ModelDto> serialList = phoneService.findAllBySerial(serial);
        if(serialList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Смартфон не найден.");
        }
        return new ResponseEntity<>(serialList, HttpStatus.OK);
    }

    @GetMapping("/color")
    public ResponseEntity<List<ModelDto>> findAllByColor(@RequestParam String color){
        List<ModelDto> colorList = phoneService.findAllByColor(color);
        if(colorList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Смартфон не найден.");
        }
        return new ResponseEntity<>(colorList, HttpStatus.OK);
    }

    @GetMapping("/size")
    public ResponseEntity<List<ModelDto>> findAllBySize(@RequestParam BigDecimal size){
        List<ModelDto> sizeList = phoneService.findAllBySize(size);
        if(sizeList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Смартфон не найден.");
        }
        return new ResponseEntity<>(sizeList, HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<List<ModelDto>> findAllByPrice(@RequestParam BigDecimal price){
        List<ModelDto> priceList = phoneService.findAllByPrice(price);
        if(priceList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Смартфоны по данной цене не найдены.");
        }
        return new ResponseEntity<>(priceList, HttpStatus.OK);
    }

    @GetMapping("/availability")
    public ResponseEntity<List<ModelDto>> findAllByAvailability(){
        List<ModelDto> avaList = phoneService.findAllByAvailability();
        return new ResponseEntity<>(avaList, HttpStatus.OK);
    }

    @GetMapping("/memory")
    public ResponseEntity<List<ModelDto>> findAllByMemory(@RequestParam Integer memory){
        List<ModelDto> doorCountList = phoneService.findAllByMemory(memory);
        if(doorCountList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Смартфон не найден.");
        }
        return new ResponseEntity<>(doorCountList, HttpStatus.OK);
    }

    @GetMapping("/camera")
    public ResponseEntity<List<ModelDto>> findAllByCamera(@RequestParam Integer camera){
        List<ModelDto> compressorList = phoneService.findAllByCamera(camera);
        if(compressorList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Смартфон не найден.");
        }
        return new ResponseEntity<>(compressorList, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DeviceDto>> findAll(){
        return new ResponseEntity<>(phoneService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PhoneDeviceDto> savePhone(@RequestBody PhoneDeviceDto phoneDeviceDto){
        return new ResponseEntity<>(phoneService.savePhone(phoneDeviceDto), HttpStatus.OK);
    }
}
