package com.example.practica1compiladores12022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practica1compiladores12022.MovenActivity.MoveWindow;

public class MainActivity extends AppCompatActivity {
    private MoveWindow move = new MoveWindow();
    private EditText ingresoDeDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // asignar los componeste R da referencia a la vista y id mencionar que tiene id
        ingresoDeDatos = (EditText) findViewById(R.id.ingresoDatos);
    }
    public void recogerText(View view){
        if (!ingresoDeDatos.getText().toString().isEmpty()) {
            if(move.MovenAnalisador(ingresoDeDatos.getText().toString())){/// verifico si cumple todo la sintacsis
                startGraph();//si todo esta bien que muestre el listado de graficas dectetadas
            }else{
                startReport();// sino muestra los errores lexicos y sintacticos
            }
        }else{
            Toast.makeText(this,"Por favor ingrese un texto",Toast.LENGTH_LONG);
        }
    }
    //lo manda al a la ventana de reportes
    private void startReport(){
        Intent go = new Intent(this,MainActivity_Reportes_Error.class);
        startActivity(go);
    }
    //metodo para ir al listado de graficas para graficar en el programa
    private void startGraph(){
        /*
        Intent next = new Intent(this,MainActivity_Grafica_View.class);
        next.putExtra("text",ingresoDeDatos.getText().toString());
        startActivity(next);*/
        Intent next = new Intent(this,MainActivity_View_Graphics.class);
        next.putExtra("text",ingresoDeDatos.getText().toString());
        startActivity(next);
    }

    public void limpiear(View view){
        ingresoDeDatos.setText("");//limpia el text
    }
}