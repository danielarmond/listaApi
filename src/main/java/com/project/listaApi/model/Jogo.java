package com.project.listaApi.model;
import com.project.listaApi.enums.Categoria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "jogos")
@Entity(name = "jogos")
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

}