package com.meiinc.mercadinho;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(this);
        setContentView(R.layout.activity_login);
    }

    public void clicouBotao(View quemClicou){
        EditText etUsername =  findViewById(R.id.etUsuario);
        EditText etSenha =  findViewById(R.id.etSenha);

        String email = etUsername.getText().toString();
        String senha = etSenha.getText().toString();
        //Toast.makeText(getApplicationContext(), "Aqui", Toast.LENGTH_SHORT).show();

        if(!email.equals("") && !senha.equals("")){
            //Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
            try {

                Realm realm = Realm.getDefaultInstance();
                RealmResults<Usuario> results = realm.where(Usuario.class).equalTo("email", email).and().equalTo("senha", senha).findAll();
                Usuario usuario = results.first();
                //Toast.makeText(getApplicationContext(), "No for: Email: "+usuario.getEmail()+"\nSenha: "+usuario.getSenha(), Toast.LENGTH_SHORT).show();
                if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                    Toast.makeText(getApplicationContext(), "Login efetuado com sucesso.", Toast.LENGTH_SHORT).show();
                    Intent intencao = new Intent(getApplicationContext(), TelaPrincipal.class);
                    intencao.putExtra("usuario", usuario);
                    startActivity(intencao);
                }

            }catch (Exception e){
                Toast.makeText(getApplicationContext(), "Nome ou senha incorretos.", Toast.LENGTH_SHORT).show();
            }

//            for(Usuario usuario : results) {
//                //Toast.makeText(getApplicationContext(), "No for: Email: "+usuario.getEmail()+"\nSenha: "+usuario.getSenha(), Toast.LENGTH_SHORT).show();
//                if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
//                    Toast.makeText(getApplicationContext(), "Login efetuado com sucesso, "+usuario.getNome(), Toast.LENGTH_SHORT).show();
//                    Intent intencao = new Intent(getApplicationContext(), TelaPrincipal.class);
//                    intencao.putExtra("usuario", usuario);
//
//                    startActivity(intencao);
//                }
//            }
            //Toast.makeText(getApplicationContext(), "Nome ou senha incorretos.", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getApplicationContext(), "Preencha os campos de email e senha", Toast.LENGTH_SHORT).show();
        }

    }
    public void criarConta(View quemClicou){
        Intent intencao = new Intent(getApplicationContext(), CriarContaActivity.class);
        startActivityForResult(intencao, 5);
    }

    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
    }
    public static void hideKeyboard(Context context, View editText) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
