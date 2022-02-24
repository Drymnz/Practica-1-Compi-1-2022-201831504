package com.example.practica1compiladores12022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.practica1compiladores12022.MovenActivity.MoveWindow;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_Grafica_View extends AppCompatActivity {
    private MoveWindow move = new MoveWindow();
    //private BarChart barChart;

    /***/
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grafica_view);
        //asigno mi barchart
        barChart = findViewById(R.id.BarChart);
        //creo
        todoBien(getIntent().getStringExtra("text").toString());
        /* getEntries();
        barDataSet = new BarDataSet(barEntries, "hola");
        barChart.setData(new BarData(barDataSet));
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(18f);*/
    }

    public void regresarVentanaPricipal(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
    private void todoBien(String text){
        if (move.MovenAnalisador(text)){
            if (! move.getListBar().isEmpty()){
                if (barChart == null) {
                    System.out.println("es null");
                }else {
                    barChart = findViewById(R.id.BarChart);
                    barChart.setData(new BarData(move.getListBar().get(0)));}
            }
        }else{
            startActivity(new Intent(this,MainActivity.class));
        }
    }

}