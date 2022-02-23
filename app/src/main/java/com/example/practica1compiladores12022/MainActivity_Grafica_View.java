package com.example.practica1compiladores12022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.practica1compiladores12022.MovenActivity.MoveWindow;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_Grafica_View extends AppCompatActivity {
    private MoveWindow move;
    private List<BarChart> listBar = new ArrayList<>();
    private List<PieChart> listPie = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grafica_view);
        todoBien(getIntent().getStringExtra("text"));
    }
    public void regresarVentanaPricipal(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
    private void todoBien(String text){
        if (move.MovenAnalisador(text)){
            listBar = move.getListBar();
            listPie = move.getListPie();
        }else{
            startActivity(new Intent(this,MainActivity.class));
        }
    }
}