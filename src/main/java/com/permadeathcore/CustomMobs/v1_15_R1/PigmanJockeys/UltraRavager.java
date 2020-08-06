package com.permadeathcore.CustomMobs.v1_15_R1.PigmanJockeys;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import net.minecraft.server.v1_15_R1.EntityHuman;
import net.minecraft.server.v1_15_R1.EntityInsentient;
import net.minecraft.server.v1_15_R1.EntityRaider;
import net.minecraft.server.v1_15_R1.EntityRavager;
import net.minecraft.server.v1_15_R1.EntityTypes;
import net.minecraft.server.v1_15_R1.PathfinderGoalFloat;
import net.minecraft.server.v1_15_R1.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_15_R1.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_15_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_15_R1.PathfinderGoalRandomStrollLand;
import net.minecraft.server.v1_15_R1.PathfinderGoalSelector;
import net.minecraft.server.v1_15_R1.PathfinderGoal.Type;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;

public class UltraRavager extends EntityRavager {
   public UltraRavager(Location var1) {
      super(EntityTypes.RAVAGER, ((CraftWorld)var1.getWorld()).getHandle());
      this.setPosition(var1.getX(), var1.getY(), var1.getZ());
      PathfinderGoalSelector var2 = this.goalSelector;
      PathfinderGoalSelector var3 = this.targetSelector;

      Field var4;
      Field var5;
      Field var6;
      try {
         var4 = PathfinderGoalSelector.class.getDeclaredField("d");
         var4.setAccessible(true);
         var4.set(var2, new LinkedHashSet());
         var5 = PathfinderGoalSelector.class.getDeclaredField("c");
         var5.setAccessible(true);
         var5.set(var2, new EnumMap(Type.class));
         var6 = PathfinderGoalSelector.class.getDeclaredField("f");
         var6.setAccessible(true);
         var6.set(var2, EnumSet.noneOf(Type.class));
      } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var8) {
         var8.printStackTrace();
      }

      try {
         var4 = PathfinderGoalSelector.class.getDeclaredField("d");
         var4.setAccessible(true);
         var4.set(var3, new LinkedHashSet());
         var5 = PathfinderGoalSelector.class.getDeclaredField("c");
         var5.setAccessible(true);
         var5.set(var3, new EnumMap(Type.class));
         var6 = PathfinderGoalSelector.class.getDeclaredField("f");
         var6.setAccessible(true);
         var6.set(var3, EnumSet.noneOf(Type.class));
      } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var7) {
         var7.printStackTrace();
      }

      this.goalSelector.a(0, new PathfinderGoalFloat(this));
      this.goalSelector.a(5, new PathfinderGoalRandomStrollLand(this, 0.4D));
      this.goalSelector.a(6, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
      this.goalSelector.a(10, new PathfinderGoalLookAtPlayer(this, EntityInsentient.class, 8.0F));
      this.targetSelector.a(2, (new PathfinderGoalHurtByTarget(this, new Class[]{EntityRaider.class})).a(new Class[0]));
      this.goalSelector.a(1, new UltraRavager$a(this));
      this.targetSelector.a(0, new PathfinderGoalMeleeAttack(this, 1.0D, true));
   }
}
