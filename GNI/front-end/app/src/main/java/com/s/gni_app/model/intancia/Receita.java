package com.s.gni_app.model.intancia;

public class Receita {

    private int tipoId;
    private double valor;
    private String data;

    public Receita() {
    }

    public Receita(int tipoId, double valor, String data) {
        this.tipoId = tipoId;
        this.valor = valor;
        this.data = data;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
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
    public String toString() {
        return String.valueOf(valor);
    }

}