package com.meiinc.mercadinho;

import java.util.ArrayList;

public class Lista {

    private String nomeLista;
    private String dataLista;
    private ArrayList<Produto> listaProduto;
    private ArrayList<Mercado> listaMercado;
    private float valorTotal;


    public Lista(String nomeLista, String dataLista, float valorTotal){
        this.dataLista = dataLista;
        this.nomeLista = nomeLista;
        this.valorTotal = valorTotal;
    }
    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(ArrayList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public ArrayList<Mercado> getListaMercado() {
        return listaMercado;
    }

    public void setListaMercado(ArrayList<Mercado> listaMercado) {
        this.listaMercado = listaMercado;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public String getDataLista() {
        return dataLista;
    }

    public void setDataLista(String dataLista) {
        this.dataLista = dataLista;
    }
}
