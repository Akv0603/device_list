package com.example.device_list.controllers;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.dto.ModelDto;
import com.example.device_list.entity.Device;
import com.example.device_list.services.DeviceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/device")
@Tag(name = "ДНС-шоп", description = "Общий контроллер для техники")
public class DeviceController {

    private DeviceService deviceService;

    @GetMapping
    @Operation(summary = "Показать весь реестр")
    public ResponseEntity<List<DeviceDto>> findAll(){
        return new ResponseEntity<>(deviceService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/name")
    @Operation(summary = "Показать технику по названию")
    public ResponseEntity<List<ModelDto>> findByNameIgnoreCase(@RequestParam String name){
        List<ModelDto> nameList = deviceService.findAllByNameIgnoreCase(name);
        if(nameList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Товар не найден.");
        }
        return new ResponseEntity<>(nameList, HttpStatus.OK);
    }

    @GetMapping("/color")
    @Operation(summary = "Показать технику по цвету")
    public ResponseEntity<List<ModelDto>> findByColor(@RequestParam String color){
        List<ModelDto> colorList = deviceService.findAllByColor(color);
        if(colorList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Товар не найден.");
        }
        return new ResponseEntity<>(colorList, HttpStatus.OK);
    }

    @GetMapping("/nameAscending")
    @Operation(summary = "Показать технику по алфавиту")
    public ResponseEntity<List<ModelDto>> findAllSortByName(){
        return new ResponseEntity<>(deviceService.findAllSortByName(), HttpStatus.OK);
    }

    @GetMapping("/priceUp")
    @Operation(summary = "Показать технику по возрастанию цены")
    public ResponseEntity<List<ModelDto>> findAllSortByPrice(){
        return new ResponseEntity<>(deviceService.findAllSortByPrice(), HttpStatus.OK);
    }

    @GetMapping("/priceDesc")
    @Operation(summary = "Показать технику по убыванию цены")
    public ResponseEntity<List<ModelDto>> findAllSortByPriceDesc(){
        return new ResponseEntity<>(deviceService.findAllSortByPriceDesc(), HttpStatus.OK);
    }

    @GetMapping("/priceBetween")
    @Operation(summary = "Показать технику в выбраном ценовом диапазоне")
    public ResponseEntity<List<ModelDto>> findAllByPriceBetween(@RequestParam BigDecimal x,
                                                                @RequestParam BigDecimal y){
        List<ModelDto> priceBetweenList = deviceService.findAllByPriceBetween(x, y);
        if(priceBetweenList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Товар не найден.");
        }
        return new ResponseEntity<>(priceBetweenList, HttpStatus.OK);
    }
}

