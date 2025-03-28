package com.github.lx025.study_apir.model;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String nome;
    private BigDecimal valor;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    
}
