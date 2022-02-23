package com.example.practica1compiladores12022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity_Grafica_View extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grafica_view);
    }
    public void regresarVentanaPricipal(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
}