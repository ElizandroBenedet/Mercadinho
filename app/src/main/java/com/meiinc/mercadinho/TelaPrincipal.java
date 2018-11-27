package com.meiinc.mercadinho;

import android.app.Activity;
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
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TelaPrincipal extends AppCompatActivity {

    private String userCity;
    public ArrayList <Lista> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        //Bundle mochila = getIntent().getExtras();
//        if(mochila != null){
//            userCity = mochila.getString("userCity");
//        }
        //Usuario usuarioLogado = (Usuario) getIntent().getSerializableExtra("usuario");
        //ArrayList <Lista> lista = new ArrayList<>();

//        for (int i = 0; i<3; i++){
//            //lista.add(new ListaParaAdapter(usuarioLogado.getListas().get(i).getNomeLista(), usuarioLogado.getListas().get(i).getDataLista(), usuarioLogado.getListas().get(i).getValorTotal()));
//            lista.add(new Lista("Lista "+i, i+1+"/10/2018", 10.00+i));
//        }
        RecyclerView rvLista = findViewById(R.id.rvLista);
        rvLista.addItemDecoration(new DividerItemDecoration(this.getApplicationContext(), DividerItemDecoration.VERTICAL));
        rvLista.setHasFixedSize(true);
        rvLista.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        rvLista.setItemAnimator(new DefaultItemAnimator());
        ListaAdapter adapter = new ListaAdapter();
        adapter.setLista(lista);

        rvLista.setAdapter(adapter);
        //rvLista.setOnClickListener();

    }

    public void adicionarLista(View quemClicou){
        Intent intencao = new Intent(getApplicationContext(), CriarListaActivity.class);
        //intencao.putExtra("userCity", userCity);
        //intencao.putExtra("usuario", userCity);
        startActivityForResult(intencao, 3);
    }


    public void telaGrafico (View quemClicou){
        Intent intencao = new Intent(getApplicationContext(), TelaGraficoActivity.class);
        startActivity(intencao);
    }

    public void logout (View quemClicou){
        setResult(RESULT_CANCELED);
        finish();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == Activity.RESULT_OK){
            //Toast.makeText(getApplicationContext(), "ResultCode"+requestCode, Toast.LENGTH_SHORT).show();
            if(requestCode == 3){
                Lista novaLista = (Lista) data.getExtras().getParcelable("novaLista");
                //Toast.makeText(getApplicationContext(), novaLista.getNomeLista(), Toast.LENGTH_LONG).show();
                lista.add(novaLista);
                ListaAdapter adapter = new ListaAdapter();
                adapter.setLista(lista);
                RecyclerView rvLista = findViewById(R.id.rvLista);
                rvLista.setAdapter(adapter);
            }
        }
    }
}
