package com.example.device_list.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Schema(description = "Общие атрибуты для техники(DTO)(название, список моделей)")
public class DeviceDto extends AbstractDeviceDto {

    @Schema(description = "Название")
    private String name;

    @Schema(description = "Список моделей для видов техники ")
    private List<ModelDto> models;

}
