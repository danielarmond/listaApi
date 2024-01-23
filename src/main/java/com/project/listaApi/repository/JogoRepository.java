package com.project.listaApi.repository;
import com.project.listaApi.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface JogoRepository  extends JpaRepository<Jogo, Long> {
    @Query(value = "SELECT u FROM Jogo u WHERE u.nome = ?1")
    List<Jogo> buscaNome(String descricao);
}