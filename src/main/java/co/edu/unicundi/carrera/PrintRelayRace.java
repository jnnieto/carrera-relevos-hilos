/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que imprime en consola las posiciones de cada corredor a medida que va
 * avanzando en la carrera de relevos
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 1.1.0
 * @since 1.0.0
 */
public class PrintRelayRace extends Thread {

    private int positionRacer;
    private String nameTeam;
    private int racerNumber;

    public PrintRelayRace(int positionRacer, String nameTeam, int racerNumber) {
        this.positionRacer = positionRacer;
        this.nameTeam = nameTeam;
        this.racerNumber = racerNumber;
    }

    @Override
    public void run() {
        try {
            progressBarRacer();
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PrintRelayRace.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void progressBarRacer() {

        if (this.positionRacer > 22) {
            throw new IllegalArgumentException();
        }

        int maxDistance = 20;
        char defaultChar = '-';      
        String speedway = new String(new char[maxDistance]).replace('\0', defaultChar) + "]";
        String iconRacer = setIconRacer();
        StringBuilder distanceDone = new StringBuilder();
        distanceDone.append("[");

        for (int i = 0; i < this.positionRacer; i++) {
            distanceDone.append(iconRacer);
        }

        String distanceRemain = speedway.substring(this.positionRacer, speedway.length());
        System.out.println("\r" + this.nameTeam + distanceDone + distanceRemain + " " + this.positionRacer);

        if (this.positionRacer == 22) {
            System.out.print("\n");
        }
    }

    public String setIconRacer() {

        String icon = "";

        switch (racerNumber) {
            case 1:
            case 4:
            case 7:
                icon = "\21";
                break;
            case 2:
            case 5:
            case 8:
                icon = "@";
                break;
            case 3:
            case 6:
            case 9:
                icon = "|";
                break;
            default:
                break;
        }

        return icon;
    }

}
