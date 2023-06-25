package com.example.device_list.dto.modelsDto;

import com.example.device_list.dto.AbstractDeviceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
@Schema(description = "Пылесосы (DTO)")
public class VacuumCleanerDeviceDto extends AbstractDeviceDto {

    @Valid
    @Schema(description = "Список моделей пылесосов (DTO)")
    private List<VacuumCleanerModelDto> models;
}
