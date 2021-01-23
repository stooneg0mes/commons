package net.stonegomes.commons.inventory.listener;

import net.stonegomes.commons.inventory.CustomInventory;
import net.stonegomes.commons.inventory.item.ClickableItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();

        if (inventory.getHolder() instanceof CustomInventory) {
            CustomInventory customInventory = (CustomInventory) inventory.getHolder();

            if (customInventory.isCancellable()) event.setCancelled(true);

            ClickableItem clickableItem = customInventory.getItems().get(event.getSlot());
            if (clickableItem == null) return;

            if (clickableItem.getEventConsumer() != null) clickableItem.getEventConsumer().accept(event);
        }
    }

}
