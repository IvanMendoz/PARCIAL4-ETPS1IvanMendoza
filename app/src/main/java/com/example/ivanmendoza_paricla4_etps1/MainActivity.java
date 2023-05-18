package com.example.ivanmendoza_paricla4_etps1;

import static com.example.ivanmendoza_paricla4_etps1.datos.BaseHelper.NOMBRE_TABLA_VEHICULOS_CLIENTES;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ivanmendoza_paricla4_etps1.adaptadores.Adaptador;
import com.example.ivanmendoza_paricla4_etps1.adaptadores.ListaClientesVehiculosAdaptador;
import com.example.ivanmendoza_paricla4_etps1.datos.BaseHelper;
import com.example.ivanmendoza_paricla4_etps1.datos.DbClientesVehiculos;
import com.example.ivanmendoza_paricla4_etps1.entidades.ClientesVehiculosEntidad;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaClientesVehiculos;

    ArrayList<ClientesVehiculosEntidad> listaVehiculosClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaClientesVehiculos = findViewById( R.id.listaCarrosClientes );


        listaClientesVehiculos.setLayoutManager( new LinearLayoutManager( this ));

        DbClientesVehiculos registrarClienteVehiculo = new DbClientesVehiculos( MainActivity.this );
        listaVehiculosClientes = new ArrayList<>();
        DbClientesVehiculos dbClientesVehiculos = null;

        ListaClientesVehiculosAdaptador adapter = new ListaClientesVehiculosAdaptador( registrarClienteVehiculo.mostrarClientesVehiculos() );
        listaClientesVehiculos.setAdapter( adapter );


        BaseHelper basHelper = new BaseHelper( this );
        SQLiteDatabase db = basHelper.getWritableDatabase();
        if ( db != null ){
            Toast.makeText( this, "Base de datos generada", Toast.LENGTH_LONG ).show();
        }else {

            Toast.makeText( this, "ERROR: Base de datos no generada", Toast.LENGTH_LONG ).show();
        }

    }

    public boolean onCreateOptionsMenu( Menu menu ){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.top_menu, menu );
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem items) {
        switch ( items.getItemId() ) {
            case R.id.agergarNuevo:
                Toast.makeText( this, "Agergar nuevo registro", Toast.LENGTH_LONG ).show();
                Intent intent = new Intent( getApplicationContext(), RegistrarClienteVehiculo.class );
                startActivity( intent );
                break;
        };
        return super.onOptionsItemSelected( items );
    }
}