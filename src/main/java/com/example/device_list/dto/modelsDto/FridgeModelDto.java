package com.example.device_list.dto.modelsDto;

import com.example.device_list.dto.AbstractModelDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class FridgeModelDto extends AbstractModelDto {

    @NotNull
    private Integer doorCount;

    @NotBlank
    private String compressor;
}
