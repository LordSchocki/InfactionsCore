package me.ventilover.infactionscore;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;


public class FactionHelpCommand extends Command { //command to see all other faction related commands

    //constructor of the command
    protected FactionHelpCommand() {
        super("fhelp");
        this.description = "Command to see available faction commands";
        this.usageMessage = "/faction help";
    }

    @Override //execute method called when the command is executed
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (CommandManager.getInstance().checkIfPlayerNoPermission(sender, "infactionscore.factionhelp")){
            return false; //check the permission
        }
        else {
            sender.sendMessage(buildHelpMessage());//send the player the textmessage
            return true;
        }

    }

    public Component buildHelpMessage(){ //method to display all the commands
        final TextColor customRedColor = TextColor.fromHexString("#e32064");
        final TextColor lighterRedColor = TextColor.fromHexString("#ff6666");
        return Component.text()
                .append(Component.newline())
                .append(Component.text("Here are some useful Commands: ", customRedColor))
                .append(Component.newline())
                .append(Component.newline())
                .append(Component.text("/faction list",lighterRedColor))
                .build();
    }


}
