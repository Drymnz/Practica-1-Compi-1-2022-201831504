package com.example.practica1compiladores12022.JflexYCup;

import com.example.practica1compiladores12022.Array.*;
import com.example.practica1compiladores12022.Grafica.*;
import com.example.practica1compiladores12022.Resportes.ReportesOperadoresMatematicos;

import java.util.ArrayList;

public class guia {


    /**
     * ***CODE*******
     */
    public static ArrayList<ReportesOperadoresMatematicos> listadoReportesMatemtaicos = new ArrayList<>();
    private ArrayList<ErrorAnalisando> listError = new ArrayList<>();//if registra[3] == true
    private ArrayList<Grafica> listadoGrafica = new ArrayList<>();
    private ArrayList<Grafica> listadoGraficaPosible = new ArrayList<>();
    //valors para crear graficas
    //para cualquier grafica
    private ArrayOrderedPair listadoUnir = new ArrayOrderedPair();//if registra[2] == true
    private String titulo;
    private boolean[] registrar = {true, true, true,true};//arreglo para indicar que solo una ves analise el etributo
    private boolean[] tipoGrafica = {false, false};//tipoGrafica[0]=BARRAS , tipoGrafica[1]PIE
    //barras
    private ArrayList<String> listadoEjeX = new ArrayList<>(); //if registra[0] == true
    private ArrayDouble listadoEjeY = new ArrayDouble();//if registra[1] == true
    //pie
    private ArrayList<String> listadoEtiqueta = new ArrayList<>(); //if registra[0] == true
    private ArrayDouble listadoValores = new ArrayDouble();//if registra[1] == true
    private double total;
    private String tipo;
    private String extra;

    //agregar grafica al listado
    private void addGraph() {
        Grafica add = null;
        //los requisitos minimos de una grafica es tener titulo un par ordenado para valor y caracter y su listado de valores y listado de caracter
        boolean requisitosBasicos = (!titulo.isEmpty()) && (listadoUnir!=null) && (listadoEjeX!=null | listadoEtiqueta!=null) && (listadoEjeY!=null | listadoValores!=null);
        //add Barra
        if (tipoGrafica[0] & requisitosBasicos) {
            add = new Barras(titulo, listadoUnir, listadoEjeY, listadoEjeX);
        }
        //add Pie
        if (tipoGrafica[1] & requisitosBasicos) {
            int cantidadPorcentaje = (tipo.equalsIgnoreCase("Porcentaje")) ? 0 : (tipo.equalsIgnoreCase("Cantidad")) ? 1 : 2;
            switch ((total == 0 && extra.isEmpty() && cantidadPorcentaje != 2) ? 0 : (total != 0 && extra.isEmpty() && cantidadPorcentaje != 2) ? 1 : (!extra.isEmpty() && total == 0 && cantidadPorcentaje != 2) ? 2 : (cantidadPorcentaje != 2) ? 3 : 4) {
                case 0:
                    add = new Pie((cantidadPorcentaje == 0) ? Pie.posible.PORCENTAJE : Pie.posible.CANTIDAD, titulo +"", listadoUnir, listadoValores, listadoEtiqueta);
                    break;
                case 1:
                    add = new Pie((cantidadPorcentaje == 0) ? Pie.posible.PORCENTAJE : Pie.posible.CANTIDAD, total, titulo +"", listadoUnir, listadoValores, listadoEtiqueta);
                    break;
                case 2:
                    add = new Pie((cantidadPorcentaje == 0) ? Pie.posible.PORCENTAJE : Pie.posible.CANTIDAD, extra, titulo +"", listadoUnir, listadoValores, listadoEtiqueta);
                    break;
                case 3:
                    add = new Pie((cantidadPorcentaje == 0) ? Pie.posible.PORCENTAJE : Pie.posible.CANTIDAD, total, extra +"", titulo +"", listadoUnir, listadoValores, listadoEtiqueta);
                    break;
                default:
                    System.out.println("NO SE ENCONTRO NADA PARA AÑADIR AL LISTADO GRAFICA");
                    throw new AssertionError();
            }
        }
        if (add != null) listadoGraficaPosible.add(add);
    }
    //En esta metodo regresa los atributos a su estado inicial
    private void restoreString() {
        total = 0;
        titulo = "";
        tipo = "";
        extra = "";
        listadoEjeX = new ArrayList<>();
        listadoEjeY = new ArrayDouble();
        listadoValores = new ArrayDouble();
        listadoEtiqueta = new ArrayList<>();
        listadoUnir = new ArrayOrderedPair();
        registrar[0] = true;
        registrar[2] = true;
        registrar[1] = true;
        tipoGrafica[0] = false;
        tipoGrafica[1] = false;
    }
// solo prubas en terminal
    private void printString() {
        System.out.println("**********" + "titulo>>>" + titulo + "*********************************");
        System.out.println("total>>>" + total);
        System.out.println("tipo>>" + tipo);
        System.out.println("extra>>>" + extra);
        System.out.println("listadoEjeX>>>" + listadoEjeX.toString());
        System.out.println("listadoEjeY>>>" + listadoEjeY.toString());
        System.out.println("listadoValores>>>" + listadoValores.toString());
        System.out.println("listadoEtiqueta>>>" + listadoEtiqueta.toString());
        System.out.println("listadoReportesMatemtaicos>>>" + listadoReportesMatemtaicos.toString());
        for (int i = 0; i < listadoGrafica.size(); i++) {
            System.out.println("listadoGrafica>>>" + listadoGrafica.get(i).toString());
        }
        System.out.println("**********************************************************************");
    }
    // aqui lista la graficas que se va a pode graficar
    private void listarGraficas(String titulo){
        if (!listadoGraficaPosible.isEmpty()) {
            for (Grafica grafica : listadoGraficaPosible) {
                if (grafica.getTitulo().equalsIgnoreCase(titulo)){
                    listadoGrafica.add(grafica);
                }
            }
        }
    }

    public ArrayList<ReportesOperadoresMatematicos> getListadoReportesMatemtaicos() {
        return listadoReportesMatemtaicos;
    }

    public ArrayList<Grafica> getListadoGrafica() {
        return listadoGrafica;
    }

    public ArrayList<ErrorAnalisando> getListError() {

        return listError;
    }

    public static void setListadoReportesMatemtaicos(ArrayList<ReportesOperadoresMatematicos> listadoReportesMatemtaicos) {
        guia.listadoReportesMatemtaicos = listadoReportesMatemtaicos;
    }

    public void setListError(ArrayList<ErrorAnalisando> listError) {
        this.listError = listError;
    }

    public void setListadoGrafica(ArrayList<Grafica> listadoGrafica) {
        this.listadoGrafica = listadoGrafica;
    }
    /**
     * ***END CODE*******
     */
}
