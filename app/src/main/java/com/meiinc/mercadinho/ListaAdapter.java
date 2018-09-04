package com.meiinc.mercadinho;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListaAdapter extends RecyclerView.Adapter {

    ArrayList <Lista> lista;

    public void setLista(ArrayList <Lista> lista){
        this.lista = lista;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_produtos, parent, false);


        ListaHolder gaveta = new ListaHolder(layoutView);
        return gaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final ListaHolder lista = (ListaHolder) holder;
        final Lista atual = this.lista.get(position);
        lista.atualizaLista( atual );
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }
}
