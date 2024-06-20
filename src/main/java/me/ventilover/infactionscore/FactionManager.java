package me.ventilover.infactionscore;
import java.util.ArrayList;


public class FactionManager {//singleton class

    //arraylist to hold all the factions
    ArrayList<Faction> factionArrayList = new ArrayList<>();

    private static FactionManager instance;

    private FactionManager(){
        //block constructor
    }

    public static FactionManager getInstance() {
        if (instance == null){
            instance = new FactionManager();

        }
        return instance;
    }

    public void addFactionToArrayList(Faction faction){
        factionArrayList.add(faction);
    }

    public void removeFactionFromArrayList(Faction faction){
        factionArrayList.remove(faction);
    }



}
