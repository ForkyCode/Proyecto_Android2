package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IniciarSesionActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextPass;
    private Button buttonIniciarS;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextPass = findViewById(R.id.editTextPass);
        buttonIniciarS = findViewById(R.id.buttonIniciarS);
        databaseHelper = new DatabaseHelper(this);

        // Método que se ejecuta al presionar el botón "Iniciar Sesión"
        buttonIniciarS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombreUsuario = editTextNombre.getText().toString();
                String contrasena = editTextPass.getText().toString();

                boolean iniciarSesionExitoso = databaseHelper.Validar(nombreUsuario, contrasena);

                if (iniciarSesionExitoso) {
                    setLoggeado(true);
                    String nombre = databaseHelper.obtenerNombre(nombreUsuario);
                    String mensajeBienvenida = "Bienvenido, " + nombre;

                    // Creamos un intent para enviar el nombre y el mensaje de bienvenida al MainActivity
                    Intent intent = new Intent(IniciarSesionActivity.this, MainActivity.class);
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("mensajeBienvenida", mensajeBienvenida);
                    startActivity(intent);

                    Toast.makeText(IniciarSesionActivity.this, mensajeBienvenida, Toast.LENGTH_SHORT).show();
                    finish(); // Finalizamos la actividad actual (IniciarSesionActivity)
                } else {
                    Toast.makeText(IniciarSesionActivity.this, "No se ha podido iniciar sesión", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Registrarse(View view) {
        Intent intent = new Intent(this, RegistrarActivity.class);
        startActivity(intent);
    }

    private void setLoggeado(boolean loggeado) {
        MainActivity.Loggeado = loggeado;
    }
}