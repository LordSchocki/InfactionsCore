package me.ventilover.infactionscore;

//custom Exception

public class ChunkAlreadyOwnedException extends Exception{

    public ChunkAlreadyOwnedException(String message){
        super(message);
    }

}
