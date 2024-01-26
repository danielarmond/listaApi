package com.project.listaApi.enums;

public enum PerfilUsuario {
    ADMIN("admin"),
    USUARIO("usuário");

    private String perfil;

    PerfilUsuario(String perfil){
        this.perfil = perfil;
    }

    public String getPerfil(){
        return perfil;
    }
}
