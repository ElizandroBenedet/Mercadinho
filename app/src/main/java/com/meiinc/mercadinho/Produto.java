package com.meiinc.mercadinho;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import io.realm.RealmObject;

public class Produto implements Parcelable{
    private long id;
    private String nome;
    private String marca;
    private double preco;

    public Produto(){}

    public Produto(Parcel in){
        this.id = in.readLong();
        this.nome = in.readString();
        this.marca = in.readString();
        this.preco = in.readDouble();
    }

    public  Produto(String nome, String marca, double preco){
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.nome);
        parcel.writeString(this.marca);
        parcel.writeDouble(this.preco);
    }

    public static final Parcelable.Creator<Produto> CREATOR = new Parcelable.Creator<Produto>() {
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };
}
