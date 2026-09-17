package com.example.immortalarmor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
    public static Item HELMET, CHESTPLATE, LEGGINGS, BOOTS;

    public static void register() {
        ItemArmor.ArmorMaterial mat = ItemArmor.ArmorMaterial.DIAMOND;
        HELMET = new ImmortalArmorItem(mat, EntityEquipmentSlot.HEAD, "helmet");
        CHESTPLATE = new ImmortalArmorItem(mat, EntityEquipmentSlot.CHEST, "chestplate");
        LEGGINGS = new ImmortalArmorItem(mat, EntityEquipmentSlot.LEGS, "leggings");
        BOOTS = new ImmortalArmorItem(mat, EntityEquipmentSlot.FEET, "boots");

        GameRegistry.registerAll(HELMET, CHESTPLATE, LEGGINGS, BOOTS);
    }
}
