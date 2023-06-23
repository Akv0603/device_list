package com.example.device_list.repository;

import com.example.device_list.entity.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceRepository extends CrudRepository<Device, Integer> {

    List<Device> findAll();
}
