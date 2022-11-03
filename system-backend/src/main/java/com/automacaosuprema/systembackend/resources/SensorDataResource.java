package com.automacaosuprema.systembackend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automacaosuprema.systembackend.entities.SensorData;
import com.automacaosuprema.systembackend.repositories.SensorDataRepositorie;

@RestController
@RequestMapping(value = "/sensorData")
public class SensorDataResource {

    @Autowired
    private SensorDataRepositorie sensorDataRepositorie;

    @GetMapping
    public ResponseEntity<List<SensorData>> findAll() {
        List<SensorData> list = (List<SensorData>) sensorDataRepositorie.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<SensorData> insert(@RequestBody SensorData obj) {
        obj = sensorDataRepositorie.save(obj);
        return ResponseEntity.ok().body(obj);
    }

}
