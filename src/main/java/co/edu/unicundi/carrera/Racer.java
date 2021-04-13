/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Hija de Figura que calcula área y perímetro del círculo
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 1.1.0
 * @since 1.0.0
 */
public class Racer {

    private int racerNumber;
    private int position;

    public Racer(int racerNumber) {
        this.racerNumber = racerNumber;
        this.position = 0;
    }

    public void moveRacer(String teamName, String color) {
        try {

            int radomNumber;

            while (position <= 20) {

                radomNumber = generateRandomNumber(1, 4);
                position += radomNumber;

                System.out.println(color + teamName + "Corredor " + racerNumber + " esta en la posición " + position);

                Thread.sleep(1000);

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Racer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static int generateRandomNumber(int numberMin, int numberMax) {
        int randomNumber = (int) Math.floor(Math.random() * (numberMax - numberMin + 1) + (numberMin));
        return randomNumber;
    }

    public int getPosition() {
        return position;
    }

}
