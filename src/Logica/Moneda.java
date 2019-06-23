/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import org.json.simple.JSONObject;

/**
 *
 * @author emiliano
 */
public class Moneda extends Entity {

    public Moneda(String name, boolean destroy, String id, double x, double y, double velocidadX, double velocidadY, double width, double height) {
        super("Moneda", destroy, id, x, y, 0, 0, 32, 32);
    }

    public JSONObject fromJSON() {
        JSONObject jMoneda = new JSONObject();
        JSONObject atributo = new JSONObject();

        //atributo.put("super", super.toJSON());
        jMoneda.put("Moneda", atributo);

        return jMoneda;
    }

}
