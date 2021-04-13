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
public class RedTeam extends Thread {

    Racer redRacer;
    
    static final String color = "\033[31m";

    public RedTeam(Racer redRacer) {
        this.redRacer = redRacer;
    }
    
    @Override
    public void run() {
        redRacer.moveRacer("Equipo rojo: ", color);
    }
    
}
