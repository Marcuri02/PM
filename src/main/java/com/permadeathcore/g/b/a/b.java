package com.permadeathcore.g.b.a;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import net.minecraft.server.v1_15_R1.AttributeInstance;
import net.minecraft.server.v1_15_R1.AttributeMapBase;
import net.minecraft.server.v1_15_R1.AttributeMapServer;
import net.minecraft.server.v1_15_R1.DamageSource;
import net.minecraft.server.v1_15_R1.EntityCreature;
import net.minecraft.server.v1_15_R1.EntityHuman;
import net.minecraft.server.v1_15_R1.EntityInsentient;
import net.minecraft.server.v1_15_R1.EntityLiving;
import net.minecraft.server.v1_15_R1.GenericAttributes;
import net.minecraft.server.v1_15_R1.IAttribute;
import net.minecraft.server.v1_15_R1.NBTTagCompound;
import net.minecraft.server.v1_15_R1.PathEntity;
import net.minecraft.server.v1_15_R1.PathfinderGoal;
import net.minecraft.server.v1_15_R1.PathfinderGoalAvoidTarget;
import net.minecraft.server.v1_15_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_15_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_15_R1.PathfinderGoalPanic;
import net.minecraft.server.v1_15_R1.PathfinderGoalSelector;
import net.minecraft.server.v1_15_R1.PathfinderGoalWrapped;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_15_R1.attribute.CraftAttributeMap;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;

public class b implements com.permadeathcore.g.b {
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
         net.minecraft.server.v1_15_R1.Entity var2 = ((CraftEntity)var1).getHandle();
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
      if (var3 instanceof LivingEntity) {
         net.minecraft.server.v1_15_R1.Entity var4 = ((CraftEntity)var3).getHandle();
         if (!(var4 instanceof EntityInsentient)) {
            return;
         }

         EntityInsentient var5 = (EntityInsentient)var4;

         try {
            var5.getAttributeMap().b(this.b(var1));
         } catch (IllegalArgumentException var7) {
         }

         var5.getAttributeInstance(this.b(var1)).setValue(var2);
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
      try {
         Field var1 = EntityLiving.class.getDeclaredField("attributeMap");
         var1.setAccessible(true);
         AttributeMapBase var2 = (AttributeMapBase)var1.get((Object)null);
         var2.b(GenericAttributes.ATTACK_DAMAGE);
         var1.set((Object)null, var2);
      } catch (Throwable var3) {
      }

   }

