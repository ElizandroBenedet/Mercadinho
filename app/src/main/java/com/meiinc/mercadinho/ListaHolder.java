package com.meiinc.mercadinho;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class ListaHolder extends RecyclerView.ViewHolder  {

    private TextView tvNomeLista;
    private TextView tvDataLista;
    private TextView tvPrecoLista;

    public LinearLayout layout;

    public ListaHolder(View itemView) {
        super(itemView);
        this.tvDataLista = itemView.findViewById(R.id.tvDataLista);
        this.tvNomeLista = itemView.findViewById(R.id.tvNomeLista);
        this.tvPrecoLista = itemView.findViewById(R.id.tvPrecoLista);

    }

    public void atualizaLista(Lista lista){

        NumberFormat format = NumberFormat.getInstance();

        format.setMinimumIntegerDigits(1);
        format.setMinimumFractionDigits(0);
        format.setMaximumFractionDigits(2);


        tvNomeLista.setText(lista.getNomeLista());
        tvPrecoLista.setText(format.format(lista.getValorTotal()));
        tvDataLista.setText(lista.getDataLista());

    }

}
