package com.example.proyectofinal;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VerInformacionActivity extends AppCompatActivity {

    private TextView textViewInformacion;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_informacion);

        textViewInformacion = findViewById(R.id.textViewInfo);


        databaseHelper = new DatabaseHelper(this);
        //Crea una objeto en el que se cargará la información que se vaya obteniendo de la base de datos según la consulta hecha
        StringBuilder stringBuilder = new StringBuilder();
        //Aquí creamos un objeto Cursor para cargar la información obtenida de la base de datos
        Cursor cursor = databaseHelper.VerDatos();

        if (cursor.getCount() == 0) {
            stringBuilder.append("No hay información registrada.");
        } else {
            while (cursor.moveToNext()) {
                //Extrae la información obtenida en la consulta y la va cargando en orden en objetos de tipo cadena/texto
                String cedula = cursor.getString(0);
                String nombre = cursor.getString(1);
                String celular = cursor.getString(2);
                String contrasena = cursor.getString(3);
                //Arma una cadena con la información cargada en las variables anteriores, y hace un espaciado para el siguiente párrafo
                stringBuilder.append("Cédula: ").append(cedula).append("\n");
                stringBuilder.append("Nombre: ").append(nombre).append("\n");
                stringBuilder.append("Celular: ").append(celular).append("\n");
                stringBuilder.append("Contraseña: ").append(contrasena).append("\n\n");
            }
        }
        //Carga la información del objeto StringBuilder en el TextView para que sea mostrado en la pantalla
        textViewInformacion.setText(stringBuilder.toString());
    }
    public void volver (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
