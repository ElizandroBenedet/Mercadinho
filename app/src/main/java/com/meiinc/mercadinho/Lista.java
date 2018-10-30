package com.meiinc.mercadinho;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Lista implements Parcelable{

    private String nomeLista;
    private String dataLista;
    private double valorTotal;
    private ArrayList<Produto> listaProdutos;
    //private RealmList<Produto> listaProdutos;
    //private RealmList<Mercado> listaMercado;


    public Lista(){}

    public Lista(Parcel in){
        this.nomeLista = in.readString();
        this.dataLista = in.readString();
        this.valorTotal = in.readDouble();
        //this.listaProdutos = new RealmList<>();
        //this.listaProdutos.addAll(in.createTypedArrayList(Produto.CREATOR));
    }

    public Lista(String nomeLista, String dataLista, double valorTotal){
        this.dataLista = dataLista;
        this.nomeLista = nomeLista;
        this.valorTotal = valorTotal;

    }
//    public RealmList<Produto> getListaProduto() {
//        return listaProdutos;
//    }
//
//    public void setListaProduto(ArrayList<Produto> listaProduto) {
//        this.listaProdutos.addAll(listaProduto);
//    }
//
//    public RealmList<Mercado> getListaMercado() {
//        return listaMercado;
//    }
//
//    public void setListaMercado(RealmList<Mercado> listaMercado) {
//        this.listaMercado = listaMercado;
//    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nomeLista);
        parcel.writeString(this.dataLista);
        parcel.writeDouble(this.valorTotal);
        //parcel.writeTypedList(this.listaProdutos);
    }

    public static final Parcelable.Creator<Lista> CREATOR = new Parcelable.Creator<Lista>() {
        public Lista createFromParcel(Parcel in) {
            return new Lista(in);
        }

        public Lista[] newArray(int size) {
            return new Lista[size];
        }
    };

    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}
