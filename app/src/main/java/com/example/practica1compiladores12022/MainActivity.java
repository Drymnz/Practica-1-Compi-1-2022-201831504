package com.example.practica1compiladores12022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practica1compiladores12022.MovenActivity.MoveWindow;

public class MainActivity extends AppCompatActivity {

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
            Intent next = new Intent(this,MainActivity_Grafica_View.class);
            next.putExtra("text",ingresoDeDatos.getText().toString());
            startActivity(next);
        }else{
            Toast.makeText(this,"Por favor ingrese un texto",Toast.LENGTH_LONG);
        }
    }
}