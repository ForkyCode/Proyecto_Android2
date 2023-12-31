package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
   private ImageView imgItemDetail;
   private TextView tvTituloDetail;
   private TextView tvDescripcionDetail;
   private ItemList itemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle(getClass().getSimpleName());

        initViews();
        initValues();
    }

    private void initViews() {
        imgItemDetail = findViewById(R.id.imgItemDetail);
        tvTituloDetail = findViewById(R.id.tvTituloDetail);
        tvDescripcionDetail = findViewById(R.id.tvDescripcionDetail);
    }

    private void initValues() {
       itemDetail = (ItemList) getIntent().getExtras().getSerializable("ItemDetail");

       imgItemDetail.setImageResource(itemDetail.getImgResource());
       tvTituloDetail.setText(itemDetail.getTitulo());
       tvDescripcionDetail.setText(itemDetail.getDescripcion());
    }
}