package me.ventilover.infactionscore;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener {
    //listener class for player leaves
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        //remove the scheduler from the player
        FactionPowerManager.getInstance().removeCountDown(event.getPlayer().getUniqueId());

    }

}
