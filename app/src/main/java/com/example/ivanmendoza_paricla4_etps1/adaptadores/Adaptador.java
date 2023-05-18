package com.example.ivanmendoza_paricla4_etps1.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ivanmendoza_paricla4_etps1.R;

import java.util.List;

public class Adaptador extends BaseAdapter {

    Context contexto;
    int layout;
    List<Integer> cliente;
    List <Integer> vehiculo;
    List<String> placa;
    List<Integer> kilometraje;

    public Adaptador(Context contexto, int layout, List<Integer> cliente) {
        this.contexto = contexto;
        this.layout = layout;
        this.cliente = cliente;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        LayoutInflater layoutInflater = LayoutInflater.from( contexto );
        v = layoutInflater.inflate( R.layout.lista_clientes_vehiculos, null );

        TextView tvIdCliente = v.findViewById( R.id.tvIdCliente );
        tvIdCliente.setText( cliente.get( i ) );

        return v;
    }
}
