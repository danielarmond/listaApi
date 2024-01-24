package com.project.listaApi.repository;
import com.project.listaApi.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository  extends JpaRepository<Jogo, Long> {

    void deleteJogoById(Long id);

    Optional<Jogo> findJogoById(Long id);
}