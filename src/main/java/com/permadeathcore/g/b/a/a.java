package com.permadeathcore.g.b.a;

import com.permadeathcore.Main;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import net.minecraft.server.v1_14_R1.AttributeInstance;
import net.minecraft.server.v1_14_R1.AttributeMapBase;
import net.minecraft.server.v1_14_R1.DamageSource;
import net.minecraft.server.v1_14_R1.EntityCreature;
import net.minecraft.server.v1_14_R1.EntityHuman;
import net.minecraft.server.v1_14_R1.EntityInsentient;
import net.minecraft.server.v1_14_R1.EntityLiving;
import net.minecraft.server.v1_14_R1.GenericAttributes;
import net.minecraft.server.v1_14_R1.IAttribute;
import net.minecraft.server.v1_14_R1.NBTTagCompound;
import net.minecraft.server.v1_14_R1.PathEntity;
import net.minecraft.server.v1_14_R1.PathfinderGoalAvoidTarget;
import net.minecraft.server.v1_14_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_14_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_14_R1.PathfinderGoalPanic;
import net.minecraft.server.v1_14_R1.PathfinderGoalSelector;
import net.minecraft.server.v1_14_R1.PathfinderGoalWrapped;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class a implements com.permadeathcore.g.b {
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
         net.minecraft.server.v1_14_R1.Entity var2 = ((CraftEntity)var1).getHandle();
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
      EntityInsentient var3 = this.g(var1);
      if (var3 != null) {
         IAttribute var4 = (IAttribute)var2;
         var3.getAttributeMap().b(var4);
      }
   }

   public void a(Object var1, Double var2, Entity var3) {
      EntityInsentient var4 = this.g(var3);
      if (var4 != null) {
         IAttribute var5 = (IAttribute)var1;
         var4.getAttributeInstance(var5).setValue(var2);
      }
   }

   public void a(Attribute var1, Double var2, Entity var3) {
      EntityInsentient var4 = (EntityInsentient)((CraftEntity)var3).getHandle();

      try {
         var4.getAttributeMap().b(this.b(var1));
      } catch (IllegalArgumentException var6) {
      }

      var4.getAttributeInstance(this.b(var1)).setValue(var2);
   }

   public void c(Entity var1) {
      EntityLiving var2 = (EntityLiving)((CraftEntity)var1).getHandle();

      try {
         Field var3 = EntityLiving.class.getDeclaredField("attributeMap");
         var3.setAccessible(true);
         var3.set(var2, (Object)null);
         Class var4 = ((CraftEntity)var1).getHandle().getClass();
         Method var5 = var4.getDeclaredMethod("initAttributes");
         var5.setAccessible(true);
         var5.invoke(((CraftEntity)var1).getHandle());
      } catch (Throwable var6) {
         var6.printStackTrace();
      }

   }

   public void a(Double var1, Double var2, Entity var3) {
   }

   public void a(HashMap var1, Entity var2) {
      EntityInsentient var3 = (EntityInsentient)((CraftEntity)var2).getHandle();

      Attribute var5;
      Double var6;
      for(Iterator var4 = var1.keySet().iterator(); var4.hasNext(); var3.getAttributeInstance(this.b(var5)).setValue(var6)) {
         var5 = (Attribute)var4.next();
         var6 = (Double)var1.get(var5);

         try {
            var3.getAttributeMap().b(this.b(var5));
         } catch (IllegalArgumentException var8) {
         }
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
            var6.a(GenericAttributes.ATTACK_DAMAGE).setValue(8.0D);
            var5.set(EntityLiving.class, var6);
         } catch (Throwable var7) {
         }
      }

   }

   public void d(Entity var1) {
      net.minecraft.server.v1_14_R1.Entity var2 = ((CraftEntity)var1).getHandle();
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
   }

   public void f(Entity var1) {
      net.minecraft.server.v1_14_R1.Entity var2 = ((CraftEntity)var1).getHandle();
      NBTTagCompound var3 = new NBTTagCompound();
      var3.setInt("Invul", 100);
      var2.save(var3);
   }

   public IAttribute b(Attribute var1) {
      IAttribute var2 = null;
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

      return var2;
   }

   public Class a(String var1) {
      try {
         return Class.forName("net.minecraft.server.v1_14_R1.Entity" + var1);
      } catch (ClassNotFoundException var3) {
         var3.printStackTrace();
         return null;
      }
   }

   public void a(Player var1, double var2) {
      net.minecraft.server.v1_14_R1.Entity var4 = ((CraftEntity)var1).getHandle();
      var4.damageEntity(DamageSource.DROWN, (float)var2);
   }

   public AttributeInstance c(Entity var1, Object var2) {
      return this.g(var1) == null ? null : this.g(var1).getAttributeInstance((IAttribute)var2);
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
