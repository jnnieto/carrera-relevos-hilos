/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carrera;

import java.util.ArrayList;
import java.util.List;

/**
 *Clase principal que inicia el programa de la carrera de relevos
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 1.1.0
 * @since 1.0.0
 */
public class Main {
    
    Racer racer1;
    Racer racer2;
    Racer racer3;
    Thread threadRacer1;
    Thread threadRacer2;
    Thread threadRacer3;

    public Main() {
                  
        racer1 = new Racer(1);
        threadRacer1 = new RedTeam(racer1);

        racer2 = new Racer(2);
        threadRacer2 = new BlueTeam(racer2);

        racer3 = new Racer(3);
        threadRacer3 = new YellowTeam(racer3);

        threadRacer1.start();
        threadRacer2.start();
        threadRacer3.start();

        while (threadRacer1.isAlive() && threadRacer2.isAlive() && threadRacer3.isAlive()) {

            if (racer1.getPosition() >= 20) {
                threadRacer1.interrupt();
                threadRacer2.interrupt();
                threadRacer3.interrupt();

                System.out.println("EL EQUIPO GANADOR ES EL EQUIPO ROJO");
                break;

            } else if (racer2.getPosition() >= 20) {

                threadRacer1.interrupt();
                threadRacer2.interrupt();
                threadRacer3.interrupt();

                System.out.println("EL EQUIPO GANADOR ES EL EQUIPO AZUL");
                break;

            } else if (racer3.getPosition() >= 20) {

                threadRacer1.interrupt();
                threadRacer2.interrupt();
                threadRacer3.interrupt();

                System.out.println("EL EQUIPO GANADOR ES EL EQUIPO AMARILLO");
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}
