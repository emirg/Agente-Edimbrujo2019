package Logica;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;
import org.dyn4j.geometry.Vector2;
import org.json.simple.JSONObject;

public class Entity {

    protected double x; // Centro de la entidad
    protected double y; // Centro de la entidad
    protected double width; // Ancho (Necesario para la detección de colisiones - Deberia ser del mismo tamaño que el sprite del cliente visual)
    protected double height; // Alto
    protected Vector2 velocidad;

    public Entity(String name, boolean destroy, String id, double x, double y, double velocidadX, double velocidadY, double width, double height) {
        //super(name, destroy, id == null ? UUID.randomUUID().toString() : id);
        // Hay que traer las cosas de State a Entity (atributos dead, leave, etc.)
        this.x = x;
        this.y = y;
        this.velocidad = new Vector2(velocidadX, velocidadY);
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public Vector2 getVelocidad(){
        return velocidad;
    }
    
    public void setVelocidad(Vector2 velocidad){
        this.velocidad = velocidad.copy();
    }

    public JSONObject fromSON() {
        JSONObject jsonEntity = new JSONObject();
        JSONObject jsonAttrs = new JSONObject();
        //jsonAttrs.put("super", super.toJSON());
        jsonAttrs.put("x", x);
        jsonAttrs.put("y", y);
        jsonAttrs.put("width", width);
        jsonAttrs.put("height", height);
        jsonAttrs.put("velocidadX", velocidad.x);
        jsonAttrs.put("velocidadY", velocidad.y);
        jsonEntity.put("Entity", jsonAttrs);
        return jsonEntity;
    }

}
