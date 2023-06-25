package com.example.device_list.dto.modelsDto;

import com.example.device_list.dto.AbstractModelDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Schema(description = "Модели пылесосов (DTO)")
public class VacuumCleanerModelDto extends AbstractModelDto {

    @NotNull
    @Schema(description = "Объем мешка")
    private BigDecimal capacity;

    @NotNull
    @Schema(description = "Кол-во режимов")
    private Integer mode;
}
