package com.permadeathcore.b;

import com.permadeathcore.Main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.SplittableRandom;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Shulker;
import org.bukkit.entity.ShulkerBullet;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.AreaEffectCloudApplyEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.Vector;

public class a implements Listener {
   private Main a;
   private List b;
   private List c;
   private ArrayList d = new ArrayList();
   private ArrayList e = new ArrayList();
   private SplittableRandom f;

   public a(Main var1) {
      this.a = var1;
      var1.getServer().getPluginManager().registerEvents(this, var1);
      this.b = new ArrayList();
      this.c = new ArrayList();
      this.f = new SplittableRandom();
   }

   @EventHandler
   public void a(ExplosionPrimeEvent var1) {
      if (this.a(var1.getEntity().getLocation()) && var1.getEntity() instanceof TNTPrimed) {
         if (!(var1.getEntity() instanceof TNTPrimed)) {
            return;
         }

         if (var1.getEntity().getCustomName() == null) {
            return;
         }

         if (!var1.getEntity().getCustomName().equalsIgnoreCase("dragontnt")) {
            return;
         }

         if (Main.a.getConfig().getBoolean("Toggles.End.Optimizar-TNT")) {
            var1.setRadius(5.0F);
         } else {
            var1.setRadius(15.0F);
         }
      }

   }

   @EventHandler
   public void a(EntityCombustEvent var1) {
      if (var1.getEntity().getWorld().getName().equalsIgnoreCase(this.a.i.getName()) && !(var1.getEntity() instanceof Player)) {
         var1.setCancelled(true);
      }

   }

   @EventHandler
   public void a(AreaEffectCloudApplyEvent var1) {
      AreaEffectCloud var2 = var1.getEntity();
      if (this.a(var2.getLocation())) {
         Iterator var3;
         Entity var4;
         if (var2.getParticle() == Particle.VILLAGER_HAPPY) {
            var3 = var1.getAffectedEntities().iterator();

            while(var3.hasNext()) {
               var4 = (Entity)var3.next();
               if (var4 instanceof Player) {
                  var1.setCancelled(true);
               } else if (var4.getType() == EntityType.ENDERMAN) {
                  Enderman var5 = (Enderman)var4;
                  this.e.add(var5);
                  Bukkit.getServer().getScheduler().runTaskLater(this.a, new b(this, var5), 300L);
                  var1.setCancelled(true);
               }
            }
         }

         if (var2.getParticle() == Particle.SMOKE_NORMAL) {
            var3 = var1.getAffectedEntities().iterator();

            while(true) {
               Player var8;
               do {
                  do {
                     do {
                        if (!var3.hasNext()) {
                           return;
                        }

                        var4 = (Entity)var3.next();
                     } while(!(var4 instanceof Player));

                     var8 = (Player)var4;
                  } while(var8.getLocation().distance(var2.getLocation()) > 3.0D);
               } while(var8.getActivePotionEffects().size() < 1);

               Iterator var6 = var8.getActivePotionEffects().iterator();

               while(var6.hasNext()) {
                  PotionEffect var7 = (PotionEffect)var6.next();
                  var8.removePotionEffect(var7.getType());
               }
            }
         }
      }

   }

   @EventHandler
   public void a(EntityDamageByEntityEvent var1) {
      if (var1.getEntity() instanceof Shulker && Main.a.o() >= 50L) {
         var1.setCancelled(true);
      }

      if (this.a(var1.getEntity().getLocation())) {
         if (var1.getDamager() instanceof Creeper) {
            Creeper var2 = (Creeper)var1.getDamager();
            if (var1.getEntity().getLocation().distance(var2.getLocation()) <= 5.0D) {
               var1.setDamage(var1.getDamage() * 1.5D);
            } else {
               var1.setDamage(var1.getDamage() * 1.3D);
            }
         } else if (var1.getDamager() instanceof Fireball) {
            var1.setDamage(var1.getDamage() * 2.0D);
         }

         if (var1.getEntity() instanceof Enderman) {
            Enderman var3 = (Enderman)var1.getEntity();
            if (this.e.contains(var3)) {
               var1.setCancelled(true);
            }
         }
      }

   }

   @EventHandler
   public void a(AsyncPlayerChatEvent var1) {
      if (var1.getMessage().startsWith("noVulne")) {
         if (this.a.l() != null) {
            this.a.l().e().setInvulnerable(false);
         }

         var1.setCancelled(true);
      }

   }

