package com.example.practica1compiladores12022.Grafica;

import com.example.practica1compiladores12022.Array.ArrayDouble;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ConvertidorGraficaChart {

private String[] listadoNombre ;


    public void listar(ArrayList<Grafica> listadoGrafica){
        listadoNombre = new String[listadoGrafica.size()];
        for (int i = 0;  i < listadoGrafica.size() ; i++){
            listadoNombre[i]  = listadoGrafica.get(i).getTitulo();
        }
    }
    public BarDataSet convertirBarra(Barras barra){
        if (barra.getUnion() != null){
            ArrayList<BarEntry> detallesBarra = new ArrayList<>();
            for (int j = 0 ; j < barra.getUnion().getX() ; j++) {
                int valorX = (int) barra.getUnion().getList()[j][0];
                int valorY = (int) barra.getUnion().getList()[j][barra.getUnion().getY()-1];
                float meter = (float) valor(barra.getListDouble(), valorX);
                detallesBarra.add(new BarEntry((j+1), meter));
            }
            BarDataSet add = new BarDataSet(detallesBarra,barra.getTitulo());
            add.setColors(ColorTemplate.COLORFUL_COLORS);
            add.setDrawValues(false);
            return add;
        }
        return null;
    }
    private double valor(ArrayDouble listDouble, int valorX){
        if ( valorX < listDouble.getList().length && valorX >= 0){
            return  listDouble.getList()[valorX];
        }
        return 0;
    }
    private String caracter(ArrayList<String> listadoString, int valorY){
        if ( valorY < listadoString.size() && valorY >= 0){
            return listadoString.get(valorY);
        }
        return "";
    }

    public String[] getListadoNombre() {
        return listadoNombre;
    }
}
