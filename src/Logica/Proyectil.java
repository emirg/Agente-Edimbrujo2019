package Logica;

import java.util.HashMap;
import java.util.LinkedList;
import org.dyn4j.geometry.Vector2;
import org.json.simple.JSONObject;

public class Proyectil {

    protected int number;
    protected String idPlayer;
    protected Vector2 direccion;
    protected double angulo;

    public Proyectil(String name, boolean destroy, String id, String idPlayer, double x, double y, double velocidadX, double velocidadY,double xDir, double yDir ,double angulo ,int number) {
        super("Proyectil", destroy, id, x, y, velocidadX, velocidadY, 64, 12);
        this.number = number;
        this.idPlayer = idPlayer;
        this.angulo=angulo;
        this.direccion = new Vector2(xDir,yDir);
    }


    public JSONObject fromJSON() {
        JSONObject jProyectil = new JSONObject();
        JSONObject jsonAttrs = new JSONObject();
        //jsonAttrs.put("super", super.toJSON());
        jsonAttrs.put("number", number);
        jsonAttrs.put("angulo", angulo);
        jProyectil.put("Proyectil", jsonAttrs);
        return jProyectil;
    }

}
