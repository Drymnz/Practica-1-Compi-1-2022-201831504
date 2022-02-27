package com.example.practica1compiladores12022.Grafica;

import com.example.practica1compiladores12022.Array.ArrayDouble;
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
    //con vertir mi objeto Barra al obto bardataset para que se pueda graficar
    public BarDataSet convertirBarra(Barras barra){
        if (barra.getUnion() != null){
            ArrayList<BarEntry> detallesBarra = new ArrayList<>();
            for (int j = 0 ; j < barra.getUnion().getX() ; j++) {
                int valorX = (int) barra.getUnion().getList()[j][0];//returnar posicion unir : [{x,y}]
                int valorY = (int) barra.getUnion().getList()[j][barra.getUnion().getY()-1];//returnar posicion unir : [{x,y}]
                float valorBX = (float) valor(barra.getListDouble(),valorX);//colocar su valor
                String valorBY = caracter(barra.getListadoString(),valorY);//colocar su su etiqueta
                BarEntry bar = new BarEntry((j+1),valorBX, valorBY);//pide la posicion en x y el valor de y en la barra
                detallesBarra.add(bar);
            }
            BarDataSet add = new BarDataSet(detallesBarra,barra.getTitulo());
            add.setColors(ColorTemplate.COLORFUL_COLORS);
            add.setDrawValues(false);// que no se muestre la magnitud de la bara
            return add;
        }
        return null;
    }
    //con vertir mi objeto pie al obto PieDataSet para que se pueda graficar
    public PieDataSet convertirPie(Pie pie){
        if (pie!=null){
            ArrayList<PieEntry> detallesPies = new ArrayList<>();
            float suma = 0;// si existe el extra
            for (int j = 0 ; j < pie.getUnion().getX() ; j++) {
                int valorX = (int) pie.getUnion().getList()[j][0];
                int valorY = (int) pie.getUnion().getList()[j][pie.getUnion().getY() - 1];
                float cantidaIngresada = (float) valor(pie.getListDouble(), valorX);
                String etiqueta = caracter(pie.getListadoString(), valorY);
                suma += cantidaIngresada;//esto para el extra
                if(pie.getTotal() != 0){
                    cantidaIngresada /= pie.getTotal();
                    cantidaIngresada *= 100;
                }
                switch (pie.getTipo()){
                    case CANTIDAD:
                        PieEntry add3 = new PieEntry(cantidaIngresada,etiqueta);
                        detallesPies.add(add3);
                        break;
                    case PORCENTAJE:
                        PieEntry add = new PieEntry(cantidaIngresada,cantidaIngresada+"%");
                        detallesPies.add(add);
                        break;
                    default:
                        break;
                }
            }
            if (suma!=pie.getTotal() && suma < pie.getTotal() &&!pie.getExtra().isEmpty()) {
                float total = (float) ((pie.getTotal()-suma)/ pie.getTotal()) *100;
                switch (pie.getTipo()) {
                    case PORCENTAJE:
                        PieEntry add = new PieEntry(total,total+"%");
                        detallesPies.add(add);
                        break;
                    case CANTIDAD:
                        PieEntry add1 = new PieEntry(total,pie.getExtra());
                        detallesPies.add(add1);
                        break;
                    default:
                        break;
                }
            }
            PieDataSet add = new PieDataSet(detallesPies,pie.getTitulo());
            add.setColors(ColorTemplate.COLORFUL_COLORS);
            add.setDrawValues(false);
            //add.setLabel("hola mundo");
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
        if ( !listadoString.isEmpty()){
            String text = listadoString.get(0);
            String[] textA = text.split(",");
            if(valorY < textA.length && valorY >= 0){
                return textA[valorY];
            }
        }
        return "";
    }

    public String[] getListadoNombre() {
        return listadoNombre;
    }
}
