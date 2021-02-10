package net.stonegomes.commons;

import net.stonegomes.commons.module.ModuleManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CommonsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        enable();

        /*
        Loading modules
         */
        ModuleManager.load(getModuleClasses());
    }

    @Override
    public void onLoad() {
        load();
    }

    @Override
    public void onDisable() {
        disable();

        /*
        Unloading modules
         */
        ModuleManager.unload(getModuleClasses());
    }

    /*
    Abstract methods
     */

    public void enable() { };

    public void load() { };

    public void disable() { };

    public Class[] getModuleClasses() { return null; }

}
