package com.example.device_list.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

//общие аттрибуты для устройств.
@Data
@Schema(description = "Общие атрибуты для техники(DTO). Абстрактный класс")
public abstract class AbstractDeviceDto {

    @Schema(description = "Страна происхождения")
    @NotBlank
    private String country;

    @Schema(description = "Производитель")
    @NotBlank
    private String manufacturer;

    @Schema(description = "Заказать онлайн (да/нет)")
    private boolean onlineOrder;

    @Schema(description = "Рассрочка платежа (да/нет)")
    private boolean installment;

}
