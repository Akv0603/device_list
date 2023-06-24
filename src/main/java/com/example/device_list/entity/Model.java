package com.example.device_list.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    private String serial;

    private String color;

    private BigDecimal size;

    private BigDecimal price;

    private boolean availability;

    private String category;

    private String technology;

    private BigDecimal capacity;

    private Integer mode;

    @Column(name = "door_count")
    private Integer doorCount;

    private String compressor;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

}
