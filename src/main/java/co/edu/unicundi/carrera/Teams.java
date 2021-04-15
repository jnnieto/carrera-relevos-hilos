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
    
    Racer racer;
    Object witness;

    public Teams(Racer racer, Object witness) {
        this.racer = racer;
        this.witness = witness;
    }

    @Override
    public void run() {
        synchronized(witness) {
            try {
                witness.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Teams.class.getName()).log(Level.SEVERE, null, ex);
            }
            racer.moveRacer();
            witness.notify();
        }
    }
    
}