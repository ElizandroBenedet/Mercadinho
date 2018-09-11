package com.meiinc.mercadinho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class telaListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista);
    }

    public void adicionaItem(View quemClicou){
        Intent intencao = new Intent(getApplicationContext(), CriarListaActivity.class);
        startActivity(intencao);
    }

    public void voltar(View quemClicou){
        finish();
    }
}

