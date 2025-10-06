package com.meuprojeto.atvdcomp3.controller;

import com.meuprojeto.atvdcomp3.model.Autor;
import com.meuprojeto.atvdcomp3.service.AutorService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @PostMapping
    public ResponseEntity<Autor> criarAutor(@RequestBody Autor autor){
        autorService.criarAutor(autor);
        return ResponseEntity.ok(autor);
    }

    @GetMapping
    public ResponseEntity<Autor> consultarAutorPorId(@RequestParam Integer id){
        return ResponseEntity.ok(autorService.consultarAutorPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Autor>> consultarTodosAutores(){
        return ResponseEntity.ok(autorService.consultarTodosAutores());
    }

    @PutMapping
    public ResponseEntity<Autor> atualizarAutores(@PathVariable Integer id, @RequestBody Autor autor){
        Autor autorAtualizado = autorService.atualizarAutores(id, autor);
        return ResponseEntity.ok(autorAtualizado);
    }

    @DeleteMapping
    public ResponseEntity<Autor> deletarAutor(@PathVariable Integer id){
        autorService.deletarAutor(id);
        return ResponseEntity.ok().build();
    }

}
