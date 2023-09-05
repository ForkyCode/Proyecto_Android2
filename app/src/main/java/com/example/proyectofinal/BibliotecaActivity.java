package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaActivity extends AppCompatActivity {
    private RecyclerView rvLista;
    private RecyclerAdapter adapter;
    private List<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblioteca);

        initViews();
        initValues();
    }
    public void onClick(View view) {
        // Regresar al MainActivity
        Intent intent = new Intent(BibliotecaActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void initViews(){
        rvLista = findViewById(R.id.rvLista);
    }

    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items);
        rvLista.setAdapter(adapter);
    }

    private List<ItemList> getItems() {
        List<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList("Tarjeta Grafica", "Un componente de hardware que procesa datos visuales y es responsable de mostrar imágenes en la pantalla de una computadora o dispositivo.", R.drawable.tarjeta_grafica));
        itemLists.add(new ItemList("Tarjeta Madre", "También conocida como placa base, es una placa de circuito que conecta y proporciona energía a todos los componentes principales de una computadora.", R.drawable.tarjeta_madre));
        itemLists.add(new ItemList("Procesador", "Es la unidad central de procesamiento de una computadora que ejecuta instrucciones, realiza cálculos y coordina el funcionamiento general del sistema.", R.drawable.procesador));
        itemLists.add(new ItemList("Memoria Ram", "Es la memoria de acceso aleatorio utilizada para almacenar temporalmente datos e instrucciones que el procesador necesita acceder rápidamente mientras se ejecutan programas.", R.drawable.memoria_ram));
        itemLists.add(new ItemList("Fuente de Poder", "Es un componente de hardware que suministra la energía eléctrica necesaria para que una computadora u otro dispositivo funcione adecuadamente. Transforma la corriente eléctrica de la toma de corriente en voltajes y corrientes específicos requeridos por los componentes internos del sistema.", R.drawable.fuente_de_poder));
        return itemLists;
    }
}