package com.meiinc.mercadinho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;

public class CriarListaActivity extends AppCompatActivity {

    public List <Produto> listaProdutos;
    private ProdutoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_lista);


        // Cria uma lista de 100 objetos para usar no exemplo.
        ArrayList<Produto> itens = new ArrayList<Produto>();

        itens.add(new Produto("leite", "Longavida", 1, "litro"));
        itens.add(new Produto("arroz", "Tio Urbano", 1, "quilo"));
        itens.add(new Produto("feijão", "Urbano", 1, "quilo"));
        itens.add(new Produto("açucar", "União", 1, "quilo"));
        itens.add(new Produto("alcatra", "friboi", 1, "quilo"));
        itens.add(new Produto("pão de queijo", "Select", 400, "grama"));
        itens.add(new Produto("chocotone", "Bauduco", 750, "grama"));
        itens.add(new Produto("batata", "", 1, "quilo"));
        itens.add(new Produto("macarrão", "Barilla", 500, "grama"));
        itens.add(new Produto("farinha de trigo", "Dona Benta", 1, "quilo"));

        // constroi o adapter passando os itens.
        adapter = new ProdutoAdapter(this, itens);
        ListView lista = (ListView) findViewById(R.id.lvLista);
        lista.setAdapter(adapter);

        //Aqui é aonde adicionamos nosso filtro no edittext.
        EditText editText = (EditText) findViewById(R.id.edProcuraProduto);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //quando o texto é alterado chamamos o filtro.

                adapter.getFilter().
                adapter.getFilter().filter(s.toString());
                }
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,
                                              int after) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
        }
        );
    }

    public void voltar(View quemClicou){
        setResult(RESULT_CANCELED);
        finish();
    }

}
