package com.example.practica1compiladores12022.Grafica;

import com.example.practica1compiladores12022.Array.*;

import java.util.ArrayList;

public class Grafica {

    private String titulo;
    private ArrayOrderedPair union;
    private ArrayDouble listDouble;
    private ArrayList<String> listadoString;

    public Grafica(String titulo, ArrayOrderedPair union, ArrayDouble listDouble, ArrayList<String> listadoString) {
        this.titulo = titulo;
        this.union = union;
        this.listDouble = listDouble;
        this.listadoString = listadoString;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayOrderedPair getUnion() {
        return union;
    }

    public void setUnion(ArrayOrderedPair union) {
        this.union = union;
    }

    public ArrayDouble getListDouble() {
        return listDouble;
    }

    public void setListDouble(ArrayDouble listDouble) {
        this.listDouble = listDouble;
    }

    public ArrayList<String> getListadoString() {
        return listadoString;
    }

    public void setListadoString(ArrayList<String> listadoString) {
        this.listadoString = listadoString;
    }

    @Override
    public String toString() {
        return "titulo<"+titulo+">union<"+union.toString()+">listDouble<"+listDouble.toString()+">listadoString<"+listadoString.toString()+">";
    }
}
