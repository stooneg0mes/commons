package net.stonegomes.commons.inventory;

import lombok.Getter;
import net.stonegomes.commons.inventory.item.ClickableItem;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class PaginatorInventory {

    @Getter
    private int currentPage = 0;

    private final Map<Integer, ClickableItem> fixedItems = new HashMap<>();
    private final List<CustomInventory> pages = new LinkedList<>();

    public PaginatorInventory() {
        CustomInventory inventory = new EmptyCustomInventory(getTitle(), getRows(), true);

        /*
        Filling the inventory & adding pages
         */

        int i = 0;
        for (ClickableItem clickableItem : getItems()) {
            if (fixedItems.containsKey(getAllowedSlots()[i])) continue;

            int allowedSlotsLength = getAllowedSlots().length;
            if (getAllowedSlots()[i] == getAllowedSlots()[allowedSlotsLength - 1]) {
                inventory.setItem(getAllowedSlots()[i], clickableItem);

                i = 0;
                inventory = new EmptyCustomInventory(getTitle(), getRows(), true);
                continue;
            }

            inventory.setItem(getAllowedSlots()[i], clickableItem);
            if (i == 0) pages.add(inventory);

            i++;
        }
    }

    /*
    Fixed items
     */

    public void setFixedItem(int slot, ClickableItem clickableItem) {
        fixedItems.put(slot, clickableItem);

        CustomInventory customInventory = pages.get(currentPage);
        customInventory.setItem(slot, clickableItem);
    }

    /*
    Pages
     */

    public void openFirstPage(Player player) {
        if (pages.size() == 0) return;

        CustomInventory customInventory = pages.get(currentPage);

        init(customInventory, player);
        customInventory.openInventory(player);
    }

    public void goToNextPage(Player player) {
        if ((currentPage + 1) >= pages.size()) return;
        currentPage++;

        CustomInventory customInventory = pages.get(currentPage);

        init(customInventory, player);
        customInventory.openInventory(player);
    }

    public void goToPreviousPage(Player player) {
        if (currentPage == 0) return;
        currentPage--;

        CustomInventory customInventory = pages.get(currentPage);

        init(customInventory, player);
        customInventory.openInventory(player);
    }

    /*
    Abstract methods
     */

    public abstract void init(CustomInventory customInventory, Player player);

    public abstract String getTitle();

    public abstract List<ClickableItem> getItems();

    public abstract Integer[] getAllowedSlots();

    public abstract int getRows();

}
