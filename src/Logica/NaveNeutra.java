/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import engine.Action;
import engine.State;
import engine.StaticState;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.simple.JSONObject;
import org.dyn4j.geometry.Vector2;

public class NaveNeutra {
    //si propietario es nulo es por que no fue reclutado

    // Entity
    protected double x; // Centro de la entidad
    protected double y; // Centro de la entidad
    //protected double width; // Ancho (Necesario para la detección de colisiones - Deberia ser del mismo tamaño que el sprite del cliente visual)
    //protected double height; // Alto
    protected Vector2 velocidad; // Velocidad de la nave

    //Nave
    protected int countProyectil;
    protected Vector2 direccion;
    protected double angulo;

    protected int puntaje;
    protected LinkedList<NaveNeutra> navesAliadas;
    protected int idBullets;
    private NavePlayer propietario;
    private static final int DISTANCIA_DE_ALIANZA = 150;
    private String idProp;
    private boolean disponible;
    private String pregunta = "2 + 5";
    private int respuesta = 7;
    private static final int[] opciones = {9, 7, 6, 4};
    private String idPosP;

    public NaveNeutra(double x, double y, Vector2 velocidad, int countProyectil, Vector2 direccion, double angulo, int puntaje, LinkedList<NaveNeutra> navesAliadas, int idBullets, NavePlayer propietario, String idProp, boolean disponible, String idPosP) {
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
        this.countProyectil = countProyectil;
        this.direccion = direccion;
        this.angulo = angulo;
        this.puntaje = puntaje;
        this.navesAliadas = navesAliadas;
        this.idBullets = idBullets;
        this.propietario = propietario;
        this.idProp = idProp;
        this.disponible = disponible;
        this.idPosP = idPosP;
    }

    public void setPropietario(NavePlayer propietario) {
        this.propietario = propietario;
    }

    public void fromJSON(JSONObject object) {

    }
}
