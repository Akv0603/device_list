package com.example.device_list.dto.modelsDto;

import com.example.device_list.dto.AbstractModelDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Schema(description = "Модели компьютеров (DTO)")
public class ComputerModelDto extends AbstractModelDto {

    @NotBlank
    @Schema(description = "Процессор")
    private String processor;

    @NotBlank
    @Schema(description = "Категория")
    private String category;
}
