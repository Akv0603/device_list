package com.example.device_list.dto.modelsDto;

import com.example.device_list.dto.AbstractDeviceDto;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class FridgeDeviceDto extends AbstractDeviceDto {

    @Valid
    private List<FridgeModelDto> models;
}