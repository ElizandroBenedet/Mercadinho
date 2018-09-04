package com.meiinc.mercadinho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CriarListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_lista);
    }

    public void voltar(View quemClicou){
        setResult(RESULT_CANCELED);
        finish();
    }
}
