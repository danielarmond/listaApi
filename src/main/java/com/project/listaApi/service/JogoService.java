package com.project.listaApi.service;
import com.project.listaApi.exception.JogoNotFoundException;
import com.project.listaApi.model.Jogo;
import com.project.listaApi.repository.JogoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class JogoService {

    private final JogoRepository jogoRepository;

    @Autowired
    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<Jogo> listaJogos() {
        return jogoRepository.findAll();
    }

    public Jogo adicionaJogo(Jogo jogo) {

        return jogoRepository.save(jogo);
    }

    public Jogo atualizaJogo(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    public Jogo buscaJogoPorId(Long id) {
        return jogoRepository.findJogoById(id)
                .orElseThrow(() -> new JogoNotFoundException("O id " + id + " não foi encontrado."));
    }

    public void deletaJogo(Long id){
        jogoRepository.deleteJogoById(id);
    }
}
