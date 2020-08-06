package com.permadeathcore.g.b.a;

import com.permadeathcore.Main;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import net.minecraft.server.v1_16_R1.AttributeBase;
import net.minecraft.server.v1_16_R1.AttributeMapBase;
import net.minecraft.server.v1_16_R1.AttributeModifiable;
import net.minecraft.server.v1_16_R1.AttributeProvider;
import net.minecraft.server.v1_16_R1.DamageSource;
import net.minecraft.server.v1_16_R1.EntityCreature;
import net.minecraft.server.v1_16_R1.EntityHuman;
import net.minecraft.server.v1_16_R1.EntityInsentient;
import net.minecraft.server.v1_16_R1.EntityLiving;
import net.minecraft.server.v1_16_R1.GenericAttributes;
import net.minecraft.server.v1_16_R1.NBTTagCompound;
import net.minecraft.server.v1_16_R1.PathEntity;
import net.minecraft.server.v1_16_R1.PathfinderGoal;
import net.minecraft.server.v1_16_R1.PathfinderGoalAvoidTarget;
import net.minecraft.server.v1_16_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_16_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_16_R1.PathfinderGoalPanic;
import net.minecraft.server.v1_16_R1.PathfinderGoalSelector;
import net.minecraft.server.v1_16_R1.PathfinderGoalWrapped;
import net.minecraft.server.v1_16_R1.AttributeProvider.Builder;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_16_R1.attribute.CraftAttributeMap;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class c implements com.permadeathcore.g.b {
   public void a(Entity var1, Double var2, boolean var3) {
      this.c(var1, GenericAttributes.MAX_HEALTH).setValue(var2);
      if (var3 && var1 instanceof LivingEntity) {
         ((LivingEntity)var1).setHealth(var2);
      }

   }

   public Double a(Entity var1) {
      return this.c(var1, GenericAttributes.MAX_HEALTH).getValue();
   }

   public EntityInsentient g(Entity var1) {
      if (var1 == null) {
         return null;
      } else {
         net.minecraft.server.v1_16_R1.Entity var2 = ((CraftEntity)var1).getHandle();
         if (var2 instanceof EntityInsentient) {
            EntityInsentient var3 = (EntityInsentient)var2;
            return var3;
         } else {
            return null;
         }
      }
   }

   public void a(Entity var1, Location var2, Double var3) {
      EntityInsentient var4 = this.g(var1);
      if (var4 != null) {
         PathEntity var5 = var4.getNavigation().a(var2.getX(), var2.getY(), var2.getZ(), 2);
         if (var5 != null) {
            var4.getNavigation().a(var5, var3);
         }

      }
   }

   public void b(Entity var1, Object var2) {
      if (var1 instanceof LivingEntity) {
         ((LivingEntity)var1).getAttribute((Attribute)var2).setBaseValue(5.0D);
      }

   }

   public void a(Object var1, Double var2, Entity var3) {
      if (var3 instanceof LivingEntity) {
         ((LivingEntity)var3).getAttribute((Attribute)var1).setBaseValue(var2);
      }

   }

   public void a(Attribute var1, Double var2, Entity var3) {
      EntityLiving var4 = (EntityLiving)((CraftEntity)var3).getHandle();

      try {
         Field var5 = EntityLiving.class.getDeclaredField("attributeMap");
         var5.setAccessible(true);
         AttributeProvider var6;
         if (var3.getType() != EntityType.BEE && var3.getType() != EntityType.PARROT) {
            var6 = EntityInsentient.p().a(GenericAttributes.FOLLOW_RANGE, var4.getAttributeInstance(GenericAttributes.FOLLOW_RANGE).getValue()).a(GenericAttributes.MOVEMENT_SPEED, var4.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).getValue()).a(GenericAttributes.MAX_HEALTH, var4.getAttributeInstance(GenericAttributes.MAX_HEALTH).getValue()).a(GenericAttributes.KNOCKBACK_RESISTANCE, var4.getAttributeInstance(GenericAttributes.KNOCKBACK_RESISTANCE).getValue()).a(GenericAttributes.ARMOR, var4.getAttributeInstance(GenericAttributes.ARMOR).getValue()).a(this.b(var1), var2).a();
         } else {
            var6 = EntityInsentient.p().a(GenericAttributes.FOLLOW_RANGE, var4.getAttributeInstance(GenericAttributes.FOLLOW_RANGE).getValue()).a(GenericAttributes.MOVEMENT_SPEED, var4.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).getValue()).a(GenericAttributes.FLYING_SPEED, var4.getAttributeInstance(GenericAttributes.FLYING_SPEED).getValue()).a(GenericAttributes.MAX_HEALTH, var4.getAttributeInstance(GenericAttributes.MAX_HEALTH).getValue()).a(GenericAttributes.KNOCKBACK_RESISTANCE, var4.getAttributeInstance(GenericAttributes.KNOCKBACK_RESISTANCE).getValue()).a(GenericAttributes.ARMOR, var4.getAttributeInstance(GenericAttributes.ARMOR).getValue()).a(this.b(var1), var2).a();
         }

         var5.set(var4, new AttributeMapBase(var6));
      } catch (Throwable var7) {
         throw new RuntimeException(var7);
      }
   }

   public void c(Entity var1) {
      EntityLiving var2 = (EntityLiving)((CraftEntity)var1).getHandle();

      try {
         Field var3 = EntityLiving.class.getDeclaredField("attributeMap");
         var3.setAccessible(true);
         AttributeProvider var4;
         if (var1.getType() != EntityType.BEE && var1.getType() != EntityType.PARROT) {
            var4 = EntityInsentient.p().a(GenericAttributes.FOLLOW_RANGE, var2.getAttributeInstance(GenericAttributes.FOLLOW_RANGE).getValue()).a(GenericAttributes.MOVEMENT_SPEED, var2.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).getValue()).a(GenericAttributes.MAX_HEALTH, var2.getAttributeInstance(GenericAttributes.MAX_HEALTH).getValue()).a(GenericAttributes.KNOCKBACK_RESISTANCE, var2.getAttributeInstance(GenericAttributes.KNOCKBACK_RESISTANCE).getValue()).a(GenericAttributes.ARMOR, var2.getAttributeInstance(GenericAttributes.ARMOR).getValue()).a();
         } else {
            var4 = EntityInsentient.p().a(GenericAttributes.FOLLOW_RANGE, var2.getAttributeInstance(GenericAttributes.FOLLOW_RANGE).getValue()).a(GenericAttributes.MOVEMENT_SPEED, var2.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).getValue()).a(GenericAttributes.FLYING_SPEED, var2.getAttributeInstance(GenericAttributes.FLYING_SPEED).getValue()).a(GenericAttributes.MAX_HEALTH, var2.getAttributeInstance(GenericAttributes.MAX_HEALTH).getValue()).a(GenericAttributes.KNOCKBACK_RESISTANCE, var2.getAttributeInstance(GenericAttributes.KNOCKBACK_RESISTANCE).getValue()).a(GenericAttributes.ARMOR, var2.getAttributeInstance(GenericAttributes.ARMOR).getValue()).a();
         }

         var3.set(var2, new AttributeMapBase(var4));
      } catch (Throwable var5) {
         var5.printStackTrace();
      }

   }

   public void a(Double var1, Double var2, Entity var3) {
      EntityLiving var4 = (EntityLiving)((CraftEntity)var3).getHandle();

      try {
         Field var5 = EntityLiving.class.getDeclaredField("attributeMap");
         var5.setAccessible(true);
         AttributeProvider var6;
         if (var3.getType() != EntityType.BEE && var3.getType() != EntityType.PARROT) {
            var6 = EntityInsentient.p().a(GenericAttributes.FOLLOW_RANGE, var4.getAttributeInstance(GenericAttributes.FOLLOW_RANGE).getValue()).a(GenericAttributes.MOVEMENT_SPEED, var4.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).getValue()).a(GenericAttributes.MAX_HEALTH, var4.getAttributeInstance(GenericAttributes.MAX_HEALTH).getValue()).a(GenericAttributes.KNOCKBACK_RESISTANCE, var4.getAttributeInstance(GenericAttributes.KNOCKBACK_RESISTANCE).getValue()).a(GenericAttributes.ARMOR, var4.getAttributeInstance(GenericAttributes.ARMOR).getValue()).a(GenericAttributes.ATTACK_KNOCKBACK, var1).a(GenericAttributes.ATTACK_DAMAGE, var2).a();
         } else {
            var6 = EntityInsentient.p().a(GenericAttributes.FOLLOW_RANGE, var4.getAttributeInstance(GenericAttributes.FOLLOW_RANGE).getValue()).a(GenericAttributes.MOVEMENT_SPEED, var4.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).getValue()).a(GenericAttributes.FLYING_SPEED, var4.getAttributeInstance(GenericAttributes.FLYING_SPEED).getValue()).a(GenericAttributes.MAX_HEALTH, var4.getAttributeInstance(GenericAttributes.MAX_HEALTH).getValue()).a(GenericAttributes.KNOCKBACK_RESISTANCE, var4.getAttributeInstance(GenericAttributes.KNOCKBACK_RESISTANCE).getValue()).a(GenericAttributes.ARMOR, var4.getAttributeInstance(GenericAttributes.ARMOR).getValue()).a(GenericAttributes.ATTACK_KNOCKBACK, var1).a(GenericAttributes.ATTACK_DAMAGE, var2).a();
         }

         var5.set(var4, new AttributeMapBase(var6));
      } catch (Throwable var7) {
         throw new RuntimeException(var7);
      }
   }

   public void a(HashMap var1, Entity var2) {
      EntityLiving var3 = (EntityLiving)((CraftEntity)var2).getHandle();

      try {
         Field var4 = EntityLiving.class.getDeclaredField("attributeMap");
         var4.setAccessible(true);
         AttributeMapBase var5 = (AttributeMapBase)var4.get(var3);
         Field var6 = AttributeMapBase.class.getDeclaredField("d");
         var6.setAccessible(true);
         AttributeProvider var7 = (AttributeProvider)var6.get(var5);
         Builder var8 = AttributeProvider.a();

         AttributeBase var11;
         for(Iterator var9 = var1.keySet().iterator(); var9.hasNext(); var8 = var8.a(var11, (Double)var1.get(var11))) {
            Attribute var10 = (Attribute)var9.next();
            var11 = this.b(var10);
         }

         AttributeProvider var15 = var8.a();
         var6.set(var5, var15);
         var4.set(var3, var5);
         Field var13 = EntityLiving.class.getDeclaredField("craftAttributes");
         var4.setAccessible(true);
         CraftAttributeMap var14 = new CraftAttributeMap(var5);
         var13.set(var3, var14);
      } catch (Throwable var12) {
         throw new RuntimeException(var12);
      }
   }

   public void a() {
      EntityType[] var1 = EntityType.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         EntityType var4 = var1[var3];
         if (Main.p().q().a(var4)) {
            return;
         }

         try {
            Field var5 = EntityLiving.class.getDeclaredField("attributeMap");
            var5.setAccessible(true);
            AttributeMapBase var6 = (AttributeMapBase)var5.get(EntityLiving.class);
            var6.b(GenericAttributes.ATTACK_DAMAGE);
            var5.set(EntityLiving.class, var6);
         } catch (Throwable var7) {
         }
      }

   }

   public void d(Entity var1) {
      net.minecraft.server.v1_16_R1.Entity var2 = ((CraftEntity)var1).getHandle();
      EntityType var3 = var1.getType();
      PathfinderGoalSelector var5;
      Field var6;
      Set var7;
      if (var2 instanceof EntityCreature) {
         EntityCreature var4 = (EntityCreature)((CraftEntity)var1).getHandle();
         var5 = var4.goalSelector;

         try {
            var6 = PathfinderGoalSelector.class.getDeclaredField("d");
            var6.setAccessible(true);
            var7 = (Set)var6.get(var5);
            boolean var8 = false;
            Iterator var9 = var7.iterator();

            while(var9.hasNext()) {
               PathfinderGoalWrapped var10 = (PathfinderGoalWrapped)var9.next();
               if (var10.getClass().getName().equalsIgnoreCase(PathfinderGoalAvoidTarget.class.getName())) {
                  var7.remove(var10);
               }

               if (var10.getClass().getName().equalsIgnoreCase(PathfinderGoalPanic.class.getName())) {
                  var7.remove(var10);
               }

               if (var10.getClass().getName().equalsIgnoreCase(PathfinderGoalMeleeAttack.class.getName())) {
                  var8 = true;
               }
            }

            if (!var8) {
               var7.add(new PathfinderGoalWrapped(0, new PathfinderGoalMeleeAttack(var4, 1.0D, true)));
            }

            var6.set(var5, var7);
         } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var12) {
            var12.printStackTrace();
         }
      }

      if (var2 instanceof EntityInsentient) {
         EntityInsentient var13 = (EntityInsentient)((CraftEntity)var1).getHandle();
         var5 = var13.targetSelector;

         try {
            var6 = PathfinderGoalSelector.class.getDeclaredField("d");
            var6.setAccessible(true);
            var7 = (Set)var6.get(var5);
            var7.add(new PathfinderGoalWrapped(0, new PathfinderGoalNearestAttackableTarget(var13, EntityHuman.class, true)));
            var6.set(var5, var7);
         } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var11) {
            var11.printStackTrace();
         }
      }

   }

   public void e(Entity var1) {
      net.minecraft.server.v1_16_R1.Entity var2 = ((CraftEntity)var1).getHandle();
      EntityType var3 = var1.getType();
      PathfinderGoalSelector var5;
      Field var6;
      Set var7;
      Iterator var8;
      PathfinderGoalWrapped var9;
      Field var10;
      PathfinderGoal var11;
      if (var2 instanceof EntityCreature) {
         EntityCreature var4 = (EntityCreature)((CraftEntity)var1).getHandle();
         var5 = var4.goalSelector;

         try {
            var6 = PathfinderGoalSelector.class.getDeclaredField("d");
            var6.setAccessible(true);
            var7 = (Set)var6.get(var5);
            var8 = var7.iterator();

            while(var8.hasNext()) {
               var9 = (PathfinderGoalWrapped)var8.next();
               var10 = var9.getClass().getDeclaredField("a");
               var10.setAccessible(true);
               var11 = (PathfinderGoal)var10.get(var9);
               if (var11.getClass().getName().equalsIgnoreCase(PathfinderGoalNearestAttackableTarget.class.getName())) {
                  var7.remove(var9);
               }
            }

            var6.set(var5, var7);
         } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var13) {
            var13.printStackTrace();
         }
      }

      if (var2 instanceof EntityInsentient) {
         EntityInsentient var14 = (EntityInsentient)((CraftEntity)var1).getHandle();
         var5 = var14.targetSelector;

         try {
            var6 = PathfinderGoalSelector.class.getDeclaredField("d");
            var6.setAccessible(true);
            var7 = (Set)var6.get(var5);
            var8 = var7.iterator();

            while(var8.hasNext()) {
               var9 = (PathfinderGoalWrapped)var8.next();
               var10 = var9.getClass().getDeclaredField("a");
               var10.setAccessible(true);
               var11 = (PathfinderGoal)var10.get(var9);
               if (var11.getClass().getName().equalsIgnoreCase(PathfinderGoalNearestAttackableTarget.class.getName())) {
                  var7.remove(var9);
               }
            }

            var6.set(var5, var7);
         } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var12) {
            var12.printStackTrace();
         }
      }

   }

   public void f(Entity var1) {
      net.minecraft.server.v1_16_R1.Entity var2 = ((CraftEntity)var1).getHandle();
      NBTTagCompound var3 = new NBTTagCompound();
      var3.setInt("Invul", 100);
      var2.save(var3);
      var2.load(var3);
   }

   public AttributeBase b(Attribute var1) {
      AttributeBase var2 = null;
      if (var1 == Attribute.GENERIC_ATTACK_DAMAGE) {
         var2 = GenericAttributes.ATTACK_DAMAGE;
      }

      if (var1 == Attribute.GENERIC_ARMOR_TOUGHNESS) {
         var2 = GenericAttributes.ARMOR_TOUGHNESS;
      }

      if (var1 == Attribute.GENERIC_ARMOR) {
         var2 = GenericAttributes.ARMOR;
      }

      if (var1 == Attribute.GENERIC_MAX_HEALTH) {
         var2 = GenericAttributes.MAX_HEALTH;
      }

      if (var1 == Attribute.GENERIC_KNOCKBACK_RESISTANCE) {
         var2 = GenericAttributes.KNOCKBACK_RESISTANCE;
      }

      if (var1 == Attribute.GENERIC_ATTACK_SPEED) {
         var2 = GenericAttributes.ATTACK_SPEED;
      }

      if (var1 == Attribute.GENERIC_FLYING_SPEED) {
         var2 = GenericAttributes.FLYING_SPEED;
      }

      if (var1 == Attribute.GENERIC_FOLLOW_RANGE) {
         var2 = GenericAttributes.FOLLOW_RANGE;
      }

      if (var1 == Attribute.GENERIC_MOVEMENT_SPEED) {
         var2 = GenericAttributes.MOVEMENT_SPEED;
      }

      if (var1 == Attribute.GENERIC_LUCK) {
         var2 = GenericAttributes.LUCK;
      }

      if (var1 == Attribute.HORSE_JUMP_STRENGTH) {
         var2 = GenericAttributes.JUMP_STRENGTH;
      }

      if (var1 == Attribute.ZOMBIE_SPAWN_REINFORCEMENTS) {
         var2 = GenericAttributes.SPAWN_REINFORCEMENTS;
      }

      return var2;
   }

   public Class a(String var1) {
      try {
         return Class.forName("net.minecraft.server.v1_16_R1.Entity" + var1);
      } catch (ClassNotFoundException var3) {
         var3.printStackTrace();
         return null;
      }
   }

   public void a(Player var1, double var2) {
      net.minecraft.server.v1_16_R1.Entity var4 = ((CraftEntity)var1).getHandle();
      var4.damageEntity(DamageSource.DROWN, (float)var2);
   }

   public AttributeModifiable c(Entity var1, Object var2) {
      return this.g(var1) == null ? null : this.g(var1).getAttributeInstance((AttributeBase)var2);
   }

   // $FF: synthetic method
   public Object a(Attribute var1) {
      return this.b(var1);
   }

   // $FF: synthetic method
   public Object b(Entity var1) {
      return this.g(var1);
   }

   // $FF: synthetic method
   public Object a(Entity var1, Object var2) {
      return this.c(var1, var2);
   }
}
