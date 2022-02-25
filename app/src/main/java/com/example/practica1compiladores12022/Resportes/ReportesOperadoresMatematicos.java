/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practica1compiladores12022.Resportes;

import java.io.Serializable;

/**
 * @author drymnz
 */
public class ReportesOperadoresMatematicos implements Serializable {
    private String operador;
    private int linea;
    private int columna;
    private String Ocurrencia;

    public ReportesOperadoresMatematicos(String operador, int linea, int columna, String Ocurrencia) {
        this.operador = operador;
        this.linea = linea;
        this.columna = columna;
        this.Ocurrencia = Ocurrencia;
    }

    public String getOperador() {
        return operador;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public String getOcurrencia() {
        return Ocurrencia;
    }
    
}
