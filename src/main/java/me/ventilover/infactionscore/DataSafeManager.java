package me.ventilover.infactionscore;

import java.io.*;
import java.util.ArrayList;

public class DataSafeManager { //singleton class
    //this class is here to manage all the data that needs to be saved via methods for each safe data

    private static DataSafeManager instance;

    private DataSafeManager(){
        //block constructor
    }

    public static DataSafeManager getInstance() {
        if (instance == null){
            instance = new DataSafeManager(); //getter, for instance
        }

        return instance;
    }

    public void safeAllData(){
        //logic to safe later data
        //this ist the method for all the sub methods like safe factions names etc...
        saveFactionsToFile();
    }
    public void loadAllData(){
        loadFactionsFromFile();
    }

    public void saveFactionsToFile() {
        if (FactionManager.getInstance().factionArrayList.isEmpty()){
            InfactionsCore.instance.getLogger().info("NO FACTIONS TO SAFE");
            return;
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("factions.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(FactionManager.getInstance().factionArrayList);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            InfactionsCore.instance.getLogger().info(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public void loadFactionsFromFile() {

        File file = new File("factions.ser");
        if (!file.exists()){
            InfactionsCore.instance.getLogger().info("FILE DOES NOT EXIST");
            return;
        }

        try {
            FileInputStream fileIn = new FileInputStream("factions.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object obj = in.readObject();
            if (obj instanceof ArrayList) {
                //noinspection unchecked

                FactionManager.getInstance().factionArrayList = (ArrayList<Faction>) obj;
                InfactionsCore.instance.getLogger().info("CLASS NOT INSTANCE OF ARRAYLIST");
            }
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            InfactionsCore.instance.getLogger().info(e.getMessage());
        }
    }
}
