package com.automacaosuprema.systembackend.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserRoleDTO {

    private Long userId;

    private List<Long> rolesId;

}
