package com.project.listaApi.infra.security;

import com.project.listaApi.enums.PerfilUsuario;

public record RegisterDTO(String email, String senha, PerfilUsuario perfil) {
}
