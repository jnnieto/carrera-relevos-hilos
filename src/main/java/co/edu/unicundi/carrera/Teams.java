/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicon
 */
public class Teams extends Thread {
    
    Racer racer;
    Object testigo;

    public Teams(Racer racer, Object testigo) {
        this.racer = racer;
        this.testigo = testigo;
    }

    @Override
    public void run() {
        synchronized(testigo) {
            try {
                testigo.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Teams.class.getName()).log(Level.SEVERE, null, ex);
            }
            racer.moveRacer();
            testigo.notify();
        }
    }
    
    
}
