package com.permadeathcore.h;

import com.permadeathcore.Main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.EnderDragon.Phase;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class a extends BukkitRunnable {
   private Entity k;
   private boolean l;
   private Main m;
   int a = 30;
   int b = 20;
   private Map n = new HashMap();
   private boolean o = false;
   boolean c = false;
   int d = 5;
   c e = null;
   boolean f = false;
   int g = 5;
   int h = 20;
   boolean i = false;
   int j = 15;
   private com.permadeathcore.b.a.a p;
   private com.permadeathcore.b.a.b q;
   private boolean r;
   private Location s;
   private boolean t;

   public a(Main var1, Entity var2) {
      this.p = com.permadeathcore.b.a.a.f;
      this.q = com.permadeathcore.b.a.b.b;
      this.r = true;
      this.t = false;
      this.m = var1;
      this.l = false;
      this.k = var2;
      ((LivingEntity)var2).getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue((double)Main.a.getConfig().getInt("Toggles.End.PermadeathDemon.Health"));
      ((LivingEntity)var2).setHealth((double)Main.a.getConfig().getInt("Toggles.End.PermadeathDemon.Health"));
      Location var3 = new Location(this.m.i, 0.0D, 0.0D, 0.0D);
      Location var4 = this.m.i.getHighestBlockAt(var3).getLocation();
      this.s = var4.add(0.0D, 2.0D, 0.0D);
      this.s.setPitch(var2.getLocation().getPitch());
      Iterator var5 = var2.getWorld().getEntities().iterator();

      while(var5.hasNext()) {
         Entity var6 = (Entity)var5.next();
         if (var6 instanceof Ghast) {
            var6.remove();
         }
      }

   }

   public void run() {
      if (!this.l && !this.k.isDead()) {
         if (this.j > 0) {
            --this.j;
         } else {
            this.m.k().b().set("DecoratedEndSpawn", true);
            this.m.k().e();
            this.m.k().f();
         }

         --this.a;
         Location var2;
         EnderDragon var3;
         if (this.a == 0) {
            Location var1 = new Location(this.m.i, 0.0D, 0.0D, 0.0D);
            var2 = this.m.i.getHighestBlockAt(var1).getLocation();
            var3 = (EnderDragon)this.k;
            if (var3.getPhase() != Phase.DYING && !this.o && var3.getLocation().distance(var2) >= 15.0D) {
               TNTPrimed var4 = (TNTPrimed)this.k.getWorld().spawnEntity(this.k.getLocation().add(3.0D, 0.0D, -3.0D), EntityType.PRIMED_TNT);
               var4.setFuseTicks(60);
               var4.setYield(var4.getYield() * 2.0F);
               var4.setCustomName("dragontnt");
               var4.setCustomNameVisible(false);
               TNTPrimed var5 = (TNTPrimed)this.k.getWorld().spawnEntity(this.k.getLocation().add(3.0D, 0.0D, 3.0D), EntityType.PRIMED_TNT);
               var5.setFuseTicks(60);
               var5.setYield(var5.getYield() * 2.0F);
               var5.setCustomName("dragontnt");
               var5.setCustomNameVisible(false);
               TNTPrimed var6 = (TNTPrimed)this.k.getWorld().spawnEntity(this.k.getLocation().add(3.0D, 0.0D, 0.0D), EntityType.PRIMED_TNT);
               var6.setFuseTicks(60);
               var6.setYield(var6.getYield() * 2.0F);
               var6.setCustomName("dragontnt");
               var6.setCustomNameVisible(false);
               TNTPrimed var7 = (TNTPrimed)this.k.getWorld().spawnEntity(this.k.getLocation().add(-3.0D, 0.0D, 3.0D), EntityType.PRIMED_TNT);
               var7.setFuseTicks(60);
               var7.setYield(var7.getYield() * 2.0F);
               var7.setCustomName("dragontnt");
               var7.setCustomNameVisible(false);
               TNTPrimed var8 = (TNTPrimed)this.k.getWorld().spawnEntity(this.k.getLocation().add(-3.0D, 0.0D, -3.0D), EntityType.PRIMED_TNT);
               var8.setFuseTicks(60);
               var8.setYield(var8.getYield() * 2.0F);
               var8.setCustomName("dragontnt");
               var8.setCustomNameVisible(false);
               TNTPrimed var9 = (TNTPrimed)this.k.getWorld().spawnEntity(this.k.getLocation().add(-3.0D, 0.0D, 0.0D), EntityType.PRIMED_TNT);
               var9.setFuseTicks(60);
               var9.setYield(var9.getYield() * 2.0F);
               var9.setCustomName("dragontnt");
               var9.setCustomNameVisible(false);
            }

            this.a = 30;
         }

         Iterator var10;
         Player var12;
         if (this.c) {
            if (this.d >= 1) {
               this.r = false;
               --this.d;
               var10 = this.m.i.getPlayers().iterator();

               while(var10.hasNext()) {
                  var12 = (Player)var10.next();
                  this.m.i.strikeLightning(var12.getLocation());
                  if (this.q == com.permadeathcore.b.a.b.a) {
                     var12.damage(1.0D);
                  }
               }
            } else {
               this.c = false;
               this.d = 5;
               this.r = true;
            }
         }

         if (this.f) {
            if (this.g >= 1) {
               --this.g;
            } else {
               var10 = this.m.i.getPlayers().iterator();

               while(var10.hasNext()) {
                  var12 = (Player)var10.next();
                  Location var13;
                  AreaEffectCloud var15;
                  if (this.q == com.permadeathcore.b.a.b.b) {
                     var13 = this.m.i.getHighestBlockAt(var12.getLocation()).getLocation().add(0.0D, 1.0D, 0.0D);
                     var15 = (AreaEffectCloud)this.m.i.spawnEntity(var13, EntityType.AREA_EFFECT_CLOUD);
                     var15.setParticle(Particle.DAMAGE_INDICATOR);
                     var15.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 100, 1), false);
                     var15.setRadius(3.0F);
                  } else {
                     var13 = this.m.i.getHighestBlockAt(var12.getLocation()).getLocation();
                     var15 = (AreaEffectCloud)this.m.i.spawnEntity(var13, EntityType.AREA_EFFECT_CLOUD);
                     var15.setParticle(Particle.DAMAGE_INDICATOR);
                     var15.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 100, 1), false);
                     var15.setRadius(3.0F);
                  }
               }

               this.f = false;
               this.r = true;
            }
         }

         int var11;
         for(var11 = this.m.i.getMaxHeight() - 1; this.m.i.getBlockAt(0, var11, 0).getType() != Material.BEDROCK && var11 > 0; --var11) {
         }

         var2 = new Location(this.m.i, 0.0D, (double)var11, 0.0D);
         if (this.k.getLocation().distance(var2) >= 10.0D && this.t) {
            this.t = false;
         }

         int var14;
         if (this.k.getLocation().distance(var2) <= 3.0D && !this.t) {
            this.t = true;
            this.k.setRotation(this.k.getLocation().getPitch(), 0.0F);
            var14 = (int)(Math.random() * 100.0D) + 1;
            if (var14 <= 80) {
               this.h();
            }
         }

         if (this.o) {
            this.r = false;
            if (this.h >= 1) {
               --this.h;
            }

            if (this.h >= 16) {
               var3 = (EnderDragon)this.k;
               if (var3.getPhase() != Phase.LAND_ON_PORTAL) {
                  var3.setPhase(Phase.LAND_ON_PORTAL);
               }

               var3.teleport(this.s);
            }

            if (this.h == 15) {
               this.e = new c(this.m, (EnderDragon)this.k, this.s);
               this.e.runTaskTimer(this.m, 5L, 5L);
            }

            if (this.h == 0) {
               if (this.e != null) {
                  this.e.cancel();
                  this.e = null;
               }

               this.r = true;
               this.h = 20;
               this.o = false;
               this.i = false;
               var3 = (EnderDragon)this.k;
               var3.setPhase(Phase.LEAVE_PORTAL);
            }
         }

         Iterator var17;
         Entity var20;
         if (this.b >= 1) {
            --this.b;
         } else if (this.b == 0) {
            if (this.i() == com.permadeathcore.b.a.b.b) {
               this.b = 60;
            } else {
               this.b = 40;
            }

            if (this.r) {
               this.a();
            } else {
               this.p = com.permadeathcore.b.a.a.f;
            }

            if (this.p == com.permadeathcore.b.a.a.f) {
               return;
            }

            if (this.p == com.permadeathcore.b.a.a.b) {
               var14 = 0;
               ArrayList var16 = new ArrayList();
               var17 = this.m.i.getEntities().iterator();

               while(var17.hasNext()) {
                  var20 = (Entity)var17.next();
                  if (var20 instanceof Enderman) {
                     Enderman var23 = (Enderman)var20;
                     Location var26 = var23.getLocation();
                     var26.setY(0.0D);
                     if (var2.distance(var26) <= 35.0D && var14 < 4) {
                        ++var14;
                        var16.add(var23);
                     }
                  }
               }

               if (!var16.isEmpty()) {
                  var17 = var16.iterator();

                  while(var17.hasNext()) {
                     Enderman var21 = (Enderman)var17.next();
                     AreaEffectCloud var24 = (AreaEffectCloud)this.m.i.spawnEntity(this.m.i.getHighestBlockAt(var21.getLocation()).getLocation().add(0.0D, 1.0D, 0.0D), EntityType.AREA_EFFECT_CLOUD);
                     var24.setRadius(10.0F);
                     var24.setParticle(Particle.VILLAGER_HAPPY);
                     var24.setColor(Color.GREEN);
                     var24.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 0), false);
                     var21.setInvulnerable(true);
                  }
               }
            } else if (this.p == com.permadeathcore.b.a.a.a) {
               this.c = true;
               this.d = 5;
            } else if (this.p == com.permadeathcore.b.a.a.d) {
               this.f = true;
               this.g = 5;
               Iterator var19 = this.m.i.getPlayers().iterator();

               while(var19.hasNext()) {
                  Player var18 = (Player)var19.next();
                  var18.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 140, 0));
               }
            }
         }

         if (this.q == com.permadeathcore.b.a.b.a) {
            var3 = (EnderDragon)this.k;
            var3.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 7));
            Main var10001 = this.m;
            var3.setCustomName(Main.a(this.m.getConfig().getString("Toggles.End.PermadeathDemon.DisplayNameEnraged")));
         } else {
            var3 = (EnderDragon)this.k;
            var3.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 5));
         }

         var14 = 0;
         new ArrayList();
         var17 = this.m.i.getEntities().iterator();

         while(var17.hasNext()) {
            var20 = (Entity)var17.next();
            if (var20 instanceof Enderman && var14 < 4) {
               var20.getWorld().strikeLightning(var20.getLocation().add(5.0D, 0.0D, 0.0D));
               ++var14;
            }
         }

         if (!this.n.isEmpty()) {
            var17 = this.n.keySet().iterator();

            while(var17.hasNext()) {
               Location var22 = (Location)var17.next();
               int var25 = (Integer)this.n.get(var22);
               if (var25 >= 1) {
                  this.n.replace(var22, var25, var25 - 1);
               } else {
                  var22.getWorld().spawnEntity(var22, EntityType.ENDER_CRYSTAL);
                  this.n.remove(var22);
                  if (var22.getWorld().getBlockAt(var22) != null) {
                     if (var22.getWorld().getBlockAt(var22).getType() == Material.BEDROCK || var22.getWorld().getBlockAt(var22).getType() == Material.AIR) {
                        return;
                     }

                     var22.getWorld().getBlockAt(var22).setType(Material.AIR);
                  }
               }
            }
         }

      } else {
         this.m.a((a)null);
         this.cancel();
      }
   }

   public void a() {
      int var1 = (new Random()).nextInt(25);
      if (var1 <= 3) {
         this.p = com.permadeathcore.b.a.a.a;
      } else if (var1 >= 4 && var1 <= 15) {
         this.p = com.permadeathcore.b.a.a.b;
      } else if (var1 >= 15 && var1 <= 25) {
         this.p = com.permadeathcore.b.a.a.d;
      }

   }

   public com.permadeathcore.b.a.a b() {
      return this.p;
   }

   public void c() {
      this.p = com.permadeathcore.b.a.a.f;
   }

   public Map d() {
      return this.n;
   }

   public void a(Entity var1) {
      this.k = var1;
   }

   public void a(boolean var1) {
      this.l = var1;
   }

   public Entity e() {
      return this.k;
   }

   public boolean f() {
      return this.l;
   }

   public Main g() {
      return this.m;
   }

   public void h() {
      this.o = true;
   }

   public com.permadeathcore.b.a.b i() {
      return this.q;
   }

   public void a(com.permadeathcore.b.a.b var1) {
      this.q = var1;
   }
}
