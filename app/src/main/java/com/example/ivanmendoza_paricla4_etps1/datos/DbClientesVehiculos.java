package com.example.ivanmendoza_paricla4_etps1.datos;

import static com.example.ivanmendoza_paricla4_etps1.datos.BaseHelper.NOMBRE_TABLA_VEHICULOS_CLIENTES;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.ivanmendoza_paricla4_etps1.RegistrarClienteVehiculo;
import com.example.ivanmendoza_paricla4_etps1.entidades.ClientesVehiculosEntidad;

import java.util.ArrayList;

public class DbClientesVehiculos extends BaseHelper{

    Context context;

    public DbClientesVehiculos(@Nullable Context context){
        super( context );
        this.context = context;
    }

    public ArrayList<ClientesVehiculosEntidad> mostrarClientesVehiculos(){
        BaseHelper baseHelper = new BaseHelper( context );
        SQLiteDatabase db =baseHelper.getWritableDatabase();

        ArrayList<ClientesVehiculosEntidad> listaClientesVehiculos = new ArrayList<>();
        ClientesVehiculosEntidad registrarClienteVehiculo = null;
        Cursor cursorRegistrarClienteVehiculo = null;

        cursorRegistrarClienteVehiculo = db.rawQuery( "SELECT * FROM " + NOMBRE_TABLA_VEHICULOS_CLIENTES, null);
        if ( cursorRegistrarClienteVehiculo.moveToFirst() ){
            do {
                registrarClienteVehiculo = new ClientesVehiculosEntidad();
                registrarClienteVehiculo.setId_cliente( cursorRegistrarClienteVehiculo.getInt( 0));
                registrarClienteVehiculo.setId_vehiculo( cursorRegistrarClienteVehiculo.getInt( 1));
                registrarClienteVehiculo.setMatricula( cursorRegistrarClienteVehiculo.getString( 2).toString());
                registrarClienteVehiculo.setKilometraje( cursorRegistrarClienteVehiculo.getInt( 3));
                listaClientesVehiculos.add( registrarClienteVehiculo );
            }while ( cursorRegistrarClienteVehiculo.moveToNext() );
        }
        cursorRegistrarClienteVehiculo.close();
        return listaClientesVehiculos;
    }

    public ClientesVehiculosEntidad verClientesVehiculos( int id ){
        BaseHelper baseHelper = new BaseHelper( context );
        SQLiteDatabase db =baseHelper.getWritableDatabase();

        ArrayList<ClientesVehiculosEntidad> listaClientesVehiculos = new ArrayList<>();
        ClientesVehiculosEntidad registrarClienteVehiculo = null;
        Cursor cursorRegistrarClienteVehiculo = null;

        cursorRegistrarClienteVehiculo = db.rawQuery( "SELECT * FROM " + NOMBRE_TABLA_VEHICULOS_CLIENTES + " WHERE id_cliente = " + id + " LIMIT 1", null);
        if ( cursorRegistrarClienteVehiculo.moveToFirst() ){
            registrarClienteVehiculo = new ClientesVehiculosEntidad();
            registrarClienteVehiculo.setId_cliente( cursorRegistrarClienteVehiculo.getInt( 0));
            registrarClienteVehiculo.setId_vehiculo( cursorRegistrarClienteVehiculo.getInt( 1));
            registrarClienteVehiculo.setMatricula( cursorRegistrarClienteVehiculo.getString( 2).toString());
            registrarClienteVehiculo.setKilometraje( cursorRegistrarClienteVehiculo.getInt( 3));
        }
        cursorRegistrarClienteVehiculo.close();
        return registrarClienteVehiculo;

    }
}
