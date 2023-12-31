package com.example.device_list.controllers;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.dto.ModelDto;
import com.example.device_list.dto.modelsDto.ComputerDeviceDto;
import com.example.device_list.services.ComputerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/computer")
@Tag(name = "Компьютеры", description = "Контроллер для компьютеров")
public class ComputerController {

    private ComputerService computerService;

    @GetMapping("/name")
    @Operation(summary = "Показать компьютеры по названию")
    public ResponseEntity<List<ModelDto>> findAllByName(@RequestParam String name){
        List<ModelDto> names = computerService.findAllByName(name);
        if(names.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Компьютер не найден");
        }
        return new ResponseEntity<>(names, HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "Показать все компьютеры")
    public ResponseEntity<List<DeviceDto>> findAll(){
        return new ResponseEntity<>(computerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/serial")
    @Operation(summary = "Показать компьютеры по серийнику")
    public ResponseEntity<List<ModelDto>> findAllBySerial(@RequestParam String serial){
        List<ModelDto> serialList = computerService.findAllBySerial(serial);
        if(serialList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Компьютер не найден");
        }
        return new ResponseEntity<>(serialList, HttpStatus.OK);
    }

    @GetMapping("/color")
    @Operation(summary = "Показать компьютеры по цвету")
    public ResponseEntity<List<ModelDto>> findAllByColor(@RequestParam String color){
        List<ModelDto> colorList = computerService.findAllByColor(color);
        if(colorList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Компьютер не найден");
        }
        return new ResponseEntity<>(colorList, HttpStatus.OK);
    }

    @GetMapping("/size")
    @Operation(summary = "Показать компьютеры по размеру оперативной памяти")
    public ResponseEntity<List<ModelDto>> findAllBySize(@RequestParam BigDecimal size){
        List<ModelDto> sizeList = computerService.findAllBySize(size);
        if(sizeList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Компьютер не найден");
        }
        return new ResponseEntity<>(sizeList, HttpStatus.OK);
    }

    @GetMapping("/price")
    @Operation(summary = "Показать компьютеры по цене")
    public ResponseEntity<List<ModelDto>> findAllByPrice(@RequestParam BigDecimal price){
        List<ModelDto> priceList = computerService.findAllByPrice(price);
        if(priceList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Компьютеры по данной цене не найдены.");
        }
        return new ResponseEntity<>(priceList, HttpStatus.OK);
    }

    @GetMapping("/availability")
    @Operation(summary = "Показать компьютеры по наличию")
    public ResponseEntity<List<ModelDto>> findAllByAvailability(){
        List<ModelDto> avaList = computerService.findAllByAvailability();
        return new ResponseEntity<>(avaList, HttpStatus.OK);
    }

    @GetMapping("/category")
    @Operation(summary = "Показать компьютеры по категории")
    public ResponseEntity<List<ModelDto>> findAllByCategory(@RequestParam String category){
        List<ModelDto> categoryList = computerService.findAllByCategory(category);
        if(categoryList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Компьютеры не найдены");
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/processor")
    @Operation(summary = "Показать компьютеры по модели процессора")
    public ResponseEntity<List<ModelDto>> findAllByProcessor(@RequestParam String processor){
        List<ModelDto> technoList = computerService.findAllByProcessor(processor);
        if(technoList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Компьютер не найден.");
        }
        return new ResponseEntity<>(technoList, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Добавить новый компьютер")
    public ResponseEntity<ComputerDeviceDto> saveTV(@Valid @RequestBody ComputerDeviceDto computerDeviceDto){
        return new ResponseEntity<>(computerService.saveComputer(computerDeviceDto), HttpStatus.OK);
    }
}
