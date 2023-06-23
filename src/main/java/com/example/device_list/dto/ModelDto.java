package com.example.device_list.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ModelDto extends AbstractModelDto {

    //вид устройства для текущей модели
    private DeviceDto deviceDto;
}
