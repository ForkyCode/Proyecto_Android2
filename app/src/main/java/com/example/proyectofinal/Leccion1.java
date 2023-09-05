package com.example.proyectofinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Leccion1 extends AppCompatActivity {
    //Se declaran los objetos para usarlos
    private RadioButton rdOpc1, rdOpc2, rdOpc3;
    private TextView txtNpregunta, txtPregunta;
    private Button btnSiguiente, btnSalir;
    //Se declaran las variables para modificar la pregunta y las opciones, y para calcular la puntuacion
    //String NoPregunta, pregunta, opcion1, opcion2, opcion3;
    private int nota = 0; int Npregunta = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leccion1);

        //Se le asigna a cada objeto el id de lo que va a usar
        rdOpc1 = (RadioButton)findViewById(R.id.rdBtnOpc1);
        rdOpc2 = (RadioButton)findViewById(R.id.rdBtnOpc2);
        rdOpc3 = (RadioButton)findViewById(R.id.rdBtnOpc3);

        txtNpregunta = (TextView)findViewById(R.id.txtNpregunta);
        txtPregunta = (TextView)findViewById(R.id.txtPregunta);

        btnSiguiente = (Button)findViewById(R.id.btnSiguiente);
        btnSalir = (Button)findViewById(R.id.btnSalir);
    }

    public void siguiente (View view){
        //if por si no se marca ninguna opcion
        if(rdOpc1.isChecked() == false && rdOpc2.isChecked() == false && rdOpc3.isChecked()==false){
            Toast.makeText(this, "Elija una opción", Toast.LENGTH_SHORT).show();
        }else if(Npregunta == 1){
            //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
            if(rdOpc2.isChecked()){
                nota = nota + 2;
            }
            //Se le suma 1 al contador de la pregunta
            Npregunta = Npregunta + 1;
            //Se setean los textos para la siguiente pregunta
            txtNpregunta.setText("Pregunta 2");
            txtPregunta.setText("Esta es la pregunta 2, su respuesta correcta es la opcion 1");
            rdOpc1.setText("Opcion 1 p2");
            rdOpc2.setText("Opcion 2 p2");
            rdOpc3.setText("Opcion 3 p2");
            //Se limpian los Radio buttons para la siguiente pregunta
            rdOpc1.setChecked(false);
            rdOpc2.setChecked(false);
            rdOpc3.setChecked(false);
        }else if(Npregunta == 2) {
            //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
            if (rdOpc1.isChecked()) {
                nota = nota + 2;
            }
            //Se le suma 1 al contador de la pregunta
            Npregunta = Npregunta + 1;
            //Se setean los textos para la siguiente pregunta
            txtNpregunta.setText("Pregunta 3");
            txtPregunta.setText("Esta es la pregunta 3, su respuesta correcta es la opcion 3");
            rdOpc1.setText("Opcion 1 p3");
            rdOpc2.setText("Opcion 2 p3");
            rdOpc3.setText("Opcion 3 p3");
            //Se limpian los Radio buttons para la siguiente pregunta
            rdOpc1.setChecked(false);
            rdOpc2.setChecked(false);
            rdOpc3.setChecked(false);
        }else if(Npregunta == 3) {
            //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
            if (rdOpc3.isChecked()) {
                nota = nota + 2;
            }
            //Se le suma 1 al contador de la pregunta
            Npregunta = Npregunta + 1;
            //Se setean los textos para la siguiente pregunta
            txtNpregunta.setText("Pregunta 4");
            txtPregunta.setText("Esta es la pregunta 4, su respuesta correcta es la opcion 1");
            rdOpc1.setText("Opcion 1 p4");
            rdOpc2.setText("Opcion 2 p4");
            rdOpc3.setText("Opcion 3 p4");
            //Se limpian los Radio buttons para la siguiente pregunta
            rdOpc1.setChecked(false);
            rdOpc2.setChecked(false);
            rdOpc3.setChecked(false);
        }else if(Npregunta == 4) {
            //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
            if (rdOpc1.isChecked()) {
                nota = nota + 2;
            }
            //Se le suma 1 al contador de la pregunta
            Npregunta = Npregunta + 1;
            //Se setean los textos para la siguiente pregunta
            txtNpregunta.setText("Pregunta 5");
            txtPregunta.setText("Esta es la pregunta 5, su respuesta correcta es la opcion 2");
            rdOpc1.setText("Opcion 1 p5");
            rdOpc2.setText("Opcion 2 p5");
            rdOpc3.setText("Opcion 3 p5");
            //Se limpian los Radio buttons para la siguiente pregunta
            rdOpc1.setChecked(false);
            rdOpc2.setChecked(false);
            rdOpc3.setChecked(false);
        }else if(Npregunta == 5) {
            //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
            if (rdOpc2.isChecked()) {
                nota = nota + 2;
            }
            //Se setean los textos para el resultado de la nota
            txtNpregunta.setText("Nota obtenida: "+nota);
            //IF para verificar si se ha aprobado o reprobado
            if(nota >= 6){
                txtPregunta.setText("Estado: Aprobado");
            }else{
                txtPregunta.setText("Estado: Reprobado");
            }
            //Se ocultan las opciones que no se van a usar para ver la nota y resultado
            rdOpc1.setVisibility(View.GONE);
            rdOpc2.setVisibility(View.GONE);
            rdOpc3.setVisibility(View.GONE);
            btnSiguiente.setVisibility(View.GONE);
        }
    }
    public void Salir(View view){
        // Ir a lecciones
        Intent intent = new Intent(Leccion1.this, LeccionesActivity.class);
        startActivity(intent);
        finish();
    }
 }
