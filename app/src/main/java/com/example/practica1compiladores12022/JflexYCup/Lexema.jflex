/*primer seccion: codigo de usuario*/
package com.example.practica1compiladores12022.JflexYCup;

import java.util.ArrayList;
import java_cup.runtime.*;
%%
/*segunda seccion: configuracion*/

%class Lexema
%unicode
%line
%column
%cup
%public
%{
    /*CODE*/
    private int contadorBarra = 0;
    private int contadorPie= 0;
    private ArrayList<ErrorAnalisando> listError = new ArrayList<>();

    //get
    public ArrayList<ErrorAnalisando> getListError() {
        return listError;
    }

    public int getContadorBarra() {
        return contadorBarra;
    }

    public int getContadorPie() {
        return contadorPie;
    }
    //get

    public void print() {
        System.out.println("\n<" + yytext() + "><Linea\"" + (yyline + 1) + "\">" + "<Columna\"" + yycolumn + "\">");
    }

    public void errorEncontradoLexico() {
        ErrorAnalisando nuevo = new ErrorAnalisando(yytext(), yyline, yycolumn, "Léxico", "Simbolo no existe en el lenguaje");
        listError.add(nuevo);
    }
%}
ENTERO =[0-9]+
DECIMAL = {ENTERO}[.]{ENTERO}
Comillas    ="\""|"“"|"”"
espacio =[\r|\t|\f|\n|\s| ]+
%%
/*tercer seccion: reglase lexicas*/
/*INGNORAR*/
#.*[\n]?            {
                    }
{espacio}           {/*nada*/}
/*SIMBOLOS DE PUNTUACION*/
":"                 {
                    return new Symbol(sym.DOBLEPUNTO,yyline,yycolumn);
                    }
";"                 {
                    return new Symbol(sym.PUNTOYCOMA,yyline,yycolumn);
                    }
","                 {
                    return new Symbol(sym.COMA,yyline,yycolumn);
                    }
/*SIMBOLOS ARIMETICOS*/
"+"                 {
                    return new Symbol(sym.SUMAR,yyline,yycolumn);
                    }
"-"                 {
                    return new Symbol(sym.RESTAR,yyline,yycolumn);
                    }
"/"                 {
                    return new Symbol(sym.DIVIDIR,yyline,yycolumn);
                    }
"*"                 {
                    return new Symbol(sym.MULTIPLICAR,yyline,yycolumn);
                    }
/*SIMBOLOS DE AGRUPACION*/
"("                 {
                    return new Symbol(sym.PARENTESIS_A,yyline,yycolumn);
                    }
")"                 {
                    return new Symbol(sym.PARENTESIS_C,yyline,yycolumn);
                    }
"["                 {
                    return new Symbol(sym.CORCHETE_A,yyline,yycolumn);
                    }
"]"                 {
                    return new Symbol(sym.CORCHETE_C,yyline,yycolumn);
                    }
"{"                 {
                    return new Symbol(sym.LLAVE_A,yyline,yycolumn);
                    }
"}"                 {
                    return new Symbol(sym.LLAVE_C,yyline,yycolumn);
                    }
/*PALABRAS RESERVADAS*/
"Def"|"def"         {
                    return new Symbol(sym.DEF,yyline,yycolumn);
                    //print();
                    }
"Barras"            {
                    this.contadorBarra++;
                    return new Symbol(sym.BARRAS,yyline,yycolumn);
                    }
"Pie"               {
                    this.contadorPie++;
                    return new Symbol(sym.PIE,yyline,yycolumn);
                    }
"titulo"            {
                    return new Symbol(sym.TITULO,yyline,yycolumn);
                    }
"ejex"              {
                    return new Symbol(sym.EJEX,yyline,yycolumn);
                    }
"ejey"              {
                    return new Symbol(sym.EJEY,yyline,yycolumn);
                    }
"etiquetas"         {
                    return new Symbol(sym.ETIQUETAS,yyline,yycolumn);
                    }
"valores"           {
                    return new Symbol(sym.VALORES,yyline,yycolumn);
                    }
"unir"              {
                    return new Symbol(sym.UNIR,yyline,yycolumn);
                    }
"tipo"              {
                    return new Symbol(sym.TIPO,yyline,yycolumn);
                    }
"total"             {
                    return new Symbol(sym.TOTAL,yyline,yycolumn);
                    }
"extra"             {
                    return new Symbol(sym.EXTRA,yyline,yycolumn);
                    }
"Ejecutar"          {
                    return new Symbol(sym.EJECUTAR,yyline,yycolumn);
                    }
"Cantidad"          {
                    return new Symbol(sym.CANTIDAD,yyline,yycolumn,(yytext()));
                    }
"Porcentaje"        {
                    return new Symbol(sym.PORCENTAJE,yyline,yycolumn,(yytext()));
                    }
/*Token*/
{ENTERO}            {
                    return new Symbol(sym.ENTERO,yyline,yycolumn, (yytext())); 
                    }
{Comillas}.*{Comillas} {
                    return new Symbol(sym.TEXT,yyline,yycolumn,yytext()); 
                    }
{DECIMAL}           {
                    return new Symbol(sym.DECIMAL,yyline,yycolumn, (yytext())); 
                    }
/*ERROR LEXICO*/
.                   {
                    System.out.println("¡¡¡¡¡¡NO PERTENECE AL ALFABETO -> ERROR LEXICO!!!!!!!!!");
                    errorEncontradoLexico();
                    }
