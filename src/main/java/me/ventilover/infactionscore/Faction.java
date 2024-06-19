package me.ventilover.infactionscore;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Faction { //this is a faction class it will hold the name of the faction, claim amount, etc.
    //variables for the faction
    private final String name;
    private final HashMap<UUID,FactionRole> memberHashMap;
    private int factionPower;//power of a faction
    private int factionBalance;//balance of a faction

    public Faction(String name,int factionPower,int factionBalance){
        this.name = name;
        this.memberHashMap = new HashMap<>();
        this.factionPower = factionPower;
        this.factionBalance = factionBalance;
    }

    public String getFactionName() {
        return name;
    }

    public void addPlayerToFaction(Player player, FactionRole factionRole){
        //method to add a player into the faction
        memberHashMap.put(player.getUniqueId(),factionRole);
    }


    public void removePlayerFromFaction(Player player) throws FactionRoleException {
        //first check if its owner, if not, it's okay to remove them
        if (checkFactionRole(player) == FactionRole.LEADER){
            throw new FactionRoleException("Cannot remove Owner from faction");
        }
        else {
            memberHashMap.remove(player.getUniqueId()); //reached if the player is not the owner
        }
    }

    public FactionRole checkFactionRole(Player player){
        return memberHashMap.get(player.getUniqueId()); //method to check the faction role of the player
    }

    public void changePlayerRole(Player player,FactionRole factionRole){
        memberHashMap.put(player.getUniqueId(),factionRole); //maybe gonna need an f player class for that
    }

    public void calculateFactionPower(){
        FactionPlayerManager playerManager = FactionPlayerManager.getInstance();
        for (Map.Entry<UUID,FactionRole> entry: memberHashMap.entrySet()){ //method to calculate the whole faction power with each member
            factionPower += playerManager.getFactionPlayer(entry.getKey()).getPower(); //increase the faction power for each member

        }
    }


    //enum set for the roles
    public enum FactionRole{
        LEADER,
        CO_LEADER,
        ELDER,
        MEMBER
    }
}
