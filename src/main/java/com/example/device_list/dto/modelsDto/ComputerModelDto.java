package com.example.device_list.dto.modelsDto;

import com.example.device_list.dto.AbstractModelDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ComputerModelDto extends AbstractModelDto {

    @NotBlank
    private String processor;

    @NotBlank
    private String category;
}
