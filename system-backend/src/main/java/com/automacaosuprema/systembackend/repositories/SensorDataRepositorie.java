package com.automacaosuprema.systembackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automacaosuprema.systembackend.entities.SensorData;

public interface SensorDataRepositorie extends JpaRepository<SensorData, Long> {

}