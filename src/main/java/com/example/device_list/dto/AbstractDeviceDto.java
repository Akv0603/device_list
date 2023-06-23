package com.example.device_list.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

//общие аттрибуты для устройств.
@Data
public abstract class AbstractDeviceDto {

    @NotBlank
    private String country;

    @NotBlank
    private String manufacturer;

    private boolean onlineOrder;

    private boolean installment;

}
