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
public class Racer {

    private int racerNumber;

    public Racer(int racerNumber) {
        this.racerNumber = racerNumber;
    }

    public void moveRacer(String teamName, String color) {
        try {
            
            int position = 0;
            int radomNumber;

            while (position < 20) {

                radomNumber = generateRandomNumber(1, 3);
                System.out.println(color + teamName + "Corredor " + racerNumber + "se ha movido " + radomNumber + " posiciones.");
                position += radomNumber;

                Thread.sleep(1500);
                
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Racer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static int generateRandomNumber(int numberMin, int numberMax) {
        int randomNumber = (int) Math.floor(Math.random() * (numberMax - numberMin + 1) + (numberMin));
        return randomNumber;
    }

}
