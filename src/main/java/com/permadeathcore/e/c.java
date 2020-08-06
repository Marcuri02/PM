package com.permadeathcore.e;

import com.destroystokyo.paper.event.entity.EnderDragonFireballHitEvent;
import com.destroystokyo.paper.event.entity.EntityTeleportEndGatewayEvent;
import com.destroystokyo.paper.event.player.PlayerTeleportEndGatewayEvent;
import com.permadeathcore.Main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.EndGateway;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class c implements Listener {
   private Main a;

   public c(Main var1) {
      this.a = var1;
   }

   @EventHandler
   public void a(EnderDragonFireballHitEvent var1) {
      AreaEffectCloud var2 = var1.getAreaEffectCloud();
      if (this.a.l() != null) {
         if (this.a.l().i() == com.permadeathcore.b.a.b.b) {
            Location var3 = this.a.i.getHighestBlockAt(var2.getLocation()).getLocation();
            Block var4 = this.a.i.getHighestBlockAt(var2.getLocation());
            if (var3.getY() != -1.0D) {
               int var5 = (new Random()).nextInt(4);
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
                  if (var10.getType() != Material.AIR) {
                     var10.setType(Material.BEDROCK);
                  }
               }
            }
         } else {
            int var12 = (new Random()).nextInt(2);
            if (var12 == 0) {
               var2.setParticle(Particle.SMOKE_NORMAL);
               var2.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 20, 1), false);
            } else {
               Location var13 = this.a.i.getHighestBlockAt(var2.getLocation()).getLocation();
               Block var14 = this.a.i.getHighestBlockAt(var2.getLocation());
               if (var13.getY() != -1.0D) {
                  int var15 = (new Random()).nextInt(4);
                  ArrayList var16 = new ArrayList();
                  if (var15 == 0) {
                     var16.add(var14.getRelative(BlockFace.NORTH));
                     var16.add(var14.getRelative(BlockFace.NORTH).getRelative(BlockFace.WEST));
                     var16.add(var14.getRelative(BlockFace.SOUTH));
                     var16.add(var14.getRelative(BlockFace.SOUTH_EAST));
                     var16.add(var14.getRelative(BlockFace.SOUTH_WEST));
                     var16.add(var14.getRelative(BlockFace.SOUTH_EAST).getRelative(BlockFace.SOUTH));
                     var16.add(var14.getRelative(BlockFace.SOUTH_EAST).getRelative(BlockFace.NORTH));
                     var16.add(var14.getRelative(BlockFace.NORTH).getRelative(BlockFace.NORTH));
                  } else if (var15 == 1) {
                     var16.add(var14.getRelative(BlockFace.NORTH));
                     var16.add(var14.getRelative(BlockFace.NORTH_EAST));
                     var16.add(var14);
                  } else if (var15 == 2) {
                     var16.add(var14.getRelative(BlockFace.SOUTH));
                     var16.add(var14.getRelative(BlockFace.SOUTH_WEST));
                     var16.add(var14);
                  } else if (var15 == 3) {
                     var16.add(var14.getRelative(BlockFace.NORTH));
                     var16.add(var14.getRelative(BlockFace.NORTH_EAST));
                     var16.add(var14);
                     var16.add(var14.getRelative(BlockFace.SOUTH));
                     var16.add(var14.getRelative(BlockFace.EAST));
                  } else if (var15 == 4) {
                     var16.add(var14.getRelative(BlockFace.SOUTH));
                     var16.add(var14.getRelative(BlockFace.NORTH_WEST));
                     var16.add(var14);
                     var16.add(var14.getRelative(BlockFace.NORTH));
                     var16.add(var14.getRelative(BlockFace.WEST));
                  }

                  Iterator var17 = var16.iterator();

                  while(var17.hasNext()) {
                     Block var18 = (Block)var17.next();
                     Location var19 = this.a.i.getHighestBlockAt(new Location(this.a.i, (double)var18.getX(), (double)var18.getY(), (double)var18.getZ())).getLocation();
                     Block var11 = this.a.i.getBlockAt(var19);
                     if (var11.getType() != Material.AIR) {
                        var11.setType(Material.BEDROCK);
                     }
                  }
               }
            }
         }
      }

   }

   @EventHandler
   public void a(EntityTeleportEndGatewayEvent var1) {
      if (this.a.o() >= 40L) {
         if (this.a.o() >= 50L) {
            if (this.a.i().d()) {
               var1.setCancelled(true);
               return;
            }

            EndGateway var2 = var1.getGateway();
            Entity var3 = var1.getEntity();
            Location var4 = var1.getFrom();
            World var5 = var4.getWorld();
            if (var3 instanceof Player) {
               return;
            }

            var1.setCancelled(true);
            Vector var6 = var3.getLocation().getDirection();
            Vector var7 = var3.getVelocity();
            Float var8 = var3.getLocation().getPitch();
            Float var9 = var3.getLocation().getYaw();
            if (var5.getName().equalsIgnoreCase(this.a.h.getName())) {
               Location var10 = this.a.j().c();
               var10.setDirection(var6);
               var10.setPitch(var8);
               var10.setYaw(var9);
               var3.teleport(var10, TeleportCause.PLUGIN);
               var3.setVelocity(var7);
            }

            if (var5.getName().equalsIgnoreCase("pdc_the_beginning")) {
               Bukkit.getScheduler().runTaskLater(this.a, new d(this, var6, var8, var9, var3, var7), 1L);
            }
         }

      }
   }

   @EventHandler
   public void a(PlayerTeleportEndGatewayEvent var1) {
      if (this.a.o() >= 40L) {
         if (this.a.o() >= 50L) {
            if (this.a.o() >= 50L) {
               if (this.a.i().d()) {
                  var1.setCancelled(true);
                  return;
               }

               EndGateway var2 = var1.getGateway();
               Player var3 = var1.getPlayer();
               Location var4 = var1.getFrom();
               World var5 = var4.getWorld();
               var2.setExitLocation(var2.getLocation());
               var2.update();
               var1.setCancelled(true);
               Vector var6 = var3.getLocation().getDirection();
               Vector var7 = var3.getVelocity();
               if (var5.getName().equalsIgnoreCase(this.a.h.getName())) {
                  Bukkit.getScheduler().runTaskLater(this.a, new e(this, var6, var3, var7), 1L);
               }

               if (var5.getName().equalsIgnoreCase("pdc_the_beginning")) {
                  Bukkit.getScheduler().runTaskLater(this.a, new f(this, var6, var3, var7), 1L);
               }
            }

         } else {
            if (var1.getPlayer().getWorld().getName().equalsIgnoreCase(this.a.h.getName()) || var1.getPlayer().getWorld().getName().equalsIgnoreCase(this.a.i().a().getName())) {
               var1.getPlayer().damage(var1.getPlayer().getHealth());
               Main var10000 = this.a;
               Bukkit.broadcastMessage(Main.a("&c&lEl jugador &4&l" + var1.getPlayer().getName() + " &c&lentró a TheBeginning antes de tiempo."));
            }

         }
      }
   }

   // $FF: synthetic method
   static Main a(c var0) {
      return var0.a;
   }
}
