package com.example.atividadeavaliativa1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnLimpar, btnCalcular, btnProximaTela;
    TextView Resultado, tvMensagem;
    EditText etValor_1, etValor_2, etValor_3, etValor_4;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Calculo calculo = new Calculo();

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnProximaTela = findViewById(R.id.btnProximaTela);
        Resultado = findViewById(R.id.tvResultado);
        tvMensagem = findViewById(R.id.tvMensagem);
        etValor_1 = findViewById(R.id.etValor1);
        etValor_2 = findViewById(R.id.etValor2);
        etValor_3 = findViewById(R.id.etValor3);
        etValor_4 = findViewById(R.id.etValor4);
        res = getResources();

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etValor_1.setText("");
                etValor_2.setText("");
                etValor_3.setText("");
                etValor_4.setText("");
                tvMensagem.setText("Informe os valores para o cálculo:");
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    calculo.setValor1(Double.parseDouble(etValor_1.getText().toString()));
                    calculo.setValor2(Double.parseDouble(etValor_2.getText().toString()));
                    calculo.setValor3(Double.parseDouble(etValor_3.getText().toString()));
                    calculo.setValor4(Double.parseDouble(etValor_4.getText().toString()));
                    calculo.setResultado(calculo.getValor1() / calculo.getValor2());
                    calculo.setResultado(calculo.getResultado() / calculo.getValor3());
                    calculo.setResultado(calculo.getResultado() / calculo.getValor4());
                    Resultado.setText(String.valueOf(calculo.getResultado()));
                } catch (Exception e) {
                    tvMensagem.setText("Informe os valores corretamente:");
                }
            }
        });
        btnProximaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent enviaDados = new Intent(MainActivity.this, Calculados.class);
                String dados = "Resultado =" + calculo.getResultado();
                Bundle bundle = new Bundle();
                bundle.putString("dados", dados);
                enviaDados.putExtras(bundle);
                startActivity(enviaDados);
            }
        });
    };
};