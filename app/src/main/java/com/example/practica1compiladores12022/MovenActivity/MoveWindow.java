package com.example.practica1compiladores12022.MovenActivity;

import androidx.annotation.NonNull;

import com.example.practica1compiladores12022.Grafica.ConvertidorGraficaChart;
import com.example.practica1compiladores12022.JflexYCup.ErrorAnalisando;
import com.example.practica1compiladores12022.JflexYCup.Lexema;
import com.example.practica1compiladores12022.JflexYCup.parser;
import com.example.practica1compiladores12022.MainActivity;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.PieDataSet;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoveWindow {

    private Lexema lexema;
    private parser sintac;
    private ArrayList<ErrorAnalisando> list;
    public  ConvertidorGraficaChart convertir = new ConvertidorGraficaChart();

    public boolean MovenAnalisador (@NonNull String text){
        if (!text.isEmpty()){
            Reader reader = new StringReader(text);
            lexema = new Lexema(reader);
            list = lexema.getListError();
            sintac = new parser(lexema);
            try {
                sintac.parse();
                System.out.println(sintac.getListadoGrafica().get(0).toString());
                if (sintac.getListadoGrafica()!=null && !sintac.getListadoGrafica().isEmpty()){
                    convertir.listar(sintac.getListadoGrafica());
                }
            } catch (Exception ex) {
                Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
                ex.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }

    public ArrayList<ErrorAnalisando> getList() {
        return list;
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
}
