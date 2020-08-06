package com.permadeathcore.e;

import com.permadeathcore.Main;
import com.permadeathcore.f.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class a implements Listener {
   private Main a;
   private ArrayList b = new ArrayList();

   public a(Main var1) {
      this.a = var1;
   }

   @EventHandler
   public void a(ChunkLoadEvent var1) {
      Main var10001;
      Iterator var2;
      Chunk var4;
      Chunk var5;
      if (var1.getWorld().getEntitiesByClass(Cat.class).size() >= 1 && this.a.o() < 50L) {
         var2 = var1.getWorld().getEntitiesByClass(Cat.class).iterator();

         while(var2.hasNext()) {
            Cat var3 = (Cat)var2.next();
            var4 = var3.getLocation().getChunk();
            var5 = var1.getChunk();
            if (var4.getX() == var5.getX() && var4.getZ() == var5.getZ()) {
               if (this.a.o() >= 40L && this.a.o() < 50L) {
                  var10001 = this.a;
                  var3.setCustomName(Main.a("&6Gato Supernova"));
                  this.a((Entity)var3);
               }

               if (this.a.o() >= 50L) {
                  var10001 = this.a;
                  var3.setCustomName(Main.a("&6Gato Galáctico"));
               }
            }
         }
      }

      if (var1.getWorld().getEntitiesByClass(Wolf.class).size() >= 1 && this.a.o() < 50L) {
         var2 = var1.getWorld().getEntitiesByClass(Wolf.class).iterator();

         while(var2.hasNext()) {
            Wolf var7 = (Wolf)var2.next();
            var4 = var7.getLocation().getChunk();
            var5 = var1.getChunk();
            if (var4.getX() == var5.getX() && var4.getZ() == var5.getZ()) {
               Cat var6;
               if (this.a.o() >= 40L && this.a.o() < 50L) {
                  var7.remove();
                  var6 = (Cat)var7.getWorld().spawnEntity(var7.getLocation(), EntityType.CAT);
                  var6.setAdult();
                  var10001 = this.a;
                  var6.setCustomName(Main.a("&6Gato Supernova"));
                  this.a((Entity)var6);
               }

               if (this.a.o() >= 50L) {
                  var6 = (Cat)var7.getWorld().spawnEntity(var7.getLocation(), EntityType.CAT);
                  var6.setAdult();
                  var10001 = this.a;
                  var6.setCustomName(Main.a("&6Gato Galáctico"));
               }
            }
         }
      }

   }

   @EventHandler
   public void a(PlayerMoveEvent var1) {
      if (this.a.o() >= 40L) {
         this.a(var1.getPlayer());
      }

      if (this.a.o() >= 50L && var1.getPlayer().getWorld().getName().endsWith("nether")) {
         int var2 = (new Random()).nextInt(4499) + 1;
         if (var2 <= 10) {
            Location var3 = var1.getPlayer().getLocation().add(10.0D, 25.0D, -5.0D);
            Location var4 = var1.getPlayer().getLocation().add(5.0D, 25.0D, 5.0D);
            Location var5 = var1.getPlayer().getLocation().add(-5.0D, 25.0D, 5.0D);
            int var6;
            int var7;
            if (var1.getPlayer().getWorld().getBlockAt(var3).getType() == Material.AIR) {
               var6 = (new Random()).nextInt(2) + 1;

               for(var7 = 0; var7 < var6; ++var7) {
                  this.a.f().a("PigZombie", EntityType.PIG_ZOMBIE, var3, SpawnReason.CUSTOM);
               }
            }

            if (var1.getPlayer().getWorld().getBlockAt(var4).getType() == Material.AIR) {
               var6 = (new Random()).nextInt(2) + 1;

               for(var7 = 0; var7 < var6; ++var7) {
                  this.a.f().a("PigZombie", EntityType.PIG_ZOMBIE, var3, SpawnReason.CUSTOM);
               }
            }

            if (var1.getPlayer().getWorld().getBlockAt(var5).getType() == Material.AIR) {
               var6 = (new Random()).nextInt(2) + 1;

               for(var7 = 0; var7 < var6; ++var7) {
                  this.a.f().a("PigZombie", EntityType.PIG_ZOMBIE, var3, SpawnReason.CUSTOM);
               }
            }
         }
      }

   }

   @EventHandler
   public void a(CreatureSpawnEvent var1) {
      if (var1.getEntity().getType() == EntityType.CAT || var1.getEntity().getType() == EntityType.OCELOT) {
         LivingEntity var10000;
         Main var10001;
         if (this.a.o() >= 50L) {
            if (var1.getSpawnReason() == SpawnReason.CUSTOM) {
               this.a((Entity)var1.getEntity());
            } else {
               var10000 = var1.getEntity();
               var10001 = this.a;
               var10000.setCustomName(Main.a("&6Gato Galáctico"));
            }
         }

         if (this.a.o() >= 40L && this.a.o() < 50L) {
            this.a((Entity)var1.getEntity());
            var10000 = var1.getEntity();
            var10001 = this.a;
            var10000.setCustomName(Main.a("&6Gato Supernova"));
         }
      }

   }

   private void a(Entity var1) {
      if (!this.b.contains(var1)) {
         this.b.add(var1);
         int var2 = (int)var1.getLocation().getX();
         int var3 = (int)var1.getLocation().getY();
         int var4 = (int)var1.getLocation().getZ();
         boolean var5 = true;
         if (Bukkit.getOnlinePlayers().size() == 0) {
            var5 = false;
         }

         if (!var5) {
            var1.remove();
         } else {
            Main var10000 = this.a;
            Bukkit.broadcastMessage(Main.a("&cUn gato supernova va a explotar en: " + var2 + " " + var3 + " " + var4 + " (" + var1.getWorld().getName() + ")."));
            World var6 = var1.getWorld();
            Location var7 = var1.getLocation();
            Bukkit.getServer().getScheduler().runTaskLater(this.a, new b(this, var1, var6, var7), 600L);
         }
      }
   }

   @EventHandler
   public void a(EntityDeathEvent var1) {
      if (this.b.contains(var1.getEntity())) {
         this.b.remove(var1.getEntity());
      }

      if (var1.getEntity().getCustomName() != null) {
         String var10000 = var1.getEntity().getCustomName();
         Main var10001 = this.a;
         if (var10000.contains(Main.a("&6Gato Gal"))) {
            Location var2 = var1.getEntity().getLocation();
            int var3 = (int)var2.getX();
            int var4 = (int)var2.getY();
            int var5 = (int)var2.getZ();
            Main var6 = this.a;
            Bukkit.broadcastMessage(Main.a("&cLa maldición de un Gato Galáctico ha comenzado en: " + var3 + ", " + var4 + ", " + var5));
            (new com.permadeathcore.h.b(var1.getEntity().getLocation(), this.a)).runTaskTimer(this.a, 0L, 20L);
         }

      }
   }

   @EventHandler
   public void a(PlayerDropItemEvent var1) {
      if (!var1.isCancelled()) {
         if (var1.getItemDrop().getItemStack() != null && var1.getItemDrop().getItemStack().getType() == Material.STRUCTURE_VOID) {
            var1.setCancelled(true);
         }

      }
   }

   @EventHandler(
      priority = EventPriority.MONITOR
   )
   public void a(InventoryClickEvent var1) {
      if (!var1.isCancelled()) {
         if (var1.getCurrentItem() != null && var1.getCurrentItem().getType() == Material.STRUCTURE_VOID) {
            var1.setCancelled(true);
            if (var1.getClick() == ClickType.NUMBER_KEY) {
               var1.getInventory().remove(Material.STRUCTURE_VOID);
            }
         }

         if (var1.getCursor() != null && var1.getCursor().getType() == Material.STRUCTURE_VOID) {
            var1.setCancelled(true);
         }

      }
   }

   @EventHandler
   public void a(PrepareItemCraftEvent var1) {
      if (var1.getInventory() != null && var1.getInventory().getResult() != null && (var1.getInventory().getResult().getType() == Material.TORCH || var1.getInventory().getResult().getType() == Material.REDSTONE_TORCH)) {
         var1.getInventory().setResult((ItemStack)null);
      }

   }

   @EventHandler
   public void a(BlockPlaceEvent var1) {
      if (var1.getBlock().getType() == Material.STRUCTURE_VOID) {
         var1.setCancelled(true);
      }

   }

   @EventHandler
   public void a(PlayerSwapHandItemsEvent var1) {
      if (!var1.isCancelled()) {
         if (var1.getOffHandItem() != null && var1.getOffHandItem().getType() == Material.STRUCTURE_VOID) {
            var1.setCancelled(true);
         }

         if (var1.getMainHandItem() != null && var1.getMainHandItem().getType() == Material.STRUCTURE_VOID) {
            var1.setCancelled(true);
         }

      }
   }

   @EventHandler
   public void a(PlayerItemConsumeEvent var1) {
      if (!var1.isCancelled()) {
         if (var1.getItem() != null && var1.getItem().hasItemMeta() && var1.getItem().getItemMeta().hasDisplayName()) {
            String var10000 = var1.getItem().getItemMeta().getDisplayName();
            Main var10001 = this.a;
            if (var10000.equalsIgnoreCase(Main.a("&6Super Golden Apple +"))) {
               Player var2 = var1.getPlayer();
               short var3 = 300;
               if (!var2.hasPotionEffect(PotionEffectType.HEALTH_BOOST)) {
                  var2.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 20 * var3, 0));
               }
            } else {
               var10000 = var1.getItem().getItemMeta().getDisplayName();
               var10001 = this.a;
               if (var10000.equalsIgnoreCase(Main.a("&6Hyper Golden Apple +"))) {
                  g var4 = new g(var1.getPlayer().getName(), this.a);
                  if (var4.e() == 0) {
                     var4.a(4);
                  }
               }
            }
         }

      }
   }

   public void a(Player var1) {
      Location var2 = var1.getWorld().getHighestBlockAt(var1.getLocation()).getLocation();
      Double var3 = var2.getY();
      if (var1.getWorld().hasStorm() && var3 < var1.getLocation().getY()) {
         int var4 = (new Random()).nextInt(9999);
         if (this.a.o() >= 50L) {
            if (var4 <= 299) {
               var1.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1200, 0));
            }

            if (var4 == 1000) {
               int var5 = (new Random()).nextInt(17);
               var5 += 3;
               var1.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, var5 * 20, 0));
            }
         } else if (var4 == 1) {
            var1.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1200, 0));
         }
      }

   }

   @EventHandler(
      priority = EventPriority.MONITOR
   )
   public void a(InventoryMoveItemEvent var1) {
      if (!var1.isCancelled()) {
         if (var1.getItem() != null && var1.getItem().getType() == Material.STRUCTURE_VOID) {
            var1.setCancelled(true);
         }

      }
   }

   @EventHandler(
      priority = EventPriority.MONITOR
   )
   public void a(InventoryPickupItemEvent var1) {
      if (!var1.isCancelled()) {
         if (var1.getItem().getItemStack() != null && var1.getItem().getItemStack().getType() == Material.STRUCTURE_VOID) {
            var1.setCancelled(true);
         }

      }
   }

   @EventHandler
   public void a(ProjectileLaunchEvent var1) {
      if (this.a.o() >= 40L) {
         if (var1.getEntity().getShooter() instanceof Witch && var1.getEntity() instanceof ThrownPotion) {
            ThrownPotion var2 = (ThrownPotion)var1.getEntity();
            int var3 = (new Random()).nextInt(2) + 1;
            ItemStack var4;
            PotionMeta var5;
            Iterator var6;
            PotionEffect var7;
            if (var3 == 1) {
               var4 = new ItemStack(Material.SPLASH_POTION);
               var5 = (PotionMeta)var4.getItemMeta();
               if (!var5.getCustomEffects().isEmpty() || var5.getCustomEffects().size() >= 1) {
                  var6 = var5.getCustomEffects().iterator();

                  while(var6.hasNext()) {
                     var7 = (PotionEffect)var6.next();
                     var5.removeCustomEffect(var7.getType());
                  }
               }

               var5.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 20, 3), true);
               var4.setItemMeta(var5);
               var2.setItem(var4);
            } else if (var3 == 2) {
               short var9 = 300;
               ItemStack var10 = new ItemStack(Material.SPLASH_POTION);
               PotionMeta var11 = (PotionMeta)var10.getItemMeta();
               if (!var11.getCustomEffects().isEmpty() || var11.getCustomEffects().size() >= 1) {
                  Iterator var12 = var11.getCustomEffects().iterator();

                  while(var12.hasNext()) {
                     PotionEffect var8 = (PotionEffect)var12.next();
                     var11.removeCustomEffect(var8.getType());
                  }
               }

               var11.addCustomEffect(new PotionEffect(PotionEffectType.POISON, var9 * 20, 2), true);
               var10.setItemMeta(var11);
               var2.setItem(var10);
            } else {
               var4 = new ItemStack(Material.SPLASH_POTION);
               var5 = (PotionMeta)var4.getItemMeta();
               if (!var5.getCustomEffects().isEmpty() || var5.getCustomEffects().size() >= 1) {
                  var6 = var5.getCustomEffects().iterator();

                  while(var6.hasNext()) {
                     var7 = (PotionEffect)var6.next();
                     var5.removeCustomEffect(var7.getType());
                  }
               }

               var5.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 400, 4), true);
               var4.setItemMeta(var5);
               var2.setItem(var4);
            }
         }

      }
   }

   @EventHandler
   public void a(InventoryDragEvent var1) {
      if (!var1.getNewItems().isEmpty()) {
         Iterator var2 = var1.getNewItems().keySet().iterator();

         while(var2.hasNext()) {
            int var3 = (Integer)var2.next();
            ItemStack var4 = (ItemStack)var1.getNewItems().get(var3);
            if (var4 != null && var4.getType() == Material.STRUCTURE_VOID) {
               var1.getInventory().removeItem(new ItemStack[]{var4});
            }
         }
      }

   }

   @EventHandler
   public void a(PlayerInteractEvent var1) {
      if (var1.getPlayer().getInventory().getItemInMainHand() != null && this.a(var1.getPlayer(), var1.getPlayer().getInventory().getItemInMainHand())) {
         var1.setCancelled(true);
      }

      if (var1.getPlayer().getInventory().getItemInOffHand() != null && this.a(var1.getPlayer(), var1.getPlayer().getInventory().getItemInOffHand())) {
         var1.setCancelled(true);
      }

   }

   public boolean a(Player var1, ItemStack var2) {
      if (var2 == null) {
         return false;
      } else if (!var2.hasItemMeta()) {
         return false;
      } else {
         if (var2.getType() == Material.LIGHT_BLUE_DYE) {
            String var10000 = var2.getItemMeta().getDisplayName();
            Main var10001 = this.a;
            if (var10000.endsWith(Main.a("&6Reliquia Del Fin"))) {
               return true;
            }
         }

         return false;
      }
   }

   private ItemStack a() {
      com.permadeathcore.j.c.d var10000 = new com.permadeathcore.j.c.d(Material.LIGHT_BLUE_DYE);
      Main var10001 = this.a;
      ItemStack var1 = var10000.c(Main.a("&6Reliquia Del Fin")).a();
      ItemMeta var2 = var1.getItemMeta();
      var2.setUnbreakable(true);
      var2.setLore(Arrays.asList(com.permadeathcore.j.c.b.a("{" + UUID.randomUUID().toString() + ": 0}")));
      var1.setItemMeta(var2);
      return var1;
   }

   // $FF: synthetic method
   static ArrayList a(a var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static Main b(a var0) {
      return var0.a;
   }
}
