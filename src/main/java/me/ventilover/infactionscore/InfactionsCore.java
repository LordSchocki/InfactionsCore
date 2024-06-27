package me.ventilover.infactionscore;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

public final class InfactionsCore extends JavaPlugin {

    //main class for the plugin

    @Override
    public void onEnable() {



       // getServer().getPluginManager().registerEvents(null,this); //register event listener here

        //create the commandMap for commands
        CommandMap commandMap = Bukkit.getCommandMap();

        commandMap.register("fhelp",new FactionHelpCommand()); //register the commands

        commandMap.register("flist", new FactionListCommand());

        commandMap.register("faction", new FactionCommand());

        SnippedTest.testSnippet();
        getLogger().info("InfactionsCore has started!");//logger message
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("InfactionsCore has stopped!");
    }
}
