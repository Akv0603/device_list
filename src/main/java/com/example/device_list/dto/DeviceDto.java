package com.example.device_list.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DeviceDto extends AbstractDeviceDto {

    private String name;

    private List<ModelDto> models;

}
