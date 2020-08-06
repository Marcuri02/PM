package com.permadeathcore.f;

import com.permadeathcore.Main;
import java.util.ArrayList;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class c implements Listener {
   private Main a;

   public c(Main var1) {
      this.a = var1;
   }

   @EventHandler
   public void a(PlayerChangedWorldEvent var1) {
      if (var1.getPlayer().getWorld().getName().equalsIgnoreCase(this.a.i.getName())) {
         this.a(var1.getPlayer().getLocation());
      }

   }

   @EventHandler
   public void a(ChunkPopulateEvent var1) {
      if (this.a.o() >= 40L) {
         if (var1.getChunk().getWorld().getName().equalsIgnoreCase(this.a.i.getName())) {
            Entity[] var2 = var1.getChunk().getEntities();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
               Entity var5 = var2[var4];
               if (var5 instanceof ItemFrame) {
                  ItemFrame var6 = (ItemFrame)var5;
                  if (var6.getItem() != null && var6.getItem().getType() == Material.ELYTRA) {
                     ItemStack var7 = (new com.permadeathcore.j.c.d(Material.ELYTRA)).a(431).a();
                     var6.setItem(var7);
                  }
               }
            }
         }

      }
   }

   @EventHandler(
      priority = EventPriority.MONITOR
   )
   public void a(EntityExplodeEvent var1) {
      if (this.a.k() != null) {
         b var2 = this.a.k();
         if (var2.b().contains("RegenZoneLocation")) {
            Location var3 = this.a(var2.b().getString("RegenZoneLocation"));
            Iterator var4 = var1.blockList().iterator();

            while(var4.hasNext()) {
               Block var5 = (Block)var4.next();
               if (var5.getWorld().getName().equalsIgnoreCase(var3.getWorld().getName()) && var5.getLocation().distance(var3) <= 10.0D) {
                  var1.setCancelled(true);
               }
            }
         }
      }

   }

   @EventHandler(
      priority = EventPriority.MONITOR
   )
   public void a(BlockBurnEvent var1) {
      if (this.a.k() != null) {
         b var2 = this.a.k();
         if (var2.b().contains("RegenZoneLocation")) {
            Location var3 = this.a(var2.b().getString("RegenZoneLocation"));
            if (var1.getBlock().getWorld().getName().equalsIgnoreCase(var3.getWorld().getName()) && var1.getBlock().getLocation().distance(var3) <= 10.0D) {
               var1.setCancelled(true);
            }
         }
      }

   }

   @EventHandler(
      priority = EventPriority.MONITOR
   )
   public void a(BlockBreakEvent var1) {
      if (this.a.k() != null) {
         b var2 = this.a.k();
         if (var2.b().contains("RegenZoneLocation")) {
            Location var3 = this.a(var2.b().getString("RegenZoneLocation"));
            if (var1.getBlock().getWorld().getName().equalsIgnoreCase(var3.getWorld().getName()) && var1.getBlock().getLocation().distance(var3) <= 4.0D) {
               var1.setCancelled(true);
               Player var10000 = var1.getPlayer();
               Main var10001 = this.a;
               var10000.sendMessage(Main.a("&cNo puedes romper bloques cerca de la Zona de Regeneración."));
            }
         }
      }

   }

   @EventHandler(
      priority = EventPriority.MONITOR
   )
   public void a(BlockIgniteEvent var1) {
      if (this.a.k() != null) {
         b var2 = this.a.k();
         if (var2.b().contains("RegenZoneLocation")) {
            Location var3 = this.a(var2.b().getString("RegenZoneLocation"));
            if (var1.getBlock().getWorld().getName().equalsIgnoreCase(var3.getWorld().getName()) && var1.getBlock().getLocation().distance(var3) <= 3.0D) {
               var1.setCancelled(true);
            }
         }
      }

   }

   @EventHandler(
      priority = EventPriority.MONITOR
   )
   public void a(BlockPlaceEvent var1) {
      if (this.a.k() != null) {
         b var2 = this.a.k();
         if (var2.b().contains("RegenZoneLocation")) {
            Location var3 = this.a(var2.b().getString("RegenZoneLocation"));
            if (var1.getBlock().getWorld().getName().equalsIgnoreCase(var3.getWorld().getName()) && var1.getBlock().getLocation().distance(var3) <= 3.0D) {
               var1.setCancelled(true);
               Player var10000 = var1.getPlayer();
               Main var10001 = this.a;
               var10000.sendMessage(Main.a("&cNo puedes colocar bloques cerca de la Zona de Regeneración."));
            }
         }
      }

   }

   private void a(Location var1) {
      b var2 = this.a.k();
      if (!var2.b().getBoolean("CreatedRegenZone")) {
         Location var3 = var1.add(-10.0D, 0.0D, 0.0D);
         Location var4 = this.a.i.getHighestBlockAt(var3).getLocation();
         if (var4.getY() == -1.0D) {
            var4.setY(var1.getY());
         }

         Block var5 = this.a.i.getBlockAt(var4);
         this.a(true, var4);
         this.a(false, var4);
         var5.getRelative(BlockFace.UP).setType(Material.RED_CARPET);
         var5.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getRelative(BlockFace.UP).getRelative(BlockFace.UP).setType(Material.SEA_LANTERN);
         var5.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getRelative(BlockFace.UP).getRelative(BlockFace.UP).getRelative(BlockFace.UP).setType(Material.RED_CARPET);
         AreaEffectCloud var6 = (AreaEffectCloud)this.a.i.spawnEntity(var5.getRelative(BlockFace.UP).getLocation(), EntityType.AREA_EFFECT_CLOUD);
         var6.addCustomEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 0), false);
         var6.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 0), false);
         var6.setDuration(999999);
         var6.setParticle(Particle.BLOCK_CRACK, Material.AIR.createBlockData());
         var6.setRadius(4.0F);
         var2.b().set("CreatedRegenZone", true);
         var2.b().set("RegenZoneLocation", this.b(var6.getLocation()));
         var2.e();
         var2.f();
         System.out.println("[INFO] Se ha creado la zona de regeneración en el END en " + var5.getRelative(BlockFace.UP).getLocation().getX() + ", " + var5.getRelative(BlockFace.UP).getLocation().getY() + ", " + var5.getRelative(BlockFace.UP).getLocation().getZ());
         Bukkit.getServer().getScheduler().runTaskLater(this.a, new d(this), 100L);
      }

   }

   private void a(boolean var1, Location var2) {
      ArrayList var3;
      Block var4;
      Block var6;
      if (var1) {
         var3 = new ArrayList();
         var4 = this.a.i.getBlockAt(var2);
         var3.add(var4);
         var3.add(this.a.i.getBlockAt(var2).getRelative(BlockFace.EAST));
         var3.add(this.a.i.getBlockAt(var2).getRelative(BlockFace.WEST));
         var3.add(var4.getRelative(BlockFace.NORTH));
         var3.add(var4.getRelative(BlockFace.NORTH_WEST));
         var3.add(var4.getRelative(BlockFace.NORTH_EAST));
         var3.add(var4.getRelative(BlockFace.SOUTH));
         var3.add(var4.getRelative(BlockFace.SOUTH_WEST));
         var3.add(var4.getRelative(BlockFace.SOUTH_EAST));
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            var6 = (Block)var5.next();
            var6.setType(Material.RED_WOOL);
         }
      } else {
         var3 = new ArrayList();
         var4 = this.a.i.getBlockAt(var2);
         Block var10 = var4.getRelative(BlockFace.NORTH).getRelative(BlockFace.NORTH).getRelative(BlockFace.EAST).getRelative(BlockFace.EAST);
         var3.add(var10);
         var3.add(var10.getRelative(BlockFace.WEST));
         var3.add(var10.getRelative(BlockFace.WEST).getRelative(BlockFace.WEST));
         var3.add(var10.getRelative(BlockFace.WEST).getRelative(BlockFace.WEST).getRelative(BlockFace.WEST));
         var3.add(var10.getRelative(BlockFace.WEST).getRelative(BlockFace.WEST).getRelative(BlockFace.WEST).getRelative(BlockFace.WEST));
         var3.add(var10.getRelative(BlockFace.SOUTH));
         var3.add(var10.getRelative(BlockFace.SOUTH).getRelative(BlockFace.SOUTH));
         var3.add(var10.getRelative(BlockFace.SOUTH).getRelative(BlockFace.SOUTH).getRelative(BlockFace.SOUTH));
         var6 = var10.getRelative(BlockFace.SOUTH).getRelative(BlockFace.SOUTH).getRelative(BlockFace.SOUTH).getRelative(BlockFace.SOUTH);
         var3.add(var6);
         var3.add(var6.getRelative(BlockFace.WEST));
         var3.add(var6.getRelative(BlockFace.WEST).getRelative(BlockFace.WEST));
         var3.add(var6.getRelative(BlockFace.WEST).getRelative(BlockFace.WEST).getRelative(BlockFace.WEST));
         Block var7 = var6.getRelative(BlockFace.WEST).getRelative(BlockFace.WEST).getRelative(BlockFace.WEST).getRelative(BlockFace.WEST);
         var3.add(var7);
         var3.add(var7.getRelative(BlockFace.NORTH));
         var3.add(var7.getRelative(BlockFace.NORTH).getRelative(BlockFace.NORTH));
         var3.add(var7.getRelative(BlockFace.NORTH).getRelative(BlockFace.NORTH).getRelative(BlockFace.NORTH));
         Iterator var8 = var3.iterator();

         while(var8.hasNext()) {
            Block var9 = (Block)var8.next();
            var9.setType(Material.RED_GLAZED_TERRACOTTA);
         }
      }

   }

   @EventHandler
   public void b(BlockPlaceEvent var1) {
      if (!var1.isCancelled()) {
         if (this.a.i.getName().equalsIgnoreCase(var1.getBlock().getLocation().getWorld().getName()) && var1.getBlock().getType() == Material.OBSIDIAN) {
            b var2 = this.a.k();
            ArrayList var3 = (ArrayList)var2.b().getStringList("PlacedObsidian");
            var3.add(this.b(var1.getBlock().getLocation()));
            var2.b().set("PlacedObsidian", var3);
            var2.e();
            var2.f();
         }

      }
   }

   private Location a(String var1) {
      String[] var2 = var1.split(";");
      Double var3 = Double.valueOf(var2[0]);
      Double var4 = Double.valueOf(var2[1]);
      Double var5 = Double.valueOf(var2[2]);
      World var6 = Bukkit.getWorld(var2[3]);
      return new Location(var6, var3, var4, var5);
   }

   private String b(Location var1) {
      return var1.getX() + ";" + var1.getY() + ";" + var1.getZ() + ";" + var1.getWorld().getName();
   }

   // $FF: synthetic method
   static Main a(c var0) {
      return var0.a;
   }
}
