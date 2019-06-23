/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import org.dyn4j.geometry.Vector2;
import org.json.simple.JSONObject;

/**
 *
 * @author karen
 */
public abstract class Nave extends Entity {

    protected int countProyectil;
    protected Vector2 direccion;
    protected double angulo;

    //depende de como tratemos la orientacion puede no ser un int
    public Nave(String name, boolean destroy, String id, double x, double y, double velocidadX, double velocidadY, double xDir, double yDir, int cantProj) {
        super(name, destroy, id, x, y, velocidadX, velocidadY, 64, 64);
        this.countProyectil = cantProj;
        this.direccion = new Vector2(xDir, yDir);
        this.angulo = direccion.getDirection() * (180 / Math.PI);

    }

    public int getCountProyectil() {
        return countProyectil;
    }

    public void setCountProyectil(int countProyectil) {
        this.countProyectil = countProyectil;
    }

    /*
    public void fromJSON(JSONObject object) {
        this.dead = (Boolean) object.get("dead");
        this.leave = (Boolean) object.get("leave");
        JSONObject entity = (JSONObject) ((JSONObject) object.get("super")).get("Entity");
        this.position = new Point((int) (long) entity.get("x"), (int) (long) entity.get("y"));
        this.team = (int) (long) object.get("team");
        this.role = (int) (long) object.get("role");
        this.health = (int) (long) object.get("health");
        this.healthMax = (int) (long) object.get("healthMax");
    }
    */
}
