package me.ventilover.infactionscore;

import org.bukkit.Bukkit;
import java.util.HashMap;
import java.util.UUID;

public class FactionPowerManager {

    //another manager singleton

    private FactionPowerManager(){
        //block constructor
    }

    private static FactionPowerManager instance;

    public static FactionPowerManager getInstance() {
        if (instance == null){
            instance = new FactionPowerManager();
        }
        return instance;
    }

    //end of singleton

    private final HashMap<UUID, Integer> taskHashMap = new HashMap<>();

    public void createPlayerPowerCountDown(UUID playerId){
        int taskId;


        taskId = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(InfactionsCore.instance, () ->

                FactionPlayerManager.getInstance().getFactionPlayer(playerId).addPower(1), 0L, 12000L);

        taskHashMap.put(playerId, taskId);

    }


    public void removeCountDown(UUID playerId){

        Bukkit.getServer().getScheduler().cancelTask(taskHashMap.get(playerId));//cancel the task

        taskHashMap.remove(playerId);//then remove it
    }


}
