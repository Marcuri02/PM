package com.permadeathcore.CustomMobs.v1_16_R1;

import net.minecraft.server.v1_16_R1.EntityCod;
import net.minecraft.server.v1_16_R1.EntityHuman;
import net.minecraft.server.v1_16_R1.EntityTypes;
import net.minecraft.server.v1_16_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_16_R1.PathfinderGoalNearestAttackableTarget;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;

public class CustomCod extends EntityCod {
   public CustomCod(Location var1) {
      super(EntityTypes.COD, ((CraftWorld)var1.getWorld()).getHandle());
      this.setPosition(var1.getX(), var1.getY(), var1.getZ());
   }

   public void initPathfinder() {
      super.initPathfinder();
      this.goalSelector.a(0, new PathfinderGoalMeleeAttack(this, 1.0D, true));
      this.targetSelector.a(1, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, true));
   }
}
