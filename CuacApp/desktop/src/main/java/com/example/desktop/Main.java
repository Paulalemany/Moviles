package com.example.desktop;

import java.awt.Button;                 //Representa el boton
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextField;              //Representa el texto
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;    //Permite escuchar los eventos de raton

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;              //Crea la ventana
import javax.swing.JOptionPane;

public class Main {

    private BufferedImage imagen;

    public static void main(String[] args) {
        //Creamos la ventana
        JFrame renderView = new JFrame("Mi CuacApp");


        renderView.setSize(600,400);    //Damos el tamaño a la ventana
        renderView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Especificamos que hacer cuando se pulsa cerrar
        renderView.setVisible(true);    //Hacemos la ventana visible
        renderView.getContentPane().setBackground(new Color(235, 202, 156)); //Cambiar el color de fondo

        //Creamos el FlowLayout
        renderView.setLayout(new FlowLayout());

        //Creamos los componentes que se verán
        TextField campoTexto = new TextField(20); //Entre los parentesis se puede poner el numero de columnas del ancho
        Button boton = new Button("¡Cuac!"); //El texto es el texto que tendrá dentro el botón

        //Añadimos a nuestra ventana
        renderView.add(campoTexto);
        renderView.add(boton);

        //Creamos la ventana emergente
        JOptionPane ventana = new JOptionPane();

        //Anadimos el listener
        boton.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                //Reproducimos el sonido
                try{
                    var url = Main.class.getResource("/duck.wav");
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    clip.start(); //Reproduce el sonido
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    ex.printStackTrace();
                }
                //Mostrar ventana emergente
                JOptionPane.showMessageDialog(renderView, campoTexto.getText());
            }

            // Métodos obligatorios de MouseListener (aunque no los usemos)
            @Override public void mouseClicked(MouseEvent e) {}
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });

        //Anadimos un canvas y sus botones
        //Lienzo
        Canvas lienzo = new Canvas();
        lienzo.setBounds(50 + 95, 50, 300, 250); //Posición y tamaño
        lienzo.setBackground(Color.WHITE);
        renderView.add(lienzo);

        Button draw = new Button("Draw");
        draw.setBounds(50 + 95, 320, 100, 30);
        renderView.add(draw);
        draw.addActionListener(e -> {
            Graphics g = lienzo.getGraphics();
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.ORANGE);
            g2.fillOval(100, 50, 100, 100);
            g2.dispose();
        });

        Button clear = new Button("Clear");
        clear.setBounds(250 + 95, 320, 100, 30);
        renderView.add(clear);
        clear.addActionListener(e ->{
            Graphics g = lienzo.getGraphics();
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.WHITE);
            g2.fillRect(0,0, lienzo.getWidth(), lienzo.getHeight());    //Para limpiar pintamos el lienzo entero del color del fondo
            g2.dispose();
        });

    }

}