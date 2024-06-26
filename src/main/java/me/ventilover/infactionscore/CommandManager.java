package me.ventilover.infactionscore;


import org.bukkit.command.CommandSender;

import java.util.HashMap;

public class CommandManager {//singleton class
    //class to manage commands and prompts for commands

    private CommandManager(){
        //block constructor
    }
    private static CommandManager instance;//private instance

    private static final HashMap<String, String> commandHashMap = new HashMap<>();// hashmap to store commands names and their usage

    public static CommandManager getInstance() {
        if (instance == null){
            instance = new CommandManager(); //getter, for instance
            createCommandHashMap();
        }

        return instance;
    }

    public boolean checkIfPlayerNoPermission(CommandSender sender, String permission){
        return !sender.hasPermission(permission); //method to check if a sender has the permission
    }

    public static void createCommandHashMap(){ //create the hashmap
        commandHashMap.put("help", "fhelp");
        commandHashMap.put("list", "flist");

        //put the commands and names
    }
    //getter, for the hashmap
    public static HashMap<String, String> getCommandHashMap() {
        return commandHashMap;
    }
}
