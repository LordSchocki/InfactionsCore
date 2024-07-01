package me.ventilover.infactionscore;

import org.bukkit.Chunk;
import org.bukkit.World;
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

    public boolean playerCanClaimChunk(Player player, Chunk chunk,World world) throws PlayerNotInFactionException, NoSuchElementException, FactionPowerException, ChunkAlreadyOwnedException, FactionRoleException {
        Faction playerFaction;
        playerFaction = FactionManager.getInstance().getFactionFromPlayer(player); //throws an exception if not found the faction

        playerHasRightRole(player, playerFaction);
        factionHasEnoughPower(playerFaction,world);
        checkIfChunkIsNotOwned(chunk,world);


        return true;
    }

    private void playerHasRightRole(Player player, Faction faction) throws FactionRoleException {
        if (faction.checkFactionRole(player) != Faction.FactionRole.LEADER && faction.checkFactionRole(player) != Faction.FactionRole.CO_LEADER){
            throw new FactionRoleException("PLayer is not Leader or Co leader");
        }

    }

    private void factionHasEnoughPower(Faction faction,World world) throws FactionPowerException { //method to check if a faction has more power than chunks
        faction.calculateFactionPower(); //first update the faction power

        if (faction.getFactionPower() < countFactionChunks(faction,world)){
            throw new FactionPowerException("Faction does have more chunks than power");
        }

    }

    private void checkIfChunkIsNotOwned(Chunk chunk,World world) throws ChunkAlreadyOwnedException {
        boolean result = true;

        for (Faction faction : FactionManager.getInstance().factionArrayList){ //for each faction go through the chunks
            if (faction.getClaimedChunkArrayList(world).contains(chunk)){
                result = false; //when the chunk is found, it is already claimed
                break;
            }
        }
        if (!result){
            throw new ChunkAlreadyOwnedException("This chunk is already owned");
        }

    }

    private int countFactionChunks(Faction faction, World world){
        int result = 0;
        for (Chunk ignored : faction.getClaimedChunkArrayList(world)){
            result++;
        }
        return result;
    }

}
