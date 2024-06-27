package me.ventilover.infactionscore;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.NoSuchElementException;


public class FactionManager {//singleton class

    //arraylist to hold all the factions
    ArrayList<Faction> factionArrayList = new ArrayList<>();

    private static FactionManager instance;

    private FactionManager(){
        //block constructor
    }

    public static FactionManager getInstance() {
        if (instance == null){
            instance = new FactionManager();

        }
        return instance;
    }

    public void addFactionToArrayList(Faction faction){
        factionArrayList.add(faction);
    }

    public void removeFactionFromArrayList(Faction faction){
        factionArrayList.remove(faction);
    }

    public Faction getFactionFromPlayer(Player player) throws PlayerNotInFactionException ,NoSuchElementException{
        if (playerMemberOfAnFaction(player)) {
            for (Faction faction : factionArrayList){
                if (faction.playerInFaction(player)){
                    return faction;
                }
            }
            throw new NoSuchElementException("Player not found in a faction");
        }
        else {
            throw new PlayerNotInFactionException("Player is not in a faction");
        }

    }

    public boolean playerMemberOfAnFaction(Player player){ //check if a player is a member of a faction
        for (Faction faction : factionArrayList){
            if (faction.playerInFaction(player)){ //loop through the array and check
                return true;// if the player is found
            }
        }
        return false;//if not found in any faction, return false
    }



}
