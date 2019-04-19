package com.s.gni_app.model.intancia;

public class TipoReceita {

    private String nome;

    public TipoReceita() {
    }

    public TipoReceita(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return nome;
    }
}
