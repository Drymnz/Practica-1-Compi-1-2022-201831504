/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practica1compiladores12022.Array;

import java.util.Vector;

/**
 *
 * @author drymnz
 */
public class ArrayDouble {

    private double[] list = null;

    public ArrayDouble() {

    }

    public ArrayDouble(double dato) {
        add(dato);
    }

    /*ESTE CODIGO AÑADE DE INICIO A FIN PARA QUE SE PEGE AL USO DE MI SINTACXIS CUP */
    public void add(double add) {
        if (this.list == null) {
            list = new double[1];
            list[0] = add;
        } else {
            double[] newList = new double[this.list.length + 1];
            newList[0] = add;
            for (int i = 1; i < newList.length; i++) {
                newList[i] = list[i - 1];
            }
            list = newList;
        }
    }

    //LIMPIAR LISTA
    public void clear() {
        this.list = null;
    }

    /*
    PARA IMPIRMIR EL ARRAY
     */
    @Override
    public String toString() {
        String retur = "[";
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                retur += list[i] + ((i < list.length - 1) ? "," : " ");
            }
        }
        retur += "]";
        return retur;
    }

    public double[] getList() {
        return list;
    }

    public void setList(double[] list) {
        this.list = list;
    }

}
