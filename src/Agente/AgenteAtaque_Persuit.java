/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agente;

import Conexion.Conexion;
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
public class AgenteAtaque_Persuit { // Y respondedor

    public static final double MAX_VELOCITY = 20;

    private Manager manager;

    private NavePlayer myAgent;

    private ArrayList<NavePlayer> navePlayers;
    private ArrayList<Moneda> monedas;

    private String myID;
    private Conexion con;

    public AgenteAtaque_Persuit() throws IOException {

        //con = new Conexion("http://10.0.20.157:8080/Edimbrujo/webservice/server");
        //con = new Conexion("http://edimbrujo.fi.uncoma.edu.ar/Edimbrujo/webservice/server");
        con = new Conexion("http://localhost:8080/Edimbrujo/webservice/server");

        this.myID = con.iniciar("agente007");
        this.manager = Manager.getManager();
        //listaMov = new LinkedList<>();
        manager.updateState(con.getFullState());
    }

    public void cargarJugador() {
        myAgent = manager.getPlayer(myID);
    }

    public void jugar() throws IOException {
        manager.updateState(con.getFullState());
        cargarJugador();
        navePlayers = manager.getPlayers();
        monedas = manager.getMonedas();

        double distanciaEnemigo = Integer.MAX_VALUE;
        double distanciaMoneda = Integer.MAX_VALUE;

        Moneda monedaObjetivo = monedaMasCercana();
        NavePlayer enemigoObjetivo = enemigoMasCercano();
        if (myAgent.getPregunta().equalsIgnoreCase("")) {
            if (enemigoObjetivo != null) {
                distanciaEnemigo = distancia(enemigoObjetivo.getPositionPoint(), myAgent.getPositionPoint());
                System.out.println("distanciaEnemigo" + distanciaEnemigo);
                if (distanciaEnemigo < (1366-639)/10) {
                    System.out.println("Encontre: (" + enemigoObjetivo.getX() + "," + enemigoObjetivo.getY() + ")");
                    Vector2 nuevaVelocidad = persuit(enemigoObjetivo);
                    con.makeAction("fire");
                } else {
                    System.out.println("Encontre: (" + enemigoObjetivo.getX() + "," + enemigoObjetivo.getY() + ")");
                    Vector2 nuevaVelocidad = persuit(enemigoObjetivo);
                    con.makeMove("" + nuevaVelocidad.x, "" + nuevaVelocidad.y);
                }
            } else {
                if (monedaObjetivo != null) {
                    System.out.println("Encontre: (" + monedaObjetivo.getX() + "," + monedaObjetivo.getY() + ")");
                    Vector2 nuevaVelocidad = steer(monedaObjetivo);
                    con.makeMove("" + nuevaVelocidad.x, "" + nuevaVelocidad.y);
                }
            }
        } else {
            con.answer("" + myAgent.getRespuesta());
        }

    }

    private Moneda monedaMasCercana() {
        Moneda masCercana = null;
        double distanciaMasCercana = Integer.MAX_VALUE;
        for (Moneda moneda : monedas) {
            if (moneda != null && myAgent != null) {
                double distanciaActual = distancia(moneda.getPosition(), myAgent.getPositionPoint());
                if (masCercana == null) {
                    masCercana = moneda;
                    distanciaMasCercana = distanciaActual;
                } else {
                    if (distanciaActual < distanciaMasCercana) {
                        masCercana = moneda;
                        distanciaMasCercana = distanciaActual;
                    }
                }
            }
        }

        return masCercana;
    }

    private NavePlayer enemigoMasCercano() {
        NavePlayer masCercano = null;
        double distanciaMasCercana = Integer.MAX_VALUE;
        for (NavePlayer player : navePlayers) {
            if (player != null && myAgent != null) {
                if (player != myAgent) {
                    double distanciaActual = distancia(player.getPositionPoint(), myAgent.getPositionPoint());
                    if (masCercano == null) {
                        masCercano = player;
                        distanciaMasCercana = distanciaActual;
                    } else {
                        if (distanciaActual < distanciaMasCercana) {
                            masCercano = player;
                            distanciaMasCercana = distanciaActual;
                        }
                    }
                }
            }
        }

        return masCercano;
    }

    // Este metodo basicamente es el seek
    private Vector2 steer(Moneda entidad) {
        Vector2 vectorDesired, vectorSteering;
        // 1. vector(desired velocity) = (target position) - (vehicle position)
        vectorDesired = new Vector2(entidad.getX(), entidad.getY()).subtract(myAgent.getX(), myAgent.getY());
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
        vectorSteering.x = vectorSteering.x / 10;
        vectorSteering.y = vectorSteering.y / 10;
        //truncate(vectorSteering.add(myAgent.getVelocidad()), MAX_VELOCITY);
        vectorSteering.add(myAgent.getVelocidad());
        return vectorSteering;

    }

    private Vector2 steer(NavePlayer entidad) {
        Vector2 vectorDesired, vectorSteering;
        // 1. vector(desired velocity) = (target position) - (vehicle position)
        vectorDesired = new Vector2(entidad.getX(), entidad.getY()).subtract(myAgent.getX(), myAgent.getY());
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
        vectorSteering.x = vectorSteering.x / 10;
        vectorSteering.y = vectorSteering.y / 10;
        //truncate(vectorSteering.add(myAgent.getVelocidad()), MAX_VELOCITY);
        vectorSteering.add(myAgent.getVelocidad());
        return vectorSteering;
    }

    private Vector2 steer(Vector2 futuraPosicion) {
        Vector2 vectorDesired, vectorSteering;
        // 1. vector(desired velocity) = (target position) - (vehicle position)
        vectorDesired = new Vector2(futuraPosicion.x, futuraPosicion.y).subtract(myAgent.getX(), myAgent.getY());
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
        vectorSteering.x = vectorSteering.x / 10;
        vectorSteering.y = vectorSteering.y / 10;
        //truncate(vectorSteering.add(myAgent.getVelocidad()), MAX_VELOCITY);
        vectorSteering.add(myAgent.getVelocidad());
        return vectorSteering;
    }

    private Vector2 persuit(NavePlayer entidad) {
        Vector2 velocidadNaveEnemiga = entidad.getVelocidad();
        Vector2 futuraPosicion = entidad.getPositionVector().add(velocidadNaveEnemiga).multiply(3);
        return steer(futuraPosicion);
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
