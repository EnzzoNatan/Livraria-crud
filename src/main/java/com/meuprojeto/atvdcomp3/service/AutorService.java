package com.meuprojeto.atvdcomp3.service;

import com.meuprojeto.atvdcomp3.model.Autor;
import com.meuprojeto.atvdcomp3.model.Editora;
import com.meuprojeto.atvdcomp3.repository.AutorRepository;
import com.meuprojeto.atvdcomp3.repository.EditoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    public void criarAutor(Autor autor){
        autorRepository.saveAndFlush(autor);
    }

    public Autor consultarAutorPorId(Integer id){
        return autorRepository.findById(id).orElse(null);
    }

    public List<Autor> consultarTodosAutores(){
        return autorRepository.findAll();
    }

    public Autor atualizarAutores(Integer id, Autor autorAtualizado) {
        Optional<Autor> autorExistente = autorRepository.findById(id);

        if (autorExistente.isPresent()) {
            Autor autor = autorExistente.get();

            autor.setNome(autorAtualizado.getNome());
            autor.setEmail(autorAtualizado.getEmail());
            autor.setNacionalidade(autorAtualizado.getNacionalidade());

            return autorRepository.save(autor); // agora sim, atualiza o existente
        } else {
            throw new RuntimeException("Autor com id " + id + " não encontrado");
        }
    }


    public void deletarAutor(Integer id){
        autorRepository.deleteById(id);
    }



}
