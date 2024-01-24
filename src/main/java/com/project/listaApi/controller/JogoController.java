package com.project.listaApi.controller;
import com.project.listaApi.model.Jogo;
import com.project.listaApi.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    @Autowired
    JogoService jogoService;
    @GetMapping
    public ResponseEntity<List<Jogo>> listarJogos () {
        List<Jogo> employees = jogoService.listaJogos();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> buscaJogoPorId (@PathVariable("id") Long id) {
        Jogo jogo = jogoService.buscaJogoPorId(id);
        return new ResponseEntity<>(jogo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Jogo> adicionaJogo(@RequestBody Jogo jogo) {
        Jogo novoJogo = jogoService.adicionaJogo(jogo);
        return new ResponseEntity<>(novoJogo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizaJogo(@PathVariable("id") Long id, @RequestBody Jogo jogo) {
        Jogo jogoExistente = jogoService.buscaJogoPorId(id);
        if (jogoExistente != null) {
            jogoExistente.setNome(jogo.getNome());
            jogoExistente.setUrlImagem(jogo.getUrlImagem());
            jogoExistente.setCategoria(jogo.getCategoria());
            jogoExistente.setNota(jogo.getNota());
            jogoExistente.setTier(jogo.getTier());

            Jogo atualizaJogo = jogoService.atualizaJogo(jogoExistente);
        return new ResponseEntity<>(atualizaJogo, HttpStatus.OK);
    } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaJogo(@PathVariable("id") Long id) {
        jogoService.deletaJogo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
