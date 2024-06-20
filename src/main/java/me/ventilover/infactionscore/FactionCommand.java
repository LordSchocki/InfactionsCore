package me.ventilover.infactionscore;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class FactionCommand extends Command { //command to see all other faction related commands

    //constructor of the command
    protected FactionCommand() {
        super("faction");
        this.description = "Command to see available faction commands";
        this.usageMessage = "/faction";
        this.setAliases(List.of("factions"));
    }

    @Override //execute method called when the command is executed
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (!checkIfPermission(sender)){
            return false; //check the permission
        }
        else {
            sender.sendMessage(buildHelpMessage());//send the player the textmessage
            return true;
        }

    }

    public Component buildHelpMessage(){
        final TextColor customRedColor = TextColor.fromHexString("#e32064");
        final TextColor lighterRedColor = TextColor.fromHexString("#ff6666");
        return Component.text()
                .append(Component.text("Here are some useful Commands: ", customRedColor))
                .append(Component.newline())
                .append(Component.text("/faction list"))
                .build();
    }

    public boolean checkIfPermission(CommandSender sender){
        return sender.hasPermission("infactionscore.faction");
    }
}
