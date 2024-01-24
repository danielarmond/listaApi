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

    public Jogo atualizaJogo(Long id, Jogo jogoAtualizado) {
        Jogo jogoExistente = buscaJogoPorId(id);

        if (jogoExistente != null) {
            jogoExistente.setNome(jogoAtualizado.getNome());
            jogoExistente.setUrlImagem(jogoAtualizado.getUrlImagem());
            jogoExistente.setCategoria(jogoAtualizado.getCategoria());
            jogoExistente.setNota(jogoAtualizado.getNota());
            jogoExistente.setTier(jogoAtualizado.getTier());

            return jogoRepository.save(jogoExistente);
        } else {
            return null;
        }
    }

    public Jogo buscaJogoPorId(Long id) {
        return jogoRepository.findJogoById(id)
                .orElseThrow(() -> new JogoNotFoundException("O id " + id + " não foi encontrado."));
    }

    public void deletaJogo(Long id){
        jogoRepository.deleteJogoById(id);
    }
}
