package com.example.device_list.controllers;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.dto.ModelDto;
import com.example.device_list.dto.modelsDto.TVDeviceDto;
import com.example.device_list.services.TVService;
import liquibase.pro.packaged.M;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tv")
public class TVController {

    private TVService tvService;

    @GetMapping("/name")
    public ResponseEntity<List<ModelDto>> findAllByName(@RequestParam String name){
        List<ModelDto> names = tvService.findAllByName(name);
        if(names.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Телевизор не найден.");
        }
        return new ResponseEntity<>(names, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DeviceDto>> findAll(){
        return new ResponseEntity<>(tvService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/serial")
    public ResponseEntity<List<ModelDto>> findAllBySerial(@RequestParam String serial){
        List<ModelDto> serialList = tvService.findAllBySerial(serial);
        if(serialList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Телевизора с данным серийным номером нет.");
        }
        return new ResponseEntity<>(serialList, HttpStatus.OK);
    }

    @GetMapping("/color")
    public ResponseEntity<List<ModelDto>> findAllByColor(@RequestParam String color){
        List<ModelDto> colorList = tvService.findAllByColor(color);
        if(colorList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Телевизор данного цвета отсутствует.");
        }
        return new ResponseEntity<>(colorList, HttpStatus.OK);
    }

    @GetMapping("/size")
    public ResponseEntity<List<ModelDto>> findAllBySize(@RequestParam BigDecimal size){
        List<ModelDto> sizeList = tvService.findAllBySize(size);
        if(sizeList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Телевизора такой диагонали нет.");
        }
        return new ResponseEntity<>(sizeList, HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<List<ModelDto>> findAllByPrice(@RequestParam BigDecimal price){
        List<ModelDto> priceList = tvService.findAllByPrice(price);
        if(priceList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Телевизоры по данной цене не найдены.");
        }
        return new ResponseEntity<>(priceList, HttpStatus.OK);
    }

    @GetMapping("/availability")
    public ResponseEntity<List<ModelDto>> findAllByAvailability(){
        List<ModelDto> avaList = tvService.findAllByAvailability();
        return new ResponseEntity<>(avaList, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<ModelDto>> findAllByCategory(@RequestParam String category){
        List<ModelDto> categoryList = tvService.findAllByCategory(category);
        if(categoryList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Телевизоры не найдены");
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/technology")
    public ResponseEntity<List<ModelDto>> findAllByTechnology(@RequestParam String technology){
        List<ModelDto> technoList = tvService.findAllByTechnology(technology);
        if(technoList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Телевизор не найден.");
        }
        return new ResponseEntity<>(technoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TVDeviceDto> saveTV(@RequestBody TVDeviceDto tvDeviceDto){
        return new ResponseEntity<>(tvService.saveTV(tvDeviceDto), HttpStatus.OK);
    }
}
