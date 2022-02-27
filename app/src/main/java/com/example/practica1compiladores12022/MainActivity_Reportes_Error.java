package com.example.practica1compiladores12022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.practica1compiladores12022.JflexYCup.ErrorAnalisando;
import com.example.practica1compiladores12022.MovenActivity.MoveWindow;
import com.example.practica1compiladores12022.Resportes.ReportesOperadoresMatematicos;

import java.util.ArrayList;

public class MainActivity_Reportes_Error extends AppCompatActivity {

    private TableLayout tableReporError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reportes_error);
        tableReporError = (TableLayout) findViewById(R.id.reporte_errores);
        tableReporError.removeAllViews();
        print(MoveWindow.listError);
        //boton de regresar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //imprimir el listdo de erroes
    private void print(ArrayList<ErrorAnalisando> print){
        if (print != null) {
            for (ErrorAnalisando error : print) {
                    TableRow fila = new TableRow(this);
                    TextView[] a = new TextView[5];
                    a[0] = new TextView(this);
                    a[1] = new TextView(this);
                    a[2] = new TextView(this);
                    a[3] = new TextView(this);
                    a[4] = new TextView(this);
                    a[0].setText(error.getLexema());
                    a[1].setText(error.getLinea() + "");
                    a[2].setText(error.getColumna() + "");
                    a[3].setText(error.getTipo());
                    a[4].setText(error.getDescripcion());
                    for (int i = 0; i < a.length; i++) {
                        fila.addView(a[i]);
                    }
                    tableReporError.addView(fila);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}