package com.permadeathcore.CustomMobs.v1_15_R1.PigmanJockeys;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Random;
import net.minecraft.server.v1_15_R1.EntityHuman;
import net.minecraft.server.v1_15_R1.EntityPig;
import net.minecraft.server.v1_15_R1.EntityTypes;
import net.minecraft.server.v1_15_R1.GenericAttributes;
import net.minecraft.server.v1_15_R1.PathfinderGoalFloat;
import net.minecraft.server.v1_15_R1.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_15_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_15_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_15_R1.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_15_R1.PathfinderGoalRandomStrollLand;
import net.minecraft.server.v1_15_R1.PathfinderGoalSelector;
import net.minecraft.server.v1_15_R1.PathfinderGoal.Type;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.entity.Pig;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpecialPig extends EntityPig {
   public SpecialPig(Location var1) {
      super(EntityTypes.PIG, ((CraftWorld)var1.getWorld()).getHandle());
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
      } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var12) {
         var12.printStackTrace();
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
      } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var11) {
         var11.printStackTrace();
      }

      this.getAttributeMap().b(GenericAttributes.ATTACK_DAMAGE);
      this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(40.0D);
      this.goalSelector.a(0, new PathfinderGoalFloat(this));
      this.goalSelector.a(1, new PathfinderGoalRandomStrollLand(this, 1.0D));
      this.goalSelector.a(2, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
      this.goalSelector.a(3, new PathfinderGoalRandomLookaround(this));
      this.goalSelector.a(4, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, true));
      this.targetSelector.a(0, new PathfinderGoalMeleeAttack(this, 1.0D, true));
      ArrayList var13 = new ArrayList();
      Pig var14 = (Pig)this.getBukkitEntity();
      var13.add("SPEED");
      var13.add("REGENERATION");
      var13.add("INCREASE_DAMAGE");
      var13.add("INVISIBILITY");
      var13.add("JUMP");
      var13.add("SLOW_FALLING");
      var13.add("GLOWING");
      var13.add("DAMAGE_RESISTANCE");

      for(int var15 = 0; var15 < 5; ++var15) {
         Random var7 = new Random();
         int var8 = var7.nextInt(var13.size());
         String var9 = (String)var13.get(var8);
         byte var10;
         if (var9.equals("SPEED")) {
            var10 = 2;
            var14.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999999, var10));
         }

         if (var9.equals("REGENERATION")) {
            var10 = 3;
            var14.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 9999999, var10));
         }

         if (var9.equals("INCREASE_DAMAGE")) {
            var10 = 3;
            var14.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, var10));
         }

         if (var9.equals("INVISIBILITY")) {
            var10 = 0;
            var14.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 9999999, var10));
         }

         if (var9.equals("JUMP")) {
            var10 = 4;
            var14.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 9999999, var10));
         }

         if (var9.equals("SLOW_FALLING")) {
            var10 = 0;
            var14.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 9999999, var10));
         }

         if (var9.equals("GLOWING")) {
            var10 = 0;
            var14.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 9999999, var10));
         }

         if (var9.equals("DAMAGE_RESISTANCE")) {
            var10 = 2;
            var14.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 9999999, var10));
         }
      }

   }
}
