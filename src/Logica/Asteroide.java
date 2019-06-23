/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;

import org.json.simple.JSONObject;

/**
 *
 * @author emiliano
 */
public class Asteroide extends Entity {

    public Asteroide(String name, boolean destroy, String id, double x, double y, double velocidadX, double velocidadY) {
        super(name, false, id, x, y, velocidadX, velocidadY, 64, 64);
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
