package com.example.immortalarmor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ImmortalArmorItem extends ItemArmor {
    public ImmortalArmorItem(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
        super(material, 0, slot);
        setRegistryName(ImmortalArmor.MODID, name);
        setTranslationKey(ImmortalArmor.MODID + "." + name);
        setCreativeTab(ImmortalArmor.TAB);
    }
}
