package me.ventilover.infactionscore;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;

import java.util.NoSuchElementException;

public class OwnershipManager { //another singleton class

    private OwnershipManager instance;

    private OwnershipManager(){
        //block constructor
    }

    public OwnershipManager getInstance() {
        if (instance == null){
            instance = new OwnershipManager();
        }
        return instance;
    }
    //end of the singleton layout

    public boolean playerCanClaimChunk(Player player, Chunk chunk) throws PlayerNotInFactionException,NoSuchElementException{
        Faction playerFaction;
        playerFaction = FactionManager.getInstance().getFactionFromPlayer(player); //throws an exception if not found the faction

        return playerHasRightRole(player, playerFaction) && ChunkIsNotOwned() && factionHasEnoughPower();
    }

    private boolean playerHasRightRole(Player player, Faction faction){
        return faction.checkFactionRole(player) == Faction.FactionRole.LEADER || faction.checkFactionRole(player) == Faction.FactionRole.CO_LEADER;

    }

    private boolean factionHasEnoughPower(){
        //NEEDS TO BE COMPLETED
        return true;
    }

    private boolean ChunkIsNotOwned(){
        //NEEDS TO BE COMPLETED
        return true;
    }

}
