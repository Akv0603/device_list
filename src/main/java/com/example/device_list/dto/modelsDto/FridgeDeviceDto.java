package com.example.device_list.dto.modelsDto;

import com.example.device_list.dto.AbstractDeviceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
@Schema(description = "Холодильники (DTO)")
public class FridgeDeviceDto extends AbstractDeviceDto {

    @Valid
    @Schema(description = "Список моделей холодильников (DTO)")
    private List<FridgeModelDto> models;
}
