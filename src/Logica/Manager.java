    package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Manager {

    private static Manager manager;
    private HashMap<String, NavePlayer> navePlayers;
    private HashMap<String, Moneda> monedas; // No estoy seguro todavia de esto
    private Match match;
    private ArrayList<NavePlayer> navePlayerList;
    private ArrayList<Proyectil> proyectilList;
    private ArrayList<Asteroide> asteroideList;
    private ArrayList<Moneda> monedaList;

    public static Manager getManager() {
        if (manager == null) {
            manager = new Manager();
        }
        return manager;
    }

    private Manager() {
        navePlayers = new HashMap<>();
        // match = new Match();
        navePlayerList = new ArrayList<>();
        proyectilList = new ArrayList<>();
        asteroideList = new ArrayList<>();
        monedaList = new ArrayList<>();
    }

    public NavePlayer getPlayer(String id) {
        return navePlayers.get(id);
    }

    public ArrayList<NavePlayer> getPlayers() {
        return navePlayerList;
    }

    public ArrayList<Proyectil> getProyectiles() {
        return proyectilList;
    }

    public ArrayList<Asteroide> getAsteroides() {
        return asteroideList;
    }

    public ArrayList<Moneda> getMonedas() {
        return monedaList;
    }

    public Match getMatch() {
        return match;
    }

    /*
    // No lo necesitamos porque no tenemos estados estaticos
    public void updateStaticState(String state) {
        try {
            spawnList = new ArrayList<>();
            JSONObject json = (JSONObject) new JSONParser().parse(state);
            for (int i = 0; i < json.size(); i++) {
                JSONObject jsonObject = (JSONObject) json.get(Integer.toString(i));
                JSONObject object;
                if ((object = (JSONObject) jsonObject.get("Map")) != null) {
                    map.fromJSON(object);
                }
                if ((object = (JSONObject) jsonObject.get("Spawn")) != null) {
                    spawnList.add(new Spawn(object));
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    
    public void updateState(String state) {
        try {
            proyectilList = new ArrayList<>();
            JSONObject json = (JSONObject) new JSONParser().parse(state);
            for (int i = 0; i < json.size(); i++) {
                JSONObject jsonObject = (JSONObject) json.get(Integer.toString(i));
                JSONObject object;
                if ((object = (JSONObject) jsonObject.get("NavePlayer")) != null) {
                    String id = (String) object.get("id");
                    NavePlayer player = navePlayers.get(id);
                    if (player == null) {
                        player = new NavePlayer(id);
                        navePlayers.put(id, player);
                        navePlayerList.add(player);
                    }
                    //player.fromJSON(object);
                } else if ((object = (JSONObject) jsonObject.get("Moneda")) != null) {
                    String id = (String) object.get("id");
                    Moneda moneda = monedas.get(id);
                    if (moneda == null) {
                        moneda = new Moneda(id);
                        monedas.put(id, moneda);
                        monedaList.add(moneda);
                    }
                    moneda.fromJSON(object);
                } else if ((object = (JSONObject) jsonObject.get("Proyectil")) != null) {
                    String id = (String) object.get("id");
                    Proyectil proyectil = new Proyectil(id);
                    proyectilList.add(proyectil);
                    proyectil.fromJSON(object);
                } else if ((object = (JSONObject) jsonObject.get("Match")) != null) {
                    match.fromJSON(object);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
