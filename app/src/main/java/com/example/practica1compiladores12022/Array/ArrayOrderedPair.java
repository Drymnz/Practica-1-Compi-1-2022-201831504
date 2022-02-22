/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practica1compiladores12022.Array;

/**
 *
 * @author drymnz
 */
public class ArrayOrderedPair {

    private double[][] list = null;
    private int x = 1;
    private final int y = 2;

    public ArrayOrderedPair() {
    }

    public ArrayOrderedPair(double x, double y) {
        add(x, y);
    }

    public void add(double x, double y) {
        if (list == null) {
            list = new double[this.x][this.y];
            list[0][0] = x;
            list[0][this.y - 1] = y;
        } else {
            double[][] listNew = new double[(this.x + 1)][this.y];
            for (int i = 0; i < this.x; i++) {
                listNew[i][0] = list[i][0];
                listNew[i][this.y - 1] = list[i][this.y - 1];
            }
            this.x++;
            listNew[this.x - 1][0] = x;
            listNew[this.x - 1][this.y - 1] = y;
            this.list = listNew;
        }
    }

    public void clear() {
        list = null;
        x = 1;
    }

    @Override
    public String toString() {
        String retur = "[";
        if (list != null) {
            for (int i = 0; i < this.x; i++) {
                retur += "{" + list[i][0] + "," + list[i][this.y - 1] + "}" + ((i < this.x - 1) ? "," : " ");
            }
        }
        retur += "]";
        return retur;
    }

}
