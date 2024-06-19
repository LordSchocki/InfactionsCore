package me.ventilover.infactionscore;

import java.util.UUID;

public class FactionPlayer {
    private Integer power;

    FactionPlayer(int power){
        this.power = power;
    }

    public Integer getPower() {
        return power;
    }

    public void addPower(int powerToAdd){
        //power cant be more than 10
        if ((powerToAdd+power) > 10){
            power = 10;

        }
        else {
            power += powerToAdd;
        }

    }

    public void decrementPower(int powerToRemove){
        if ((power-powerToRemove) < -10){
            power = -10;
        }
        else {
            power -= powerToRemove;
        }
    }
}
