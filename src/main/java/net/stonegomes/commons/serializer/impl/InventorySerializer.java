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
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < value.getSize(); i++) {
            ItemStack itemStack = value.getItem(i);
            if (itemStack == null) continue;

            stringBuilder.append(i + ":" + itemStackSerializer.serialize(itemStack)).append(i != value.getSize() ? ";" : "");
        }

        if (stringBuilder.toString().isEmpty()) stringBuilder.append("Empty");

        return stringBuilder.toString();
    }

    @Override
    public Inventory deserialize(String key) {
        return deserialize(key, "Default inventory", 9 * 5);
    }

    public Inventory deserialize(String key, String name, int size) {
        Inventory inventory = Bukkit.createInventory(null, size, name);
        if (key.equals("Empty")) return inventory;

        for (String string : key.split(";")) {
            String[] splitString = string.split(":");
            inventory.setItem(Integer.parseInt(splitString[0]), itemStackSerializer.deserialize(splitString[1]));
        }

        return inventory;
    }

}
