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

    /**
     * Variable entera que almacena el número asignado a cada corredor de cada
     * equipo
     */
    private int racerNumber;

    /**
     * Variable entera que almacena la posicion de cada corredor a medida que
     * transcurre la carrera de relevos
     */
    private int position;

    /**
     * Constructor sobrecargado de la clase Racer
     *
     * @param racerNumber
     */
    public Racer(int racerNumber) {
        this.racerNumber = racerNumber;
        this.position = 0;
    }

    /**
     * Metodo sincronizado el cual se encarga de asignarle las posiciones
     * aleatorias a todos los corredores de cada equipo y de esta forma llevar a
     * cabo la carrera de relevos
     */
    public synchronized void moveRacer() {

        try {

            int randomNumber;
            while (position < 20) {

                // Número aleatorio que se le asignara a cada corredor para su desplazamiento
                randomNumber = generateRandomNumber(1, 3);
                position += randomNumber;

                switch (racerNumber) {

                    // Identificador de los corredores del equipo rojo (1,2,3)
                    case 1:
                    case 2:
                    case 3:
                        PrintRelayRace printRedTeam = new PrintRelayRace(position, "T E A M  ROJO", racerNumber);
                        printRedTeam.start();
                        break;

                    // Identificador de los corredores del equipo azul (4,5,6)
                    case 4:
                    case 5:
                    case 6:
                        PrintRelayRace printBlueTeam = new PrintRelayRace(position, "T E A M  AZUL", racerNumber);
                        printBlueTeam.start();
                        break;

                    // Identificador de los corredores del equipo amarillo (7,8,9)
                    case 7:
                    case 8:
                    case 9:
                        PrintRelayRace printYellowTeam = new PrintRelayRace(position, "TEAM AMARILLO", racerNumber);
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

    /**
     * Método que genera un número aleatorio que se le asignara a la posicion de
     * cada corredor
     *
     * @param numberMin
     * @param numberMax
     * @return Numero aleatorio
     */
    public static int generateRandomNumber(int numberMin, int numberMax) {
        int randomNumber = (int) Math.floor(Math.random() * (numberMax - numberMin + 1) + (numberMin));
        return randomNumber;
    }

    /**
     * Método encapsulado que obtiene la posición de cada corredor
     *
     * @return Posicion del corredor en cada momento determinado
     */
    public int getPosition() {
        return position;
    }

}
