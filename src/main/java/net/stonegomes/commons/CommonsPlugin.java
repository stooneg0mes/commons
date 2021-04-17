package net.stonegomes.commons;

import net.stonegomes.commons.module.Module;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class CommonsPlugin extends JavaPlugin {

    @Override
    public void onLoad() {
        handleLoad();

        /*
        Loading modules
         */

        Arrays.stream(getModules()).forEach(Module::handleLoad);
    }

    @Override
    public void onEnable() {
        handleEnable();

        /*
        Enabling modules
         */

        Arrays.stream(getModules()).forEach(Module::handleEnable);
    }

    @Override
    public void onDisable() {
        handleDisable();

        /*
        Disabling modules
         */

        Arrays.stream(getModules()).forEach(Module::handleDisable);
    }

    /*
    Abstract methods
     */

    public void handleEnable() { }

    public void handleLoad() { }

    public void handleDisable() { }

    public Module[] getModules() {
        return new Module[0];
    }

}
