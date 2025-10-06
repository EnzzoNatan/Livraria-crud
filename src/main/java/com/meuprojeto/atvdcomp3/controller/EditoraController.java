package com.meuprojeto.atvdcomp3.controller;

import com.meuprojeto.atvdcomp3.model.Editora;
import com.meuprojeto.atvdcomp3.service.EditoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoras")
@RequiredArgsConstructor
public class EditoraController {

    private final EditoraService editoraService;

    @PostMapping
    public ResponseEntity<Editora> criarEditora(@RequestBody Editora editora){
       editoraService.criarEditora(editora);
        return ResponseEntity.ok(editora);
    }

    @GetMapping
    public ResponseEntity<Editora>consultarEditoraId(@RequestParam Integer id){
        return ResponseEntity.ok(editoraService.consultarEditoraId(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Editora>> listarTodosAsEditoras(){
        return ResponseEntity.ok(editoraService.listarTodosAsEditoras());
    }

    @PutMapping
    public ResponseEntity<Editora> atualizarEditora(@RequestParam Integer id, @RequestBody Editora editora){
        Editora editoraAtualizada = editoraService.atualizarEditora(id, editora);
        return ResponseEntity.ok(editoraAtualizada);
    }

    @DeleteMapping
    public ResponseEntity<Editora> deletarEditora(@RequestParam Integer id){
        editoraService.deletarEditora(id);
        return ResponseEntity.ok().build();
    }


}
