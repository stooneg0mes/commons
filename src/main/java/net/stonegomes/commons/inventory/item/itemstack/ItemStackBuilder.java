package net.stonegomes.commons.inventory.item.itemstack;

import com.google.common.collect.Lists;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.List;

public class ItemStackBuilder {

    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public ItemStackBuilder(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemStackBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemStackBuilder name(String name, boolean translateCode) {
        itemMeta.setDisplayName(translateCode ? name.replace("&", "§") : name);
        itemStack.setItemMeta(itemMeta);

        return this;
    }

    public ItemStackBuilder lore(String... lore) {
        itemMeta.setLore(Lists.newArrayList(lore));
        itemStack.setItemMeta(itemMeta);

        return this;
    }

    public ItemStackBuilder lore(List<String> lore, boolean translateCode) {
        if (translateCode) lore.replaceAll(string -> string.replace("&", "§"));

        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        return this;
    }

    public ItemStackBuilder addLore(String... lore) {
        List<String> actualLore = itemMeta.getLore();
        actualLore.addAll(Arrays.asList(lore));
        itemMeta.setLore(actualLore);
        itemStack.setItemMeta(itemMeta);

        return this;
    }

    public ItemStackBuilder durability(int durability) {
        itemStack.setDurability((short) durability);

        return this;
    }

    public ItemStackBuilder owner(String owner) {
        SkullMeta skullMeta = (SkullMeta) itemMeta;
        skullMeta.setOwner(owner);

        itemStack.setItemMeta(skullMeta);

        return this;
    }

    public ItemStackBuilder enchantment(Enchantment enchantment, int value) {
        itemStack.addUnsafeEnchantment(enchantment, value);

        return this;
    }

    public ItemStackBuilder amount(int amount) {
        itemStack.setAmount(amount);

        return this;
    }

    public ItemStackBuilder glow() {
        itemStack.addEnchantment(Enchantment.DIG_SPEED, 1);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemStack.setItemMeta(itemMeta);

        return this;
    }

    public ItemStack build() {
        return itemStack;
    }

}