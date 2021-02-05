package net.stonegomes.commons.serializer.impl;

import lombok.Getter;
import net.stonegomes.commons.serializer.Serializer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationSerializer implements Serializer<String, Location> {

    @Getter
    private static final LocationSerializer instance = new LocationSerializer();

    @Override
    public String serialize(Location value) {
        if (value.getWorld() == null) return null;

        return value.getWorld().getName() + ";" + value.getX() + ";" + value.getY() + ";" + value.getZ();
    }

    @Override
    public Location deserialize(String key) {
        String[] splitKey = key.split(";");

        World world = Bukkit.getWorld(splitKey[0]);
        if (world == null) return null;

        return new Location(world, Double.parseDouble(splitKey[1]), Double.parseDouble(splitKey[2]), Double.parseDouble(splitKey[3]));
    }

}
