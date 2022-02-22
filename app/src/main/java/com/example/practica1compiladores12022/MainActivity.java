package com.example.practica1compiladores12022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practica1compiladores12022.JflexYCup.ErrorAnalisando;
import com.example.practica1compiladores12022.JflexYCup.Lexema;
import com.example.practica1compiladores12022.JflexYCup.parser;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private EditText ingresoDeDatos;
    private TextView mostarDatos;
    private Lexema lexema;
    private parser sintac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // asignar los componeste R da referencia a la vista y id mencionar que tiene id
        ingresoDeDatos = (EditText) findViewById(R.id.ingresoDatos);
        mostarDatos = (TextView) findViewById(R.id.mostarText);
        System.out.println("hola mundo");
    }
    public void recogerText(View view){
        String text = ingresoDeDatos.getText().toString();
        if (!text.isEmpty()){
            Reader reader = new StringReader(text);
            lexema = new Lexema(reader);
            ArrayList<ErrorAnalisando> list = lexema.getListError();
                if (!list.isEmpty()){
                    //fallo
                }else{
                    sintac = new parser(lexema);
                    try {
                        sintac.parse();
                    } catch (Exception ex) {
                        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }
                }
        }else{

        }
    }
}