package com.permadeathcore.c;

import com.permadeathcore.Main;
import com.permadeathcore.g.l;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Biome;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cod;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Evoker;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Golem;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Illager;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Monster;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Pillager;
import org.bukkit.entity.Player;
import org.bukkit.entity.PufferFish;
import org.bukkit.entity.Ravager;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Vex;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Vindicator;
import org.bukkit.entity.Witch;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class b implements Listener {
   private final Main b;
   private SplittableRandom c;
   private EntityType d;
   private Class e;
   private boolean f;

   public b(Main var1) {
      this.b = var1;
      this.c = new SplittableRandom();
      this.f = var1.getConfig().getBoolean("Toggles.Optimizar-Mob-Spawns");
      this.a();
      if (l.c()) {
         this.d = EntityType.valueOf("ZOMBIFIED_PIGLIN");
      } else {
         this.d = EntityType.valueOf("PIG_ZOMBIE");
      }

      this.e = this.d.getEntityClass();
   }

   private void a() {
      if (Main.a.o() >= 30L) {
         Iterator var1 = Bukkit.getWorlds().iterator();

         while(var1.hasNext()) {
            World var2 = (World)var1.next();
            Iterator var3 = var2.getEntities().iterator();

            while(var3.hasNext()) {
               Entity var4 = (Entity)var3.next();
               if (var4.getType() == EntityType.SQUID) {
                  Guardian var5 = (Guardian)var2.spawnEntity(var4.getLocation(), EntityType.GUARDIAN);
                  var5.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                  var4.remove();
               } else if (var4.getType() == EntityType.BAT) {
                  Blaze var6 = (Blaze)var2.spawnEntity(var4.getLocation(), EntityType.BLAZE);
                  var6.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 1));
                  var4.remove();
               } else if (var4.getType() == EntityType.PILLAGER) {
                  if (var4 instanceof Pillager) {
                     Pillager var7 = (Pillager)var4;
                     var7.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));
                     var7.getEquipment().setItemInMainHand((new com.permadeathcore.j.c.d(Material.CROSSBOW)).a(Enchantment.QUICK_CHARGE, 5).a());
                     var7.getEquipment().setItemInMainHandDropChance(0.0F);
                  }
               } else if (var4.getType() == EntityType.CREEPER) {
                  Creeper var8 = (Creeper)var4;
                  if (!var8.isPowered()) {
                     var8.setPowered(true);
                  }
               } else if (var4.getType() == this.d) {
                  LivingEntity var9 = (LivingEntity)var4;
                  if (var9.getEquipment().getArmorContents() == null) {
                     var9.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                     var9.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                     var9.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                     var9.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                  }
               } else if (var4.getType() == EntityType.IRON_GOLEM) {
                  IronGolem var10 = (IronGolem)var4;
                  if (!var10.hasPotionEffect(PotionEffectType.SPEED)) {
                     var10.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3));
                  }
               } else if (var4.getType() == EntityType.ENDERMAN) {
                  Enderman var11 = (Enderman)var4;
                  if (!var11.hasPotionEffect(PotionEffectType.SPEED)) {
                     var11.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
                  }
               } else if (var4.getType() == EntityType.SILVERFISH) {
                  var4.remove();
               }
            }
         }
      }

   }

   @EventHandler
   public void a(CreatureSpawnEvent var1) {
      if (var1.isCancelled()) {
         var1.getEntity().remove();
      } else {
         boolean var2 = Main.a.h.hasStorm();
         int var3 = ThreadLocalRandom.current().nextInt(-20, 21);
         int var4 = var1.getEntity().getLocation().getBlockX() + var3;
         int var5 = var1.getEntity().getLocation().getBlockZ() + var3;
         Location var6 = new Location(Main.a.h, (double)var4, 100.0D, (double)var5);
         int var7 = Bukkit.getServer().getOnlinePlayers().size();
         Random var8 = new Random();
         if (this.b.o() >= 1L && !var1.isCancelled() && var1.getEntity() instanceof Spider) {
            if (!var6.getChunk().isLoaded()) {
               return;
            }

            var6.setY((double)Main.a.h.getHighestBlockAt(var4, var5).getY());
            int var9;
            if (var7 > 1 && var7 < 5) {
               var9 = ThreadLocalRandom.current().nextInt(1, 41);
               if (var1.getEntity() instanceof Monster && Main.a.h.hasStorm() && var9 == 15) {
                  Main.a.h.strikeLightning(var6);
               }
            }

            if (var7 > 5 && var7 < 10) {
               var9 = ThreadLocalRandom.current().nextInt(1, 76);
               if (var1.getEntity() instanceof Monster && Main.a.h.hasStorm() && var9 == 32) {
                  Main.a.h.strikeLightning(var6);
               }
            }

            if (var7 > 10 && var7 < 15) {
               var9 = ThreadLocalRandom.current().nextInt(1, 81);
               if (var1.getEntity() instanceof Monster && Main.a.h.hasStorm() && var9 == 45) {
                  Main.a.h.strikeLightning(var6);
               }
            }

            if (var7 > 15 && var7 < 20) {
               var9 = ThreadLocalRandom.current().nextInt(1, 101);
               if (var1.getEntity() instanceof Monster && Main.a.h.hasStorm() && var9 == 35) {
                  Main.a.h.strikeLightning(var6);
               }
            }

            if (var7 > 20) {
               var9 = ThreadLocalRandom.current().nextInt(1, 151);
               if (var1.getEntity() instanceof Monster && Main.a.h.hasStorm() && var9 == 53) {
                  Main.a.h.strikeLightning(var6);
               }
            }

            if (var7 >= 1 && var7 < 5 && this.b.o() >= 10L && this.b.o() < 20L) {
               var9 = ThreadLocalRandom.current().nextInt(1, 71);
               if (var1.getEntity() instanceof Monster && Main.a.h.hasStorm() && var9 == 15) {
                  Main.a.h.strikeLightning(var6);
               }
            }

            if (var7 >= 5 && var7 < 10 && this.b.o() >= 10L && this.b.o() < 20L) {
               var9 = ThreadLocalRandom.current().nextInt(1, 141);
               if (var1.getEntity() instanceof Monster && Main.a.h.hasStorm() && var9 == 32) {
                  Main.a.h.strikeLightning(var6);
               }
            }

            if (var7 >= 10 && var7 < 15 && this.b.o() >= 10L && this.b.o() < 20L) {
               var9 = ThreadLocalRandom.current().nextInt(1, 181);
               if (var1.getEntity() instanceof Monster && Main.a.h.hasStorm() && var9 == 45) {
                  Main.a.h.strikeLightning(var6);
               }
            }

            if (var7 >= 15 && var7 < 20 && this.b.o() >= 10L && this.b.o() < 20L) {
               var9 = ThreadLocalRandom.current().nextInt(1, 221);
               if (var1.getEntity() instanceof Monster && Main.a.h.hasStorm() && var9 == 35) {
                  Main.a.h.strikeLightning(var6);
               }
            }

            if (var7 >= 20 && this.b.o() >= 10L && this.b.o() < 20L) {
               var9 = ThreadLocalRandom.current().nextInt(1, 151);
               if (var1.getEntity() instanceof Monster && Main.a.h.hasStorm() && var9 == 53) {
                  Main.a.h.strikeLightning(var6);
               }
            }
         }

         ArrayList var26 = new ArrayList();
         var26.add("SPEED");
         var26.add("REGENERATION");
         var26.add("INCREASE_DAMAGE");
         var26.add("INVISIBILITY");
         var26.add("JUMP");
         var26.add("SLOW_FALLING");
         var26.add("DAMAGE_RESISTANCE");
         if (this.b.o() < 50L) {
            var26.add("GLOWING");
         }

         int var10;
         int var11;
         int var12;
         if (this.b.o() >= 10L && var1.getEntity() instanceof Spider && Main.a.getConfig().getBoolean("Toggles.Spider-Effect")) {
            var10 = ThreadLocalRandom.current().nextInt(1, 3);
            if (this.b.o() >= 20L && this.b.o() < 25L) {
               var10 = ThreadLocalRandom.current().nextInt(3, 5);
            }

            if (this.b.o() >= 25L) {
               var10 = 4;
            }

            for(var11 = 0; var11 < var10; ++var11) {
               var12 = var8.nextInt(var26.size());
               String var13 = (String)var26.get(var12);
               byte var14;
               if (var13.equals("SPEED")) {
                  var14 = 2;
                  var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999999, var14));
               }

               if (var13.equals("REGENERATION")) {
                  var14 = 3;
                  var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 9999999, var14));
               }

               if (var13.equals("INCREASE_DAMAGE")) {
                  var14 = 3;
                  var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, var14));
               }

               if (var13.equals("INVISIBILITY")) {
                  var14 = 0;
                  var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 9999999, var14));
               }

               if (var13.equals("JUMP")) {
                  var14 = 4;
                  var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 9999999, var14));
               }

               if (var13.equals("SLOW_FALLING")) {
                  var14 = 0;
                  var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 9999999, var14));
               }

               if (var13.equals("GLOWING")) {
                  var14 = 0;
                  var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 9999999, var14));
               }

               if (var13.equals("DAMAGE_RESISTANCE")) {
                  var14 = 2;
                  var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 9999999, var14));
               }
            }
         }

         Main var10001;
         Ravager var25;
         EntityEquipment var30;
         int var50;
         if (this.b.o() >= 20L) {
            if (var1.getEntity() instanceof Phantom) {
               Phantom var21 = (Phantom)var1.getEntity();
               var21.setSize(9);
               this.b.n().a(var21, this.b.n().a((Entity)var21) * 2.0D, true);
               if (this.b.o() >= 40L) {
                  Skeleton var22 = (Skeleton)Main.a.f().a("Skeleton", EntityType.SKELETON, var1.getLocation(), SpawnReason.NATURAL);
                  var22.setCollidable(true);
                  var22.teleport(var21.getLocation());
                  var21.addPassenger(var22);
               }

               if (this.b.o() >= 50L) {
                  var21.setSize(18);
                  byte var24 = 1;
                  if (this.b.o() >= 60L) {
                     var24 = 25;
                  }

                  if (this.c.nextInt(100) + 1 <= var24) {
                     for(var12 = 0; var12 < 3; ++var12) {
                        Main.a.f().b(var1.getLocation(), SpawnReason.CUSTOM, true);
                     }
                  }
               }
            }

            if (var1.getEntityType() == this.d) {
               if (this.b.o() >= 60L) {
                  var1.setCancelled(true);
                  return;
               }

               LivingEntity var23 = var1.getEntity();

               try {
                  Method var27 = var23.getClass().getDeclaredMethod("setAngry", Boolean.TYPE);
                  var27.setAccessible(true);
                  var27.invoke(var23, true);
               } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException var20) {
                  var20.printStackTrace();
               }

               if (this.b.o() >= 30L && this.b.o() < 40L) {
                  var30 = var23.getEquipment();
                  var30.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                  var30.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                  var30.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                  var30.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
               }

               if (this.b.o() >= 40L) {
                  var11 = (new Random()).nextInt(99) + 1;
                  byte var28 = 5;
                  if (this.b.o() >= 50L) {
                     var28 = 20;
                  }

                  if (var1.getSpawnReason() == SpawnReason.CUSTOM) {
                     return;
                  }

                  EntityEquipment var31;
                  if (var11 <= var28) {
                     var31 = var23.getEquipment();
                     var50 = ThreadLocalRandom.current().nextInt(1, 6);
                     if (var50 == 1) {
                        this.c(var1);
                     }

                     ItemStack var15;
                     ItemStack var16;
                     ItemStack var17;
                     ItemStack var18;
                     if (var50 == 2) {
                        var15 = (new com.permadeathcore.j.c.e(Material.LEATHER_HELMET, 1)).a(Color.YELLOW).a();
                        var16 = (new com.permadeathcore.j.c.e(Material.LEATHER_CHESTPLATE, 1)).a(Color.YELLOW).a();
                        var17 = (new com.permadeathcore.j.c.e(Material.LEATHER_LEGGINGS, 1)).a(Color.YELLOW).a();
                        var18 = (new com.permadeathcore.j.c.e(Material.LEATHER_BOOTS, 1)).a(Color.YELLOW).a();
                        var31.setHelmet(var15);
                        var31.setChestplate(var16);
                        var31.setLeggings(var17);
                        var31.setBoots(var18);
                        Main.a.n().a(var23, var23.getHealth(), true);
                        LivingEntity var19;
                        if (l.e()) {
                           var19 = (LivingEntity)var1.getLocation().getWorld().spawnEntity(var1.getLocation(), EntityType.PARROT);
                           Main.a.n().a((Attribute)Attribute.GENERIC_ATTACK_DAMAGE, (Double)8.0D, (Entity)var19);
                           Main.a.n().d(var19);
                        } else {
                           var19 = (LivingEntity)Main.a.f().b("PigmanJockeys.SpecialBee", EntityType.BEE, var1.getLocation(), SpawnReason.CUSTOM);
                        }

                        var23.setCollidable(true);
                        var19.setCollidable(true);
                        Bukkit.getScheduler().runTaskLater(Main.a, new c(this, var23, var19), 10L);
                     }

                     if (var50 == 3) {
                        var23.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(8.0D);
                        var23.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3));
                        Ghast var40 = (Ghast)Main.a.f().b(var1.getLocation(), SpawnReason.CUSTOM, false);
                        var40.getPersistentDataContainer().set(new NamespacedKey(Main.a, "tp_ghast"), PersistentDataType.BYTE, (byte)1);
                        var40.setCollidable(true);
                        var23.setCollidable(true);
                        var40.addPassenger(var23);
                     }

                     if (var50 == 4) {
                        MagmaCube var43 = (MagmaCube)Main.a.f().a("MagmaCube", EntityType.MAGMA_CUBE, var1.getLocation(), SpawnReason.SLIME_SPLIT);
                        var43.setSize(1);
                        Main.a.n().a(var23, 1.0D, true);
                        var23.setCollidable(false);
                        var43.addPassenger(var23);
                     }

                     if (var50 == 5) {
                        var15 = (new com.permadeathcore.j.c.e(Material.LEATHER_HELMET, 1)).a(Color.GRAY).a();
                        var16 = (new com.permadeathcore.j.c.e(Material.LEATHER_CHESTPLATE, 1)).a(Color.GRAY).a();
                        var17 = (new com.permadeathcore.j.c.e(Material.LEATHER_LEGGINGS, 1)).a(Color.GRAY).a();
                        var18 = (new com.permadeathcore.j.c.e(Material.LEATHER_BOOTS, 1)).a(Color.GRAY).a();
                        var31.setHelmet(var15);
                        var31.setChestplate(var16);
                        var31.setLeggings(var17);
                        var31.setBoots(var18);
                        Main.a.n().a(var23, var23.getHealth(), true);
                        Pig var61 = (Pig)Main.a.f().b("PigmanJockeys.SpecialPig", EntityType.PIG, var1.getLocation(), SpawnReason.SPAWNER_EGG);
                        Bukkit.getScheduler().runTaskLater(Main.a, new d(this, var61, var23), 10L);
                     }
                  } else {
                     var31 = var23.getEquipment();
                     var31.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                     var31.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                     var31.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                     var31.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                  }
               }
            }

            if (var1.getEntity() instanceof Ravager && this.b.o() >= 40L) {
               if (var1.getSpawnReason() == SpawnReason.CUSTOM) {
                  return;
               }

               if (this.b.o() >= 50L && var1.getEntity().getWorld().getName().equalsIgnoreCase(Main.a.h.getName())) {
                  var25 = (Ravager)Main.a.f().b("PigmanJockeys.UltraRavager", EntityType.RAVAGER, var1.getLocation(), SpawnReason.CUSTOM);
                  var10001 = Main.a;
                  var25.setCustomName(Main.a("&6Ultra Ravager"));
                  var25.setCustomNameVisible(true);
                  var25.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                  var25.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
                  Main.a.n().a(var25, 500.0D, true);
                  var1.setCancelled(true);
               }
            }
         }

         if (this.b.o() >= 25L && this.b.o() < 40L && var1.getEntity() instanceof Ravager) {
            var25 = (Ravager)var1.getEntity();
            var25.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
            var25.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
            var25.setRemoveWhenFarAway(true);
         }

         LivingEntity var10000;
         String var32;
         byte var33;
         Creeper var36;
         if (this.b.o() >= 30L) {
            if (var1.getEntity() instanceof Silverfish || var1.getEntity() instanceof Endermite) {
               for(var10 = 0; var10 < 5; ++var10) {
                  var11 = var8.nextInt(var26.size());
                  var32 = (String)var26.get(var11);
                  if (var32.equals("SPEED")) {
                     var33 = 2;
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999999, var33));
                  }

                  if (var32.equals("REGENERATION")) {
                     var33 = 3;
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 9999999, var33));
                  }

                  if (var32.equals("INCREASE_DAMAGE")) {
                     var33 = 3;
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, var33));
                  }

                  if (var32.equals("INVISIBILITY")) {
                     var33 = 0;
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 9999999, var33));
                  }

                  if (var32.equals("JUMP")) {
                     var33 = 4;
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 9999999, var33));
                  }

                  if (var32.equals("SLOW_FALLING")) {
                     var33 = 0;
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 9999999, var33));
                  }

                  if (var32.equals("GLOWING")) {
                     var33 = 0;
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 9999999, var33));
                  }

                  if (var32.equals("DAMAGE_RESISTANCE")) {
                     var33 = 2;
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 9999999, var33));
                  }

                  if (var1.getEntity() instanceof Silverfish) {
                     var10000 = var1.getEntity();
                     var10001 = Main.a;
                     var10000.setCustomName(Main.a("&6Silverfish de la Muerte"));
                  } else {
                     var10000 = var1.getEntity();
                     var10001 = Main.a;
                     var10000.setCustomName(Main.a("&6Endermite Misterioso"));
                  }
               }
            }

            if (var1.getEntity() instanceof Enderman) {
               byte var29 = 1;
               if (Main.a.o() >= 60L) {
                  var29 = 9;
               }

               var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, var29));
            }

            if (var1.getEntity() instanceof Squid) {
               if ((new Random()).nextInt(1499) <= 9) {
                  Guardian var34 = (Guardian)var1.getEntity().getWorld().spawnEntity(var1.getLocation(), EntityType.GUARDIAN);
                  var34.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
               }

               var1.setCancelled(true);
            }

            if (var1.getEntity() instanceof IronGolem) {
               var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3));
               if (this.b.o() >= 50L) {
                  var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 1));
               }

               if (this.b.o() >= 60L) {
                  var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 3));
                  var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 3));
               }
            }

            if (var1.getEntity() instanceof Bat) {
               var10 = (new Random()).nextInt(1499);
               if (var10 <= 9) {
                  Blaze var35 = (Blaze)var1.getEntity().getWorld().spawnEntity(var1.getLocation(), EntityType.BLAZE);
                  var35.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 1));
               }

               var1.setCancelled(true);
            }

            if (var1.getEntity() instanceof Creeper) {
               var36 = (Creeper)var1.getEntity();
               var36.setPowered(true);
            }

            if (var1.getEntity() instanceof Pillager) {
               Pillager var38 = (Pillager)var1.getEntity();
               var38.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));
               var38.getEquipment().setItemInMainHand((new com.permadeathcore.j.c.d(Material.CROSSBOW)).a(Enchantment.QUICK_CHARGE, 5).a());
               var38.getEquipment().setItemInMainHandDropChance(0.0F);
               if (this.b.o() >= 50L) {
                  var11 = (new SplittableRandom()).nextInt(100) + 1;
                  if (var11 == 1) {
                     var1.getLocation().getWorld().spawnEntity(var1.getLocation(), EntityType.EVOKER);
                     var1.setCancelled(true);
                  }
               }
            }
         }

         if (this.b.o() >= 40L) {
            if (var1.getEntityType() == EntityType.MUSHROOM_COW && var1.getLocation().getBlock().getLightLevel() < 7 && var1.getLocation().getWorld().getTime() >= 13000L) {
               ArrayList var41 = new ArrayList();
               var41.add(EntityType.SPIDER);
               var41.add(EntityType.ZOMBIE);
               var41.add(EntityType.SKELETON);
               var41.add(EntityType.CREEPER);
               var41.add(EntityType.ENDERMAN);
               var41.add(EntityType.WITCH);
               var11 = this.c.nextInt(4) + 1;

               for(var12 = 0; var12 < var11; ++var12) {
                  if (this.c.nextInt(20) == 0) {
                     EntityType var49 = (EntityType)var41.get(this.c.nextInt(var41.size()));
                     Main.a.f().a(StringUtils.capitalize(var49.toString().toLowerCase()), var49, var1.getLocation(), SpawnReason.NATURAL);
                     var1.setCancelled(true);
                  }
               }
            }

            if (var1.getEntity() instanceof Creeper) {
               var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
               var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 1));
               if (this.b.o() >= 50L && this.b.o() < 60L) {
                  Location var44 = var1.getLocation();
                  if (var44.getWorld().getEnvironment() == Environment.NORMAL) {
                     var11 = this.c.nextInt(100) + 1;
                     if (var11 <= 20) {
                        var1.setCancelled(true);
                        Bukkit.getScheduler().runTaskLater(Main.a, new e(this, var44), 5L);
                     } else {
                        Creeper var37 = (Creeper)var1.getEntity();
                        var10001 = Main.a;
                        var37.setCustomName(Main.a("&6Quantum Creeper"));
                        Main.a.d().b(var37, "quantum_creeper");
                        var37.setPowered(true);
                     }
                  }
               }

               if (this.b.o() >= 60L) {
                  var36 = (Creeper)var1.getEntity();
                  var36.setPowered(true);
                  var36.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));
                  var10001 = Main.a;
                  var36.setCustomName(Main.a("&6Ender Quantum Creeper"));
                  Main.a.d().b(var36, "ender_quantum_creeper");
                  var36.setMaxFuseTicks(var36.getMaxFuseTicks() / 2);
               }
            }

            if (var1.getEntity() instanceof IronGolem) {
               var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
            }

            if (var1.getEntity().getType() == EntityType.GUARDIAN) {
               var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
               var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 1));
            }

            if (var1.getEntity().getType() == EntityType.SPIDER) {
               Main.a.f().a("CaveSpider", EntityType.CAVE_SPIDER, var1.getLocation(), SpawnReason.NATURAL);
               var1.setCancelled(true);
            }

            if (var1.getEntity().getType() == EntityType.ZOMBIE) {
               if (this.b.o() < 60L) {
                  Vindicator var53 = (Vindicator)var1.getLocation().getWorld().spawnEntity(var1.getLocation(), EntityType.VINDICATOR);
                  Double var46 = Main.a.n().a((Entity)var53);
                  Main.a.n().a(var53, var46, true);
                  var53.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
                  var1.setCancelled(true);
               } else {
                  var10 = (new SplittableRandom()).nextInt(100) + 1;
                  Double var39;
                  if (var10 <= 50) {
                     Vindicator var45 = (Vindicator)var1.getLocation().getWorld().spawnEntity(var1.getLocation(), EntityType.VINDICATOR);
                     var39 = Main.a.n().a((Entity)var45);
                     Main.a.n().a(var45, var39, true);
                     var45.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
                     var1.setCancelled(true);

                     for(int var54 = 0; var54 < 4; ++var54) {
                        var50 = var8.nextInt(var26.size());
                        String var47 = (String)var26.get(var50);
                        byte var51;
                        if (var47.equals("SPEED")) {
                           var51 = 2;
                           var45.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999999, var51));
                        }

                        if (var47.equals("REGENERATION")) {
                           var51 = 3;
                           var45.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 9999999, var51));
                        }

                        if (var47.equals("INCREASE_DAMAGE")) {
                           var51 = 3;
                           var45.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, var51));
                        }

                        if (var47.equals("INVISIBILITY")) {
                           var51 = 0;
                           var45.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 9999999, var51));
                        }

                        if (var47.equals("JUMP")) {
                           var51 = 4;
                           var45.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 9999999, var51));
                        }

                        if (var47.equals("SLOW_FALLING")) {
                           var51 = 0;
                           var45.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 9999999, var51));
                        }

                        if (var47.equals("GLOWING")) {
                           var51 = 0;
                           var45.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 9999999, var51));
                        }

                        if (var47.equals("DAMAGE_RESISTANCE")) {
                           var51 = 2;
                           var45.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 9999999, var51));
                        }
                     }
                  } else {
                     Evoker var42 = (Evoker)var1.getLocation().getWorld().spawnEntity(var1.getLocation(), EntityType.EVOKER);
                     var39 = Main.a.n().a((Entity)var42);
                     Main.a.n().a(var42, var39, true);
                     var42.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 2));
                     var1.setCancelled(true);
                  }
               }
            }

            if (var1.getEntity() instanceof Wolf) {
               if (this.c.nextInt(5) + 1 == 1) {
                  Main.a.f().a("Cat", EntityType.CAT, var1.getLocation(), SpawnReason.NATURAL);
               }

               var1.setCancelled(true);
            }

            if (var1.getEntity() instanceof Cow || var1.getEntity() instanceof Sheep || var1.getEntity() instanceof Pig || var1.getEntity() instanceof MushroomCow) {
               if (!var1.getLocation().getWorld().getName().equalsIgnoreCase(this.b.h.getName())) {
                  return;
               }

               if (this.b.o() < 50L && this.b.o() >= 40L) {
                  Main.a.f().a("Ravager", EntityType.RAVAGER, var1.getLocation(), SpawnReason.NATURAL);
                  var1.setCancelled(true);
               }

               if (this.b.o() >= 50L) {
                  var25 = (Ravager)Main.a.f().b("PigmanJockeys.UltraRavager", EntityType.RAVAGER, var1.getLocation(), SpawnReason.CUSTOM);
                  var10001 = Main.a;
                  var25.setCustomName(Main.a("&6Ultra Ravager"));
                  var25.setCustomNameVisible(true);
                  var25.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                  var25.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
                  Main.a.n().a(var25, 500.0D, true);
                  var1.setCancelled(true);
               }
            }

            if (var1.getEntity() instanceof Chicken) {
               if (this.b.o() < 50L && this.b.o() >= 40L) {
                  Main.a.f().a("Ravager", EntityType.RAVAGER, var1.getLocation(), SpawnReason.NATURAL);
                  var1.setCancelled(true);
                  return;
               }

               if (this.b.o() >= 50L) {
                  var1.getLocation().getWorld().spawnEntity(var1.getLocation(), EntityType.SILVERFISH);
                  var1.setCancelled(true);
               }
            }

            if (var1.getEntity() instanceof Enderman && var1.getEntity().getWorld().getName().endsWith("nether")) {
               Main.a.d().a(var1.getLocation());
               var1.setCancelled(true);
            }

            if (var1.getEntity() instanceof Witch) {
               var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
               Main.a.n().a(var1.getEntity(), var1.getEntity().getHealth() * 2.0D, true);
               var10000 = var1.getEntity();
               var10001 = Main.a;
               var10000.setCustomName(Main.a("&6Bruja Imposible"));
            }
         }

         if (this.b.o() >= 50L) {
            if (var1.getEntity() instanceof Illager) {
               Illager var56 = (Illager)var1.getEntity();
               var56.getEquipment().setItemInMainHand((new com.permadeathcore.j.c.d(Material.DIAMOND_AXE)).a(Enchantment.DAMAGE_ALL, 5).a());
            }

            if (var1.getEntityType() == EntityType.VEX) {
               var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 2));
            }

            if (var1.getEntityType() == EntityType.BLAZE) {
               Main.a.n().a(var1.getEntity(), 200.0D, true);
            }

            if (var1.getEntityType() == EntityType.PHANTOM) {
               for(var10 = 0; var10 < 2; ++var10) {
                  var11 = var8.nextInt(var26.size());
                  var32 = (String)var26.get(var11);
                  if (var32.equals("SPEED")) {
                     var33 = 2;
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999999, var33));
                  }

                  if (var32.equals("REGENERATION")) {
                     var33 = 3;
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 9999999, var33));
                  }

                  if (var32.equals("INCREASE_DAMAGE")) {
                     var33 = 3;
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, var33));
                  }

                  if (var32.equals("INVISIBILITY")) {
                     var33 = 0;
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 9999999, var33));
                  }

                  if (var32.equals("JUMP")) {
                     var33 = 4;
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 9999999, var33));
                  }

                  if (var32.equals("SLOW_FALLING")) {
                     var33 = 0;
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 9999999, var33));
                  }

                  if (var32.equals("GLOWING")) {
                     var33 = 0;
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 9999999, var33));
                  }

                  if (var32.equals("DAMAGE_RESISTANCE")) {
                     var33 = 2;
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 9999999, var33));
                  }

                  if (var1.getEntity() instanceof Silverfish) {
                     var10000 = var1.getEntity();
                     var10001 = Main.a;
                     var10000.setCustomName(Main.a("&6Silverfish de la Muerte"));
                  } else {
                     var10000 = var1.getEntity();
                     var10001 = Main.a;
                     var10000.setCustomName(Main.a("&6Endermite Misterioso"));
                  }
               }
            }

            if (var1.getEntity().getType() == EntityType.COD) {
               if (var1.getSpawnReason() == SpawnReason.CUSTOM) {
                  return;
               }

               Cod var57 = (Cod)Main.a.f().b("CustomCod", EntityType.COD, var1.getLocation(), SpawnReason.CUSTOM);
               if (var57 != null) {
                  var10001 = this.b;
                  var57.setCustomName(Main.a("&6Bacalao de la Muerte"));
                  var1.setCancelled(true);
               }
            }

            if (var1.getEntity().getType() == EntityType.DROWNED) {
               var1.getEntity().getEquipment().setItemInMainHand(new ItemStack(Material.TRIDENT));
            }

            PufferFish var58;
            if (var1.getEntity().getType() == EntityType.SALMON) {
               if ((new Random()).nextInt(999) <= 9) {
                  var58 = (PufferFish)var1.getLocation().getWorld().spawnEntity(var1.getLocation(), EntityType.PUFFERFISH);
                  var10001 = Main.a;
                  var58.setCustomName(Main.a("&6Pufferfish invulnerable"));
                  var58.setInvulnerable(true);
               }

               var1.setCancelled(true);
            }

            if (var1.getEntity().getType() == EntityType.PUFFERFISH) {
               var58 = (PufferFish)var1.getEntity();
               var10001 = Main.a;
               var58.setCustomName(Main.a("&6Pufferfish invulnerable"));
               var58.setInvulnerable(true);
            }

            if (var1.getEntity().getType() == EntityType.WITHER_SKELETON) {
               WitherSkeleton var59 = (WitherSkeleton)var1.getEntity();
               var30 = var59.getEquipment();
               boolean var48 = true;
               if (Main.a.o() < 60L) {
                  var12 = (new Random()).nextInt(50) + 1;
               } else {
                  var12 = (new Random()).nextInt(13) + 1;
               }

               if (var59.getWorld().getName().endsWith("nether") && var12 == 5) {
                  this.b.n().a(var59, 80.0D, true);
                  var10001 = this.b;
                  var59.setCustomName(Main.a("&6Wither Skeleton Emperador"));
                  var59.setCollidable(false);
                  ItemStack var62 = new ItemStack(Material.BLACK_BANNER, 1);
                  BannerMeta var55 = (BannerMeta)var62.getItemMeta();
                  ArrayList var52 = new ArrayList();
                  var52.add(new Pattern(DyeColor.YELLOW, PatternType.STRAIGHT_CROSS));
                  var52.add(new Pattern(DyeColor.BLACK, PatternType.BRICKS));
                  var52.add(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
                  var52.add(new Pattern(DyeColor.YELLOW, PatternType.FLOWER));
                  var52.add(new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_TOP));
                  var52.add(new Pattern(DyeColor.RED, PatternType.GRADIENT_UP));
                  var55.setPatterns(var52);
                  var62.setItemMeta(var55);
                  var30.setHelmet(var62);
                  var30.setHelmetDropChance(0.0F);
                  var30.setChestplate(new ItemStack(Material.GOLDEN_CHESTPLATE));
                  var30.setLeggings(new ItemStack(Material.GOLDEN_LEGGINGS));
                  var30.setBoots(new ItemStack(Material.GOLDEN_BOOTS));
                  var30.setItemInMainHand((new com.permadeathcore.j.c.d(Material.BOW)).a(Enchantment.ARROW_KNOCKBACK, 5).a(Enchantment.ARROW_DAMAGE, 100).a());
                  var30.setItemInMainHandDropChance(0.0F);
                  var1.setCancelled(false);
               }
            }

            if (var1.getEntity().getType() == EntityType.ZOMBIE && var1.getLocation().getWorld().getBiome((int)var1.getLocation().getX(), (int)var1.getLocation().getY(), (int)var1.getLocation().getZ()) == Biome.PLAINS) {
               boolean var60 = true;
               if (this.b.o() < 60L) {
                  var10 = (new Random()).nextInt(500) + 1;
               } else {
                  var10 = (new Random()).nextInt(125) + 1;
               }

               if (var1.getLocation().distance(var1.getLocation().getWorld().getHighestBlockAt(var1.getLocation()).getLocation()) <= 3.0D && var10 == 5) {
                  Main.a.f().b("CustomGiant", EntityType.GIANT, var1.getLocation(), SpawnReason.CUSTOM);
                  var1.setCancelled(true);
               }
            }
         }

         if (this.b.o() >= 60L) {
            if (var1.getEntityType() == EntityType.PIG) {
               var10 = this.c.nextInt(1000) + 1;
               if (var10 <= 5) {
                  var1.getLocation().getWorld().spawn(var1.getLocation(), Golem.class);
                  var1.setCancelled(true);
               }
            }

            if (var1.getEntityType() == EntityType.VEX) {
               Vex var63 = (Vex)var1.getEntity();
               var63.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 2));
               var63.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(7.0D);
            }

            if (var1.getEntityType() == EntityType.GUARDIAN) {
               if (this.c.nextInt(1000) == 0) {
                  var1.getLocation().getWorld().spawn(var1.getLocation(), ElderGuardian.class);
               }

               var1.setCancelled(true);
            }
         }

         if (var1.isCancelled()) {
            var1.getEntity().remove();
         }

      }
   }

   @EventHandler
   public void a(EntityDamageByEntityEvent var1) {
      if (var1.getDamager() instanceof Drowned && Main.a.o() >= 60L) {
         var1.setDamage(var1.getDamage() * 3.0D);
      }

   }

   @EventHandler
   public void a(EntityDeathEvent var1) {
      if (this.b.o() >= 20L) {
         LivingEntity var2 = var1.getEntity();
         int var3;
         if (this.b.o() < 40L) {
            if (var2 instanceof IronGolem || var2.getType() == this.d || var2 instanceof Ghast || var2 instanceof Guardian || var2 instanceof Enderman || var2 instanceof Witch || var2 instanceof WitherSkeleton || var2 instanceof Evoker || var2 instanceof Phantom || var2 instanceof Slime || var2 instanceof Drowned || var2 instanceof Blaze) {
               var1.getDrops().clear();
            }
         } else {
            if (var2 instanceof IronGolem || var2 instanceof Ghast || var2 instanceof Guardian || var2 instanceof Enderman || var2 instanceof Witch || var2 instanceof WitherSkeleton || var2 instanceof Evoker || var2 instanceof Phantom || var2 instanceof Slime || var2 instanceof Drowned || var2 instanceof Blaze) {
               var1.getDrops().clear();
            }

            byte var4;
            if (var2.getType() == this.d) {
               if (var2.getCustomName() == null) {
                  var1.getDrops().clear();
                  return;
               }

               if (var2.getCustomName().equalsIgnoreCase(ChatColor.GREEN + "Carlos el Esclavo")) {
                  var3 = (new SplittableRandom()).nextInt(100) + 1;
                  var4 = 100;
                  if (Main.a.o() >= 60L) {
                     var4 = 33;
                  }

                  if (var3 <= var4) {
                     var1.getDrops().add(new ItemStack(Material.GOLD_INGOT, 32));
                  }
               }
            }

            if (var2 instanceof Villager) {
               if (var2.getCustomName() == null) {
                  return;
               }

               if (var2.getCustomName().equalsIgnoreCase(ChatColor.GREEN + "Jess la Emperatriz")) {
                  var3 = (new SplittableRandom()).nextInt(100) + 1;
                  var4 = 100;
                  if (Main.a.o() >= 60L) {
                     var4 = 33;
                  }

                  if (var3 <= var4) {
                     var1.getDrops().add(new ItemStack(Material.GOLDEN_APPLE, 2));
                  }
               }
            }
         }

         byte var5;
         int var10;
         if (this.b.o() < 40L) {
            if (var1.getEntity().getKiller() == null) {
               return;
            }

            Player var8 = var1.getEntity().getKiller();
            if (var2 instanceof Ravager) {
               var10 = (new SplittableRandom()).nextInt(100) + 1;
               var5 = 1;
               if (Main.a.o() >= 25L) {
                  var5 = 20;
               }

               int var6 = ThreadLocalRandom.current().nextInt(1, 5);
               if (var10 <= var5) {
                  ItemStack var7 = new ItemStack(Material.TOTEM_OF_UNDYING, 1, (short)3);
                  var2.getWorld().dropItem(var2.getLocation(), var7);
                  var8.sendMessage(ChatColor.YELLOW + "¡Un tótem!");
                  var8.playSound(var8.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, -5.0F);
               } else if (var6 == 1) {
                  assert var8 != null;

                  var8.sendMessage(ChatColor.RED + "Vaya que mala suerte, ese ravager no tenia nada :(");
               } else if (var6 == 2) {
                  assert var8 != null;

                  var8.sendMessage(ChatColor.RED + "¡Porras... otro ravager sin suerte!");
               } else if (var6 == 3) {
                  assert var8 != null;

                  var8.sendMessage(ChatColor.RED + "Nada... hoy no hay totem :(");
               } else if (var6 == 4) {
                  assert var8 != null;

                  var8.sendMessage(ChatColor.RED + "¡Hoy no es tu día!");
               }
            }
         }

         String var10000;
         Main var10001;
         if (this.b.o() >= 40L && var1.getEntity() instanceof Ravager) {
            Ravager var9 = (Ravager)var1.getEntity();
            if (var9.getCustomName() == null) {
               return;
            }

            var10000 = var9.getCustomName();
            var10001 = Main.a;
            if (var10000.contains(Main.a("&6Ultra Ravager"))) {
               if (var9.getWorld().getEnvironment() != Environment.NETHER) {
                  var1.getDrops().clear();
               } else {
                  var10 = (new SplittableRandom()).nextInt(100) + 1;
                  var5 = 100;
                  if (Main.a.o() >= 60L) {
                     var5 = 33;
                  }

                  if (var10 <= var5) {
                     var1.getDrops().add(new ItemStack(Material.TOTEM_OF_UNDYING));
                  }
               }
            }
         }

         if (this.b.o() >= 50L) {
            if (var1.getEntity().getType() == EntityType.GIANT && this.b.o() < 60L) {
               List var11 = var1.getDrops();
               com.permadeathcore.j.c.d var12 = new com.permadeathcore.j.c.d(Material.BOW);
               Main var10002 = Main.a;
               var11.add(var12.c(Main.a("&bArco de Gigante")).a(Enchantment.ARROW_DAMAGE, 10).a());
            }

            if (var1.getEntity().getType() == EntityType.WITHER_SKELETON) {
               if (var1.getEntity().getCustomName() == null) {
                  return;
               }

               var10000 = var1.getEntity().getCustomName();
               var10001 = this.b;
               if (var10000.contains(Main.a("&6Wither Skeleton Emperador")) && Main.a.o() < 60L) {
                  var3 = (int)(Math.random() * 100.0D) + 1;
                  if (var3 <= 50) {
                     var1.getDrops().add(com.permadeathcore.j.c.a.e());
                  }
               }
            }
         }
      }

   }

   @EventHandler
   public void b(CreatureSpawnEvent var1) {
      if (!var1.isCancelled()) {
         if (this.b.o() >= 25L) {
            if (this.b.o() >= 50L) {
               if (this.b.o() < 60L) {
                  var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0));
               } else {
                  if (var1.getEntity().getEquipment() == null) {
                     return;
                  }

                  ItemStack var2 = var1.getEntity().getEquipment().getItemInMainHand();
               }
            }

            if (var1.getLocation().getWorld().hasStorm()) {
               if (var1.getLocation().getWorld().getName().endsWith("end") || var1.getLocation().getWorld().getName().endsWith("beginning")) {
                  return;
               }

               if (this.a(var1.getEntity().getType())) {
                  if (this.b.o() >= 50L) {
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 1));
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
                  } else {
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0));
                     var1.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
                  }
               }
            }
         }

      }
   }

   @EventHandler
   public void a(WeatherChangeEvent var1) {
      if (this.b.o() >= 25L) {
         if (var1.getWorld().getName().equalsIgnoreCase(Main.a.h.getName())) {
            if (!var1.getWorld().hasStorm()) {
               Bukkit.getServer().getScheduler().runTaskLater(Main.a, new f(this), 200L);
            } else {
               Bukkit.getServer().getScheduler().runTaskLater(Main.a, new g(this, var1), 200L);
            }
         }

      }
   }

   private void c(CreatureSpawnEvent var1) {
      Ravager var2 = (Ravager)var1.getLocation().getWorld().spawn(var1.getLocation(), Ravager.class);
      LivingEntity var3 = (LivingEntity)var1.getLocation().getWorld().spawnEntity(var1.getLocation(), this.d);
      Villager var4 = (Villager)var1.getLocation().getWorld().spawn(var1.getLocation(), Villager.class);
      var3.addPassenger(var4);
      var2.addPassenger(var3);
      Main.a.n().a(var4, 500.0D, true);
      Main.a.n().a(var3, 150.0D, true);
      Main.a.n().a(var2, 240.0D, true);
      var4.setCustomName(ChatColor.GREEN + "Jess la Emperatriz");
      var3.setCustomName(ChatColor.GREEN + "Carlos el Esclavo");
      var2.setCustomName(ChatColor.GREEN + "Ultra Ravager");
      var4.getEquipment().setItemInMainHand(new ItemStack(Material.GOLDEN_APPLE, 2));
      var4.getEquipment().setItemInMainHandDropChance(0.0F);
      var3.getEquipment().setItemInMainHand(new ItemStack(Material.GOLD_INGOT, 32));
      var3.getEquipment().setItemInMainHandDropChance(0.0F);
      var2.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
      var2.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
      var2.getPersistentDataContainer().set(new NamespacedKey(Main.a, "ultra_ravager"), PersistentDataType.BYTE, (byte)1);
      var1.setCancelled(true);
   }

   private boolean a(EntityType var1) {
      return var1 == EntityType.BLAZE || var1 == EntityType.CREEPER || var1 == EntityType.GHAST || var1 == EntityType.MAGMA_CUBE || var1 == EntityType.SILVERFISH || var1 == EntityType.SKELETON || var1 == EntityType.SLIME || var1 == EntityType.ZOMBIE || var1 == EntityType.ZOMBIE_VILLAGER || var1 == EntityType.DROWNED || var1 == EntityType.WITHER_SKELETON || var1 == EntityType.WITCH || var1 == EntityType.PILLAGER || var1 == EntityType.EVOKER || var1 == EntityType.VINDICATOR || var1 == EntityType.RAVAGER || var1 == EntityType.VEX || var1 == EntityType.GUARDIAN || var1 == EntityType.ELDER_GUARDIAN || var1 == EntityType.SHULKER || var1 == EntityType.HUSK || var1 == EntityType.STRAY || var1 == EntityType.PHANTOM;
   }

   // $FF: synthetic method
   static boolean a(b var0, EntityType var1) {
      return var0.a(var1);
   }
}
