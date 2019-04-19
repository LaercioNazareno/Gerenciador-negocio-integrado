package com.s.gni_app.model.intancia;

public class Despesa {

    private String titulo;
    private int tipoId;
    private double valor;
    private String data;

    public Despesa() {
    }

    public Despesa(String titulo, int tipoId, double valor, String data) {
        this.titulo = titulo;
        this.tipoId = tipoId;
        this.valor = valor;
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTipo() {
        return tipoId;
    }

    public void setTipo(int tipoId) {
        this.tipoId = tipoId;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return titulo;
    }
}
