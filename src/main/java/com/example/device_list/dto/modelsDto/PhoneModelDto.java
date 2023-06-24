package com.example.device_list.dto.modelsDto;

import com.example.device_list.dto.AbstractModelDto;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PhoneModelDto extends AbstractModelDto {

    @NotNull
    private Integer memory;

    @NotNull
    private Integer camera;
}
