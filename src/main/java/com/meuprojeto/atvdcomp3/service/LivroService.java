package com.meuprojeto.atvdcomp3.service;


import com.meuprojeto.atvdcomp3.model.Autor;
import com.meuprojeto.atvdcomp3.model.Livro;
import com.meuprojeto.atvdcomp3.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private LivroRepository livroRepository;

    public LivroService (LivroRepository repository){
        this.livroRepository = repository;
    }

    public void criarLivro(Livro livro){
        livroRepository.saveAndFlush(livro);
    }

    public Livro consultarPorId(Integer id){
        return livroRepository.findById(id).orElse(null);
    }

    public List<Livro> listarTodosOsLivros(){
        return livroRepository.findAll();
    }

    public Livro atualizarLivro(Integer id, Livro livroAtualizado){
        Optional<Livro> livroExistente = livroRepository.findById(id);

        if(livroExistente.isPresent()){

            Livro livro =  livroExistente.get();

            livro.setNome(livroAtualizado.getNome());
            livro.setIsbn(livroAtualizado.getIsbn());
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setPrecoDeCusto(livroAtualizado.getPrecoDeCusto());
            livro.setPrecoDeVenda(livroAtualizado.getPrecoDeVenda());
            livro.setMargemDeLucro(livroAtualizado.getMargemDeLucro());
            livro.setDataDeCadastro(livroAtualizado.getDataDeCadastro());

            return livroRepository.save(livro);
            } else {
            throw new RuntimeException("Livro com id" + id + " nao encontrado");
        }
    }

    public void deletarLivro(Integer id){
        livroRepository.deleteById(id);
    }




}
