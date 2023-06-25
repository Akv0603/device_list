package com.example.device_list.dto.modelsDto;

import com.example.device_list.dto.AbstractModelDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Модели смартфонов (DTO)")
public class PhoneModelDto extends AbstractModelDto {

    @NotNull
    @Schema(description = "Обьем памяти")
    private Integer memory;

    @NotNull
    @Schema(description = "Кол-во камер")
    private Integer camera;
}
