package com.meuprojeto.atvdcomp3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "livro")
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String isbn;
    private String titulo;
    private BigDecimal precoDeCusto;
    private BigDecimal precoDeVenda;
    private BigDecimal margemDeLucro;
    private LocalDate dataDeCadastro;
}
