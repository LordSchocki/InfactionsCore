package me.ventilover.infactionscore;

public class DataSafeManager { //singleton class
    //this class is here to manage all the data that needs to be saved via methods for each safe data

    private static DataSafeManager instance;

    private DataSafeManager(){
        //block constructor
    }

    public DataSafeManager getInstance() {
        if (instance == null){
            instance = new DataSafeManager(); //getter, for instance
        }

        return instance;
    }

    public void safeAllData(){
        //logic to safe later data
        //this ist the method for all the sub methods like safe factions names etc...
    }
}
