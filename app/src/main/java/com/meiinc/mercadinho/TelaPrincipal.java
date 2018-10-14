package com.meiinc.mercadinho;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TelaPrincipal extends AppCompatActivity {

    private String userCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        Bundle mochila = getIntent().getExtras();
        if(mochila != null){
            userCity = mochila.getString("userCity");
        }
        ArrayList <Lista> lista = new ArrayList<>();

        lista.add(new Lista("Lista da quarta", "07/08/2018", 351));
        lista.add(new Lista("Lista da quarta", "07/08/2018", 351));
        lista.add(new Lista("Lista da quarta", "07/08/2018", 351));
        lista.add(new Lista("Lista da quarta", "07/08/2018", 351));

        for (int i = 0; i<100; i++){
            lista.add(new Lista("Lista da quarta", "07/08/2018", 351+i));
        }
        RecyclerView rvLista = findViewById(R.id.rvLista);
        rvLista.addItemDecoration(new DividerItemDecoration(this.getApplicationContext(), DividerItemDecoration.VERTICAL));
        rvLista.setHasFixedSize(true);
        rvLista.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        rvLista.setItemAnimator(new DefaultItemAnimator());
        ListaAdapter adapter = new ListaAdapter();
        adapter.setLista(lista);

        rvLista.setAdapter(adapter);

    }

    public void adicionarLista(View quemClicou){
        Intent intencao = new Intent(getApplicationContext(), CriarListaActivity.class);
        intencao.putExtra("userCity", userCity);
        startActivity(intencao);
    }

    public void telaGrafico (View quemClicou){
        Intent intencao = new Intent(getApplicationContext(), TelaGraficoActivity.class);
        startActivity(intencao);
    }

    public void logout (View quemClicou){
        setResult(RESULT_CANCELED);
        finish();
    }
}
