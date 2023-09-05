package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static boolean Loggeado = false;
    public static TextView textViewWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewWelcome = findViewById(R.id.textViewWelcome);

        // Verificamos si se ha iniciado sesión y actualizamos la visibilidad del mensaje de bienvenida
        if (Loggeado) {
            textViewWelcome.setVisibility(View.VISIBLE);
        } else {
            textViewWelcome.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Aquí puedes realizar otras acciones necesarias en el onResume del MainActivity
    }

    // Método para dirigirse a la actividad "PerfilPersonal"
    public void goToPerfilPersonal(View view) {
        Intent intent = new Intent(this, PerfilPersonalActivity.class);
        startActivity(intent);
    }

    // Método para dirigirse a la actividad "Simulador"
    public void goToSimulador(View view) {
        Intent intent = new Intent(this, SimuladorActivity.class);
        startActivity(intent);
    }

    // Método para dirigirse a la actividad "Lecciones"
    public void goToLecciones(View view) {
        Intent intent = new Intent(this, LeccionesActivity.class);
        startActivity(intent);
    }


    // Método para dirigirse a la actividad "Biblioteca"
    public void goToBiblioteca(View view) {
        Intent intent = new Intent(this, BibliotecaActivity.class);
        startActivity(intent);
    }

    // Método para dirigirse a la actividad "Informacion"
    public void goToInformacion(View view) {
        Intent intent = new Intent(this, VerInformacionActivity.class);
        startActivity(intent);
    }
    public void IniciarSesion(View view) {
        Intent intent = new Intent(this, IniciarSesionActivity.class);
        startActivity(intent);
    }
}