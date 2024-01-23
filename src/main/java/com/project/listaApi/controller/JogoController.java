package com.project.listaApi.controller;
import com.project.listaApi.dto.JogoDto;
import com.project.listaApi.model.Jogo;
import com.project.listaApi.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @PostMapping
    @Transactional
    public ResponseEntity<JogoDto> criarJogo(@RequestBody JogoDto jogoDto) {
        Jogo jogoCriado = jogoService.criarJogo(jogoDto);
        JogoDto jogoCriadoDto = jogoService.converterParaDto(jogoCriado);
        return ResponseEntity.status(201).body(jogoCriadoDto);
    }

    @GetMapping
    public ResponseEntity<List<JogoDto>> listarJogos() {
        List<Jogo> jogos = jogoService.listarJogos();
        List<JogoDto> jogosDto = jogoService.converterParaDto(jogos);
        return ResponseEntity.ok(jogosDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogoDto> obterJogoPorId(@PathVariable Long id) {
        Jogo jogo = jogoService.obterJogoPorId(id);
        if (jogo != null) {
            JogoDto jogoDto = jogoService.converterParaDto(jogo);
            return ResponseEntity.ok(jogoDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<JogoDto> atualizarJogo(@PathVariable Long id, @RequestBody JogoDto atualizacaoJogoDto) {
        Jogo jogoAtualizado = jogoService.obterJogoPorId(id);

        if (jogoAtualizado != null) {
            jogoAtualizado.setNome(atualizacaoJogoDto.getNome());
            jogoAtualizado.setUrlImagem(atualizacaoJogoDto.getUrlImagem());
            jogoAtualizado.setCategoria(atualizacaoJogoDto.getCategoria());
            jogoAtualizado.setNota(atualizacaoJogoDto.getNota());
            jogoAtualizado.setTier(atualizacaoJogoDto.getTier());

            jogoAtualizado = jogoService.atualizarJogo(jogoAtualizado);
            JogoDto jogoAtualizadoDto = jogoService.converterParaDto(jogoAtualizado);
            return ResponseEntity.ok(jogoAtualizadoDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirJogo(@PathVariable Long id) {
        Jogo jogo = jogoService.obterJogoPorId(id);
        if (jogo != null) {
            jogoService.excluirJogo(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
