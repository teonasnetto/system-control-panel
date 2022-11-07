package com.automacaosuprema.systembackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automacaosuprema.systembackend.entities.Place;

public interface RoleRepositiry extends JpaRepository<Place, Long> {

}