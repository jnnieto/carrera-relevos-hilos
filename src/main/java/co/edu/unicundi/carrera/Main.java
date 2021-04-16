/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carrera;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
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

    Object witnessRed = new Object();
    Object witnessBlue = new Object();
    Object witnessYellow = new Object();

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

        racer1 = new Racer(1);
        threadRacer1 = new Teams(racer1, witnessRed);
        racer2 = new Racer(2);
        threadRacer2 = new Teams(racer2, witnessRed);
        racer3 = new Racer(3);
        threadRacer3 = new Teams(racer3, witnessRed);

        racer4 = new Racer(4);
        threadRacer4 = new Teams(racer4, witnessBlue);
        racer5 = new Racer(5);
        threadRacer5 = new Teams(racer5, witnessBlue);
        racer6 = new Racer(6);
        threadRacer6 = new Teams(racer6, witnessBlue);

        racer7 = new Racer(7);
        threadRacer7 = new Teams(racer7, witnessYellow);
        racer8 = new Racer(8);
        threadRacer8 = new Teams(racer8, witnessYellow);
        racer9 = new Racer(9);
        threadRacer9 = new Teams(racer9, witnessYellow);

        initThreads();
        finishRelayRace();
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

    public void initThreads() {

        threadRacer1.start();
        threadRacer4.start();
        threadRacer7.start();
        threadRacer2.start();
        threadRacer5.start();
        threadRacer8.start();
        threadRacer3.start();
        threadRacer6.start();
        threadRacer9.start();

        try {
            for (int i = 3; i >= 1; i--) {
                System.out.println("La carrera empezará en " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        synchronized (witnessRed) {
            witnessRed.notify();
        }

        synchronized (witnessBlue) {
            witnessBlue.notify();
        }

        synchronized (witnessYellow) {
            witnessYellow.notify();
        }
    }

    public void interruptThreads() {
        threadRacer1.interrupt();
        threadRacer2.interrupt();
        threadRacer3.interrupt();
        threadRacer4.interrupt();
        threadRacer5.interrupt();
        threadRacer6.interrupt();
        threadRacer7.interrupt();
        threadRacer8.interrupt();
        threadRacer9.interrupt();
    }

    public void finishRelayRace() {

        while (threadRacer1.isAlive() || threadRacer2.isAlive() || threadRacer3.isAlive()
                || threadRacer4.isAlive() || threadRacer5.isAlive() || threadRacer6.isAlive()
                || threadRacer7.isAlive() || threadRacer8.isAlive() || threadRacer9.isAlive()) {

            if (racer3.getPosition() >= 20) {

                interruptThreads();
                System.out.println("************************************************");
                System.out.println("*****¡EL EQUIPO GANADOR ES EL EQUIPO ROJO!*****");
                System.out.println("************************************************");
                break;

            } else if (racer6.getPosition() >= 20) {

                interruptThreads();
                System.out.println("************************************************");
                System.out.println("******¡EL EQUIPO GANADOR ES EL EQUIPO AZUL!*****");
                System.out.println("************************************************");
                break;

            } else if (racer9.getPosition() >= 20) {

                interruptThreads();
                System.out.println("************************************************");
                System.out.println("****¡EL EQUIPO GANADOR ES EL EQUIPO AMARILLO!***");
                System.out.println("************************************************");
                break;
            }
        }
    }

}
