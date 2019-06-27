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

    //private String propietario; // Podria ser una NavePlayer tambien
    private NavePlayer propietario;
    private static final int DISTANCIA_DE_ALIANZA = 150;
    private String idProp;
    private boolean disponible;
    private String pregunta = "2 + 5";
    private int respuesta = 7;
    private static final int[] opciones = {9,7,6,4};
    private String idPosP;

    public NaveNeutra(String name,boolean destroy, String id, double x, double y, double velocidadX, double velocidadY,double xDir,double yDir, int cantProj, NavePlayer prop) {
        super("NaveNeutra",destroy, id, x, y, velocidadX, velocidadY,xDir,yDir, cantProj);
        this.propietario = prop;
        //this.idPosP= posible;
        //disponible va a estar en falso cuando un jugador este respondiendo
        //this.disponible= d;
        //this.idProp = p;
        //this.pregunta = preg;
        //this.respuesta = resp;
    }


    public void setPropietario(NavePlayer propietario) {
        this.propietario = propietario;
    }

   


    @Override
    public JSONObject fromJSON(JSONObject object) {
        JSONObject jNeutra = new JSONObject();
        JSONObject atributo = new JSONObject();

        atributo.put("super", super.toJSON());
        atributo.put("propietario", propietario);
        jNeutra.put("NaveNeutra", atributo);

        return jNeutra;
    }
}
