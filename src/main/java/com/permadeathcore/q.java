package com.permadeathcore;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.SplittableRandom;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EnderDragon;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

class q implements Runnable {
   // $FF: synthetic field
   final Main a;

   q(Main var1) {
      this.a = var1;
   }

   public void run() {
      if (!Main.a(this.a)) {
         Main.b(this.a);
         com.permadeathcore.j.d.a.a(Main.a);
         Main.a(this.a, true);
      }

      if (Main.c(this.a)) {
         Bukkit.broadcastMessage(Main.a(this.a.g + "&7> &4&lADVERTENCIA&7: &eEl plugin NO es compatible con CraftBukkit, cambia a SpigotMC o PaperSpigot"));
      } else if (Bukkit.getPluginManager().getPlugin("WorldEdit") == null) {
         Main var10000 = Main.a;
         Bukkit.broadcastMessage(Main.a(this.a.g + "&7 &4&lADVERTENCIA&7: &eEl plugin NO pudo encontrar WorldEdit, por favor instalalo."));
         var10000 = Main.a;
         Bukkit.broadcastMessage(Main.a("&c&lDe lo contrario el plugin NO funcionará."));
      } else {
         this.a.a();
         long var1 = (long)(this.a.h.getWeatherDuration() / 20);
         long var3 = var1 % 86400L / 3600L;
         long var5 = var1 % 3600L / 60L;
         long var7 = var1 % 60L;
         long var9 = var1 / 86400L;
         String var11 = String.format("%02d:%02d:%02d", var3, var5, var7);
         if (var9 == 1L) {
            var11 = var9 + " día, " + var11;
         }

         if (var9 > 1L) {
            var11 = var9 + " días, " + var11;
         }

         if (!Main.d(this.a).exists()) {
            this.a.saveDefaultConfig();
         }

         Main.a(this.a, this.a.b.until(this.a.c, ChronoUnit.DAYS));
         this.a.c = LocalDate.now();
         this.a.e = Main.e(this.a) * 3600L;
         this.a.f = this.a.e / 60L / 60L;

         try {
            this.a.b = LocalDate.parse(Main.f(this.a).getString("Fecha"));
         } catch (DateTimeParseException var13) {
            Bukkit.getConsoleSender().sendMessage(Main.a(this.a.g + "&eLa fecha está mal configurada, por favor ingresa /pdc cambiardia o borra el archivo config.yml"));
         }

         if (Main.e(this.a) >= 60L && !Main.g(this.a)) {
            Main.b(this.a, true);
         }

         Bukkit.getOnlinePlayers().forEach((var2) -> {
            this.a.g().a(var2);
            if (this.a.h.hasStorm()) {
               String var3 = Main.h(this.a).a("ActionBarMessage", var2).replace("%tiempo%", var11);
               var2.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(var3));
            }

            if (var2.getWorld().getEnvironment() == Environment.THE_END && this.a.o() >= 30L && var2.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.BEDROCK) {
               var2.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 200, 9));
            }

            if (this.a.o() >= 60L && var2.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SOUL_SAND) {
               var2.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 600, 2));
            }

            if (var2.getWorld().getName().equalsIgnoreCase("pdc_the_beginning") && var2.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
               var2.removePotionEffect(PotionEffectType.INVISIBILITY);
            }

            if (this.a.o() >= 40L) {
               com.permadeathcore.j.c.a.a(var2);
            }

            int var6;
            int var7;
            int var8;
            if (this.a.o() >= 50L) {
               if (this.a.j() != null && this.a.i() != null) {
                  com.permadeathcore.f.a var10 = this.a.j();
                  World var4 = this.a.i().a();
                  if (!var10.e()) {
                     Chunk var5 = var4.getBlockAt(0, 100, 0).getChunk();
                     var6 = 0;

                     while(true) {
                        if (var6 >= 16) {
                           if (var4.getEntitiesByClass(EnderDragon.class).size() < 1) {
                              break;
                           }

                           Iterator var15 = var4.getEntitiesByClass(EnderDragon.class).iterator();

                           while(var15.hasNext()) {
                              EnderDragon var16 = (EnderDragon)var15.next();
                              var16.remove();
                           }

                           var10.f();
                           break;
                        }

                        for(var7 = var4.getMaxHeight() - 1; var7 > 0; --var7) {
                           for(var8 = 0; var8 < 16; ++var8) {
                              Block var9 = var5.getBlock(var6, var7, var8);
                              if (var9.getType() == Material.END_GATEWAY || var9.getType() == Material.BEDROCK) {
                                 var9.setType(Material.AIR);
                              }
                           }
                        }

                        ++var6;
                     }
                  }
               }

               if (var2.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
                  PotionEffect var11x = var2.getPotionEffect(PotionEffectType.SLOW_DIGGING);
                  if (var11x.getDuration() >= 4800 && !this.a.r().contains(var2)) {
                     short var13 = 600;
                     var2.removePotionEffect(PotionEffectType.SLOW_DIGGING);
                     var2.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, var13 * 20, 2));
                     this.a.r().add(var2);
                  }

                  if (var11x.getDuration() == 4799 && this.a.r().contains(var2)) {
                     this.a.r().remove(var2);
                  }
               }
            }

            if (this.a.o() >= 60L && this.a.getConfig().getBoolean("Toggles.Mike-Creeper-Spawn")) {
               Location var12 = var2.getLocation();
               SplittableRandom var14 = new SplittableRandom();
               if (var14.nextInt(5000) == 0) {
                  var12.setY(var12.getY() - 10.0D);
                  if (var12.getY() < 0.0D) {
                     var12.setY(1.0D);
                  }

                  for(var6 = (int)var12.getY(); var6 < var12.getWorld().getMaxHeight() && var12.getWorld().getBlockAt((int)var12.getX(), var6, (int)var12.getZ()).getType() != Material.AIR; ++var6) {
                  }

                  var7 = var14.nextInt(10) + 1;
                  var8 = var14.nextInt(10) + 1;
                  if (var14.nextBoolean()) {
                     var7 *= -1;
                  }

                  if (var14.nextBoolean()) {
                     var8 *= -1;
                  }

                  Location var17 = new Location(var12.getWorld(), var12.getX() + (double)var7, (double)var6, var12.getZ() + (double)var8);
                  this.a.d().c(var17);
               }
            }

         });
      }
   }
}
