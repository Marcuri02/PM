package com.permadeathcore.g.a.a.a;

import net.minecraft.server.v1_15_R1.EntityHuman;
import net.minecraft.server.v1_15_R1.EntityTurtle;
import net.minecraft.server.v1_15_R1.EntityTypes;
import net.minecraft.server.v1_15_R1.GenericAttributes;
import net.minecraft.server.v1_15_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_15_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_15_R1.World;

public class w extends EntityTurtle {
   private String a;

   public w(EntityTypes var1, World var2) {
      this(var2);
   }

   public w(World var1) {
      super(EntityTypes.TURTLE, var1);
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
