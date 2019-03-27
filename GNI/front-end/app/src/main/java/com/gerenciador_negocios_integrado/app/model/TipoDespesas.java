package com.gerenciador_negocios_integrado.app.model;

public class TipoDespesas {

    private String tipo;

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoDespesas() {
    }

    public TipoDespesas(String tipo) {
        this.nome = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
