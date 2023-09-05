package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LeccionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecciones);
    }
    public void onClick(View view) {
        // Regresar al MainActivity
        Intent intent = new Intent(LeccionesActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void leccion1 (View view) {
        // Ir a leccion 1
        Intent intent = new Intent(LeccionesActivity.this, Leccion1.class);
        startActivity(intent);
        finish();
    }
}