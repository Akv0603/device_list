package com.example.device_list.dto.modelsDto;

import com.example.device_list.dto.AbstractModelDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Schema(description = "Модели телевизоров (DTO)")
public class TVModelDto extends AbstractModelDto {

    @NotBlank
    @Schema(description = "Категория тв")
    private String category;

    @NotBlank
    @Schema(description = "Технология тв")
    private String technology;
}
