package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SimuladorActivity extends AppCompatActivity {
   private ImageView imagen;
   private int grados=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulador);
        imagen=findViewById(R.id.imagen);
    }
    public void onClick(View view) {
        // Regresar al MainActivity
        Intent intent = new Intent(SimuladorActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void Derecha(View view) {
        if(grados>=360) {
            imagen.setRotation(360);
        } else {
             grados++;
             imagen.setRotation(grados);
        }
    }

    public void Izquierda(View view) {
        if(grados<=0) {
            imagen.setRotation(0);
        } else {
            grados--;
            imagen.setRotation(grados);
        }
    }

}