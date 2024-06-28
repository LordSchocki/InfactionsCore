package me.ventilover.infactionscore;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.UUID;

public class FactionPlayerManager {//singleton class
    private static FactionPlayerManager instance;
    private final HashMap<UUID,FactionPlayer>factionPlayerHashMap = new HashMap<>();

    private FactionPlayerManager(){
        //block constructor
    }

    public static FactionPlayerManager getInstance() {
        if (instance == null){
            instance = new FactionPlayerManager();
        }
        return instance;
    }

    public void addFactionPlayer(UUID playerId,FactionPlayer factionPlayer){
        factionPlayerHashMap.put(playerId,factionPlayer);
    }

    public FactionPlayer getFactionPlayer(UUID playerId) throws NoSuchElementException {
        if (!factionPlayerHashMap.containsKey(playerId)){
            throw new NoSuchElementException("No fplayer in hashmap");
        }


        return factionPlayerHashMap.get(playerId);
    }
}
