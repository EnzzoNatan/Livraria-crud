package com.meuprojeto.atvdcomp3.service;


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

    public Livro atualizarLivro(Integer id, Livro livro){
        Optional<Livro> livroExistente = livroRepository.findById(id);
        if(livroExistente.isPresent()){

            livro.setNome(livro.getNome());
            livro.setIsbn(livro.getIsbn());
            livro.setTitulo(livro.getTitulo());
            livro.setPrecoDeCusto(livro.getPrecoDeCusto());
            livro.setPrecoDeVenda(livro.getPrecoDeVenda());
            livro.setMargemDeLucro(livro.getMargemDeLucro());
            livro.setDataDeCadastro(livro.getDataDeCadastro());

            return livroRepository.save(livro);
            } else {
            throw new RuntimeException("Livro com id" + id + " nao encontrado");
        }
    }

    public void deletarLivro(Integer id){
        livroRepository.deleteById(id);
    }




}
