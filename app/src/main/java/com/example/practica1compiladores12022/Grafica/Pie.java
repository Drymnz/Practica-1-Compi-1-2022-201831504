/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practica1compiladores12022.Grafica;

import com.example.practica1compiladores12022.Array.ArrayDouble;
import com.example.practica1compiladores12022.Array.ArrayOrderedPair;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author drymnz
 */
public class Pie extends Grafica implements Serializable {
    private final double GRADO = 360;
    public enum posible {CANTIDAD,PORCENTAJE};
    private posible tipo;
    private double total;
    private String extra;

    public Pie(posible tipo, double total, String extra, String titulo, ArrayOrderedPair union, ArrayDouble listDouble, ArrayList<String> listadoString) {
        super(titulo, union, listDouble, listadoString);
        this.tipo = tipo;
        this.total = total;
        this.extra = extra;
    }

    public Pie(posible tipo, double total, String titulo, ArrayOrderedPair union, ArrayDouble listDouble, ArrayList<String> listadoString) {
        super(titulo, union, listDouble, listadoString);
        this.tipo = tipo;
        this.total = total;
    }

    public Pie(posible tipo, String extra, String titulo, ArrayOrderedPair union, ArrayDouble listDouble, ArrayList<String> listadoString) {
        super(titulo, union, listDouble, listadoString);
        this.tipo = tipo;
        this.extra = extra;
        switch (tipo){
            case PORCENTAJE:
                this.total =  GRADO;
                break;
            case CANTIDAD:
                this.total =  (sumaEjeXUnir()<360)? 360 : 0;
                break;
        }
    }

    public Pie(posible tipo, String titulo, ArrayOrderedPair union, ArrayDouble listDouble, ArrayList<String> listadoString) {
        super(titulo, union, listDouble, listadoString);
        this.tipo = tipo;
    }
    private double sumaEjeXUnir(){
        double suma = 0 ;
        for(int i = 0; i < this.getUnion().getX(); i++){
            int valorX = (int) this.getUnion().getList()[i][0];
            suma += valor(this.getListDouble(),valorX);
        }
        return suma;
    }

    private double valor(ArrayDouble listDouble, int valorX){
        if ( valorX < listDouble.getList().length && valorX >= 0){
            return  listDouble.getList()[valorX];
        }
        return 0;
    }

    public posible getTipo() {
        return tipo;
    }

    public void setTipo(posible tipo) {
        this.tipo = tipo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    
    
}
