package com.automacaosuprema.systembackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automacaosuprema.systembackend.entities.Sensor;

public interface SensorRepositorie extends JpaRepository<Sensor, Long> {

}