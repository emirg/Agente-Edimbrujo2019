package Logica;

import java.util.HashMap;
import java.util.LinkedList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Match {

    protected LinkedList<String> players;
    protected LinkedList<String> playingPlayers;

    public Match(String id, LinkedList<String> players, LinkedList<String> playingPlayers, boolean destroy) {
        //super("Match", destroy, id);
        this.players = players;
        this.playingPlayers = playingPlayers;
    }

    public JSONObject fromJSON() {
        JSONObject jsonMatch = new JSONObject();
        JSONObject jsonAttrs = new JSONObject();
        //jsonAttrs.put("super", super.toJSON());

        JSONArray jsonPlayers = new JSONArray();
        for (String player : players) {
            jsonPlayers.add(player);
        }
        jsonAttrs.put("players", jsonPlayers);

        JSONArray jsonPlayingPlayers = new JSONArray();
        for (String playingPlayer : playingPlayers) {
            jsonPlayingPlayers.add(playingPlayer);
        }
        jsonAttrs.put("playingPlayers", jsonPlayingPlayers);

        jsonMatch.put("Match", jsonAttrs);
        return jsonMatch;
    }

}
