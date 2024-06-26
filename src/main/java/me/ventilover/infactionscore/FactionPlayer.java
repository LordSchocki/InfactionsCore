package me.ventilover.infactionscore;

import org.yaml.snakeyaml.Yaml;


public class FactionPlayer {
    private Integer power;
    private Integer balance;

    FactionPlayer(int power,int balance){
        this.power = power;
        this.balance = balance;
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

    public String serialize(){
        Yaml yaml = new Yaml();
        return yaml.dump(this);
    }

    public static FactionPlayer deserializse(String yamlStr){
        Yaml yaml = new Yaml();
        return yaml.loadAs(yamlStr,FactionPlayer.class);
    }
}
