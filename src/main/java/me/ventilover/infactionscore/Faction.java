package me.ventilover.infactionscore;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Faction { //this is a faction class it will hold the name of the faction, claim amount, etc.
    //variables for the faction
    private final String name;
    private final HashMap<UUID,FactionRole> memberHashMap;
    private int factionPower;//power of a faction
    private ArrayList<Chunk> claimedChunkArrayList;

    public Faction(String name,int factionPower){
        this.name = name;
        this.claimedChunkArrayList = new ArrayList<>();
        this.memberHashMap = new HashMap<>();
        this.factionPower = factionPower;
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
        memberHashMap.put(player.getUniqueId(),factionRole); //change the value of the player role
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

    public void addChunkToFaction(Chunk chunk){
        claimedChunkArrayList.add(chunk);
    }

    public void removeChunkFromFaction(Chunk chunk){
        claimedChunkArrayList.remove(chunk);
    }

    public boolean playerInFaction(Player player){
        boolean result = false;
        UUID playerUuid = player.getUniqueId();

        for (UUID uuid: memberHashMap.keySet()){
            if (uuid == playerUuid){
                result = true;
                break;
            }
        }
        return result;
    }
}
