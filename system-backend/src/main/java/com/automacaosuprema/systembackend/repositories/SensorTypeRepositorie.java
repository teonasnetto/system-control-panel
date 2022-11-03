package com.automacaosuprema.systembackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automacaosuprema.systembackend.entities.SensorType;

public interface SensorTypeRepositorie extends JpaRepository<SensorType, Long> {

}
