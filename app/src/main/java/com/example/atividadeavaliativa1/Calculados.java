package com.example.atividadeavaliativa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculados extends AppCompatActivity {
        public EditText etLista;
        Button btnNovoCalculo;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calculados);

            etLista = (EditText) findViewById(R.id.etLista);
            Intent receberDados = getIntent();
            Bundle bundle = receberDados.getExtras();
            etLista.setText(bundle.getString("dados"));

            btnNovoCalculo = (Button) findViewById(R.id.btnNovoCalculo);
            btnNovoCalculo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

        }
    }