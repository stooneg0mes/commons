package net.stonegomes.commons.serializer.impl;

import lombok.Getter;
import net.stonegomes.commons.serializer.Serializer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ItemStackSerializer implements Serializer<String, ItemStack> {

    @Getter
    private static final ItemStackSerializer instance = new ItemStackSerializer();

    @Override
    public String serialize(ItemStack value) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
            dataOutput.writeObject(value);
            dataOutput.close();

            return Base64Coder.encodeLines(outputStream.toByteArray());
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public ItemStack deserialize(String key) {
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(key));
            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);

            ItemStack itemStack = (ItemStack) dataInput.readObject();
            dataInput.close();

            return itemStack;
        } catch (ClassNotFoundException | IOException exception) {
            return null;
        }
    }

}
