package com.example.ivanmendoza_paricla4_etps1;

import static com.example.ivanmendoza_paricla4_etps1.datos.BaseHelper.NOMBRE_TABLA_VEHICULOS_CLIENTES;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ivanmendoza_paricla4_etps1.datos.BaseHelper;

import java.util.ArrayList;

public class RegistrarClienteVehiculo extends AppCompatActivity {

    Button btRegresar, btAgregar;
    EditText edCliente, edVehiculo, edMatricula, edKilometraje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cliente_vehiculo);

        edCliente = findViewById( R.id.edtCliente );
        edVehiculo = findViewById( R.id.edtVehiculo );
        edMatricula = findViewById( R.id.edtMatricula );
        edKilometraje = findViewById( R.id.edtKilometraje );
        btAgregar = findViewById( R.id.btnAgregar );
        btRegresar = findViewById( R.id.btnRegresar );

        btAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseHelper baseHelper = new BaseHelper( getApplicationContext() );
                SQLiteDatabase db =baseHelper.getWritableDatabase();
                String id_cliente = edCliente.getText().toString(),
                        id_vehiculo = edVehiculo.getText().toString(),
                        sMatricula = edMatricula.getText().toString(),
                        iKilometros = edKilometraje.getText().toString();

                ContentValues clienteVehiculo = new ContentValues();
                clienteVehiculo.put( "id_cliente", id_cliente );
                clienteVehiculo.put( "id_vehiculo", id_vehiculo );
                clienteVehiculo.put( "sMatricula", sMatricula );
                clienteVehiculo.put( "iKilometros", iKilometros );

                try {
                    db.insert( "MD_ClienteVehiculo", null, clienteVehiculo );
                    db.close();
                    Toast.makeText( getApplicationContext(), "El registro fue insertado correctamente", Toast.LENGTH_LONG ).show();
                    Intent intent = new Intent( getApplicationContext(), MainActivity.class );
                    startActivity( intent );
                }catch ( Exception e ){
                    Toast.makeText( getApplicationContext(), "El registro no se pudo insertar", Toast.LENGTH_LONG ).show();
                }
            }
        });

        btRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), MainActivity.class );
                startActivity( intent );
            }
        });

    }
}