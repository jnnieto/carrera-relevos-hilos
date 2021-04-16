/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Teams que contiene los hilos que representan a cada competidor en 
 * la carrera de relevos
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 1.1.0
 * @since 1.0.0
 */
public class Teams extends Thread {
    
    /**
     * Instancia de la clase Racer 
     */
    Racer racer;
    
    /**
     * Instancia de la clase Object que actúa como testigo de relevo
     */
    Object witness;

    /**
     * Constructor sobrecargado que instancia los objetos de Racer y Object
     * @param racer
     * @param witness 
     */
    public Teams(Racer racer, Object witness) {
        this.racer = racer;
        this.witness = witness;
    }

    /**
     * Método run que ejecuta el hilo de esta clase
     */
    @Override
    public void run() {
        // Todos lo hilos que lleguen se apilan en la fila
        synchronized(witness) {
            try {
                // El testigo avisa al resto de hilos que esperen mientra su actecesor acaba
                witness.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Teams.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Mover el competidor
            racer.moveRacer();
            // El testigo le avisa al siguiente hilo que ya puede iniciar su ejecución
            witness.notify();
        }
    }
    
}