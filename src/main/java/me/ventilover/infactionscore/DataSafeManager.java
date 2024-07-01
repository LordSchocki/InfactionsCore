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
        //logic to load data
        //method for all the sub load methods
        loadFactionsFromFile();
    }

    public void saveFactionsToFile() { //method to safe all the factions (faction arraylist)


        if (FactionManager.getInstance().factionArrayList.isEmpty()){
            InfactionsCore.instance.getLogger().info("NO FACTIONS TO SAFE");//Don't safe if the list is empty
            return;
        }
        //then start an output stream
        try {
            FileOutputStream fileOut = new FileOutputStream("factions.ser"); //start the stream
            ObjectOutputStream out = new ObjectOutputStream(fileOut);//start the object stream
            out.writeObject(FactionManager.getInstance().factionArrayList); //now we write the faction array list into byte format
            out.close();
            fileOut.close();//closing streams
        } catch (IOException e) {
            InfactionsCore.instance.getLogger().info(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public void loadFactionsFromFile() {

        File file = new File("factions.ser");
        if (!file.exists()){
            InfactionsCore.instance.getLogger().info("FILE DOES NOT EXIST"); //first check
            // if the ser file exists, we cant load from nothing
            return;
        }

        try {
            FileInputStream fileIn = new FileInputStream("factions.ser");//new streams
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object obj = in.readObject();
            if (obj instanceof ArrayList) {
                //noinspection unchecked

                FactionManager.getInstance().factionArrayList = (ArrayList<Faction>) obj; //casting the object back to the arraylist
                InfactionsCore.instance.getLogger().info("CLASS NOT INSTANCE OF ARRAYLIST");
            }
            in.close();
            fileIn.close();//close streams
        } catch (IOException | ClassNotFoundException e) {
            InfactionsCore.instance.getLogger().info(e.getMessage());
        }
    }
}
