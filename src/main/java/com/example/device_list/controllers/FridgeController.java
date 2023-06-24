package com.example.device_list.controllers;

import com.example.device_list.dto.DeviceDto;
import com.example.device_list.dto.ModelDto;
import com.example.device_list.dto.modelsDto.FridgeDeviceDto;
import com.example.device_list.dto.modelsDto.VacuumCleanerDeviceDto;
import com.example.device_list.services.FridgeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/fridge")
public class FridgeController {

    private FridgeService fridgeService;

    @GetMapping("/name")
    public ResponseEntity<List<ModelDto>> findAllByName(@RequestParam String name){
        List<ModelDto> names = fridgeService.findAllByName(name);
        if(names.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Холодильник не найден.");
        }
        return new ResponseEntity<>(names, HttpStatus.OK);
    }

    @GetMapping("/serial")
    public ResponseEntity<List<ModelDto>> findAllBySerial(@RequestParam String serial){
        List<ModelDto> serialList = fridgeService.findAllBySerial(serial);
        if(serialList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Холодильник не найден.");
        }
        return new ResponseEntity<>(serialList, HttpStatus.OK);
    }

    @GetMapping("/color")
    public ResponseEntity<List<ModelDto>> findAllByColor(@RequestParam String color){
        List<ModelDto> colorList = fridgeService.findAllByColor(color);
        if(colorList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Холодильник не найден.");
        }
        return new ResponseEntity<>(colorList, HttpStatus.OK);
    }

    @GetMapping("/size")
    public ResponseEntity<List<ModelDto>> findAllBySize(@RequestParam BigDecimal size){
        List<ModelDto> sizeList = fridgeService.findAllBySize(size);
        if(sizeList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Холодильник не найден.");
        }
        return new ResponseEntity<>(sizeList, HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<List<ModelDto>> findAllByPrice(@RequestParam BigDecimal price){
        List<ModelDto> priceList = fridgeService.findAllByPrice(price);
        if(priceList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Холодильники по данной цене не найдены.");
        }
        return new ResponseEntity<>(priceList, HttpStatus.OK);
    }

    @GetMapping("/availability")
    public ResponseEntity<List<ModelDto>> findAllByAvailability(){
        List<ModelDto> avaList = fridgeService.findAllByAvailability();
        return new ResponseEntity<>(avaList, HttpStatus.OK);
    }

    @GetMapping("/door")
    public ResponseEntity<List<ModelDto>> findAllByDoorCount(@RequestParam Integer doorCount){
        List<ModelDto> doorCountList = fridgeService.findAllByDoorCount(doorCount);
        if(doorCountList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Холодильник не найден.");
        }
        return new ResponseEntity<>(doorCountList, HttpStatus.OK);
    }

    @GetMapping("/compressor")
    public ResponseEntity<List<ModelDto>> findAllByCompressor(@RequestParam String compressor){
        List<ModelDto> compressorList = fridgeService.findAllByCompressor(compressor);
        if(compressorList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Холодильник не найден.");
        }
        return new ResponseEntity<>(compressorList, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DeviceDto>> findAll(){
        return new ResponseEntity<>(fridgeService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FridgeDeviceDto> saveFridge(@RequestBody FridgeDeviceDto fridgeDeviceDto){
        return new ResponseEntity<>(fridgeService.saveFridge(fridgeDeviceDto), HttpStatus.OK);
    }
}
