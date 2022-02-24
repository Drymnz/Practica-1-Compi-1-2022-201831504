package com.example.practica1compiladores12022;

import static com.example.practica1compiladores12022.MainActivity_Grafica_View.barras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;

public class MainActivity_View_Grafica_Barra extends AppCompatActivity {
private BarChart barChart;
private TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_grafica_barra);
        //asigno mi barchart
        barChart = findViewById(R.id.BarChart);
        titulo = findViewById(R.id.tituloGrafica);
        titulo.setText(getIntent().getStringExtra("titulo").toString());
        barChart.setData(new BarData(barras));
    }
}