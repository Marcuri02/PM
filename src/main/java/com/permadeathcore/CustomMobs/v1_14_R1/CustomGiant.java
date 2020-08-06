package com.permadeathcore.CustomMobs.v1_14_R1;

import net.minecraft.server.v1_14_R1.DamageSource;
import net.minecraft.server.v1_14_R1.EntityGiantZombie;
import net.minecraft.server.v1_14_R1.EntityHuman;
import net.minecraft.server.v1_14_R1.EntityTypes;
import net.minecraft.server.v1_14_R1.GenericAttributes;
import net.minecraft.server.v1_14_R1.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_14_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_14_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_14_R1.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_14_R1.PathfinderGoalRandomStrollLand;
import net.minecraft.server.v1_14_R1.SoundEffect;
import net.minecraft.server.v1_14_R1.SoundEffects;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_14_R1.CraftWorld;
import org.bukkit.entity.Giant;

public class CustomGiant extends EntityGiantZombie {
   public CustomGiant(Location var1) {
      super(EntityTypes.GIANT, ((CraftWorld)var1.getWorld()).getHandle());
      this.setPosition(var1.getX(), var1.getY(), var1.getZ());
      this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(2000.0D);
      this.getAttributeInstance(GenericAttributes.MAX_HEALTH).setValue(600.0D);
      Giant var2 = (Giant)this.getBukkitEntity();
      var2.setHealth(600.0D);
      this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
      this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
      this.goalSelector.a(7, new PathfinderGoalRandomStrollLand(this, 1.0D));
      this.targetSelector.a(0, new PathfinderGoalMeleeAttack(this, 1.0D, true));
      this.targetSelector.a(1, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, true));
   }

   protected SoundEffect getSoundAmbient() {
      return SoundEffects.ENTITY_ZOMBIE_AMBIENT;
   }

   protected SoundEffect getSoundHurt(DamageSource var1) {
      return SoundEffects.ENTITY_ZOMBIE_HURT;
   }

   protected SoundEffect getSoundDeath() {
      return SoundEffects.ENTITY_ZOMBIE_DEATH;
   }
}