   public void c(Entity var1) {
      if (var1 instanceof LivingEntity) {
         if (var1 instanceof Mob) {
            ((Mob)var1).setTarget((LivingEntity)null);
         }

         ((LivingEntity)var1).setAI(false);
         EntityLiving var2 = (EntityLiving)((CraftEntity)var1).getHandle();

         try {
            Field var3 = EntityLiving.class.getDeclaredField("attributeMap");
            var3.setAccessible(true);
            AttributeMapServer var4 = new AttributeMapServer();
            var4.b(GenericAttributes.MAX_HEALTH);
            var4.b(GenericAttributes.KNOCKBACK_RESISTANCE);
            var4.b(GenericAttributes.MOVEMENT_SPEED);
            var4.b(GenericAttributes.ARMOR);
            var4.b(GenericAttributes.ARMOR_TOUGHNESS);
            if (var2 instanceof EntityInsentient) {
               var4.b(GenericAttributes.FOLLOW_RANGE).setValue(15.0D);
               var4.b(GenericAttributes.ATTACK_KNOCKBACK);
            }

            var4.a(GenericAttributes.MAX_HEALTH).setValue(((LivingEntity)var1).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            if (((LivingEntity)var1).getAttribute(Attribute.GENERIC_ARMOR) != null) {
               var4.a(GenericAttributes.ARMOR).setValue(((LivingEntity)var1).getAttribute(Attribute.GENERIC_ARMOR).getValue());
            }

            if (((LivingEntity)var1).getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS) != null) {
               var4.a(GenericAttributes.ARMOR_TOUGHNESS).setValue(((LivingEntity)var1).getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).getValue());
            }

            var4.a(GenericAttributes.MOVEMENT_SPEED).setValue(((LivingEntity)var1).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getValue());
            var4.a(GenericAttributes.FOLLOW_RANGE).setValue(((LivingEntity)var1).getAttribute(Attribute.GENERIC_FOLLOW_RANGE).getValue());
            if (((LivingEntity)var1).getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE) != null) {
               var4.a(GenericAttributes.KNOCKBACK_RESISTANCE).setValue(((LivingEntity)var1).getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE) == null ? 1.0D : ((LivingEntity)var1).getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).getValue());
            }

            if (((LivingEntity)var1).getAttribute(Attribute.GENERIC_FLYING_SPEED) != null) {
               var4.b(GenericAttributes.FLYING_SPEED);
               var4.a(GenericAttributes.FLYING_SPEED).setValue(((LivingEntity)var1).getAttribute(Attribute.GENERIC_FLYING_SPEED).getValue());
            }

            CraftAttributeMap var5 = new CraftAttributeMap(var4);
            var3.set(var2, var4);
            Field var6 = EntityLiving.class.getDeclaredField("craftAttributes");
            var6.setAccessible(true);
            var6.set(var2, var5);
         } catch (Throwable var7) {
            var7.printStackTrace();
         }

         ((LivingEntity)var1).setAI(true);
      }
   }

   public void d(Entity var1) {
      net.minecraft.server.v1_15_R1.Entity var2 = ((CraftEntity)var1).getHandle();
      EntityType var3 = var1.getType();
      PathfinderGoalSelector var5;
      Field var6;
      Set var7;
      if (var2 instanceof EntityCreature) {
         EntityCreature var4 = (EntityCreature)((CraftEntity)var1).getHandle();
         var5 = var4.goalSelector;

         try {
            if (var3 == EntityType.LLAMA || var3 == EntityType.PANDA) {
               return;
            }

            var6 = PathfinderGoalSelector.class.getDeclaredField("d");
            var6.setAccessible(true);
            var7 = (Set)var6.get(var5);
            boolean var8 = false;
            Iterator var9 = var7.iterator();

            while(var9.hasNext()) {
               PathfinderGoalWrapped var10 = (PathfinderGoalWrapped)var9.next();
               Field var11 = var10.getClass().getDeclaredField("a");
               var11.setAccessible(true);
               PathfinderGoal var12 = (PathfinderGoal)var11.get(var10);
               if (var12.getClass().getName().equalsIgnoreCase(PathfinderGoalAvoidTarget.class.getName())) {
                  var7.remove(var12);
               }

               if (var12.getClass().getName().equalsIgnoreCase(PathfinderGoalPanic.class.getName())) {
                  var7.remove(var12);
               }

               if (var12.getClass().getName().equalsIgnoreCase(PathfinderGoalMeleeAttack.class.getName())) {
                  var8 = true;
               }
            }

            if (!var8) {
               var7.add(new PathfinderGoalWrapped(0, new PathfinderGoalMeleeAttack(var4, 1.0D, true)));
            }

            var6.set(var5, var7);
         } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var14) {
            var14.printStackTrace();
         }
      }

      if (var2 instanceof EntityInsentient) {
         EntityInsentient var15 = (EntityInsentient)((CraftEntity)var1).getHandle();
         var5 = var15.targetSelector;

         try {
            var6 = PathfinderGoalSelector.class.getDeclaredField("d");
            var6.setAccessible(true);
            var7 = (Set)var6.get(var5);
            var7.add(new PathfinderGoalWrapped(0, new PathfinderGoalNearestAttackableTarget(var15, EntityHuman.class, true)));
            var6.set(var5, var7);
         } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var13) {
            var13.printStackTrace();
         }
      }

   }

   public void e(Entity var1) {
      net.minecraft.server.v1_15_R1.Entity var2 = ((CraftEntity)var1).getHandle();
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
         } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var14) {
            var14.printStackTrace();
         }
      }

      if (var2 instanceof EntityInsentient) {
         EntityInsentient var15 = (EntityInsentient)((CraftEntity)var1).getHandle();
         var5 = var15.targetSelector;

         try {
            var6 = PathfinderGoalSelector.class.getDeclaredField("d");
            var6.setAccessible(true);
            var7 = (Set)var6.get(var5);
            if (var7 != null) {
               try {
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
               } catch (Throwable var12) {
               }
            }

            var6.set(var5, var7);
         } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var13) {
            var13.printStackTrace();
         }
      }

   }

   public void f(Entity var1) {
      net.minecraft.server.v1_15_R1.Entity var2 = ((CraftEntity)var1).getHandle();
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
         return Class.forName("net.minecraft.server.v1_15_R1.Entity" + var1);
      } catch (ClassNotFoundException var3) {
         var3.printStackTrace();
         return null;
      }
   }

   public void a(Player var1, double var2) {
      net.minecraft.server.v1_15_R1.Entity var4 = ((CraftEntity)var1).getHandle();
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
