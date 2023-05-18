package com.example.ivanmendoza_paricla4_etps1.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ivanmendoza_paricla4_etps1.MostrarRegistro;
import com.example.ivanmendoza_paricla4_etps1.R;
import com.example.ivanmendoza_paricla4_etps1.entidades.ClientesVehiculosEntidad;

import java.util.ArrayList;

public class ListaClientesVehiculosAdaptador extends RecyclerView.Adapter<ListaClientesVehiculosAdaptador.ClienteViewHolder> {

    ArrayList<ClientesVehiculosEntidad> lstClientesVehiculos;

    public ListaClientesVehiculosAdaptador( ArrayList<ClientesVehiculosEntidad> lstClientesVehiculos ) {
        this.lstClientesVehiculos = lstClientesVehiculos;
    }

    @NonNull
    @Override
    public ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate(R.layout.lista_clientes_vehiculos, null, false );
        return new ClienteViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteViewHolder holder, int position) {
        String cliente = String.valueOf( lstClientesVehiculos.get( position ).getId_cliente() );
        String vehiculo = String.valueOf( lstClientesVehiculos.get( position ).getId_vehiculo() );
        String kilometraje = String.valueOf( lstClientesVehiculos.get( position ).getKilometraje() );
        holder.tvIdCliente.setText( cliente );
        holder.viewVehiculo.setText( vehiculo );
        holder.viewMatricula.setText( lstClientesVehiculos.get( position ).getMatricula() );
        holder.viewKilometraje.setText( kilometraje );
    }

    @Override
    public int getItemCount() {
        return lstClientesVehiculos.size();
    }

    public class ClienteViewHolder extends RecyclerView.ViewHolder {

        TextView tvIdCliente, viewVehiculo, viewMatricula, viewKilometraje;
        public ClienteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdCliente = itemView.findViewById( R.id.tvIdCliente );
            viewVehiculo = itemView.findViewById( R.id.tvIdVehiculo );
            viewMatricula = itemView.findViewById( R.id.tvSMatricula );
            viewKilometraje = itemView.findViewById( R.id.tvIKilometros );

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Toast.makeText(context, "Selección Realizada", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent( context, MostrarRegistro.class);
                    intent.putExtra("cliente", lstClientesVehiculos.get( getAdapterPosition() ).getId_cliente() );
                    intent.putExtra("vehiculo", lstClientesVehiculos.get( getAdapterPosition() ).getId_vehiculo() );
                    intent.putExtra("matricula", lstClientesVehiculos.get( getAdapterPosition() ).getMatricula() );
                    intent.putExtra("kilometraje", lstClientesVehiculos.get( getAdapterPosition() ).getKilometraje() );
                    context.startActivity( intent );
                }
            });
        }
    }
}
