package com.meiinc.mercadinho;

public class Produto {
    private long id;
    private String nome;
    private String marca;
    private float peso;
    private String tipoPeso;
    private float preco;

    public  Produto(String nome, String marca, float peso, String tipoPeso){
        this.nome = nome;
        this.marca = marca;
        this.peso = peso;
        this.tipoPeso = tipoPeso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getTipoPeso() {
        return tipoPeso;
    }

    public void setTipoPeso(String tipoPeso) {
        this.tipoPeso = tipoPeso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
