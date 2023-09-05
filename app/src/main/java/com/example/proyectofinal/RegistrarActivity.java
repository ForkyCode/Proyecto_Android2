package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarActivity extends AppCompatActivity {

    private EditText editTextCed;
    private EditText editTextNombre;
    private EditText editTextCel;
    private EditText editTextPass;
    private Button buttonRegistrarS;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        editTextCed = findViewById(R.id.editTextCed);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextCel = findViewById(R.id.editTextCel);
        editTextPass = findViewById(R.id.editTextPass);
        buttonRegistrarS = findViewById(R.id.buttonRegistrarS);

        databaseHelper = new DatabaseHelper(this);

        buttonRegistrarS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cedula = editTextCed.getText().toString();
                String nombre = editTextNombre.getText().toString();
                String celular = editTextCel.getText().toString();
                String contrasena = editTextPass.getText().toString();
                //Envía los datos ingresados en los edittext y devuelve un booleano
                //Devuelve true si se cargaron los datos correctamente, y false en caso contrario
                boolean guardadoExitoso = databaseHelper.Registrar(cedula, nombre, celular, contrasena);
                if (guardadoExitoso) {
                    Toast.makeText(RegistrarActivity.this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
                    finish(); // Regresa al MainActivity
                } else {
                    Toast.makeText(RegistrarActivity.this, "No se ha podido guardar correctamente", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void IniciarSesion(View view) {
        Intent intent = new Intent(this, IniciarSesionActivity.class);
        startActivity(intent);
    }
}
