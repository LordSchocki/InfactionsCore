package me.ventilover.infactionscore;

import org.bukkit.Chunk;
import org.bukkit.World;

import java.io.Serializable;

public class FactionChunk implements Serializable { //class to make chunks serializable

    private final int chunkX;
    private final int chunkZ;

    public FactionChunk(Chunk chunk){
        this.chunkX = chunk.getX();
        this.chunkZ = chunk.getZ();
    }

    public Chunk toChunk(World world){
        return world.getChunkAt(chunkX, chunkZ);
    }


}
