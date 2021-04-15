/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carrera;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal que inicia el programa de la carrera de relevos
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 1.1.0
 * @since 1.0.0
 */
public class Main {

    Object testigoRojo = new Object();
    Object testigoAzul = new Object();
    Object testigoAmarillo = new Object();

    Racer racer1;
    Thread threadRacer1;
    Racer racer2;
    Thread threadRacer2;
    Racer racer3;
    Thread threadRacer3;

    Racer racer4;
    Thread threadRacer4;
    Racer racer5;
    Thread threadRacer5;
    Racer racer6;
    Thread threadRacer6;

    Racer racer7;
    Thread threadRacer7;
    Racer racer8;
    Thread threadRacer8;
    Racer racer9;
    Thread threadRacer9;

    public Main() {

        racer1 = new Racer("1-R");
        threadRacer1 = new Teams(racer1, testigoRojo);
        racer2 = new Racer("2-R");
        threadRacer2 = new Teams(racer2, testigoRojo);
        racer3 = new Racer("3-R");
        threadRacer3 = new Teams(racer3, testigoRojo);

        racer4 = new Racer("1-B");
        threadRacer4 = new Teams(racer4, testigoAzul);
        racer5 = new Racer("2-B");
        threadRacer5 = new Teams(racer5, testigoAzul);
        racer6 = new Racer("3-B");
        threadRacer6 = new Teams(racer6, testigoAzul);

        racer7 = new Racer("1-Y");
        threadRacer7 = new Teams(racer7, testigoAmarillo);
        racer8 = new Racer("2-Y");
        threadRacer8 = new Teams(racer8, testigoAmarillo);
        racer9 = new Racer("3-Y");
        threadRacer9 = new Teams(racer9, testigoAmarillo);

        threadRacer1.start();
        threadRacer2.start();
        threadRacer3.start();
        threadRacer4.start();
        threadRacer5.start();
        threadRacer6.start();
        threadRacer7.start();
        threadRacer8.start();
        threadRacer9.start();

        try {
            Thread.sleep(3000);

        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        synchronized (testigoRojo) {
            testigoRojo.notify();
        }

        synchronized (testigoAmarillo) {
            testigoAmarillo.notify();
        }

        synchronized (testigoAzul) {
            testigoAzul.notify();
        }

        while (threadRacer1.isAlive() || threadRacer2.isAlive() || threadRacer3.isAlive()
                || threadRacer4.isAlive() || threadRacer5.isAlive() || threadRacer6.isAlive()
                || threadRacer7.isAlive() || threadRacer8.isAlive() || threadRacer9.isAlive()) {

            if (racer3.getPosition() >= 20) {
                threadRacer1.interrupt();
                threadRacer2.interrupt();
                threadRacer3.interrupt();
                threadRacer4.interrupt();
                threadRacer5.interrupt();
                threadRacer6.interrupt();
                threadRacer7.interrupt();
                threadRacer8.interrupt();
                threadRacer9.interrupt();

                System.out.println("EL EQUIPO GANADOR ES EL EQUIPO ROJO");
                break;

            } else if (racer6.getPosition() >= 20) {
                threadRacer1.interrupt();
                threadRacer2.interrupt();
                threadRacer3.interrupt();
                threadRacer4.interrupt();
                threadRacer5.interrupt();
                threadRacer6.interrupt();
                threadRacer7.interrupt();
                threadRacer8.interrupt();
                threadRacer9.interrupt();

                System.out.println("EL EQUIPO GANADOR ES EL EQUIPO AZUL");
                break;

            } else if (racer9.getPosition() >= 20) {
                threadRacer1.interrupt();
                threadRacer2.interrupt();
                threadRacer3.interrupt();
                threadRacer4.interrupt();
                threadRacer5.interrupt();
                threadRacer6.interrupt();
                threadRacer7.interrupt();
                threadRacer8.interrupt();
                threadRacer9.interrupt();

                System.out.println("EL EQUIPO GANADOR ES EL EQUIPO AMARILLO");
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}
