package com.example.device_list.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    private String country;

    private String manufacturer;

    @Column(name = "online_order")
    private boolean onlineOrder;

    private boolean installment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
    private List<Model> models = new ArrayList<>();

}
