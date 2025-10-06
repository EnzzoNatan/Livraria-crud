package com.meuprojeto.atvdcomp3.service;

import com.meuprojeto.atvdcomp3.model.Editora;
import com.meuprojeto.atvdcomp3.repository.EditoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {

    private final EditoraRepository editoraRepository;

    public EditoraService(EditoraRepository editoraRepository){
        this.editoraRepository = editoraRepository;
    }

    public void criarEditora(Editora editora){
        editoraRepository.saveAndFlush(editora);
    }

    public Editora consultarEditoraId(Integer id){
        return editoraRepository.findById(id).orElse(null);
    }

    public List<Editora> listarTodosAsEditoras(){
        return editoraRepository.findAll();
    }

    public Editora atualizarEditora(Integer id, Editora editora){
        Optional<Editora> editoraExistente = editoraRepository.findById(id);
        if(editoraExistente.isPresent()){

            editora.setNome(editora.getNome());
            editora.setEmail(editora.getEmail());
            editora.setCidade(editora.getCidade());
            editora.setEstado(editora.getEstado());

            return editoraRepository.save(editora);
        } else {
            throw new RuntimeException("Editora com id" + id + " nao encontrado");
        }
    }

    public void deletarEditora(Integer id){
        editoraRepository.deleteById(id);
    }

}
