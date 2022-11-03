package com.automacaosuprema.systembackend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automacaosuprema.systembackend.entities.SensorType;
import com.automacaosuprema.systembackend.repositories.SensorTypeRepositorie;

@RestController
@RequestMapping(value = "/sensors_types")
public class SensorTypeResource {

    @Autowired
    private SensorTypeRepositorie sensorRepositorie;

    @GetMapping
    public ResponseEntity<List<SensorType>> findAll() {
        List<SensorType> list = (List<SensorType>) sensorRepositorie.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SensorType> findById(@PathVariable Long id) {
        SensorType obj = sensorRepositorie.findById(id).get();
        return ResponseEntity.ok().body(obj);
    }
}
