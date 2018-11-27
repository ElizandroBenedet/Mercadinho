package com.meiinc.mercadinho;

import java.util.ArrayList;

public class Mercado{
    private String nome;
    private String cidade;
    private String telefone;
    private ArrayList<Produto> produtosDoMercado;

    public Mercado(String nome, String cidade, String telefone){
        this.nome = nome;
        this.cidade = cidade;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Produto> getProdutosDoMercado() {
        return produtosDoMercado;
    }

    public void setProdutosDoMercado(ArrayList<Produto> produtosDoMercado) {
        this.produtosDoMercado = produtosDoMercado;
    }

    public double getPrecoPorNome(String nomeProduto, String marcaProduto){
        for (int i = 0; i < produtosDoMercado.size(); i++){
            if(produtosDoMercado.get(i).getNome().equals(nomeProduto) && produtosDoMercado.get(i).getMarca().equals(marcaProduto))
                return produtosDoMercado.get(i).getPreco();
        }
        return 0;
    }
}
