/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carrera;

/**
 *
 * @author nicon
 */
public class BlueTeam extends Thread {

    Racer blueRacer;
    
    final static String color = "\033[36m";

    public BlueTeam(Racer blueRacer) {
        this.blueRacer = blueRacer;
    }
    
    @Override
    public void run() {
        blueRacer.moveRacer("Equipo azul: ", color);
    }
    
}
