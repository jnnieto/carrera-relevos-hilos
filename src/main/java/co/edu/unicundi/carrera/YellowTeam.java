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
public class YellowTeam extends Thread {
    
    Racer yellowRacer;

    static final String color = "\033[33m";
    
    public YellowTeam(Racer yellowRacer) {
        this.yellowRacer = yellowRacer;
    }

    @Override
    public void run() {
        yellowRacer.moveRacer("Equipo Amarillo: ", color);
    }
    
}
