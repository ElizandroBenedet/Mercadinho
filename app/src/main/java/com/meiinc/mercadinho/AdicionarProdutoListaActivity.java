package com.meiinc.mercadinho;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdicionarProdutoListaActivity extends AppCompatActivity {

    private ProdutoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_produto_lista);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        // Cria uma lista de 100 objetos para usar no exemplo.
        ArrayList<Produto> itens = new ArrayList<Produto>();

        itens.add(new Produto("Leite", "Longavida", 3.50));
        itens.add(new Produto("Arroz", "Tio Urbano", 4.50));
        itens.add(new Produto("Feijão", "Urbano", 1.00));
        itens.add(new Produto("Açucar", "União", 1.00));
        itens.add(new Produto("Alcatra", "friboi", 1.00));
        itens.add(new Produto("Pão de queijo", "Select", 4.00));
        itens.add(new Produto("Chocotone", "Bauduco", 7.50));
        itens.add(new Produto("Batata", "", 1.00));
        itens.add(new Produto("Macarrão", "Barilla", 5.49));
        itens.add(new Produto("Farinha de trigo", "Dona Benta", 1.99));
        itens.add(new Produto("Leite", "Longavida", 1.99));
        itens.add(new Produto("Arroz", "Tio Urbano", 6.99));
        itens.add(new Produto("Feijão", "Urbano", 9.00));
        itens.add(new Produto("Açucar", "União", 2.00));
        itens.add(new Produto("Alcatra", "friboi", 1.00));
        itens.add(new Produto("Pão de queijo", "Select", 4.00));
        itens.add(new Produto("Chocotone", "Bauduco", 7.50));
        itens.add(new Produto("Batata", "BatatAPP", 1.00));
        itens.add(new Produto("Macarrão", "Barilla", 10.50));
        itens.add(new Produto("Farinha de trigo", "Dona Benta", 1.00));
        itens.add(new Produto("Leite", "Longavida", 1.00));
        itens.add(new Produto("Arroz", "Tio Urbano", 1.00));
        itens.add(new Produto("Feijão", "Urbano", 1.00));
        itens.add(new Produto("Açucar", "União", 1.00));
        itens.add(new Produto("Alcatra", "friboi", 1.00));
        itens.add(new Produto("Pão de queijo", "Select", 4.00));
        itens.add(new Produto("Chocotone", "Bauduco", 7.50));
        itens.add(new Produto("Batata", "BatatApp", 1.00));
        itens.add(new Produto("Macarrão", "Barilla", 11.00));
        itens.add(new Produto("Farinha de trigo", "Dona Benta", 1.00));

        // constroi o adapter passando os itens.
        adapter = new ProdutoAdapter(this, itens);
        ListView lista = (ListView) findViewById(R.id.lvListaAdicionar);
        lista.setAdapter(adapter);

        //Aqui é aonde adicionamos nosso filtro no edittext.
        EditText editText = (EditText) findViewById(R.id.edProcuraProdutoAdicionar);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                //quando o texto é alterado chamamos o filtro.
                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Produto produto = (Produto) adapterView.getItemAtPosition(i);
                //Toast.makeText(getApplicationContext(), produto.getNome(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("produto", produto);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });{

        }
    }

    public void clicouVoltar(View quemClicou){
        Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}
