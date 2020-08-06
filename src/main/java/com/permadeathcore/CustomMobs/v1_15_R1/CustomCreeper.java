package com.permadeathcore.CustomMobs.v1_15_R1;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import net.minecraft.server.v1_15_R1.DamageSource;
import net.minecraft.server.v1_15_R1.EntityCreeper;
import net.minecraft.server.v1_15_R1.EntityDamageSourceIndirect;
import net.minecraft.server.v1_15_R1.EntityHuman;
import net.minecraft.server.v1_15_R1.EntityTypes;
import net.minecraft.server.v1_15_R1.EnumDirection;
import net.minecraft.server.v1_15_R1.IBlockData;
import net.minecraft.server.v1_15_R1.PathfinderGoalFloat;
import net.minecraft.server.v1_15_R1.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_15_R1.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_15_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_15_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_15_R1.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_15_R1.PathfinderGoalRandomStrollLand;
import net.minecraft.server.v1_15_R1.PathfinderGoalSelector;
import net.minecraft.server.v1_15_R1.PathfinderGoalSwell;
import net.minecraft.server.v1_15_R1.TagsFluid;
import net.minecraft.server.v1_15_R1.World;
import net.minecraft.server.v1_15_R1.BlockPosition.MutableBlockPosition;
import net.minecraft.server.v1_15_R1.PathfinderGoal.Type;

public class CustomCreeper extends EntityCreeper {
   private boolean a;

   public CustomCreeper(EntityTypes var1, World var2, boolean var3) {
      super(var1, var2);
      PathfinderGoalSelector var4 = this.goalSelector;
      PathfinderGoalSelector var5 = this.targetSelector;

      Field var6;
      Field var7;
      Field var8;
      try {
         var6 = PathfinderGoalSelector.class.getDeclaredField("d");
         var6.setAccessible(true);
         var6.set(var4, new LinkedHashSet());
         var7 = PathfinderGoalSelector.class.getDeclaredField("c");
         var7.setAccessible(true);
         var7.set(var4, new EnumMap(Type.class));
         var8 = PathfinderGoalSelector.class.getDeclaredField("f");
         var8.setAccessible(true);
         var8.set(var4, EnumSet.noneOf(Type.class));
      } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var10) {
         var10.printStackTrace();
      }

      try {
         var6 = PathfinderGoalSelector.class.getDeclaredField("d");
         var6.setAccessible(true);
         var6.set(var5, new LinkedHashSet());
         var7 = PathfinderGoalSelector.class.getDeclaredField("c");
         var7.setAccessible(true);
         var7.set(var5, new EnumMap(Type.class));
         var8 = PathfinderGoalSelector.class.getDeclaredField("f");
         var8.setAccessible(true);
         var8.set(var5, EnumSet.noneOf(Type.class));
      } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var9) {
         var9.printStackTrace();
      }

      this.goalSelector.a(1, new PathfinderGoalFloat(this));
      this.goalSelector.a(2, new PathfinderGoalSwell(this));
      this.goalSelector.a(3, new PathfinderGoalMeleeAttack(this, 1.0D, false));
      this.goalSelector.a(4, new PathfinderGoalRandomStrollLand(this, 0.8D));
      this.goalSelector.a(5, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
      this.goalSelector.a(5, new PathfinderGoalRandomLookaround(this));
      this.targetSelector.a(1, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, true));
      this.targetSelector.a(2, new PathfinderGoalHurtByTarget(this, new Class[0]));
      this.a = var3;
   }

   public boolean damageEntity(DamageSource var1, float var2) {
      if (this.isInvulnerable(var1)) {
         return false;
      } else if (!(var1 instanceof EntityDamageSourceIndirect) && var1 != DamageSource.FIREWORKS) {
         boolean var4 = super.damageEntity(var1, var2);
         if (!this.world.p_() && var1.ignoresArmor() && this.random.nextInt(10) != 0 && this.a) {
            this.a();
         }

         return var4;
      } else {
         for(int var3 = 0; var3 < 64; ++var3) {
            if (this.a()) {
               return true;
            }
         }

         return false;
      }
   }

   protected boolean a() {
      if (!this.world.p_() && this.isAlive()) {
         double var1 = this.locX() + (this.random.nextDouble() - 0.5D) * 64.0D;
         double var3 = this.locY() + (double)(this.random.nextInt(64) - 32);
         double var5 = this.locZ() + (this.random.nextDouble() - 0.5D) * 64.0D;
         return this.a(var1, var3, var5);
      } else {
         return false;
      }
   }

   private boolean a(double var1, double var3, double var5) {
      MutableBlockPosition var7 = new MutableBlockPosition(var1, var3, var5);

      while(var7.getY() > 0 && !this.world.getType(var7).getMaterial().isSolid()) {
         var7.c(EnumDirection.DOWN);
      }

      IBlockData var8 = this.world.getType(var7);
      boolean var9 = var8.getMaterial().isSolid();
      boolean var10 = var8.getFluid().a(TagsFluid.WATER);
      if (var9 && !var10) {
         boolean var11 = this.a(var1, var3, var5, true);
         return var11;
      } else {
         return false;
      }
   }
}
