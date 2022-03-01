package com.example.practica1compiladores12022.Grafica

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.practica1compiladores12022.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
/*
*Esta clase es el adaptador de listview para que puede mostrar todos sus elementos, es decir los elementos n graficas de barras
**/
class MyAdapter(private var context: Activity, private val array:List<BarData>, private val listado:ArrayList<String>) : ArrayAdapter<BarData>(context, R.layout.listview_barchart,array){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var inflater : LayoutInflater = LayoutInflater.from(context)
        var view : View = inflater.inflate(R.layout.listview_barchart, null)

        var titulo: TextView = view.findViewById(R.id.titulo_barchart)
        var graficaDetalles: BarData = array.get(position)
        var grafica: BarChart = view.findViewById(R.id.grafica_bar)
        grafica.setData(graficaDetalles)
        titulo.setText(listado.get(position))
        return view
    }
}