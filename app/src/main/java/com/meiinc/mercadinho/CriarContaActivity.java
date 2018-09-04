package com.meiinc.mercadinho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import customfonts.MyEditText;

public class CriarContaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);
    }

    public void salvarConta(View quemClicou){
        MyEditText metNome = findViewById(R.id.nome);
        MyEditText metSobrenome = findViewById(R.id.sobrenome);
        MyEditText metEmail = findViewById(R.id.emails);
        MyEditText metSenha = findViewById(R.id.senha);

        if(metEmail.getText().toString() != "" || metNome.getText().toString() != ""
                || metSobrenome.getText().toString() != "" || metSenha.getText().toString() != "" ){
            setResult(RESULT_OK);
            finish();

        }else{
            Toast.makeText(this, "Favor inserir todos os campos.", Toast.LENGTH_SHORT).show();
        }
    }

    public void voltar(View quemClicou){
        setResult(RESULT_CANCELED);
        finish();
    }
}
