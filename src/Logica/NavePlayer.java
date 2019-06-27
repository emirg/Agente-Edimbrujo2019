package Logica;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import org.dyn4j.geometry.Vector2;
import org.json.simple.JSONObject;

public class NavePlayer {

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

    // NavePlayer
    protected int health;
    protected int healthMax;
    protected boolean leave;
    protected boolean dead;
    protected int puntaje;
    protected LinkedList<NaveNeutra> navesAliadas;
    protected int idBullets;

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
