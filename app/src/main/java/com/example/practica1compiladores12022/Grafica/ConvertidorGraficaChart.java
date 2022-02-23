package com.example.practica1compiladores12022.Grafica;

import com.example.practica1compiladores12022.Array.ArrayDouble;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class ConvertidorGraficaChart {


    private List<BarChart> listBar = new ArrayList<>();
    private List<PieChart> listPie = new ArrayList<>();

    public void convertir(ArrayList<Grafica> listadoGrafica){
         List<BarEntry> detallesBarra = new ArrayList<>();
         List<PieEntry> listadoPie = new ArrayList<>();
        for (int i = 0;  i < listadoGrafica.size() ; i++){
            // esta parte añade las graficas en barras
            if (listadoGrafica.get(i) instanceof Barras){
                Barras barra = (Barras) listadoGrafica.get(i);
                ArrayList<String> imprimir = new ArrayList<>();
                for (int j = 0 ; j < barra.getUnion().getX() ; j++) {
                    int valorX = (int) barra.getUnion().getList()[j][0];
                    int valorY = (int) barra.getUnion().getList()[j][barra.getUnion().getY()];
                    detallesBarra.add(new BarEntry(j, (float) valor(barra.getListDouble(), valorX),imprimir.add(caracter(barra.getListadoString(), valorY))));
                }
            }
            // esta parte añade las graficas en pie
            if (listadoGrafica.get(i) instanceof Pie){
            }
        }
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

    public List<BarChart> getListBar() {
        return listBar;
    }

    public List<PieChart> getListPie() {
        return listPie;
    }
}
