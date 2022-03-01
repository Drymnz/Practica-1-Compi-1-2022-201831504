package com.example.practica1compiladores12022.Grafica

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.practica1compiladores12022.R
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
/*
*Esta clase es el adaptador de listview para que puede mostrar todos sus elementos, es decir los elementos n graficas de pie
**/
class MyAdapterPie(private var context: Activity, private val array:List<PieData>, private val listado:ArrayList<String>) : ArrayAdapter<PieData>(context, R.layout.listview_piechart,array){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var inflater : LayoutInflater = LayoutInflater.from(context)
        var view : View = inflater.inflate(R.layout.listview_piechart, null)

        var titulo: TextView = view.findViewById(R.id.titulo_pie)
        var graficaDetalles: PieData = array.get(position)
        var grafica: PieChart = view.findViewById(R.id.ParChart)
        grafica.setData(graficaDetalles)
        titulo.setText(listado.get(position))
        return view
    }
}