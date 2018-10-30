package com.meiinc.mercadinho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import customfonts.MyEditText;
import io.realm.Realm;

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

        String nome = metNome.getText().toString();
        String sobrenome = metSobrenome.getText().toString();
        String email = metEmail.getText().toString();
        String senha = metSenha.getText().toString();

        if(!nome.equals("") && !sobrenome.equals("") && !email.equals("")&& !senha.equals("")){
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();

            Usuario usuario = realm.createObject(Usuario.class);
            usuario.setNome(nome);
            usuario.setSobrenome(sobrenome);
            usuario.setEmail(email);
            usuario.setSenha(senha);

            realm.copyToRealm(usuario);
            realm.commitTransaction();

            Toast.makeText(this, "Cadastro com sucesso", Toast.LENGTH_SHORT).show();
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
