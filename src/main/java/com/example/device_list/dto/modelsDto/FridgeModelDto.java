package com.example.device_list.dto.modelsDto;

import com.example.device_list.dto.AbstractModelDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Модели холодильников (DTO)")
public class FridgeModelDto extends AbstractModelDto {

    @NotNull
    @Schema(description = "Кол-во дверей")
    private Integer doorCount;

    @NotBlank
    @Schema(description = "тип компрессора")
    private String compressor;
}
