package com.example.practica1compiladores12022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.practica1compiladores12022.Grafica.Barras;
import com.example.practica1compiladores12022.Grafica.ConvertidorGrafica;
import com.example.practica1compiladores12022.Grafica.Pie;
import com.example.practica1compiladores12022.MovenActivity.MoveWindow;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.PieDataSet;

public class MainActivity_Grafica_View extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private MoveWindow move = new MoveWindow();
    private ListView opcionesGrafica;
    public static BarDataSet barras = null;
    public static PieDataSet pie = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grafica_view);
        //asignar listview
        opcionesGrafica =  (ListView) findViewById(R.id.listGraficaOpcion);
        opcionesGrafica.setOnItemClickListener(this);
        if(move.MovenAnalisador(getIntent().getStringExtra("text").toString())){
            if (move.getConvertir().getListadoNombre()!=null) listarGraficas();
        }
        //boton de atras en la bara
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //metodo de listar graficas disponibles para ejecutar
    private void listarGraficas(){
        //listar nombres de graficas disponibles
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,move.getConvertir().getListadoNombre());
        opcionesGrafica.setAdapter(adapter);
    }
//metodo para ver que grafica debe de grficar, al precionar un titulo de la grafica
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (move.getSintac().getListadoGrafica().get(i) instanceof Barras){
            Barras ejecutar = (Barras) move.getSintac().getListadoGrafica().get(i);
            barras = (move.getConvertir().convertirBarra(ejecutar));
            if (ejecutar!=null){
                Intent next = new Intent(this,MainActivity_View_Grafica_Barra.class);
                next.putExtra("titulo",move.getConvertir().getListadoNombre()[i]);
                startActivity(next);
            }
        }
        if (move.getSintac().getListadoGrafica().get(i) instanceof Pie){
            Pie ejecutar = (Pie) move.getSintac().getListadoGrafica().get(i);
            pie = (move.getConvertir().convertirPie(ejecutar));
            if (ejecutar!=null){
                Intent next = new Intent(this,MainActivity_View_Grafica_Pie.class);
                next.putExtra("titulo",move.getConvertir().getListadoNombre()[i]);
                startActivity(next);
            }
        }
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

    //Ir a reprotes del listado de matematicas y la cantidad de graficas dectectadas
    public void report(View view){
        Intent go = new Intent(this,MainActivity_Reportes.class);
        go.putExtra("listado_reportes_mate",move.getSintac().getListadoReportesMatemtaicos());
        go.putExtra("num_list_bar",(move.getLexema().getContadorBarra() + ""));
        go.putExtra("num_list_pie",(move.getLexema().getContadorPie()+""));
        startActivity(go);
    }

}