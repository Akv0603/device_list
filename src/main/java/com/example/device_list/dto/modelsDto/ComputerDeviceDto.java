package com.example.device_list.dto.modelsDto;

import com.example.device_list.dto.AbstractDeviceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
@Schema(description = "Компьютеры (DTO)")
public class ComputerDeviceDto extends AbstractDeviceDto {

    @Valid
    @Schema(description = "Список моделей компьютеров(DTO)")
    private List<ComputerModelDto> models;
}
