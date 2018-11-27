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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CriarListaActivity extends AppCompatActivity {

    private ProdutoAdapter adapter;
    public ArrayList<Produto> itens = new ArrayList<>();
    public Mercado mercado1 = new Mercado("Bistek", "Itajaí", "1234-4567");
    public Mercado mercado2 = new Mercado("Angeloni", "Itajaí", "1587-9782");
    public Mercado mercado3 = new Mercado("Angeloni", "Balneário Camboriú", "1234-4567");
    public Mercado mercado4 = new Mercado("Koch", "Itapema", "9999-4567");
    public Mercado mercado5 = new Mercado("Fort", "Brusque", "3333-5507");

    public ArrayList<Produto> produtosAddMercado1 = new ArrayList<Produto>();
    public ArrayList<Produto> produtosAddMercado2 = new ArrayList<Produto>();
    public ArrayList<Produto> produtosAddMercado3 = new ArrayList<Produto>();
    public ArrayList<Produto> produtosAddMercado4 = new ArrayList<Produto>();
    public ArrayList<Produto> produtosAddMercado5 = new ArrayList<Produto>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_lista);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        ArrayList<Produto> lena = new ArrayList<>();

        lena.add(new Produto("Leite", "Longavida", 3.50));
        lena.add(new Produto("Arroz", "Tio Urbano", 4.50));
        lena.add(new Produto("Feijão", "Urbano", 1.00));
        lena.add(new Produto("Açucar", "União", 1.00));
        lena.add(new Produto("Alcatra", "friboi", 1.00));
        lena.add(new Produto("Pão de queijo", "Select", 4.00));
        lena.add(new Produto("Chocotone", "Bauduco", 7.50));
        lena.add(new Produto("Batata", "", 1.00));
        lena.add(new Produto("Macarrão", "Barilla", 5.49));
        lena.add(new Produto("Farinha de trigo", "Dona Benta", 1.99));
        lena.add(new Produto("Leite", "Longavida", 1.99));
        lena.add(new Produto("Arroz", "Tio Urbano", 6.99));
        lena.add(new Produto("Feijão", "Urbano", 9.00));
        lena.add(new Produto("Açucar", "União", 2.00));
        lena.add(new Produto("Alcatra", "friboi", 1.00));
        lena.add(new Produto("Pão de queijo", "Select", 4.00));
        lena.add(new Produto("Chocotone", "Bauduco", 7.50));
        lena.add(new Produto("Batata", "BatatAPP", 1.00));
        lena.add(new Produto("Macarrão", "Barilla", 10.50));
        lena.add(new Produto("Farinha de trigo", "Dona Benta", 1.00));
        lena.add(new Produto("Leite", "Longavida", 1.00));
        lena.add(new Produto("Arroz", "Tio Urbano", 1.00));
        lena.add(new Produto("Feijão", "Urbano", 1.00));
        lena.add(new Produto("Açucar", "União", 1.00));
        lena.add(new Produto("Alcatra", "friboi", 1.00));
        lena.add(new Produto("Pão de queijo", "Select", 4.00));
        lena.add(new Produto("Chocotone", "Bauduco", 7.50));
        lena.add(new Produto("Batata", "BatatApp", 1.00));
        lena.add(new Produto("Macarrão", "Barilla", 11.00));
        lena.add(new Produto("Farinha de trigo", "Dona Benta", 1.00));

        for(int i = 0; i < lena.size(); i++){
            produtosAddMercado1.add(lena.get(i));
            lena.get(i).setPreco(lena.get(i).getPreco()+1);
        }
        mercado1.setProdutosDoMercado(produtosAddMercado1);

        for(int i = 0; i < lena.size(); i++){
            produtosAddMercado2.add(lena.get(i));
            lena.get(i).setPreco(lena.get(i).getPreco()+i*i);
        }
        mercado2.setProdutosDoMercado(produtosAddMercado2);

        for(int i = 0; i < lena.size(); i++){
            produtosAddMercado3.add(lena.get(i));
            lena.get(i).setPreco(lena.get(i).getPreco()+i*i);
        }
        mercado3.setProdutosDoMercado(produtosAddMercado3);

        for(int i = 0; i < lena.size(); i++){
            produtosAddMercado4.add(lena.get(i));
            lena.get(i).setPreco(lena.get(i).getPreco()+i*i);
        }
        mercado4.setProdutosDoMercado(produtosAddMercado4);

        for(int i = 0; i < lena.size(); i++){
            produtosAddMercado5.add(lena.get(i));
            lena.get(i).setPreco(lena.get(i).getPreco()+i*i);
        }
        mercado5.setProdutosDoMercado(produtosAddMercado5);



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
        final String[] modo = {"Por mercado", "Por preço"};
        b.setItems(modo, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
                //"Toast.makeText(getApplicationContext(), modo[which], Toast.LENGTH_SHORT).show();
                switch (which){
                    case 0:
                        AlertDialog.Builder c = new AlertDialog.Builder(CriarListaActivity.this);
                        c.setTitle("Selecione o mercado");
                        final String[] cidades = {"Bistek - Itajaí", "Angeloni - Itajaí", "Angeloni - Balneário Camboriú", "Koch - Itapema", "Fort - Brusque"};
                        c.setItems(cidades, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();
                                //Toast.makeText(getApplicationContext(), ""+which, Toast.LENGTH_SHORT).show();
                                Lista listaProdutos = new Lista();

                                switch (which){
                                    case 0:
                                        for (int i=0;i<itens.size();i++){
                                            itens.get(i).setPreco(mercado1.getPrecoPorNome(itens.get(i).getNome()));
                                        }
                                        break;
                                    case 1:
                                        for (int i=0;i<itens.size();i++){
                                            itens.get(i).setPreco(mercado2.getPrecoPorNome(itens.get(i).getNome()));
                                        }
                                        break;
                                    case 2:
                                        for (int i=0;i<itens.size();i++){
                                            itens.get(i).setPreco(mercado3.getPrecoPorNome(itens.get(i).getNome()));
                                        }
                                        break;
                                    case 3:
                                        for (int i=0;i<itens.size();i++){
                                            itens.get(i).setPreco(mercado4.getPrecoPorNome(itens.get(i).getNome()));
                                        }
                                        break;
                                    case 4:
                                        for (int i=0;i<itens.size();i++){
                                            itens.get(i).setPreco(mercado5.getPrecoPorNome(itens.get(i).getNome()));
                                        }
                                        break;
                                }

                                listaProdutos.setListaProdutos(itens);
                                listaProdutos.setNomeLista(etNomeLista.getText().toString());
                                double valorTotal = 0;
                                for (int i = 0; i < itens.size(); i++){
                                    valorTotal += itens.get(i).getPreco();
                                }
                                //Toast.makeText(getApplicationContext(), ""+valorTotal, Toast.LENGTH_SHORT).show();
                                listaProdutos.setValorTotal(valorTotal);
                                Date date = Calendar.getInstance().getTime();
                                SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
                                listaProdutos.setDataLista(dataFormatada.format(date));
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
                        Date date = Calendar.getInstance().getTime();
                        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
                        listaProdutos.setDataLista(dataFormatada.format(date));
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
