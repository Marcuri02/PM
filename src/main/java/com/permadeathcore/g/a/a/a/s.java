package com.permadeathcore.g.a.a.a;

import net.minecraft.server.v1_15_R1.EntityHorseSkeleton;
import net.minecraft.server.v1_15_R1.EntityHuman;
import net.minecraft.server.v1_15_R1.EntityTypes;
import net.minecraft.server.v1_15_R1.GenericAttributes;
import net.minecraft.server.v1_15_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_15_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_15_R1.World;
import org.bukkit.Location;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class s extends EntityHorseSkeleton {
   private String a;

   public s(EntityTypes var1, World var2) {
      this(var2);
   }

   public s(World var1) {
      super(EntityTypes.SKELETON_HORSE, var1);
   }

   public void a(Location var1) {
      this.setPositionRotation(var1.getX(), var1.getY(), var1.getZ(), var1.getYaw(), var1.getPitch());
      this.world.addEntity(this, SpawnReason.CUSTOM);
   }

   protected void initAttributes() {
      super.initAttributes();
      this.getAttributeMap().b(GenericAttributes.ATTACK_DAMAGE);
      this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(8.0D);
   }

   protected void initPathfinder() {
      super.initPathfinder();
      this.goalSelector.a(0, new PathfinderGoalMeleeAttack(this, 1.0D, true));
      this.targetSelector.a(0, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, true));
   }
}
