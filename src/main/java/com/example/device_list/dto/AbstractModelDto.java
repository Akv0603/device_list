package com.example.device_list.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Schema(description = "Общие атрибуты моделей техники(DTO). Абстрактный класс")
public abstract class AbstractModelDto {

    @Schema(description = "Название модели")
    private String name;

    @Schema(description = "Серийный номер модели")
    private String serial;

    @Schema(description = "Цвет модели")
    private String color;

    @Schema(description = "Размер модели")
    private BigDecimal size;

    @Schema(description = "Цена модели")
    private BigDecimal price;

    @Schema(description = "Наличие модели(да/нет)")
    private boolean availability;

}
