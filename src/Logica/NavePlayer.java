package Logica;

import java.util.HashMap;
import java.util.LinkedList;
import org.json.simple.JSONObject;

public class NavePlayer extends Nave {

    protected int health;
    protected int healthMax;
    protected boolean leave;
    protected boolean dead;
    protected int puntaje;
    protected LinkedList<Nave> navesAliadas;
    protected int idBullets;

    public NavePlayer(String name,boolean destroy, String id, double x, double y, double velocidadX, double velocidadY,double xDir,double yDir, int h, int hM, int cantProj, int puntaje, boolean leave, boolean dead) {
        super("NavePlayer",destroy, id, x, y, velocidadX, velocidadY,xDir,yDir, cantProj);
        this.health = h;
        this.healthMax = hM;
        this.leave = leave;
        this.dead = dead;
        this.puntaje = puntaje;
        this.navesAliadas = new LinkedList<Nave>();
        this.idBullets = 0;
    }

    public JSONObject fromJSON() {
        JSONObject jJugador = new JSONObject();
        JSONObject atributo = new JSONObject();

        //atributo.put("super", super.toJSON());
        atributo.put("health", health);
        atributo.put("healthMax", healthMax);
        atributo.put("leave", leave);
        atributo.put("dead", dead);
        atributo.put("puntaje", puntaje);
        jJugador.put("NavePlayer", atributo);

        return jJugador;
    }


}
