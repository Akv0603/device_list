package com.example.device_list.controllers;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.dto.ModelDto;
import com.example.device_list.services.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
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

    @GetMapping("/name")
    public ResponseEntity<List<ModelDto>> findByNameIgnoreCase(@RequestParam String name){
        List<ModelDto> nameList = deviceService.findAllByNameIgnoreCase(name);
        if(nameList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Товар не найден.");
        }
        return new ResponseEntity<>(nameList, HttpStatus.OK);
    }

    @GetMapping("/color")
    public ResponseEntity<List<ModelDto>> findByColor(@RequestParam String color){
        List<ModelDto> colorList = deviceService.findAllByColor(color);
        if(colorList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Товар не найден.");
        }
        return new ResponseEntity<>(colorList, HttpStatus.OK);
    }

    @GetMapping("/nameAscending")
    public ResponseEntity<List<ModelDto>> findAllSortByName(){
        return new ResponseEntity<>(deviceService.findAllSortByName(), HttpStatus.OK);
    }

    @GetMapping("/priceUp")
    public ResponseEntity<List<ModelDto>> findAllSortByPrice(){
        return new ResponseEntity<>(deviceService.findAllSortByPrice(), HttpStatus.OK);
    }

    @GetMapping("/priceDesc")
    public ResponseEntity<List<ModelDto>> findAllSortByPriceDesc(){
        return new ResponseEntity<>(deviceService.findAllSortByPriceDesc(), HttpStatus.OK);
    }

    @GetMapping("/priceBetween")
    public ResponseEntity<List<ModelDto>> findAllByPriceBetween(@RequestParam BigDecimal x,
                                                                @RequestParam BigDecimal y){
        List<ModelDto> priceBetweenList = deviceService.findAllByPriceBetween(x, y);
        if(priceBetweenList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Товар не найден.");
        }
        return new ResponseEntity<>(priceBetweenList, HttpStatus.OK);
    }
}

