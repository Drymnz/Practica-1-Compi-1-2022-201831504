package com.example.practica1compiladores12022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.practica1compiladores12022.Grafica.Barras;
import com.example.practica1compiladores12022.Grafica.Pie;
import com.example.practica1compiladores12022.MovenActivity.MoveWindow;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_Grafica_View extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static MoveWindow move = new MoveWindow();
    private ListView opcionesGrafica;
    public static BarDataSet barras = null;
    public static PieDataSet pie = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grafica_view);
        //creo el listado
        opcionesGrafica =  (ListView) findViewById(R.id.listGraficaOpcion);
        opcionesGrafica.setOnItemClickListener(this);
        listarGraficas(getIntent().getStringExtra("text").toString());
    }

    public void regresarVentanaPricipal(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
    /* barChart = findViewById(R.id.BarChart);
                    barChart.setData(new BarData(move.getListBar().get(0)));*/
    private void listarGraficas(String text){
        if (!text.isEmpty()){
            if (move.MovenAnalisador(text)){
                if (move.getConvertir().getListadoNombre()!=null){
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,move.getConvertir().getListadoNombre());
                    opcionesGrafica.setAdapter(adapter);
                }

            }else{
                startActivity(new Intent(this,MainActivity.class));
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        System.out.println("adapterView"+adapterView+"View"+view+"int"+i+"long"+l);
        if (move.getSintac().getListadoGrafica().get(i) instanceof Barras){
            Barras ejecutar = (Barras) move.getSintac().getListadoGrafica().get(i);
            barras = (move.getConvertir().convertirBarra(ejecutar));
            Intent next = new Intent(this,MainActivity_View_Grafica_Barra.class);
            next.putExtra("titulo",move.getConvertir().getListadoNombre()[i]);
            startActivity(next);
        }
        if (move.getSintac().getListadoGrafica().get(i) instanceof Pie){
            Pie ejecutar = (Pie) move.getSintac().getListadoGrafica().get(i);
            //pie = (move.getConvertir().convertirBarra(ejecutar));
        }
    }
}