package com.example.ivanmendoza_paricla4_etps1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ivanmendoza_paricla4_etps1.datos.DbClientesVehiculos;
import com.example.ivanmendoza_paricla4_etps1.entidades.ClientesVehiculosEntidad;

public class MostrarRegistro extends AppCompatActivity {

    EditText edViewCliente, edViewVehiculo, edViewMatricula, edViewKilometraje;
    Button btActualizar, btEliminar, btRegresarLista;

    ClientesVehiculosEntidad listaClientesVehiculosAdaptador;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_registro);

        edViewCliente = findViewById( R.id.edtClienteVista );
        edViewVehiculo = findViewById( R.id.edtVehiculoVista );
        edViewMatricula = findViewById( R.id.edtClienteVista );
        edViewKilometraje = findViewById( R.id.edtKilometrajeVista );
        btActualizar = findViewById( R.id.btnEditar );
        btEliminar = findViewById( R.id.btnEliminar );
        btRegresarLista = findViewById( R.id.btnViewRegresar );

        if ( savedInstanceState == null ){
            Bundle bundle = getIntent().getExtras();
            if ( bundle == null ){
                id = Integer.parseInt( null );
            }else{
                id = bundle.getInt( "cliente" );
            }
        }else {
            id = ( int ) savedInstanceState.getSerializable( "cliente" );
        }

        DbClientesVehiculos dbClientesVehiculos = new DbClientesVehiculos( MostrarRegistro.this );
        listaClientesVehiculosAdaptador = dbClientesVehiculos.verClientesVehiculos( id );

        if( listaClientesVehiculosAdaptador != null ){
            edViewCliente.setText( String.valueOf( listaClientesVehiculosAdaptador.getId_cliente() ) );
            edViewVehiculo.setText( String.valueOf( listaClientesVehiculosAdaptador.getId_vehiculo() ) );
            edViewMatricula.setText( listaClientesVehiculosAdaptador.getMatricula() );
            edViewKilometraje.setText( String.valueOf( listaClientesVehiculosAdaptador.getKilometraje() ) );
        }

/*
        Bundle bundle = getIntent().getExtras();

        edViewCliente.setText( String.valueOf( bundle.getInt( "cliente" ) ) );
        edViewVehiculo.setText( String.valueOf( bundle.getInt( "vehiculo" )  ) );
        edViewMatricula.setText( bundle.getString( "matricula" ) );
        edViewKilometraje.setText( String.valueOf( bundle.getInt( "kilometraje" ) ) );
*/
        btRegresarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), MainActivity.class );
                startActivity( intent );
            }
        });
    }
}