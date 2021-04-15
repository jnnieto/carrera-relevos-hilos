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

    private int racerNumber;
    private int position;

    public Racer(int racerNumber) {
        this.racerNumber = racerNumber;
        this.position = 0;
    }

    public synchronized void moveRacer() {

        try {

            int randomNumber;
            while (position < 20) {

                randomNumber = generateRandomNumber(1, 3);
                position += randomNumber;

                switch (racerNumber) {
                    case 1:
                    case 2:
                    case 3:
                        PrintRelayRace printRedTeam = new PrintRelayRace(position, "EQUIPO ROJO", racerNumber);
                        printRedTeam.start();
                        break;

                    case 4:
                    case 5:
                    case 6:
                        PrintRelayRace printBlueTeam = new PrintRelayRace(position, "EQUIPO AZUL", racerNumber);
                        printBlueTeam.start();
                        break;

                    case 7:
                    case 8:
                    case 9:
                        PrintRelayRace printYellowTeam = new PrintRelayRace(position, "EQUIPO AMARILLO", racerNumber);
                        printYellowTeam.start();
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
