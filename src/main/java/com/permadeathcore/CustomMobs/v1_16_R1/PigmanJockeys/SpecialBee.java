package com.permadeathcore.CustomMobs.v1_16_R1.PigmanJockeys;

import net.minecraft.server.v1_16_R1.EntityBee;
import net.minecraft.server.v1_16_R1.EntityHuman;
import net.minecraft.server.v1_16_R1.EntityTypes;
import net.minecraft.server.v1_16_R1.GenericAttributes;
import net.minecraft.server.v1_16_R1.NBTTagCompound;
import net.minecraft.server.v1_16_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_16_R1.PathfinderGoalNearestAttackableTarget;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.entity.Bee;

public class SpecialBee extends EntityBee {
   public SpecialBee(Location var1) {
      super(EntityTypes.BEE, ((CraftWorld)var1.getWorld()).getHandle());
      this.setPosition(var1.getX(), var1.getY(), var1.getZ());
      this.getAttributeInstance(GenericAttributes.MAX_HEALTH).setValue(100.0D);
      this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(12.0D);
      Bee var2 = (Bee)this.getBukkitEntity();
      var2.setHealth(100.0D);
      var2.setAnger(10000);
      var2.setRemoveWhenFarAway(true);
      this.goalSelector.a(0, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, true));
      this.targetSelector.a(0, new PathfinderGoalMeleeAttack(this, 1.0D, true));
   }

   public void saveData(NBTTagCompound var1) {
      super.saveData(var1);
      var1.setInt("anger", 100000);
   }
}
