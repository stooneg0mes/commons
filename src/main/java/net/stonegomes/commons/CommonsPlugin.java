package net.stonegomes.commons;

import net.stonegomes.commons.module.ModuleManager;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class CommonsPlugin extends JavaPlugin {

    @Override
    public void onEnable() { ModuleManager.load(); }

    @Override
    public void onDisable() { ModuleManager.unload(); }

}
