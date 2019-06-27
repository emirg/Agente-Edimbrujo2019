package Logica;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import org.dyn4j.geometry.Vector2;
import org.json.simple.JSONObject;

public class NavePlayer {

    // Entity
    private double x; // Centro de la entidad
    private double y; // Centro de la entidad
    //protected double width; // Ancho (Necesario para la detección de colisiones - Deberia ser del mismo tamaño que el sprite del cliente visual)
    //protected double height; // Alto
    private Vector2 velocidad; // Velocidad de la nave
    
    //Nave
    private int countProyectil;
    private Vector2 direccion;
    private double angulo;

    // NavePlayer
    private int health;
    private int healthMax;
    private boolean leave;
    private boolean dead;
    private int puntaje;
    private LinkedList<NaveNeutra> navesAliadas;
    private int idBullets;
    private String name;
    private boolean destroy;
    private String id;


    public NavePlayer(String name, boolean destroy, String id, double x, double y, double velocidadX, double velocidadY, double xDir, double yDir, int h, int hM, int cantProj, int puntaje, boolean leave, boolean dead) {
        this.x = x;
        this.y = y;
        this.velocidad = new Vector2(velocidadX, velocidadY);
        this.countProyectil = cantProj;
        this.direccion = new Vector2(xDir,yDir);
        this.angulo = direccion.getDirection()*(180/Math.PI);
        this.health = h;
        this.healthMax = hM;
        this.leave = leave;
        this.dead = dead;
        this.puntaje = puntaje;
        //this.navesAliadas = new LinkedList<NaveNeutra>();
        this.idBullets = 0;
        this.name=name;
        this.destroy=destroy;
        this.id=id;
    }

    public JSONObject fromJSON(JSONObject object) {
        this.dead = (Boolean) object.get("dead");
        this.leave = (Boolean) object.get("leave");
        this.health = (int) (long) object.get("health");
        this.healthMax = (int) (long) object.get("healthMax");
        JSONObject entity = (JSONObject) ((JSONObject) object.get("super")).get("Entity");
        this.position = new Point((int) (long) entity.get("x"), (int) (long) entity.get("y"));

        return jJugador;
    }

}
