package com.example.practica1compiladores12022;

import static com.example.practica1compiladores12022.MainActivity_Grafica_View.barras;
import static com.example.practica1compiladores12022.MainActivity_Grafica_View.pie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.PieData;

public class MainActivity_View_Grafica_Pie extends AppCompatActivity {
    private PieChart pieChart;
    private TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_grafica_pie);
        pieChart = findViewById(R.id.ParChart);
        titulo = findViewById(R.id.tituloGrafica);
        titulo.setText(getIntent().getStringExtra("titulo").toString());
        pieChart.setData(new PieData(pie));
        //boton de atras en la bara
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //para el boton de atras de la app
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}