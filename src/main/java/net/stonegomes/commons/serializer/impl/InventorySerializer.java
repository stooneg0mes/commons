package net.stonegomes.commons.serializer.impl;

import lombok.Getter;
import net.stonegomes.commons.serializer.Serializer;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventorySerializer implements Serializer<String, Inventory> {

    @Getter
    private static final InventorySerializer instance = new InventorySerializer();

    private final ItemStackSerializer itemStackSerializer = ItemStackSerializer.getInstance();

    @Override
    public String serialize(Inventory value) {
        if (value.getContents().length == 0) return "empty";

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < value.getSize(); i++) {
            ItemStack itemStack = value.getItem(i);
            if (itemStack == null) continue;

            stringBuilder.append(i + ":" + itemStackSerializer.serialize(itemStack)).append(i != value.getSize() ? ";" : "");
        }

        return stringBuilder.toString();
    }

    @Override
    public Inventory deserialize(String key) {
        return deserialize(key, null, 9 * 5);
    }

    public Inventory deserialize(String key, String name, int size) {
        Inventory inventory = Bukkit.createInventory(null, size, name);
        if (key.equals("empty")) return inventory;

        for (String string : key.split(";")) {
            String[] splitString = string.split(":");
            inventory.setItem(Integer.parseInt(splitString[0]), itemStackSerializer.deserialize(splitString[1]));
        }

        return inventory;
    }

}
