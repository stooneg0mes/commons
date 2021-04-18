package net.stonegomes.commons.builder;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationBuilder {

    private final World world;

    private double x, y, z;
    private Float pitch, yaw;

    public LocationBuilder(World world) {
        this.world = world;
    }

    public LocationBuilder(String world) {
        this.world = Bukkit.getWorld(world);
    }

    public LocationBuilder x(double x) {
        this.x = x;

        return this;
    }

    public LocationBuilder y(double y) {
        this.y = y;

        return this;
    }

    public LocationBuilder z(double z) {
        this.z = z;

        return this;
    }

    public LocationBuilder pitch(float pitch) {
        this.pitch = pitch;

        return this;
    }

    public LocationBuilder yaw(float yaw) {
        this.yaw = yaw;

        return this;
    }

    public Location build() {
        Location location = new Location(world, x, y, z);

        if (yaw != null) location.setYaw(yaw);
        if (pitch != null) location.setPitch(pitch);

        return location;
    }

}
