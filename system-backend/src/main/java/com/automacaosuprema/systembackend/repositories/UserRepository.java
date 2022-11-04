package com.automacaosuprema.systembackend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automacaosuprema.systembackend.entities.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    public Optional<UserModel> findByUserName(String userName);

}