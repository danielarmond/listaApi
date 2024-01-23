package com.project.listaApi.dto;
import com.project.listaApi.enums.Categoria;

public class JogoDto {

    private String nome;
    private String urlImagem;
    private Categoria categoria;
    private int nota;
    private char tier;

    public JogoDto() {
    }

    public JogoDto(String nome, String urlImagem, Categoria categoria, int nota, char tier) {
        this.nome = nome;
        this.urlImagem = urlImagem;
        this.categoria = categoria;
        this.nota = nota;
        this.tier = tier;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public char getTier() {
        return tier;
    }

    public void setTier(char tier) {
        this.tier = tier;
    }
}
