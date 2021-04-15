/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Racer que maneja tanto las posiciones como el identificador de cada
 * competidor, además controla y asigna las posiciones aleatoriamente 
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 1.1.0
 * @since 1.0.0
 */
public class Racer {

    private String racerNumber;
    private int position;

    public Racer(String racerNumber) {
        this.racerNumber = racerNumber;
        this.position = 0;
    }

    public void moveRacer() {
        
        try {
            
            int randomNumber;
            while (position < 20) {

                randomNumber = generateRandomNumber(1, 3);
                position += randomNumber;

                switch (racerNumber) {
                    case "1-R":
                    case "2-R":
                    case "3-R":
                        System.out.println("Equipo rojo --> Corredor " + racerNumber + " esta en la posición " + position);
                        break;
                        
                    case "1-Y":
                    case "2-Y":
                    case "3-Y":
                        System.out.println("Equipo amarillo --> Corredor " + racerNumber + " esta en la posición " + position);
                        break;
                        
                    case "1-B":
                    case "2-B":
                    case "3-B":
                        System.out.println("Equipo azul --> Corredor " + racerNumber + " esta en la posición " + position);
                        break;
                        
                    default:
                        break;
                }
                Thread.sleep(1000);
                System.out.println("\n");
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