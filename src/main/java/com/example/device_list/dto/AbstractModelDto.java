package com.example.device_list.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
public abstract class AbstractModelDto {

    private String name;

    private String serial;

    private String color;

    private BigDecimal size;

    private BigDecimal price;

    private boolean availability;

}
