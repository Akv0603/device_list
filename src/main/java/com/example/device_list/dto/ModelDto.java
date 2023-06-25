package com.example.device_list.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Schema(description = "Отдельные атрибуты моделей техники(DTO).")
public class ModelDto extends AbstractModelDto {

    //вид устройства для текущей модели
    @Schema(description = "Вид техники для данной модели (DTO)")
    private DeviceDto deviceDto;
//доп параметр для тв
    @Nullable
    @Schema(description = "Категория ТВ/Компьетеров")
    private String category;

//доп параметр для тв
    @Nullable
    @Schema(description = "Технология ТВ")
    private String technology;

    //доп параметр для пылесоса
    @Nullable
    @Schema(description = "Объем мешка пылесоса")
    private BigDecimal capacity;

    //доп параметр для пылесоса
    @Nullable
    @Schema(description = "Кол-во режимов пылесоса")
    private Integer mode;

    //доп параметр для холодильника
    @Nullable
    @Schema(description = "Кол-во дверей холодильника")
    private Integer doorCount;

    //доп параметр для холодильника
    @Nullable
    @Schema(description = "тип компрессора")
    private String compressor;

    //доп параметр для смартфона
    @Nullable
    @Schema(description = "кол-во памяти")
    private Integer memory;

    //доп параметр для смартфона
    @Nullable
    @Schema(description = "Кол-во камер")
    private Integer camera;

    @Nullable
    @Schema(description = "Процессор, модель ")
    private String processor;
}
