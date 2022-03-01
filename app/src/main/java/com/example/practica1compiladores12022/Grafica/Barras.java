
package com.example.practica1compiladores12022.Grafica;

import com.example.practica1compiladores12022.Array.ArrayDouble;
import com.example.practica1compiladores12022.Array.ArrayOrderedPair;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author drymnz
 */
public class Barras extends Grafica implements Serializable {

    public Barras(String titulo, ArrayOrderedPair union, ArrayDouble listDouble, ArrayList<String> listadoString) {
        super(titulo, union, listDouble, listadoString);
    }
}
