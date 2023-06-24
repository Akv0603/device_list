package com.example.device_list.dto.modelsDto;

import com.example.device_list.dto.AbstractModelDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class VacuumCleanerModelDto extends AbstractModelDto {

    @NotNull
    private BigDecimal capacity;

    @NotNull
    private Integer mode;
}
