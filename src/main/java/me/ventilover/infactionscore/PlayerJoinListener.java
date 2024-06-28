package me.ventilover.infactionscore;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.NoSuchElementException;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        try{
            FactionPlayerManager.getInstance().getFactionPlayer(event.getPlayer().getUniqueId()); //we try to get their uuid if we cant we make a new one
        } catch (NoSuchElementException e) {
            FactionPlayerManager.getInstance().addFactionPlayer(event.getPlayer().getUniqueId(), new FactionPlayer(10)); //start power is 10
        }

    }
}
