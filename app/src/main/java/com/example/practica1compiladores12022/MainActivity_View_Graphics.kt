package com.example.practica1compiladores12022

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.practica1compiladores12022.Grafica.Barras
import com.example.practica1compiladores12022.Grafica.ConvertidorGrafica
import com.example.practica1compiladores12022.Grafica.Pie
import com.example.practica1compiladores12022.MovenActivity.MoveWindow
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet

class MainActivity_View_Graphics : AppCompatActivity() {

    private var move:MoveWindow = MoveWindow()
    private lateinit var listBar:ListView
    private lateinit var listPie:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view_graphics)
        listBar = findViewById<ListView>(R.id.listGraficaBar)
        listPie = findViewById<ListView>(R.id.listGraficaPie)
        if(move.MovenAnalisador(intent.getStringExtra("text").toString())){
            if(move.convertir.listadoNombre!=null)
                listart()
        }
        var botn:Button = findViewById(R.id.btn_report)
        botn.setOnClickListener(){
            val go = Intent(this, MainActivity_Reportes::class.java)
            go.putExtra("listado_reportes_mate", move.sintac.listadoReportesMatemtaicos)
            go.putExtra("num_list_bar", move.lexema.contadorBarra.toString() + "")
            go.putExtra("num_list_pie", move.lexema.contadorPie.toString() + "")
            startActivity(go)
        }
        //boton de atras en la bara
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
    private fun listart(){
        var list:ArrayList<GraficaChart>  = ArrayList()
        var listBar:ArrayList<BarData> = ArrayList()
        var listTiulobar:ArrayList<String> = ArrayList()
        var listTiulopiew:ArrayList<String> = ArrayList()
        var listPie:ArrayList<PieData> = ArrayList()
        var conver:ConvertidorGrafica = ConvertidorGrafica()
        for(i in move.sintac.listadoGrafica){
            if(i is Barras ){
                var add:BarDataSet = (conver.convertidor(i))
                var dasd:BarData = BarData(add)
                var addFinal:GraficaChart = GraficaChart(dasd,i.titulo)
                listBar.add(dasd)
                listTiulobar.add(i.titulo)
                list.add(addFinal)
            }
            if(i is Pie ){
                var add:PieDataSet = (conver.convertirPie(i))
                var dasd:PieData = PieData(add)
                var addFinal:GraficaChart = GraficaChart(dasd,i.titulo)
                listPie.add(dasd)
                listTiulopiew.add(i.titulo)
                list.add(addFinal)
            }
        }
        var adaptorBar:MyAdapter = MyAdapter(this,listBar,listTiulobar)
        var adaptorPie:MyAdapterPie = MyAdapterPie(this,listPie,listTiulopiew)
        this.listBar.setAdapter(adaptorBar)
        this.listPie.setAdapter(adaptorPie)
    }

class MyAdapter(private var context: Activity, private val array:List<BarData>,private val listado:ArrayList<String>) : ArrayAdapter<BarData> (context, R.layout.listview_barchart,array){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var inflater : LayoutInflater = LayoutInflater.from(context)
        var view : View = inflater.inflate(R.layout.listview_barchart, null)

        var titulo:TextView = view.findViewById(R.id.titulo_barchart)
        var graficaDetalles:BarData = array.get(position)
        var grafica:BarChart = view.findViewById(R.id.grafica_bar)
        grafica.setData(graficaDetalles)
        titulo.setText(listado.get(position))
        return view
    }
}

    class MyAdapterPie(private var context: Activity, private val array:List<PieData>,private val listado:ArrayList<String>) : ArrayAdapter<PieData> (context, R.layout.listview_piechart,array){
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var inflater : LayoutInflater = LayoutInflater.from(context)
            var view : View = inflater.inflate(R.layout.listview_piechart, null)

            var titulo:TextView = view.findViewById(R.id.titulo_pie)
            var graficaDetalles:PieData = array.get(position)
            var grafica:PieChart = view.findViewById(R.id.ParChart)
            grafica.setData(graficaDetalles)
            titulo.setText(listado.get(position))
            return view
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}