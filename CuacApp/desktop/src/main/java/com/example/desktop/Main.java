package com.example.desktop;

import java.awt.Button;                 //Representa el boton
import java.awt.FlowLayout;
import java.awt.TextField;              //Representa el texto
import java.awt.event.MouseListener;    //Permite escuchar los eventos de raton

import javax.swing.JFrame;              //Crea la ventana

public class Main {

    public static void Main(String[] args) {
        //Creamos la ventana
        JFrame renderView = new JFrame("Mi CuacApp");


        renderView.setSize(600,400);    //Damos el tamaño a la ventana
        renderView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Especificamos que hacer cuando se pulsa cerrar
        renderView.setVisible(true);    //Hacemos la ventana visible

        //Creamos el FlowLayout
        renderView.setLayout(new FlowLayout());

        //Creamos los componentes que se verán
        TextField campoTexto = new TextField(); //Entre los parentesis se puede poner el numero de columnas del ancho
        Button boton = new Button("¡Cuac!"); //El texto es el texto que tendrá dentro el botón

        //Añadimos a nuestra ventana
        renderView.add(campoTexto);
        renderView.add(boton);

    }

}