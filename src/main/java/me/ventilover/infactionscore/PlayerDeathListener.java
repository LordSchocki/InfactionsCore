package me.ventilover.infactionscore;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        //this event is triggered when a player dies, so we decrease their f power
        FactionPlayerManager.getInstance().getFactionPlayer(event.getPlayer().getUniqueId()).decrementPower(1);
    }


}
