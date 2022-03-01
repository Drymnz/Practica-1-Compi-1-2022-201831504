package com.example.practica1compiladores12022.Grafica

import android.graphics.drawable.Drawable
import com.example.practica1compiladores12022.Array.ArrayDouble
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate

class ConvertidorGrafica {
    private val listadoNombre = arrayOf<String>()

    constructor()

    fun  convertidor(barra:Barras):BarDataSet{
        var detallesBarra:ArrayList<BarEntry> = ArrayList()
        if(barra.union != null){
                 for( i in 0..(barra.union.x-1)){
                     var valorX:Int = barra.union.list[i][0].toInt()
                     var valorY:Int = barra.union.list[i][barra.union.y - 1].toInt()
                     var valorBX:Float = valor(barra.listDouble,valorX).toFloat()
                     var valorBY:String = caracter(barra.listadoString,valorY)
                     var bar:BarEntry = BarEntry((i+1).toFloat(),valorBX,valorBY)
                     detallesBarra.add(bar)
                 }
             }
        var add:BarDataSet = BarDataSet(detallesBarra,barra.titulo)
        add.setColors(*ColorTemplate.COLORFUL_COLORS)
        add.setDrawValues(true)
        return add
     }
    public fun convertirPie(pie:Pie):PieDataSet{
        var detallesPie:ArrayList<PieEntry> = ArrayList()
        var suma:Float = 0f
        if (pie!=null){
            for(i in 0..(pie.union.x-1)){
                var valorX:Int = pie.getUnion().getList()[i][0].toInt()
                var valorY:Int = pie.getUnion().getList()[i][pie.getUnion().y - 1].toInt()
                var valorBX:Float = valor(pie.listDouble,valorX).toFloat()
                var valorBY:String = caracter(pie.listadoString,valorY)
                suma += valorBX
                if (!pie.total.equals(0) ){
                    valorBX/= pie.total.toFloat()
                    valorBX *= 100
                }
                var add:PieEntry
                when (pie.tipo){
                    Pie.posible.CANTIDAD-> add =  PieEntry(valorBX,valorBY,"${valorBX} % ")
                    Pie.posible.PORCENTAJE-> add = PieEntry(valorBX,valorBY,valorBY)
                }
                detallesPie.add(add)
            }
            if( suma<pie.total && !pie.getExtra().isEmpty()){
                var resto:Float = ((pie.total.toFloat()-suma)/pie.total.toFloat())*100
                var add:PieEntry
                when(pie.tipo) {
                    Pie.posible.CANTIDAD -> add = PieEntry(resto,pie.getExtra().toString())
                    Pie.posible.PORCENTAJE -> add = PieEntry(resto, pie.getExtra().toString())
                }
                detallesPie.add(add)
            }
        }
        var addFinal:PieDataSet = PieDataSet(detallesPie,pie.titulo)
        addFinal.setColors(*ColorTemplate.COLORFUL_COLORS)
        addFinal.setDrawValues(true)
        addFinal.setAutomaticallyDisableSliceSpacing(true)
        return addFinal
    }
    private fun caracter(listadoString:ArrayList<String>, valorY:Int):String{
        if(!listadoString.isEmpty()){
            var text:String = listadoString.get(0)
            var textA = text.split(",")
            if ((valorY < textA.size) && (valorY >=0) ){
                return textA[valorY]
            }
        }
        return ""
    }

    private fun valor(listDouble:ArrayDouble, valorX:Int):Double{
        if ((valorX < listDouble.list.size) && (valorX>=0))
        {
            return listDouble.list[valorX]
        }
        return 0.0
    }

}