/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import org.dyn4j.geometry.Vector2;
import org.json.simple.JSONObject;

/**
 *
 * @author emiliano
 */
public class Moneda {

    String name;
    boolean destroy;
    String id;
    double x;
    double y;
    double width;
    double height;

    public Moneda(String name, boolean destroy, String id, double x, double y, double width, double height) {
        this.name = name;
        this.destroy = destroy;
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void fromJSON(JSONObject object) {
        this.x = (double) object.get("x");
        this.y = (double) object.get("y");
        this.id = (String) object.get("id");
        this.name = (String) object.get("name");
        this.destroy = (boolean) object.get("destroy");

    }

}
