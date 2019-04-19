package com.s.gni_app.model.intancia;

public class TipoDespesa {

    private String nome;

    private int periodicidade;

    private int id;

    public TipoDespesa(){

    }

    public TipoDespesa(String nome, int periodicidade) {
        this.nome = nome;
        this.periodicidade = periodicidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(int periodicidade) {
        this.periodicidade = periodicidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return getNome();
    }
}