   @EventHandler
   public void a(EntityDamageEvent var1) {
      if (var1.getEntity().getType() == EntityType.DROPPED_ITEM && var1.getCause() == DamageCause.ENTITY_EXPLOSION) {
         Item var2 = (Item)var1.getEntity();
         if (var2.getItemStack().getType() == Material.SHULKER_SHELL) {
            var1.setCancelled(true);
         }
      }

      if (var1.getEntity() instanceof Enderman) {
         Enderman var3 = (Enderman)var1.getEntity();
         if (this.e.contains(var3)) {
            var1.setCancelled(true);
         }
      }

      Entity var4 = var1.getEntity();
   }

   @EventHandler
   public void a(EntityDeathEvent var1) {
      if (var1.getEntity().getType() == EntityType.ENDER_DRAGON && this.a.l() != null) {
         this.a.l().a(true);
         Iterator var2 = this.a.i.getPlayers().iterator();

         while(var2.hasNext()) {
            Player var3 = (Player)var2.next();
            a(var3.getLocation().add(0.0D, 1.0D, 0.0D), 1);
         }
      }

      LivingEntity var6 = var1.getEntity();
      if (this.c.contains(var6)) {
         this.c.remove(var6);
         var1.getDrops().clear();
         var1.setDroppedExp(0);
      }

      if (this.b.contains(var6)) {
         this.b.remove(var6);
         var1.getDrops().clear();
         var1.setDroppedExp(0);
      }

      if (var6 instanceof Shulker) {
         boolean var7 = true;
         Iterator var4 = var1.getEntity().getNearbyEntities(2.0D, 2.0D, 2.0D).iterator();

         while(var4.hasNext()) {
            Entity var5 = (Entity)var4.next();
            if (var5.getType() == EntityType.PRIMED_TNT) {
               var7 = false;
            }
         }

         if (var7) {
            TNTPrimed var8 = (TNTPrimed)var1.getEntity().getWorld().spawnEntity(var1.getEntity().getLocation(), EntityType.PRIMED_TNT);
            var8.setFuseTicks(80);
            var8.setCustomName("tntdeath");
            var8.setCustomNameVisible(false);
            var1.getDrops().clear();
            int var9 = (new Random()).nextInt(99);
            ++var9;
            if (this.a.o() <= 39L) {
               if (var9 <= 20) {
                  if (Main.a.u().b()) {
                     var1.getDrops().add(new ItemStack(Material.SHULKER_SHELL, 2));
                  } else {
                     var1.getDrops().add(new ItemStack(Material.SHULKER_SHELL, 1));
                  }
               }
            } else if (this.a.o() >= 40L && var9 <= 2) {
               if (Main.a.u().b()) {
                  var1.getDrops().add(new ItemStack(Material.SHULKER_SHELL, 2));
               } else {
                  var1.getDrops().add(new ItemStack(Material.SHULKER_SHELL, 1));
               }
            }
         }
      }

   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void a(EntityExplodeEvent var1) {
      Entity var2 = var1.getEntity();
      if (this.a(var2.getLocation()) && var1.getEntity().getType() == EntityType.ENDER_CRYSTAL && this.a.l() != null) {
         if (this.d.contains(var1.getLocation())) {
            return;
         }

         EnderCrystal var3 = (EnderCrystal)var1.getEntity();
         if (var3.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.BEDROCK) {
            int var4 = (new Random()).nextInt(this.a.k().d().size());
            this.a.l().d().put(var3.getLocation(), this.a.k().d().get(var4));
            Location var5 = var1.getLocation().add(0.0D, 10.0D, 0.0D);
            Entity var6 = Main.a.f().b(var5, SpawnReason.CUSTOM, true);
            this.c.add(var6);
            Location var7 = var1.getLocation();
            this.d.add(var7);
            Bukkit.getScheduler().runTaskLater(Main.a, new c(this, var7), 100L);
            Iterator var8 = this.a.i.getPlayers().iterator();

            while(var8.hasNext()) {
               Player var9 = (Player)var8.next();
               var9.playSound(var5, Sound.ENTITY_WITHER_SPAWN, 100.0F, 100.0F);
            }
         }
      }

      if (var1.getEntity() instanceof TNTPrimed) {
         if (var1.getEntity().getCustomName() == null) {
            return;
         }

         if (!var1.getEntity().getCustomName().equalsIgnoreCase("dragontnt")) {
            return;
         }

         if (!var1.blockList().isEmpty()) {
            Location var13 = new Location(this.a.i, 0.0D, 0.0D, 0.0D);
            Location var14 = this.a.i.getHighestBlockAt(var13).getLocation();
            if (var1.getLocation().distance(var14) <= (double)Main.a.getConfig().getInt("Toggles.End.Protect-Radius") && Main.a.getConfig().getBoolean("Toggles.End.Protect-End-Spawn")) {
               var1.blockList().clear();
               var1.setYield(0.0F);
               return;
            }

            ArrayList var15 = new ArrayList();
            ArrayList var16 = new ArrayList(var1.blockList());
            Iterator var17 = var16.iterator();

            while(true) {
               float var10;
               float var11;
               Block var18;
               float var19;
               do {
                  if (!var17.hasNext()) {
                     return;
                  }

                  var18 = (Block)var17.next();
                  var19 = (float)(-0.2D + (double)((float)(Math.random() * 0.6000000000000001D)));
                  var10 = -1.0F + (float)(Math.random() * 3.0D);
                  var11 = (float)(-0.2D + (double)((float)(Math.random() * 0.6000000000000001D)));
               } while(var18.getType() != Material.END_STONE && var18.getType() != Material.END_STONE_BRICKS);

               FallingBlock var12 = var18.getWorld().spawnFallingBlock(var18.getLocation(), var18.getState().getData());
               var18.getState().setData(var18.getState().getData());
               var12.setVelocity(new Vector(var19, var10, var11));
               var12.setDropItem(false);
               var12.setMetadata("Exploded", new FixedMetadataValue(this.a, 0));
               var15.add(var12);
               (new d(this, var16)).runTaskLater(this.a, 2L);
               var1.blockList().clear();
            }
         }
      }

   }

   @EventHandler
   public void a(EntityRegainHealthEvent var1) {
      if (var1.getEntity() instanceof EnderDragon) {
         var1.setAmount(var1.getAmount() / 2.0D);
      }

   }

   @EventHandler
   public void a(CreatureSpawnEvent var1) {
      if (!var1.isCancelled()) {
         LivingEntity var2 = var1.getEntity();
         if (this.a(var2.getLocation())) {
            int var5;
            if (!this.a.k().b().getBoolean("DecoratedEndSpawn")) {
               LivingEntity var3 = var1.getEntity();
               if (var3.getType() == EntityType.ENDERMAN || var3.getType() == EntityType.CREEPER) {
                  Block var4 = var3.getLocation().getBlock().getRelative(BlockFace.DOWN);
                  var5 = (new Random()).nextInt(4);
                  ArrayList var6 = new ArrayList();
                  if (var5 == 0) {
                     var6.add(var4.getRelative(BlockFace.NORTH));
                     var6.add(var4.getRelative(BlockFace.NORTH).getRelative(BlockFace.WEST));
                     var6.add(var4.getRelative(BlockFace.SOUTH));
                     var6.add(var4.getRelative(BlockFace.SOUTH_EAST));
                     var6.add(var4.getRelative(BlockFace.SOUTH_WEST));
                     var6.add(var4.getRelative(BlockFace.SOUTH_EAST).getRelative(BlockFace.SOUTH));
                     var6.add(var4.getRelative(BlockFace.SOUTH_EAST).getRelative(BlockFace.NORTH));
                     var6.add(var4.getRelative(BlockFace.NORTH).getRelative(BlockFace.NORTH));
                  } else if (var5 == 1) {
                     var6.add(var4.getRelative(BlockFace.NORTH));
                     var6.add(var4.getRelative(BlockFace.NORTH_EAST));
                     var6.add(var4);
                  } else if (var5 == 2) {
                     var6.add(var4.getRelative(BlockFace.SOUTH));
                     var6.add(var4.getRelative(BlockFace.SOUTH_WEST));
                     var6.add(var4);
                  } else if (var5 == 3) {
                     var6.add(var4.getRelative(BlockFace.NORTH));
                     var6.add(var4.getRelative(BlockFace.NORTH_EAST));
                     var6.add(var4);
                     var6.add(var4.getRelative(BlockFace.SOUTH));
                     var6.add(var4.getRelative(BlockFace.EAST));
                  } else if (var5 == 4) {
                     var6.add(var4.getRelative(BlockFace.SOUTH));
                     var6.add(var4.getRelative(BlockFace.NORTH_WEST));
                     var6.add(var4);
                     var6.add(var4.getRelative(BlockFace.NORTH));
                     var6.add(var4.getRelative(BlockFace.WEST));
                  }

                  Iterator var7 = var6.iterator();

                  while(var7.hasNext()) {
                     Block var8 = (Block)var7.next();
                     Location var9 = this.a.i.getHighestBlockAt(new Location(this.a.i, (double)var8.getX(), (double)var8.getY(), (double)var8.getZ())).getLocation();
                     Block var10 = this.a.i.getBlockAt(var9);
                     if (var10.getType() == Material.END_STONE) {
                        var10.setType(Material.END_STONE_BRICKS);
                     }
                  }
               }
            }

            if (this.a.l() == null) {
               Iterator var12 = var1.getLocation().getWorld().getEntitiesByClass(EnderDragon.class).iterator();

               while(var12.hasNext()) {
                  Entity var15 = (Entity)var12.next();
                  if (var15.isValid() && !var15.isDead()) {
                     Main var10001 = Main.a;
                     var15.setCustomName(Main.a(Main.a.getConfig().getString("Toggles.End.PermadeathDemon.DisplayName")));
                     ((LivingEntity)var15).getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue((double)Main.a.getConfig().getInt("Toggles.End.PermadeathDemon.Health"));
                     ((LivingEntity)var15).setHealth((double)Main.a.getConfig().getInt("Toggles.End.PermadeathDemon.Health"));
                     this.a.a(new com.permadeathcore.h.a(this.a, var15));
                     this.a.l().runTaskTimer(this.a, 0L, 20L);
                  }
               }
            } else if (!this.a.l().f()) {
               Entity var11 = this.a.l().e();
               if (var11.getType() == EntityType.ENDER_DRAGON && var11.isValid() && !var11.isDead()) {
                  EnderDragon var14 = (EnderDragon)var11;
                  var5 = Main.a.getConfig().getInt("Toggles.End.PermadeathDemon.EnragedHealth");
                  if (var5 > Main.a.getConfig().getInt("Toggles.End.PermadeathDemon.EnragedHealth") || var5 < 10) {
                     var5 = Main.a.getConfig().getInt("Toggles.End.PermadeathDemon.EnragedHealth") / 2;
                  }

                  if (var14.getHealth() <= (double)var5) {
                     this.a.l().a(com.permadeathcore.b.a.b.a);
                  }
               }
            }

            int var13 = Main.a.getConfig().getInt("Toggles.End.Mob-Spawn-Limit");
            if (var13 <= 5) {
               var13 = 70;
            }

            var1.getLocation().getWorld().setMonsterSpawnLimit(var13);
            if (!(var2 instanceof Enderman)) {
               return;
            }

            int var17 = Main.a.getConfig().getInt("Toggles.End.Ender-Creeper-Count");
            if (var17 < 1 || var17 > 1000) {
               var17 = 20;
            }

            var5 = Main.a.getConfig().getInt("Toggles.End.Ender-Ghast-Count");
            if (var5 < 1 || var5 > 1000) {
               var5 = 170;
            }

            int var18 = this.f.nextInt(var17) + 1;
            int var19 = this.f.nextInt(var5) + 1;
            if (var18 == 1) {
               if (Main.a.o() < 60L) {
                  Main.a.d().a(var1.getLocation());
               } else {
                  Main.a.d().c(var1.getLocation());
               }

               var1.setCancelled(true);
            }

            if (var19 == 1) {
               boolean var20 = true;
               if (this.a.i.getEntitiesByClass(EnderDragon.class).size() >= 1) {
                  var20 = false;
               }

               if (var20) {
                  this.a.f().b(var1.getLocation(), SpawnReason.CUSTOM, true);
                  var1.setCancelled(true);
               }
            }

            if (Main.a.getConfig().getBoolean("Toggles.Optimizar-Mob-Spawns")) {
               int var21 = this.f.nextInt(100) + 1;
               if (var21 <= 25) {
                  var1.setCancelled(true);
               }
            }
         } else if (var1.getEntity() instanceof Enderman && this.a.o() >= 40L) {
            Enderman var16 = (Enderman)var1.getEntity();
            if (this.f.nextInt(100) + 1 == 1) {
               Main.a.n().d(var16);
            }
         }

      }
   }

   @EventHandler
   public void a(ProjectileHitEvent var1) {
      if (this.a(var1.getEntity().getLocation())) {
         ShulkerBullet var2;
         Shulker var3;
         if (var1.getHitBlock() != null) {
            if (var1.getEntity() instanceof Fireball && var1.getEntity().getShooter() instanceof Ghast && var1.getHitEntity() == null) {
               var1.getHitBlock().getWorld().createExplosion(var1.getHitBlock().getLocation(), 2.0F, true, true, (Entity)var1.getEntity().getShooter());
            }

            if (var1.getEntity() instanceof ShulkerBullet) {
               var2 = (ShulkerBullet)var1.getEntity();
               if (var2.getShooter() instanceof Shulker) {
                  var3 = (Shulker)var2.getShooter();
                  if (var3.getLocation().distance(var1.getHitBlock().getLocation()) >= 4.0D) {
                     Location var4 = var1.getHitBlock().getLocation();
                     if (var1.getHitBlockFace() == BlockFace.EAST) {
                        var4 = var1.getHitBlock().getRelative(BlockFace.EAST).getLocation();
                     }

                     if (var1.getHitBlockFace() == BlockFace.UP) {
                        var4 = var1.getHitBlock().getRelative(BlockFace.UP).getLocation();
                     }

                     if (var1.getHitBlockFace() == BlockFace.DOWN) {
                        var4 = var1.getHitBlock().getRelative(BlockFace.DOWN).getLocation();
                     }

                     if (var1.getHitBlockFace() == BlockFace.NORTH) {
                        var4 = var1.getHitBlock().getRelative(BlockFace.NORTH).getLocation().add(0.0D, 1.0D, 0.0D);
                     }

                     if (var1.getHitBlockFace() == BlockFace.SOUTH) {
                        var4 = var1.getHitBlock().getRelative(BlockFace.SOUTH).getLocation().add(0.0D, 1.0D, 0.0D);
                     }

                     var4.getBlock().setType(Material.AIR);
                     TNTPrimed var5 = (TNTPrimed)var3.getWorld().spawnEntity(var4, EntityType.PRIMED_TNT);
                     var5.setFuseTicks(40);
                     var5.setCustomName("tnt");
                     var5.setCustomNameVisible(false);
                  }
               }
            }
         }

         if (var1.getHitEntity() != null && var1.getEntity() instanceof ShulkerBullet) {
            var2 = (ShulkerBullet)var1.getEntity();
            if (var2.getShooter() instanceof Shulker) {
               var3 = (Shulker)var2.getShooter();
               if (var3.getLocation().getX() == var1.getHitEntity().getLocation().getX() && var3.getLocation().getY() == var1.getHitEntity().getLocation().getY() && var3.getLocation().getZ() == var1.getHitEntity().getLocation().getZ()) {
                  return;
               }

               TNTPrimed var6 = (TNTPrimed)var3.getWorld().spawnEntity(var1.getHitEntity().getLocation(), EntityType.PRIMED_TNT);
               var6.setFuseTicks(20);
               var6.setCustomName("tnt");
               var6.setCustomNameVisible(false);
            }
         }

      }
   }

   public static void a(Location var0, int var1) {
      Location var2 = var0;
      Firework var3 = (Firework)var0.getWorld().spawnEntity(var0, EntityType.FIREWORK);
      FireworkMeta var4 = var3.getFireworkMeta();
      var4.setPower(2);
      var4.addEffect(FireworkEffect.builder().withColor(Color.LIME).flicker(true).build());
      var3.setFireworkMeta(var4);
      var3.detonate();

      for(int var5 = 0; var5 < var1; ++var5) {
         Firework var6 = (Firework)var2.getWorld().spawnEntity(var2, EntityType.FIREWORK);
         var6.setFireworkMeta(var4);
      }

   }

   public boolean a(Location var1) {
      return var1.getWorld().getName().endsWith("_the_end");
   }

   // $FF: synthetic method
   static ArrayList a(a var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static ArrayList b(a var0) {
      return var0.d;
   }
}
