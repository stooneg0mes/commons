package net.stonegomes.commons.inventory;

import org.bukkit.entity.Player;

public class EmptyCustomInventory extends CustomInventory {

    public EmptyCustomInventory(String title, int rows, boolean cancellable) {
        super(title, rows, cancellable);
    }

    @Override
    public void init(Player player) {
        /*
        Nothing here
         */
    }

}
