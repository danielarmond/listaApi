package com.project.listaApi.service;
import com.project.listaApi.dto.JogoDto;
import com.project.listaApi.model.Jogo;
import com.project.listaApi.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public Jogo criarJogo(JogoDto jogoDto) {
        return new Jogo(jogoDto.getNome(), jogoDto.getUrlImagem(), jogoDto.getCategoria(), jogoDto.getNota(), jogoDto.getTier());
    }

    public JogoDto converterParaDto(Jogo jogo) {
        return new JogoDto(jogo.getNome(), jogo.getUrlImagem(), jogo.getCategoria(), jogo.getNota(), jogo.getTier());
    }

    public List<JogoDto> converterParaDto(List<Jogo> jogos) {
        return jogos.stream().map(this::converterParaDto).collect(Collectors.toList());
    }

    public Jogo obterJogoPorId(Long id) {
        return jogoRepository.findById(id).orElse(null);
    }

    public List<Jogo> listarJogos() {
        return jogoRepository.findAll();
    }

    public Jogo atualizarJogo(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    public void excluirJogo(Long id) {
        jogoRepository.deleteById(id);
    }
}
