package com.permadeathcore.g.a.a.a;

import net.minecraft.server.v1_15_R1.EntityHuman;
import net.minecraft.server.v1_15_R1.EntitySnowman;
import net.minecraft.server.v1_15_R1.EntityTypes;
import net.minecraft.server.v1_15_R1.GenericAttributes;
import net.minecraft.server.v1_15_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_15_R1.World;

public class t extends EntitySnowman {
   private String a;

   public t(EntityTypes var1, World var2) {
      this(var2);
   }

   public t(World var1) {
      super(EntityTypes.SNOW_GOLEM, var1);
   }

   protected void initAttributes() {
      super.initAttributes();
      this.getAttributeMap().b(GenericAttributes.ATTACK_DAMAGE);
      this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(8.0D);
   }

   protected void initPathfinder() {
      super.initPathfinder();
      this.targetSelector.a(0, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, true));
   }
}
