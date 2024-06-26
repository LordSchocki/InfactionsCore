package me.ventilover.infactionscore;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;


public class FactionListCommand extends Command {


    //constructor
    protected FactionListCommand(){
        super("flist");
        this.description = "A command to show all the factions";
        this.usageMessage = "/faction list";
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (CommandManager.getInstance().checkIfPlayerNoPermission(sender, "infactionscore.factionlist")){ //check the permission
            return false;
        }
        sender.sendMessage(createFactionList()); //if the code here is reached, the player has the permission, and we can send the message
        return true;

    }

    private Component createFactionList(){ //method to create the list
        //colors
        final TextColor lighterRedColor = TextColor.fromHexString("#ff6666");
        final TextColor darkerRedColor = TextColor.fromHexString("#540e0f");


        //check if the list is empty
        if (FactionManager.getInstance().factionArrayList.isEmpty()){
            return Component.text()
                    .append(Component.text("No Factions there to show!",lighterRedColor)) //we do this to even check if factions exist
                    .appendSpace()
                    .append(Component.text("[!]",darkerRedColor))
                    .build();


        }
        else {
            TextComponent.Builder builder = Component.text(); //this is our message

            builder.append(Component.text("Here are some Factions: ",darkerRedColor));
            //then loop the faction array
            for (Faction faction : FactionManager.getInstance().factionArrayList){ //for each faction we append it to the builder
                builder
                        .append(Component.newline())
                        .append(Component.text(faction.getFactionName(), lighterRedColor))
                        .append(Component.space());

            }
            return builder.build();


        }


    }
}
