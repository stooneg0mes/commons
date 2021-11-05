package net.stonegomes.commons;

import net.stonegomes.commons.module.Module;
import net.stonegomes.commons.storage.SqlCredentials;
import net.stonegomes.commons.storage.SqlStorage;
import net.stonegomes.commons.storage.impl.MySQLStorage;
import net.stonegomes.commons.storage.query.Query;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.UUID;

public class CommonsPlugin extends JavaPlugin {

    @Override
    public void onLoad() {
        handleLoad();

        Arrays.stream(getModules()).forEach(Module::handleLoad);

        handlePostLoad();
    }

    @Override
    public void onEnable() {
        handleEnable();

        Arrays.stream(getModules()).forEach(Module::handleEnable);

        handlePostEnable();
    }

    @Override
    public void onDisable() {
        handleDisable();

        Arrays.stream(getModules()).forEach(Module::handleDisable);

        handlePostDisable();
    }

    /*
    Abstract methods
     */

    public void handleEnable() { }

    public void handleLoad() { }

    public void handleDisable() { }

    /*
    Post abstract methods
     */

    public void handlePostEnable() { }

    public void handlePostLoad() { }

    public void handlePostDisable() { }

    public Module[] getModules() {
        return new Module[0];
    }

}
