package me.ventilover.infactionscore;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Faction { //this is a faction class it will hold the name of the faction, claim amount, etc.
    //variables for the faction
    private final String name;
    private final HashMap<UUID,FactionRole> memberHashMap;
    private Integer power;

    public Faction(String name){
        this.name = name;
        this.memberHashMap = new HashMap<>();
    }

    public String getFactionName() {
        return name;
    }

    public void addPlayerToFaction(Player player, FactionRole factionRole){
        //method to add a player into the faction
        memberHashMap.put(player.getUniqueId(),factionRole);
    }

    public void addPower(int powerToAdd){
        //power cant be more than 10
        if ((powerToAdd+power) > 10){
            power = 10;

        }
        else {
            power += powerToAdd;
        }

    }

    public void decrementPower(int powerToRemove){
        if ((power-powerToRemove) < -10){
            power = -10;
        }
        else {
            power -= powerToRemove;
        }
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
        return memberHashMap.get(player.getUniqueId());
    }

    public void changePlayerRole(Player player,FactionRole factionRole){
        memberHashMap.put(player.getUniqueId(),factionRole); //maybe gonna need an f player class for that
    }



    //enum set for the roles
    public enum FactionRole{
        LEADER,
        CO_LEADER,
        ELDER,
        MEMBER
    }
}
