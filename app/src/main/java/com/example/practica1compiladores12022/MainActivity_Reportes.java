package com.example.practica1compiladores12022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.practica1compiladores12022.Resportes.ReportesOperadoresMatematicos;

import java.util.ArrayList;

public class MainActivity_Reportes extends AppCompatActivity {

    private TableLayout tableReporA;//reprotes arimetricos
    private TextView numBar;
    private TextView numPie;
    private ArrayList<ReportesOperadoresMatematicos> listMate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reportes);
        tableReporA = (TableLayout) findViewById(R.id.reporte_operacional);
        listMate = (ArrayList<ReportesOperadoresMatematicos>) getIntent().getSerializableExtra("listado_reportes_mate");
        numBar = (TextView) findViewById(R.id.num_bar_report);
        numPie = (TextView) findViewById(R.id.num_pie_report);
        numPie.setText(getIntent().getStringExtra("num_list_pie").toString());
        numBar.setText(getIntent().getStringExtra("num_list_bar").toString());
        if (listMate != null) {
            for (ReportesOperadoresMatematicos report : listMate) {
                TableRow fila = new TableRow(this);
                TextView[] a = new TextView[4];
                a[0] = new TextView(this);
                a[1] = new TextView(this);
                a[2] = new TextView(this);
                a[3] = new TextView(this);
                a[0].setText(report.getOperador());
                a[1].setText(report.getLinea() + "");
                a[2].setText(report.getColumna() + "");
                a[3].setText(report.getOcurrencia());
                for (int i = 0; i < a.length ; i++){
                    fila.addView(a[i]);
                }
                tableReporA.addView(fila);
            }
        }

        //boton de regresar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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