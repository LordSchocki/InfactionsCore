package me.ventilover.infactionscore;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class FactionCommand extends Command {
    //this is the basic command for handling the other ones
    //e.g /faction list

    protected FactionCommand(){ //constructor
        super("faction");
        this.description = "Basic faction command"; //command description
        this.usageMessage = "/faction [command]";
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        //this method is called when the command gets executed

        if (CommandManager.getInstance().checkIfPlayerNoPermission(sender, "infactions.factioncommand")) {//first check if the sender has the permission
            sender.sendMessage("No permission");//if not send an error message
            return false;
        }

        if (args.length == 1){ //check if we have one argument (for the specific command name)
            if (commandExist(args[0])){ //if the command exist dispatch it via the hashmap
                Bukkit.dispatchCommand(sender, CommandManager.getCommandHashMap().get(args[0].toLowerCase()));
            }
            else {
                Bukkit.dispatchCommand(sender, "fhelp"); //else display basic help command

            }
        }
        else {
            Bukkit.dispatchCommand(sender, "fhelp"); //if there's no or more than one argument basic help command
        }
        return true;
    }

    public boolean commandExist(String string){ //method to check if a command exists in the hashmap
        boolean result = false;
        for (String name : CommandManager.getCommandHashMap().keySet()){ //check the key set
            if (string.equalsIgnoreCase(name)){//ignore case sensitivity
                result = true;// loop through the map, and if we find it, break the loop
                break;
            }
        }

        return result; //return the boolean
    }
}
