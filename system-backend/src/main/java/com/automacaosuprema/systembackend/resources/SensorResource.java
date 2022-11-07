package com.automacaosuprema.systembackend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automacaosuprema.systembackend.entities.Sensor;
import com.automacaosuprema.systembackend.repositories.SensorRepositorie;

@RestController
@RequestMapping(value = "/sensors")
public class SensorResource {

    @Autowired
    private SensorRepositorie sensorRepositorie;

    @GetMapping
    public ResponseEntity<List<Sensor>> findAll() {
        List<Sensor> list = (List<Sensor>) sensorRepositorie.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sensor> findById(@PathVariable Long id) {
        Sensor obj = sensorRepositorie.findById(id).get();
        return ResponseEntity.ok().body(obj);
    }
}
