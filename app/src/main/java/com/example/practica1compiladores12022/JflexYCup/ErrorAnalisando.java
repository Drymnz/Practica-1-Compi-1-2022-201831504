/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practica1compiladores12022.JflexYCup;

/**
 *
 * @author drymnz
 */
public class ErrorAnalisando {

    private String lexema;
    private int linea;
    private int columna;
    private String tipo;
    private String Descripcion;

    public ErrorAnalisando(String lexema, int linea, int columna, String tipo, String Descripcion) {
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
        this.tipo = tipo;
        this.Descripcion = Descripcion;
    }

    public String getLexema() {
        return lexema;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    @Override
    public String toString() {
        return "Lexema<" + lexema + ">linea<" + linea + ">columna<" + columna + ">tipo<" + tipo + ">descripcion<" + Descripcion+">";
        //return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
