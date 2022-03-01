package com.example.practica1compiladores12022.MovenActivity;

import androidx.annotation.NonNull;

import com.example.practica1compiladores12022.Grafica.ConvertidorGraficaChart;
import com.example.practica1compiladores12022.JflexYCup.Lexema;
import com.example.practica1compiladores12022.JflexYCup.parser;
import com.example.practica1compiladores12022.Resportes.ErrorAnalisando;


import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;


public class MoveWindow implements Serializable {

    private Lexema lexema;
    private parser sintac;
    public static ArrayList<ErrorAnalisando> listError = new ArrayList<>();
    private  ConvertidorGraficaChart convertir = new ConvertidorGraficaChart();
/*
metodo resibe un String para analisar sintacticamente
* */
    public boolean MovenAnalisador (@NonNull String text){
        listError.clear();
        if (!text.isEmpty()){
            Reader reader = new StringReader(text);
            lexema = new Lexema(reader);
            sintac = new parser(lexema);
            lexema.setListError(listError);
            sintac.setListError(listError);
            try {
                sintac.parse();
                if((listError!=null && !listError.isEmpty())) return false;
                if (sintac.getListadoGrafica()!=null && !sintac.getListadoGrafica().isEmpty()){
                    convertir.listar(sintac.getListadoGrafica());
                    return true;
                }
            } catch (Exception ex) {
                //Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
                ex.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }


    public Lexema getLexema() {
        return lexema;
    }

    public parser getSintac() {
        return sintac;
    }

    public ConvertidorGraficaChart getConvertir() {
        return convertir;
    }

    public ArrayList<ErrorAnalisando> getListError() {
        return listError;
    }
}
