package me.ventilover.infactionscore;
//custom exception
public class PlayerNotInFactionException extends Exception{
    public PlayerNotInFactionException(String message){
        super(message);
    }
}
