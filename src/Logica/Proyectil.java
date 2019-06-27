package Logica;

import java.util.HashMap;
import java.util.LinkedList;
import org.dyn4j.geometry.Vector2;
import org.json.simple.JSONObject;

public class Proyectil {

    private int number;
    private String idPlayer;
    private Vector2 direccion;
    private double angulo;
    private String id;
    private boolean destroy;
    private String name;
    private double x;
    private double y;
    private Vector2 velocidad;
    private double width = 64;
    private double height = 12;

    public Proyectil(String name, boolean destroy, String id, String idPlayer, double x, double y, double velocidadX, double velocidadY,double xDir, double yDir ,double angulo ,int number) {
        this.destroy=destroy;
        this.name=name;
        this.id=id;
        this.x=x;
        this.y=y;
        this.number = number;
        this.idPlayer = idPlayer;
        this.angulo=angulo;
        this.direccion = new Vector2(xDir,yDir);
        this.velocidad = new Vector2(velocidadX, velocidadY);
    }

    public void fromJSON(JSONObject object) {
        this.x = (double) object.get("x");
        this.y = (double) object.get("y");
        this.velocidad = new Vector2((double) object.get("velocidadX"), (double) object.get("velocidadY"));
        this.direccion = new Vector2((double) object.get("xDir"), (double) object.get("yDir"));
        this.id = (String) object.get("id");
        this.name = (String) object.get("name");
        this.destroy = (boolean) object.get("destroy");
        this.number= (int) object.get("numero");
        this.idPlayer = (String) object.get("idPlayer");
        this.angulo = (double) object.get("angulo");
    }

}
