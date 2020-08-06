package com.permadeathcore.CustomMobs.v1_15_R1.PigmanJockeys;

import net.minecraft.server.v1_15_R1.EntityLiving;
import net.minecraft.server.v1_15_R1.PathfinderGoalMeleeAttack;

class UltraRavager$a extends PathfinderGoalMeleeAttack {
   // $FF: synthetic field
   final UltraRavager d;

   public UltraRavager$a(UltraRavager var1) {
      super(var1, 1.0D, true);
      this.d = var1;
   }

   protected double a(EntityLiving var1) {
      float var2 = this.d.getWidth() - 0.1F;
      return (double)(var2 * 2.0F * var2 * 2.0F + var1.getWidth());
   }
}
