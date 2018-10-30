package com.meiinc.mercadinho;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CriarListaActivity extends AppCompatActivity {

    private ProdutoAdapter adapter;
    public  ArrayList<Produto> itens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_lista);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    public void clicouAdicionarProduto(View quemClicou){
        Intent intent = new Intent(getApplicationContext(), AdicionarProdutoListaActivity.class);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == 1){
                Produto produto = (Produto) data.getExtras().getParcelable("produto");
                itens.add(produto);
                adapter = new ProdutoAdapter(this, itens);
                ListView lista = (ListView) findViewById(R.id.lvLista);
                lista.setAdapter(adapter);
        }

        }else
            return;
    }

    public void voltar(View quemClicou){
        setResult(RESULT_CANCELED);
        finish();
    }

    public void salvarListaClick(View quemClicou){
        final EditText etNomeLista = findViewById(R.id.etNomeLista);
        if(itens.size() == 0){
            Toast.makeText(getApplicationContext(), "A lista não pode estar vazia", Toast.LENGTH_SHORT).show();
            return;
        }else if(etNomeLista.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "A lista precisa de um nome", Toast.LENGTH_SHORT).show();
            return;
        }


        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Selecione o modo de organizar os preços");
        final String[] modo = {"Por cidade", "Por preço"};
        b.setItems(modo, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
                //"Toast.makeText(getApplicationContext(), modo[which], Toast.LENGTH_SHORT).show();
                switch (which){
                    case 0:
                        AlertDialog.Builder c = new AlertDialog.Builder(CriarListaActivity.this);
                        c.setTitle("Selecione a cidade");
                        final String[] cidades = {"Itajaí", "Balneário Camboriú", "Itapema", "Brusque", "Navegantes", "Little Bombs", "Floripa", "Blumenau"};
                        c.setItems(cidades, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();
                                //Toast.makeText(getApplicationContext(), cidades[which], Toast.LENGTH_SHORT).show();
                                Lista listaProdutos = new Lista();
                                listaProdutos.setListaProdutos(itens);
                                listaProdutos.setNomeLista(etNomeLista.getText().toString());
                                double valorTotal = 0;
                                for (int i = 0; i < itens.size(); i++){
                                    valorTotal += itens.get(i).getPreco();
                                }
                                Toast.makeText(getApplicationContext(), ""+valorTotal, Toast.LENGTH_SHORT).show();
                                listaProdutos.setValorTotal(valorTotal);
                                Date date = Calendar.getInstance().getTime();
                                listaProdutos.setDataLista(date.toString());
                                Intent intent = new Intent();
                                intent.putExtra("novaLista", listaProdutos);
                                setResult(Activity.RESULT_OK, intent);
                                finish();

                            }

                        });
                        c.show();
                        break;
                    case 1:
                        Lista listaProdutos = new Lista();
                        listaProdutos.setListaProdutos(itens);
                        listaProdutos.setNomeLista(etNomeLista.getText().toString());
                        double valorTotal = 0;
                        for (int i = 0; i < itens.size(); i++){
                            valorTotal += itens.get(i).getPreco();
                        }
                        listaProdutos.setValorTotal(valorTotal);
                        Intent intent = new Intent();
                        intent.putExtra("novaLista", listaProdutos);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;

                }

            }

        });

        b.show();
    }

}
