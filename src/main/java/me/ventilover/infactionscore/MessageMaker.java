package me.ventilover.infactionscore;


import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;

public class MessageMaker {

    //class to make several messages

    //color variables
    private final TextColor darkerRedColor = TextColor.fromHexString("#b02d13");
    private final TextColor lighterRedColor = TextColor.fromHexString("#ff6666");
    private final TextColor greenTextColor = TextColor.fromHexString("#24c712");
    private final TextColor lighterGreenColor = TextColor.fromHexString("#31e31e");


    public Component makeErrorMessage(String message){ //method to make an error message
        TextComponent.Builder builder = Component.text();

        builder
                .append(Component.text("[!]", darkerRedColor))
                .append(Component.space())
                .append(Component.text(message, lighterRedColor))
                .append(Component.space())
                .append(Component.text("[!]", darkerRedColor));



        return builder.build();
    }

    public Component makeConfirmMessage(String message){

        TextComponent.Builder builder = Component.text();

        builder
                .append(Component.text("[✔]", greenTextColor))
                .append(Component.space())
                .append(Component.text(message,lighterGreenColor))
                .append(Component.space())
                .append(Component.text("[✔]", greenTextColor));


        return builder.build();
    }


}
