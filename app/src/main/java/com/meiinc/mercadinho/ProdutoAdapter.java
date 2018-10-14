package com.meiinc.mercadinho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.TextView;
import java.text.Normalizer;
import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.List;

public class ProdutoAdapter extends BaseAdapter {

    public static String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    //Itens de exibição / filtrados
    private List<Produto> itens_exibicao;
    //Essa lista contem todos os itens.
    private List<Produto> itens;
    //Utilizado no getView para carregar e construir um item.
    private LayoutInflater layoutInflater;

    public ProdutoAdapter(Context context, List<Produto> itens) {
        this.itens = itens;
        this.itens_exibicao = itens;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return itens_exibicao.size();
    }

    @Override
    public Object getItem(int position) {
        return itens_exibicao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return itens_exibicao.get(position).getId() ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemHelper itemHelper = new ItemHelper();
        Produto produto = itens_exibicao.get(position);

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.lista_produtos, null);
            itemHelper.nome = convertView.findViewById(R.id.tvNomeLista);
            itemHelper.marca = convertView.findViewById(R.id.tvDataLista);
            itemHelper.peso = convertView.findViewById(R.id.tvPrecoLista);
            convertView.setTag(itemHelper);
        }else{
            itemHelper = (ItemHelper) convertView.getTag();
        }
        itemHelper.nome.setText(produto.getNome());
        itemHelper.marca.setText(produto.getMarca());
        itemHelper.peso.setText(Float.toString(produto.getPeso()));

        return convertView;
    }
    private class ItemHelper {

        TextView nome, marca, peso;
    }

    public Filter getFilter() {
        Filter filter = new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence filtro) {
                FilterResults results = new FilterResults();
                //se não foi realizado nenhum filtro insere todos os itens.
                if (filtro == null || filtro.length() == 0) {
                    results.count = itens.size();
                    results.values = itens;
                } else {
                    //cria um array para armazenar os objetos filtrados.
                    List<Produto> itens_filtrados = new ArrayList<Produto>();

                    filtro = deAccent(filtro.toString().toLowerCase());
                    //percorre toda lista verificando se contem a palavra do filtro na descricao do objeto.
                    for (int i = 0; i < itens.size(); i++) {
                        Produto data = itens.get(i);


                        String condicao = deAccent(data.getNome().toLowerCase() + " " + data.getMarca().toLowerCase());

                        if (condicao.contains(filtro)) {
                            //se conter adiciona na lista de itens filtrados.
                            itens_filtrados.add(data);
                        }
                    }
                    // Define o resultado do filtro na variavel FilterResults
                    results.count = itens_filtrados.size();
                    results.values = itens_filtrados;
                }
                return results;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
                itens_exibicao = (List<Produto>) results.values; // Valores filtrados.
                notifyDataSetChanged();  // Notifica a lista de alteração
            }

        };
        return filter;
    }
}
