/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que hereda de Thread e imprime en consola las posiciones de cada
 * corredor a medida que va avanzando en la carrera de relevos
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 1.1.0
 * @since 1.0.0
 */
public class PrintRelayRace extends Thread {

    /**
     * Variable entera que almacena la posición del corredor durante la carrera
     */
    private int positionRacer;
    /**
     * Variable de la clase String que almacena los nombres de los equipos en
     * competencia
     */
    private String nameTeam;
    /**
     * Variable entera que almacena el número de cada corredor participante en
     * la carrera
     */
    private int racerNumber;

    /**
     * Constructor sobrecargado de la clase PrintRelayRace
     *
     * @param positionRacer
     * @param nameTeam
     * @param racerNumber
     */
    public PrintRelayRace(int positionRacer, String nameTeam, int racerNumber) {
        this.positionRacer = positionRacer;
        this.nameTeam = nameTeam;
        this.racerNumber = racerNumber;
    }

    /**
     * Método run que ejecuta el hilo de la presente clase
     */
    @Override
    public void run() {

        try {
            // Se muestra en consola las distancias recorridas por cada competidor
            progressBarRacer();
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PrintRelayRace.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo sincronizado que se encarga de imprimir en consola la barra de
     * progreso de cada competidor, dependiendo de su respectiva posicion en la
     * carrera de relevos
     */
    public synchronized void progressBarRacer() {

        if (this.positionRacer > 22) {
            throw new IllegalArgumentException();
        }

        int maxDistance = 20; // Se refiere a la máxima distancia recorrida por cada corredor
        char defaultChar = '-';
        String speedway = new String(new char[maxDistance]).replace('\0', defaultChar) + "]";
        String iconRacer = setIconRacer();
        StringBuilder distanceDone = new StringBuilder();
        distanceDone.append("[");

        for (int i = 0; i < this.positionRacer; i++) {
            distanceDone.append(iconRacer);
        }

        String distanceRemain = speedway.substring(this.positionRacer, speedway.length());
        System.out.println("\r" + this.nameTeam + "     " + distanceDone + distanceRemain + " " + this.positionRacer);

        if (this.positionRacer == 22) {
            System.out.print("\n");
        }
    }

    /**
     * Metodo que segun el numero de corredor que esta participando, le asigna
     * un respectivo caracter
     *
     * @return Caracter asignado para los corredores en cada relevo
     */
    public String setIconRacer() {

        String icon = "";

        switch (racerNumber) {

            // El caso 1, 4 y 7 hace referencia a los primeros tres corredores de
            // cada equipo que iniciaran la carrera
            case 1:
            case 4:
            case 7:
                icon = "\21";
                break;

            // El caso 2, 5 y 8 hace referencia a los segundos tres corredores de
            // cada equipo que iniciaran el segundo relevo de la carrera
            case 2:
            case 5:
            case 8:
                icon = "@";
                break;

            // El caso 3, 6 y 9 hace referencia a los ultimos tres corredores de
            // cada equipo que terminaran la carrera de relevos
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
