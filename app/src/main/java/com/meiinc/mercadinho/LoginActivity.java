package com.meiinc.mercadinho;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void clicouBotao(View quemClicou){
        EditText etUsername =  findViewById(R.id.etUsuario);
        EditText etSenha =  findViewById(R.id.etSenha);

        if(etUsername.getText().toString().equals("") && etSenha.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Mercadinho", Toast.LENGTH_LONG).show();
            Intent intencao = new Intent(getApplicationContext(), TelaPrincipal.class);
            Usuario user = new Usuario();
            user.setCidade("Promorar");
            intencao.putExtra("userCity", user.getCidade());
            startActivity(intencao);
        }else{
            Toast.makeText(getApplicationContext(), "Mercadinho não deu liga", Toast.LENGTH_LONG).show();
        }
    }
    public void criarConta(View quemClicou){
        Intent intencao = new Intent(getApplicationContext(), CriarContaActivity.class);
        startActivityForResult(intencao, 5);
    }

    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 5 && resultCode == RESULT_OK){
            EditText etUsername =  findViewById(R.id.etUsuario);
            EditText etSenha =  findViewById(R.id.etSenha);

            etSenha.setText("finja que seu email esta aqui");
            etUsername.setText("Finja novamente que seu u");
        }else{
            return;
        }
    }
    public static void hideKeyboard(Context context, View editText) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
