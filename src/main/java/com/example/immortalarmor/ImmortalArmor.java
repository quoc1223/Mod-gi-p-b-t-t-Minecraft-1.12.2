package com.example.immortalarmor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ImmortalArmor.MODID, name = "Immortal Armor", version = "1.0.0")
public class ImmortalArmor {
    public static final String MODID = "immortalarmor";
    public static final CreativeTabs TAB = new CreativeTabs(MODID) {
        @Override public Item getTabIconItem() { return ModItems.CHESTPLATE; }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.register();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new SurvivalHandler());
    }
}
