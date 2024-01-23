package com.project.listaApi.model;
import com.project.listaApi.enums.Categoria;
import jakarta.persistence.*;

@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String urlImagem;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private int nota;
    private char tier;

    public Jogo(Long id, String nome, String urlImagem, Categoria categoria, int nota, char tier) {
        this.id = id;
        this.nome = nome;
        this.urlImagem = urlImagem;
        this.categoria = categoria;
        this.nota = nota;
        this.tier = tier;
    }

    public Jogo(String nome, String urlImagem, Categoria categoria, int nota, char tier) {
        this.nome = nome;
        this.urlImagem = urlImagem;
        this.categoria = categoria;
        this.nota = nota;
        this.tier = tier;
    }

    public Jogo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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