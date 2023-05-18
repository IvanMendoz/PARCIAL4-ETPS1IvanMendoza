package com.example.ivanmendoza_paricla4_etps1.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseHelper extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASEDATOS = "BDCLIENTES.db";
    public static final String NOMBRE_TABLA_CLIENTES = "MD_Clientes";
    private static final String NOMBRE_TABLA_VEHICULOS = "MD_Vehiculos";
    public static final String NOMBRE_TABLA_VEHICULOS_CLIENTES = "MD_ClienteVehiculo";

    public BaseHelper( @Nullable Context context ) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS "+ NOMBRE_TABLA_CLIENTES + " ( " +
                "id_cliente int PRIMARY KEY, " +
                "sNombreCliente text not null, " +
                "sApellidosCliente text not null, " +
                "sDireccionCliente text not null, " +
                "sCiudadCliente text not null ) ");

        sqLiteDatabase.execSQL( "CREATE TABLE IF NOT EXISTS " + NOMBRE_TABLA_VEHICULOS + " ( " +
                "id_vehiculo int PRIMARY KEY, " +
                "Marca text not null, " +
                "sModelo text not null )" );

        sqLiteDatabase.execSQL( "CREATE TABLE IF NOT EXISTS " + NOMBRE_TABLA_VEHICULOS_CLIENTES + " ( " +
                "id_cliente int, " +
                "id_vehiculo int, " +
                "sMatricula text, " +
                "iKilometros int, " +
                "PRIMARY KEY (id_cliente, id_vehiculo)," +
                "FOREIGN KEY ( id_cliente ) REFERENCES MD_clientes( id_cliente )," +
                "FOREIGN KEY ( id_vehiculo ) REFERENCES MD_vehiculos ( id_vehiculo )" +
                " )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL( "DROP TABLE " + NOMBRE_TABLA_CLIENTES );
        sqLiteDatabase.execSQL( "DROP TABLE " + NOMBRE_TABLA_VEHICULOS );
        sqLiteDatabase.execSQL( "DROP TABLE " + NOMBRE_TABLA_VEHICULOS_CLIENTES );
        onCreate( sqLiteDatabase );
    }
}
