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

    /**
     * Instacia de la clase Object que representa el testigo del equipo rojo
     */
    Object witnessRed = new Object();
    
    /**
     * Instacia de la clase Object que representa el testigo del equipo azul
     */
    Object witnessBlue = new Object();
    
    /**
     * Instacia de la clase Object que representa el testigo del equipo amarillo
     */
    Object witnessYellow = new Object();

    /**
     * Instacia de la clase Racer que representa al competidor 1 del equipo rojo
     */
    Racer racer1;
    
    /**
     * Instancia de hilo que representa al competidor 1 del equipo rojo
     */
    Thread threadRacer1;
    
    /**
     * Instacia de la clase Racer que representa al competidor 2 del equipo rojo
     */
    Racer racer2;
    
    /**
     * Instancia de hilo que representa al competidor 2 del equipo rojo
     */
    Thread threadRacer2;
    
    /**
     * Instacia de la clase Racer que representa al competidor 3 del equipo rojo
     */
    Racer racer3;
    
    /**
     * Instancia de hilo que representa al competidor 3 del equipo rojo
     */
    Thread threadRacer3;

    /**
     * Instacia de la clase Racer que representa al competidor 1 del equipo azul
     */
    Racer racer4;
    
    /**
     * Instancia de hilo que representa al competidor 1 del equipo azul
     */
    Thread threadRacer4;
    
    /**
     * Instacia de la clase Racer que representa al competidor 2 del equipo azul
     */
    Racer racer5;
    
    /**
     * Instancia de hilo que representa al competidor 2 del equipo azul
     */
    Thread threadRacer5;
    
    /**
     * Instacia de la clase Racer que representa al competidor 3 del equipo azul
     */
    Racer racer6;
    
    /**
     * Instancia de hilo que representa al competidor 3 del equipo azul
     */
    Thread threadRacer6;

    /**
     * Instacia de la clase Racer que representa al competidor 1 del equipo amarillo
     */
    Racer racer7;
    
    /**
     * Instancia de hilo que representa al competidor 1 del equipo amarillo
     */
    Thread threadRacer7;
    
    /**
     * Instacia de la clase Racer que representa al competidor 2 del equipo amarillo
     */
    Racer racer8;
    
    /**
     * Instancia de hilo que representa al competidor 2 del equipo amarillo
     */
    Thread threadRacer8;
    
    /**
     * Instacia de la clase Racer que representa al competidor 3 del equipo amarillo
     */
    Racer racer9;
    
    /**
     * Instancia de hilo que representa al competidor 3 del equipo amarillo
     */
    Thread threadRacer9;

    /**
     * Contructor de la clase Main que inicializa la carrera
     */
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

        // Iniciar todos los hilos que son los competidores de la carrera
        initThreads();
        // Avisar cuando la carrera finalice con un ganador
        finishRelayRace();
    }

    /**
     * Método main que inicia la ejecución del programa
     * @param args 
     */
    public static void main(String[] args) {
        Main main = new Main();
    }

    /**
     * Método que pone en marcha todos los hilos creados en el programa
     */
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

        // Se muestra el inicio de la carrera 
        try {
            for (int i = 3; i >= 1; i--) {
                System.out.println("La carrera empezará en " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Empila este objeto que es el testigo del equipo rojo
        synchronized (witnessRed) {
            // Avisa al testigo que el siguiente competidor puede iniciar
            witnessRed.notify();
        }

        // Empila este objeto que es el testigo del equipo azul
        synchronized (witnessBlue) {
            // Avisa al testigo que el siguiente competidor puede iniciar
            witnessBlue.notify();
        }

        // Empila este objeto que es el testigo del equipo amarillo
        synchronized (witnessYellow) {
            // Avisa al testigo que el siguiente competidor puede iniciar
            witnessYellow.notify();
        }
    }

    /**
     * Método que para la ejecución de todos los hilos del programa
     */
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

    /**
     * Método que imprime el ganador de la carrera 
     */
    public void finishRelayRace() {

        // Validación de que todos lo hilos estén ejecutándose
        while (threadRacer1.isAlive() || threadRacer2.isAlive() || threadRacer3.isAlive()
                || threadRacer4.isAlive() || threadRacer5.isAlive() || threadRacer6.isAlive()
                || threadRacer7.isAlive() || threadRacer8.isAlive() || threadRacer9.isAlive()) {

            // Si llega primero el competidor 3 del equipo rojo
            if (racer3.getPosition() >= 20) {
                // Interrumpe los hilos
                interruptThreads();
                System.out.println("************************************************");
                System.out.println("*****¡EL EQUIPO GANADOR ES EL EQUIPO ROJO!*****");
                System.out.println("************************************************");
                break;

            // Si llega primero el competidor 3 del equipo azul
            } else if (racer6.getPosition() >= 20) {
                // Interrumpe los hilos
                interruptThreads();
                System.out.println("************************************************");
                System.out.println("******¡EL EQUIPO GANADOR ES EL EQUIPO AZUL!*****");
                System.out.println("************************************************");
                break;

            // Si llega primero el competidor 3 del equipo amarillo
            } else if (racer9.getPosition() >= 20) {
                // Interrumpe los hilos
                interruptThreads();
                System.out.println("************************************************");
                System.out.println("****¡EL EQUIPO GANADOR ES EL EQUIPO AMARILLO!***");
                System.out.println("************************************************");
                break;
            }
        }
    }

}
