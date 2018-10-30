package com.meiinc.mercadinho;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Usuario extends RealmObject implements Parcelable{
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String cidade;
   // private RealmList<Lista> listasDoUsuario;

    public Usuario(){}

    public Usuario(Parcel in){
        this.nome = in.readString();
        this.sobrenome = in.readString();
        this.email = in.readString();
        this.senha = in.readString();
        this.cidade= in.readString();
        //this.listasDoUsuario = new RealmList<>();
        //this.listasDoUsuario.addAll(in.createTypedArrayList(Lista.CREATOR));

    }

    public Usuario(String nome, String sobrenome, String email, String senha){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }


//    public Usuario(String nome, String email, String senha){
//        this.nome = nome;
//        this.email = email;
//        this.senha = senha;
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

//    public RealmList<Lista> getListasDoUsuario() {
//        return listasDoUsuario;
//    }
//
//    public void setListasDoUsuario(ArrayList<Lista> listasDoUsuario) {
//        this.listasDoUsuario = new RealmList<>();
//        this.listasDoUsuario.addAll(listasDoUsuario);
//    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nome);
        parcel.writeString(this.sobrenome);
        parcel.writeString(this.email);
        parcel.writeString(this.senha);
        parcel.writeString(this.cidade);
        //parcel.writeTypedList(this.listasDoUsuario);

    }

    public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };


}
