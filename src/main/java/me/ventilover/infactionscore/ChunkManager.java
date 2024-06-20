package me.ventilover.infactionscore;

import org.bukkit.Chunk;

import javax.sound.midi.MidiFileFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class ChunkManager {//singleton class

    private ChunkManager(){
        //block constructor
    }

    private static ChunkManager instance;

    public static ChunkManager getInstance() {
        if (instance == null){
            instance = new ChunkManager();
        }
        return instance;
    }


}
