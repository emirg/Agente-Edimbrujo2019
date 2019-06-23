/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agente;

import Conexion.Conexion;
import Logica.Entity;
import Logica.Manager;
import Logica.Moneda;
import Logica.NavePlayer;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dyn4j.geometry.Vector2;

/**
 *
 * @author emiliano
 */
public class Agente {

    public static final double MAX_VELOCITY = 50;

    private Manager manager;

    private NavePlayer myAgent;

    private ArrayList<NavePlayer> navePlayers;
    private ArrayList<Moneda> monedas;

    private String myID;
    private Conexion con;

    public Agente() throws IOException {

        //con = new Conexion("http://10.0.20.157:8080/Edimbrujo/webservice/server");
        //con = new Conexion("http://edimbrujo.fi.uncoma.edu.ar/Edimbrujo/webservice/server");
        con = new Conexion("http://localhost:8080/Edimbrujo/webservice/server");

        this.myID = con.iniciar("agente007");
        this.manager = Manager.getManager();
        //listaMov = new LinkedList<>();
        manager.updateState(con.getFullState());
    }

    public void jugar() throws IOException {
        manager.updateState(con.getFullState());
        navePlayers = manager.getPlayers();
        monedas = manager.getMonedas();

        // System.out.println("Ataco");
        Moneda monedaObjetivo = monedaMasCercana();
        if (monedaObjetivo != null) {
            steer(monedaObjetivo);
        }
    }

    private Moneda monedaMasCercana() {
        return null;
    }

    private NavePlayer enemigoMasCercano() {
        return null;
    }

    // Este metodo basicamente es el seek
    private void steer(Entity entidad) {
        Vector2 vectorDesired, vectorSteering;
        // 1. vector(desired velocity) = (target position) - (vehicle position)
        vectorDesired = new Vector2(myAgent.getX(), myAgent.getY()).subtract(entidad.getX(), entidad.getY());
        // 2. normalize vector(desired velocity)
        vectorDesired.normalize();
        // 3. scale vector(desired velocity) to maximum speed
        vectorDesired.setMagnitude(MAX_VELOCITY);
        // 4. vector(steering force) = vector(desired velocity) - vector(current velocity)
        vectorSteering = vectorDesired.subtract(myAgent.getVelocidad());

        // 5. limit the magnitude of vector(steering force) to maximum force
        //vectorSteering.scale(200);
        // 6. vector(new velocity) = vector(current velocity) + vector(steering force)
        // 7. limit the magnitude of vector(new velocity) to maximum speed
        //vectorSteering.x = vectorSteering.x / pVehicle.body.mass
        //vectorSteering.y = vectorSteering.y / pVehicle.body.mass
        truncate(vectorSteering.add(myAgent.getVelocidad()), MAX_VELOCITY);
        myAgent.setVelocidad(vectorSteering);

    }

    private void truncate(Vector2 vector, double max) {
        double i;
        i = max / vector.getMagnitude();
        if (i > 1.0) {
            i = 1.0;
        }
        vector.setMagnitude(i);
    }

    public double distancia(Point a, Point b) {
        // Tambien se puede medir la distancia entre dos vectores (Vector2) utilizados como puntos
        int xA = a.x, yA = a.y, xB = b.x, yB = b.y;
        return Math.sqrt((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA));
    }

}
