package com.example.immortalarmor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.List;

public class SurvivalHandler {

    private boolean isWearingFullSet(EntityPlayer player) {
        for (ItemStack stack : player.getArmorInventoryList()) {
            if (stack.isEmpty() || !(stack.getItem() instanceof ImmortalArmorItem)) {
                return false;
            }
        }
        return true;
    }

    @SubscribeEvent
    public void onLivingAttack(LivingAttackEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            if (isWearingFullSet(player)) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void onLivingDamage(LivingDamageEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            if (isWearingFullSet(player)) {
                event.setCanceled(true);
                event.setAmount(0.0F);
            }
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;
        if (player.world.isRemote) return;

        if (isWearingFullSet(player)) {
            // Khả năng bay Creative
            player.capabilities.allowFlying = true;

            // Hồi phục toàn bộ máu & xóa sạch hiệu ứng xấu (Parasite debuff)
            player.setHealth(player.getMaxHealth());
            player.clearActivePotions();

            // Đẩy lùi quái/ký sinh trùng xung quanh bán kính 6 ô
            List<Entity> nearbyEntities = player.world.getEntitiesWithinAABBExcludingEntity(player, player.getEntityBoundingBox().grow(6.0D));
            for (Entity entity : nearbyEntities) {
                double dx = entity.posX - player.posX;
                double dz = entity.posZ - player.posZ;
                entity.addVelocity(dx * 0.2D, 0.2D, dz * 0.2D);
            }
        }
    }
}
