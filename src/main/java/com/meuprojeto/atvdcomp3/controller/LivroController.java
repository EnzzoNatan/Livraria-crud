package com.meuprojeto.atvdcomp3.controller;

import com.meuprojeto.atvdcomp3.model.Livro;
import com.meuprojeto.atvdcomp3.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;


    @PostMapping//Usado para guardar os dados
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro){
        livroService.criarLivro(livro);
        return ResponseEntity.ok(livro);
    }

    @GetMapping
    public ResponseEntity<Livro> consultarPorId(@RequestParam int id){
        return ResponseEntity.ok(livroService.consultarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Livro>>listarTodosOsLivros(){
        return ResponseEntity.ok(livroService.listarTodosOsLivros());
    }

    @PutMapping
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Integer id, @RequestBody Livro livro){
        Livro livroAtualizado = livroService.atualizarLivro(id, livro);
        return ResponseEntity.ok(livroAtualizado);
    }

    @DeleteMapping
    public ResponseEntity<Livro> deletarLivro(@PathVariable Integer id){
        livroService.deletarLivro(id);
        return ResponseEntity.ok().build();
    }


}
