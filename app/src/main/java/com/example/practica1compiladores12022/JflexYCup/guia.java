package com.example.practica1compiladores12022.JflexYCup;

import com.example.practica1compiladores12022.Array.*;
import com.example.practica1compiladores12022.Grafica.*;
import com.example.practica1compiladores12022.Resportes.ReportesOperadoresMatematicos;

import java.util.ArrayList;

public class guia {
    /**
     * ***CODE*******
     */
    private ArrayList<ReportesOperadoresMatematicos> listadoReportesMatemtaicos = new ArrayList<>();
    private ArrayList<Grafica> listadoGrafica = new ArrayList<>();
    //valors para crear graficas
    private ArrayList<String> listadoEjeX = new ArrayList<>(); //if registra[0] == true
    private ArrayList<String> listadoEtiqueta = new ArrayList<>(); //if registra[0] == true
    private ArrayDouble listadoValores = new ArrayDouble();//if registra[1] == true
    private ArrayDouble listadoEjeY = new ArrayDouble();//if registra[1] == true
    private ArrayOrderedPair listadoUnir = new ArrayOrderedPair();//if registra[2] == true
    private boolean[] registrar = {true, true, true};
    private boolean[] tipoGrafica = {false, false};//tipoGrafica[0]=BARRAS , tipoGrafica[1]PIE
    private double total;
    private String titulo;
    private String tipo;
    private String extra;

    //agregar grafica al listado
    private void addGraph() {
        Grafica add = null;
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
                    add = new Pie((cantidadPorcentaje == 0) ? Pie.posible.PORCENTAJE : Pie.posible.CANTIDAD, titulo, listadoUnir, listadoValores, listadoEtiqueta);
                    break;
                case 1:
                    add = new Pie((cantidadPorcentaje == 0) ? Pie.posible.PORCENTAJE : Pie.posible.CANTIDAD, total, titulo, listadoUnir, listadoValores, listadoEtiqueta);
                    break;
                case 2:
                    add = new Pie((cantidadPorcentaje == 0) ? Pie.posible.PORCENTAJE : Pie.posible.CANTIDAD, extra, titulo, listadoUnir, listadoValores, listadoEtiqueta);
                    break;
                case 3:
                    add = new Pie((cantidadPorcentaje == 0) ? Pie.posible.PORCENTAJE : Pie.posible.CANTIDAD, total, extra, titulo, listadoUnir, listadoValores, listadoEtiqueta);
                    break;
                default:
                    System.out.println("NO SE ENCONTRO NADA PARA AÑADIR AL LISTADO GRAFICA");
                    throw new AssertionError();
            }
        }
        if (add == null) {
            System.out.println("NO SE ENCONTRO NADA PARA AÑADIR AL LISTADO GRAFICA");
        } else {
            listadoGrafica.add(add);
        }
    }
    //En esta parte regresa los atributos a su estado inicial

    private void restoreString() {
        total = 0;
        titulo = null;
        tipo = null;
        extra = null;
        listadoEjeX.clear();
        listadoEjeY.clear();
        listadoValores.clear();
        listadoEtiqueta.clear();
        listadoUnir.clear();
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

    public ArrayList<ReportesOperadoresMatematicos> getListadoReportesMatemtaicos() {
        return listadoReportesMatemtaicos;
    }

    public ArrayList<Grafica> getListadoGrafica() {
        return listadoGrafica;
    }
    /**
     * ***END CODE*******
     */
}
