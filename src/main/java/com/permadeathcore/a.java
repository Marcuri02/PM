package com.permadeathcore;

import com.permadeathcore.g.a.a.a.B;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.SplittableRandom;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.BanList.Type;
import org.bukkit.World.Environment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.LlamaSpit;
import org.bukkit.entity.Player;
import org.bukkit.entity.PolarBear;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityAirChangeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;
import org.bukkit.event.player.PlayerBedEnterEvent.BedEnterResult;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.event.raid.RaidFinishEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class a implements Listener {
   private final Main j;
   private LocalDate k;
   private LocalDate l;
   World a;
   String b;
   ArrayList c = new ArrayList();
   ArrayList d = new ArrayList();
   long e;
   long f;
   boolean g = false;
   Object h;
   public boolean i;

   public a(Main var1) {
      this.j = var1;
      this.a = var1.h;
      this.b = Main.a.g;
      this.e = this.j.o() * 3600L;
      this.f = this.e / 60L / 60L;
      this.l = LocalDate.parse(Main.a.d);
      this.k = LocalDate.now();
      this.i = true;
      this.h = new B();
      this.a();
   }

   public void a() {
      if (this.j.o() <= 24L) {
         this.e = this.j.o() * 3600L;
         this.f = this.e / 60L / 60L;
      }

      long var1;
      if (this.j.o() >= 25L && this.j.o() < 50L) {
         var1 = this.j.o() - 24L;
         this.e = var1 * 3600L;
         this.f = this.e / 60L / 60L;
      }

      if (this.j.o() == 50L) {
         this.e = 1800L;
         this.f = this.e / 60L / 60L;
      }

      if (this.j.o() > 50L && this.j.o() < 75L) {
         var1 = this.j.o() - 49L;
         this.e = var1 * 3600L / 2L;
         this.f = this.e / 60L / 60L;
      }

   }

   @EventHandler
   public void a(PlayerDeathEvent var1) {
      try {
         if (!var1.getDrops().isEmpty()) {
            Iterator var2 = var1.getDrops().iterator();

            while(var2.hasNext()) {
               ItemStack var3 = (ItemStack)var2.next();
               if (var3 != null && var3.getType() == Material.STRUCTURE_VOID) {
                  var1.getDrops().remove(var3);
               }
            }
         }
      } catch (ConcurrentModificationException var27) {
      }

      Player var28 = var1.getEntity();
      int var29 = var28.getLocation().getBlockX();
      int var4 = var28.getLocation().getBlockZ();
      int var5 = var28.getLocation().getBlockY() - 1;
      int var6 = var5 + 1;
      int var7 = var6 + 1;
      Location var8 = var28.getLocation();
      if (this.j.getConfig().getBoolean("Toggles.Player-Skulls")) {
         (new b(this, var7, var8, var29, var4, var28, var5, var6)).runTaskLater(this.j, 10L);
      }

      boolean var9 = this.a.hasStorm();
      String var10 = var1.getEntity().getPlayer().getName();
      int var11 = var1.getEntity().getPlayer().getLocation().getBlockX();
      int var12 = var1.getEntity().getPlayer().getLocation().getBlockY();
      int var13 = var1.getEntity().getPlayer().getLocation().getBlockZ();
      Iterator var14 = Bukkit.getOnlinePlayers().iterator();

      while(var14.hasNext()) {
         Player var15 = (Player)var14.next();
         String var16 = this.a("DeathMessageChat", var15).replace("%player%", var10);
         var15.sendMessage(var16);
      }

      this.b(this.a("DeathMessageChat").replace("%player%", var10));
      Main var10000;
      if (Main.a.getConfig().contains("Server-Messages.CustomDeathMessages." + var28.getName())) {
         var10000 = Main.a;
         Bukkit.broadcastMessage(Main.a(Main.a.getConfig().getString("Server-Messages.CustomDeathMessages." + var28.getName()).replace("%player%", var28.getName())));
      } else {
         var10000 = Main.a;
         Bukkit.broadcastMessage(Main.a(Main.a.getConfig().getString("Server-Messages.DefaultDeathMessage").replace("%player%", var28.getName())));
      }

      if (Main.a.getConfig().getBoolean("Server-Messages.coords-msg-enable")) {
         Bukkit.broadcastMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "X: " + var11 + " || Y: " + var12 + " || Z: " + var13 + ChatColor.RESET);
      }

      this.a();
      int var30 = this.a.getWeatherDuration();
      int var31 = var30 / 20;
      long var32 = (long)var31 + this.e;
      int var18 = (int)this.e;
      int var19 = (int)var32;
      boolean var20 = Main.a.getConfig().getBoolean("Toggles.OP-Ban");
      if (!var20) {
         if (!var1.getEntity().hasPermission("permadeathcore.banoverride")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "minecraft:weather thunder");
            if (var9) {
               this.a.setWeatherDuration(var19 * 20);
               if (Main.a.o() >= 50L) {
                  if (Main.a.i() != null) {
                     Main.a.i().b();
                  }

                  var10000 = Main.a;
                  Bukkit.broadcastMessage(Main.a(this.b + "&e¡Ha comenzado el modo UHC!"));
                  this.g = true;
               }
            } else {
               this.a.setWeatherDuration(var18 * 20);
               if (Main.a.o() >= 50L) {
                  if (Main.a.i() != null) {
                     Main.a.i().b();
                  }

                  var10000 = Main.a;
                  Bukkit.broadcastMessage(Main.a(this.b + "&e¡Ha comenzado el modo UHC!"));
                  this.g = true;
               }
            }
         }
      } else {
         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "minecraft:weather thunder");
         if (var9) {
            this.a.setWeatherDuration(var19 * 20);
            if (Main.a.o() >= 50L) {
               if (Main.a.i() != null) {
                  Main.a.i().b();
               }

               var10000 = Main.a;
               Bukkit.broadcastMessage(Main.a(this.b + "&e¡Ha comenzado el modo UHC!"));
               this.g = true;
            }
         } else {
            this.a.setWeatherDuration(var18 * 20);
            if (Main.a.o() >= 50L) {
               if (Main.a.i() != null) {
                  Main.a.i().b();
               }

               var10000 = Main.a;
               Bukkit.broadcastMessage(Main.a(this.b + "&e¡Ha comenzado el modo UHC!"));
               this.g = true;
            }
         }
      }

      com.permadeathcore.f.g var21 = new com.permadeathcore.f.g(var1.getEntity().getPlayer().getName(), Main.a);
      var21.a(var1.getEntity().getPlayer().getLastDamageCause().getCause());
      var21.g();
      var21.f();
      var21.a(var1.getEntity().getPlayer().getLocation());
      BukkitScheduler var22 = Bukkit.getServer().getScheduler();
      if (!var20) {
         if (!var1.getEntity().hasPermission("permadeathcore.banoverride")) {
            var22.scheduleSyncDelayedTask(Main.a, new i(this), 75L);
         } else {
            var10000 = Main.a;
            Bukkit.broadcastMessage(Main.a("&eEl jugador &b" + var1.getEntity().getName() + " &eno puede dar más horas de tormenta (es operador)."));
         }
      } else {
         var22.scheduleSyncDelayedTask(Main.a, new j(this), 75L);
      }

      Iterator var23 = Bukkit.getOnlinePlayers().iterator();

      while(var23.hasNext()) {
         Player var24 = (Player)var23.next();
         String var25 = this.a("DeathMessageTitle", var24);
         String var26 = this.a("DeathMessageSubtitle", var24);
         var24.sendTitle(var25, var26.replace("%player%", var10));
         var24.playSound(var24.getLocation(), Sound.ENTITY_BLAZE_DEATH, 10.0F, -5.0F);
      }

      var22.runTaskLater(Main.a, new k(this, var28, var20), 3L);
      if (!var20) {
         if (!var28.hasPermission("permadeathcore.banoverride") && Main.a.getConfig().getBoolean("ban-enabled")) {
            var22.runTaskLater(Main.a, new l(this, var28), 100L);
         }
      } else if (Main.a.getConfig().getBoolean("ban-enabled")) {
         var22.runTaskLater(Main.a, new m(this, var28), 100L);
      }

   }

   @EventHandler
   public void a(EntityPickupItemEvent var1) {
      if (!var1.isCancelled()) {
         if (var1.getEntity() instanceof Player) {
            ItemStack var2 = var1.getItem().getItemStack();
            if (var2.getType() == Material.PLAYER_HEAD) {
               SkullMeta var3 = (SkullMeta)var2.getItemMeta();
               com.permadeathcore.f.g var4 = new com.permadeathcore.f.g(var3.getOwner(), Main.a);
               var4.a(var2);
            }
         }

      }
   }

   @EventHandler
   public void a(PlayerBedEnterEvent var1) {
      Main var10001;
      Player var10;
      if (var1.getPlayer().getWorld().getEnvironment() != Environment.NORMAL) {
         var10 = var1.getPlayer();
         var10001 = Main.a;
         var10.sendMessage(Main.a("&cSolo puedes dormir en el Overworld."));
      } else if (var1.getBedEnterResult() != BedEnterResult.OK) {
         var10 = var1.getPlayer();
         var10001 = Main.a;
         var10.sendMessage(Main.a("&cNo puedes dormir ahora."));
      } else if (this.j.o() >= 20L) {
         Location var8 = var1.getBed().getLocation().add(0.0D, 1.0D, 0.0D);
         this.a.playSound(var8, Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
         this.a.spawnParticle(Particle.EXPLOSION_HUGE, var8, 1);
         if (this.j.o() >= 50L) {
            if ((new SplittableRandom()).nextInt(100) + 1 <= 10) {
               var10 = var1.getPlayer();
               var10001 = this.j;
               var10.sendMessage(Main.a(this.b + " &aHas restablecido el contador de Phantoms."));
               var1.getPlayer().setStatistic(Statistic.TIME_SINCE_REST, 0);
            }
         } else {
            var10 = var1.getPlayer();
            var10001 = this.j;
            var10.sendMessage(Main.a(this.b + " &aHas restablecido el contador de Phantoms."));
            var1.getPlayer().setStatistic(Statistic.TIME_SINCE_REST, 0);
         }

         var1.setCancelled(true);
      } else {
         Player var2 = var1.getPlayer();
         long var3 = Main.a.h.getTime();
         byte var5 = 1;
         if (Main.a.o() >= 10L) {
            var5 = 4;
         }

         if (Bukkit.getOnlinePlayers().size() < var5) {
            var2.sendMessage(Main.a("&cNo puedes dormir porque no hay suficientes personas en línea (" + var5 + ")."));
            var1.setCancelled(true);
         } else if (var3 < 13000L) {
            var10001 = Main.a;
            var2.sendMessage(Main.a("&cSolo puedes dormir de noche."));
            var1.setCancelled(true);
         } else {
            if (this.j.o() < 10L && var3 >= 13000L) {
               ArrayList var6 = new ArrayList();
               Bukkit.getServer().getScheduler().runTaskLater(Main.a, new n(this, var1, var2, var6), 60L);
            }

            if (this.j.o() >= 10L && this.j.o() <= 19L && var3 >= 13000L) {
               this.d.add(var2);
               Bukkit.getOnlinePlayers().forEach((var2x) -> {
                  String var3 = this.a("Sleeping", var2x).replace("%needed%", String.valueOf(4)).replace("%players%", String.valueOf(this.d.size())).replace("%player%", var2.getName());
                  var2x.sendMessage(var3);
               });
               this.b(this.a("Sleeping").replace("%needed%", String.valueOf(4)).replace("%players%", String.valueOf(this.d.size())).replace("%player%", var2.getName()));
               if (this.d.size() >= var5 && this.d.size() < Bukkit.getOnlinePlayers().size()) {
                  Bukkit.getServer().getScheduler().runTaskLater(Main.a, new o(this, var1), 40L);
               }

               if (this.d.size() == Bukkit.getOnlinePlayers().size()) {
                  var1.getPlayer().getWorld().setTime(0L);
                  Iterator var9 = Bukkit.getOnlinePlayers().iterator();

                  Main var10000;
                  while(var9.hasNext()) {
                     Player var7 = (Player)var9.next();
                     var7.setStatistic(Statistic.TIME_SINCE_REST, 0);
                     var7.damage(0.1D);
                     var10000 = Main.a;
                     Bukkit.broadcastMessage(Main.a((String)Objects.requireNonNull(Main.a.getConfig().getString("Server-Messages.Sleep").replace("%player%", var7.getName()))));
                  }

                  var10000 = Main.a;
                  Bukkit.broadcastMessage(Main.a("&eHan dormido todos los jugadores."));
                  this.d.clear();
                  var1.setCancelled(true);
               }
            }

         }
      }
   }

   @EventHandler
   public void a(PlayerBedLeaveEvent var1) {
      Player var2 = var1.getPlayer();
      if (var2.getWorld().getEnvironment() == Environment.NORMAL) {
         if (this.c.contains(var2)) {
            this.c.remove(var2);
         }

         if (this.d.contains(var2)) {
            this.d.remove(var2);
         }

         if (var2.getWorld().getTime() < 0L || var2.getWorld().getTime() >= 13000L) {
            Main var10001 = Main.a;
            var2.sendMessage(Main.a("&eHas abandonado la cama, ya no contarás para pasar la noche."));
         }
      }
   }

   @EventHandler
   public void a(PlayerQuitEvent var1) {
      Player var2 = var1.getPlayer();
      if (this.c.contains(var2)) {
         this.c.remove(var2);
      }

      if (this.d.contains(var2)) {
         this.d.remove(var2);
      }

      Iterator var3 = Bukkit.getOnlinePlayers().iterator();

      while(var3.hasNext()) {
         Player var4 = (Player)var3.next();
         Scoreboard var5 = var4.getScoreboard();
         if (var5.getTeam("jugadores") == null) {
            var5.registerNewTeam("jugadores");
         }

         Team var6 = var5.getTeam("jugadores");
         var6.setCanSeeFriendlyInvisibles(true);
         if (var6.hasEntry(var1.getPlayer().getName())) {
            var6.removeEntry(var1.getPlayer().getName());
         }
      }

   }

   @EventHandler
   public void a(PlayerJoinEvent var1) {
      Player var2 = var1.getPlayer();
      String var3 = var2.getName();
      var1.setJoinMessage((String)null);
      Bukkit.getOnlinePlayers().forEach((var2x) -> {
         String var3 = this.a("OnJoin", var2x).replace("%player%", var1.getPlayer().getName());
         var2x.sendMessage(var3);
      });
      this.b(this.a("OnJoin").replace("%player%", var2.getName()));
      com.permadeathcore.f.g var4 = new com.permadeathcore.f.g(var1.getPlayer().getName(), Main.a);
      var4.a(Main.a.o());
      Player var5 = var1.getPlayer();
      Iterator var6 = Bukkit.getOnlinePlayers().iterator();

      while(var6.hasNext()) {
         Player var7 = (Player)var6.next();
         Scoreboard var8 = var7.getScoreboard();
         if (var8.getTeam("jugadores") == null) {
            var8.registerNewTeam("jugadores");
         }

         Team var9 = var8.getTeam("jugadores");
         var9.setCanSeeFriendlyInvisibles(true);
         if (!var9.hasEntry(var5.getName())) {
            var9.addEntry(var5.getName());
         }
      }

      if (Main.a.u().b()) {
         Main.a.u().a(var1.getPlayer());
      }

      if (var2.isOp()) {
         (new com.permadeathcore.j.c(this.j)).a((var2x) -> {
            Main var10001;
            if (this.j.getDescription().getVersion().equalsIgnoreCase(var2x)) {
               var10001 = this.j;
               var2.sendMessage(Main.a(this.b + "&3Estás utilizando la versión más reciente del Plugin."));
            } else {
               var10001 = this.j;
               var2.sendMessage(Main.a(this.b + "&3Se ha encontrado una nueva versión del plugin"));
               var10001 = this.j;
               var2.sendMessage(Main.a(this.b + "&eDescarga en: &7https://www.spigotmc.org/resources/permadeathcore-reloaded-%E2%98%A0%EF%B8%8F.81231/"));
            }

         });
      }

      if (Main.a.o() >= 50L && Main.a.i() != null && Main.a.i().d() && var1.getPlayer().getWorld().getName().equalsIgnoreCase("pdc_the_beginning")) {
         var1.getPlayer().teleport(Main.a.h.getSpawnLocation());
      }

   }

   @EventHandler
   public void a(AsyncPlayerPreLoginEvent var1) {
      if (Main.a.getConfig().getBoolean("anti-afk-enabled")) {
         if (Main.a.getConfig().getStringList("AntiAFK.Bypass").contains(var1.getName())) {
            return;
         }

         com.permadeathcore.f.g var2 = new com.permadeathcore.f.g(var1.getName(), Main.a);
         long var3 = Main.a.o();
         long var5 = var2.c();
         if (var3 < var5) {
            var2.a(var3);
            return;
         }

         OfflinePlayer var7 = Bukkit.getOfflinePlayer(var1.getName());
         if (var7 == null) {
            return;
         }

         if (!Bukkit.getWhitelistedPlayers().contains(var7) || Bukkit.getBannedPlayers().contains(var7)) {
            return;
         }

         long var8 = var3 - var5;
         if (var8 >= (long)Main.a.getConfig().getInt("AntiAFK.DaysForBan")) {
            Main var10000 = Main.a;
            String var10 = Main.a("&c&lHas sido PERMABANEADO\n&eRazón: AFK\n&7Si crees que es un\n&7error, contacta un\n&7administrador.");
            var1.disallow(Result.KICK_BANNED, var10);
            Bukkit.getBanList(Type.NAME).addBan(var1.getName(), var10, (Date)null, "console");
         }
      }

   }

   @EventHandler
   public void b(PlayerQuitEvent var1) {
      Player var2 = var1.getPlayer();
      String var3 = var2.getName();
      var1.setQuitMessage((String)null);
      Bukkit.getOnlinePlayers().forEach((var2x) -> {
         String var3 = this.a("OnLeave", var2x).replace("%player%", var1.getPlayer().getName());
         var2x.sendMessage(var3);
      });
      this.b(this.a("OnLeave").replace("%player%", var1.getPlayer().getName()));
      Main.a.u().b(var1.getPlayer());
   }

   @EventHandler
   public void a(EntityDamageEvent var1) {
      if (var1.getEntity() instanceof Player && Main.a.o() >= 50L && var1.getCause() == DamageCause.DROWNING) {
         Player var2 = (Player)var1.getEntity();
         if (Main.a.o() < 60L) {
            var1.setDamage(5.0D);
         } else {
            var1.setDamage(10.0D);
         }
      }

      if (var1.getEntity() instanceof Creeper && Main.a.o() >= 50L && var1.getEntity().getWorld().getEnvironment() == Environment.NORMAL) {
         Creeper var3 = (Creeper)var1.getEntity();
         new com.permadeathcore.f.e(var3, var1);
      }

      if (var1.getEntity() instanceof Ghast && Main.a.o() >= 30L) {
         new com.permadeathcore.f.e(var1.getEntity(), var1);
      }

   }

   @EventHandler
   public void a(EntityRegainHealthEvent var1) {
      if (var1.getEntity() instanceof Player && this.g && var1.getRegainReason() != RegainReason.MAGIC_REGEN) {
         var1.setAmount(0.0D);
         var1.setCancelled(true);
      }

   }

   @EventHandler
   public void a(EntityDamageByEntityEvent var1) {
      Player var2;
      if (this.j.o() >= 50L && var1.getEntity() instanceof Player && var1.getDamager() instanceof PolarBear) {
         var2 = (Player)var1.getEntity();
         PolarBear var3 = (PolarBear)var1.getDamager();
         var3.setAI(false);
         var2.getWorld().playSound(var3.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1.0F, 1.0F);
         Location var4 = var3.getLocation();
         Bukkit.getScheduler().runTaskLater(Main.a, new p(this, var4, var3), 10L);
         var1.setCancelled(true);
      }

      if (this.j.o() >= 50L && var1.getEntity() instanceof Player && var1.getDamager() instanceof LlamaSpit) {
         var2 = (Player)var1.getEntity();
         var2.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 600, 2));
         var2.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0));
         var2.setVelocity(var2.getVelocity().multiply(3));
      }

      if (var1.getEntity() instanceof Player && var1.getDamager() instanceof Player) {
         if (this.j.o() >= 40L) {
            var1.setCancelled(false);
         } else if (this.j.o() <= 39L) {
            var1.setCancelled(true);
         }
      }

   }

   @EventHandler
   public void a(WeatherChangeEvent var1) {
      boolean var2 = var1.getWorld().hasStorm();
      if (var2) {
         Iterator var3 = Bukkit.getOnlinePlayers().iterator();

         while(var3.hasNext()) {
            Player var4 = (Player)var3.next();
            String var5 = this.b + this.a("StormEnd", var4);
            var4.sendMessage(var5);
         }

         this.b(this.a("StormEnd"));
         if (Main.a.o() >= 50L) {
            if (Main.a.i() != null) {
               Main.a.i().a(false);
            }

            this.g = false;
         }
      }

   }

   @EventHandler(
      priority = EventPriority.MONITOR
   )
   public void a(EntityResurrectEvent var1) {
      if (var1.getEntity() instanceof Player) {
         if (((Player)var1.getEntity()).getInventory().getItemInMainHand().getType() == Material.TOTEM_OF_UNDYING || ((Player)var1.getEntity()).getInventory().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING) {
            if (!Main.a.getConfig().getBoolean("TotemFail.Enable")) {
               return;
            }

            Player var2 = (Player)var1.getEntity();
            String var3 = var2.getName();
            int var4 = 0;
            boolean var5;
            if (this.j.getConfig().contains("TotemFail.FailProbs." + this.j.o())) {
               var4 = (Integer)Objects.requireNonNull(Objects.requireNonNull(Main.a.getConfig().getInt("TotemFail.FailProbs." + this.j.o())));
               var5 = true;
            } else {
               System.out.println("[INFO] La probabilidad del tótem se encuentra desactivada para el día: " + this.j.o());
               var5 = false;
            }

            String var6 = (String)Objects.requireNonNull(Main.a.getConfig().getString("TotemFail.ChatMessage"));
            String var7 = (String)Objects.requireNonNull(Main.a.getConfig().getString("TotemFail.PlayerUsedTotemMessage"));
            if (this.j.o() >= 40L) {
               if (this.j.o() < 60L) {
                  var7 = (String)Objects.requireNonNull(Main.a.getConfig().getString("TotemFail.PlayerUsedTotemsMessage").replace("{ammount}", "dos").replace("%player%", var3));
               } else {
                  var7 = (String)Objects.requireNonNull(Main.a.getConfig().getString("TotemFail.PlayerUsedTotemsMessage").replace("{ammount}", "tres").replace("%player%", var3));
               }
            }

            Iterator var8 = Main.a.getConfig().getConfigurationSection("TotemFail.FailProbs").getKeys(false).iterator();

            int var10;
            while(var8.hasNext()) {
               String var9 = (String)var8.next();

               try {
                  var10 = Integer.valueOf(var9);
                  if ((long)var10 == this.j.o()) {
                     var5 = true;
                  }
               } catch (NumberFormatException var20) {
                  System.out.println("[ERROR] Ha ocurrido un error al cargar la probabilidad de tótem del día '" + var9 + "'");
               }
            }

            if (!var5) {
               return;
            }

            if (var4 >= 101) {
               var4 = 100;
            }

            if (var4 < 0) {
               var4 = 1;
            }

            Main var10000;
            if (var4 == 100) {
               var10000 = Main.a;
               Bukkit.broadcastMessage(Main.a(var7.replace("%player%", var3).replace("%porcent%", "=").replace("%totem_fail%", String.valueOf(100)).replace("%number%", String.valueOf(var4))));
               var10000 = Main.a;
               Bukkit.broadcastMessage(Main.a(var6.replace("%player%", var3)));
               var1.setCancelled(true);
            } else {
               int var11;
               int var23;
               if (Main.a.o() < 40L) {
                  int var21 = (int)(Math.random() * 100.0D) + 1;
                  var23 = 100 - var4;
                  var10 = var23;
                  if (var23 == var21) {
                     var10 = var23 - 1;
                  }

                  var11 = var21;
                  if (var21 == var23) {
                     var11 = var21 - 1;
                  }

                  boolean var12 = false;
                  if (var2.getInventory().getItemInMainHand() != null && var2.getInventory().getItemInMainHand().getType() == Material.TOTEM_OF_UNDYING && var2.getInventory().getItemInMainHand().getItemMeta().isUnbreakable()) {
                     var12 = true;
                  }

                  if (var2.getInventory().getItemInOffHand() != null && var2.getInventory().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING && var2.getInventory().getItemInOffHand().getItemMeta().isUnbreakable()) {
                     var12 = true;
                  }

                  if (var12) {
                     var10000 = Main.a;
                     Bukkit.broadcastMessage(Main.a(Main.a.getConfig().getString("TotemFail.Medalla").replace("%player%", var2.getName())));
                     return;
                  }

                  if (var21 > var23) {
                     var10000 = Main.a;
                     Bukkit.broadcastMessage(Main.a(var7.replace("%player%", var3).replace("%porcent%", "=").replace("%totem_fail%", String.valueOf(var10)).replace("%number%", String.valueOf(var23))));
                     var10000 = Main.a;
                     Bukkit.broadcastMessage(Main.a(var6.replace("%player%", var3)));
                     var1.setCancelled(true);
                  } else {
                     var10000 = Main.a;
                     Bukkit.broadcastMessage(Main.a(var7.replace("%player%", var3).replace("%porcent%", "!=").replace("%totem_fail%", String.valueOf(var11)).replace("%number%", String.valueOf(var23))));
                  }
               } else {
                  byte var22 = 2;
                  if (Main.a.o() >= 60L) {
                     var22 = 3;
                  }

                  var23 = (int)(Math.random() * 100.0D) + 1;
                  var10 = 100 - var4;
                  var11 = var10;
                  if (var10 == var23) {
                     var11 = var10 - 1;
                  }

                  int var24 = var23;
                  if (var23 == var10) {
                     var24 = var23 - 1;
                  }

                  boolean var13 = false;
                  int var25 = var2.getInventory().all(Material.TOTEM_OF_UNDYING).size();
                  if (var2.getInventory().getItemInOffHand() != null && var2.getInventory().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING) {
                     ++var25;
                  }

                  if (var25 < var22) {
                     var10000 = Main.a;
                     Bukkit.broadcastMessage(Main.a(Main.a.getConfig().getString("TotemFail.NotEnoughTotems").replace("%player%", var3).replace("%porcent%", "=").replace("%totem_fail%", String.valueOf(var11)).replace("%number%", String.valueOf(var10))));
                     var1.setCancelled(true);
                     return;
                  }

                  boolean var14 = false;
                  if (var2.getInventory().getItemInOffHand() != null && var2.getInventory().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING && var2.getInventory().getItemInOffHand().getItemMeta().isUnbreakable()) {
                     var14 = true;
                  }

                  if (var2.getInventory().getItemInMainHand() != null && var2.getInventory().getItemInMainHand().getType() == Material.TOTEM_OF_UNDYING && var2.getInventory().getItemInMainHand().getItemMeta().isUnbreakable()) {
                     var14 = true;
                  }

                  int var15 = 0;
                  ItemStack[] var16 = var2.getInventory().getContents();
                  int var17 = var16.length;

                  for(int var18 = 0; var18 < var17; ++var18) {
                     ItemStack var19 = var16[var18];
                     if (var19 != null && var19.getType() == Material.TOTEM_OF_UNDYING && var15 < var22) {
                        var2.getInventory().removeItem(new ItemStack[]{var19});
                        ++var15;
                     }
                  }

                  if (var2.getInventory().getItemInOffHand() != null && var15 < var22 && var2.getInventory().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING) {
                     var2.getInventory().setItemInOffHand((ItemStack)null);
                     ++var15;
                  }

                  if (var14) {
                     var10000 = Main.a;
                     Bukkit.broadcastMessage(Main.a(Main.a.getConfig().getString("TotemFail.Medalla").replace("%player%", var2.getName())));
                     return;
                  }

                  if (var23 > var10) {
                     var10000 = Main.a;
                     Bukkit.broadcastMessage(Main.a(var7.replace("%player%", var3).replace("%porcent%", "=").replace("%totem_fail%", String.valueOf(var11)).replace("%number%", String.valueOf(var10))));
                     var10000 = Main.a;
                     Bukkit.broadcastMessage(Main.a(Main.a.getConfig().getString("TotemFail.ChatMessageTotems").replace("%player%", var3)));
                     var1.setCancelled(true);
                  } else {
                     var10000 = Main.a;
                     Bukkit.broadcastMessage(Main.a(var7.replace("%player%", var3).replace("%porcent%", "!=").replace("%totem_fail%", String.valueOf(var24)).replace("%number%", String.valueOf(var10))));
                  }
               }
            }
         }

      }
   }

   @EventHandler
   public void a(RaidFinishEvent var1) {
      if (this.j.o() >= 50L) {
         if (!var1.getWinners().isEmpty()) {
            Bukkit.getScheduler().runTaskLater(Main.a, new c(this, var1), 10L);
         }
      }
   }

   @EventHandler
   public void a(BlockBreakEvent var1) {
      if (this.j.o() >= 50L) {
         ArrayList var2 = new ArrayList();
         var2.add(com.permadeathcore.j.c.a.h());
         var2.add(com.permadeathcore.j.c.a.i());
         var2.add(com.permadeathcore.j.c.a.e());
         var2.add(com.permadeathcore.j.c.a.f());
         var2.add(com.permadeathcore.j.c.a.g());
         boolean var3 = true;
         if (var1.getPlayer().getInventory().getItemInMainHand() != null) {
            Iterator var4 = var2.iterator();

            while(var4.hasNext()) {
               ItemStack var5 = (ItemStack)var4.next();
               ItemStack var6 = var1.getPlayer().getInventory().getItemInMainHand();
               if (var6.hasItemMeta() && var6.getItemMeta().hasDisplayName() && var6.getItemMeta().getDisplayName().contains(var5.getItemMeta().getDisplayName())) {
                  var3 = false;
               }
            }
         }

         if (var3) {
            if (Main.a.o() < 60L) {
               var1.getPlayer().damage(1.0D);
            } else {
               var1.getPlayer().damage(16.0D);
            }
         }

      }
   }

   @EventHandler
   public void a(EntityAirChangeEvent var1) {
      if (var1.getEntity() instanceof Player) {
         Player var2 = (Player)var1.getEntity();
         if (var2.getRemainingAir() >= var1.getAmount()) {
            int var3;
            int var4;
            int var5;
            byte var6;
            if (Main.a.o() >= 50L && Main.a.o() < 60L) {
               if (var1.getAmount() < 20) {
                  return;
               }

               var3 = var1.getAmount() / 20;
               var4 = var3 / 5;
               if (var4 <= 0) {
                  var6 = 0;
                  var1.setAmount(var6);
                  Main.a.n().a(var2, 5.0D);
                  return;
               }

               var5 = var4 * 20;
               var1.setAmount(var5);
            }

            if (Main.a.o() >= 60L) {
               if (var1.getAmount() < 20) {
                  return;
               }

               var3 = var1.getAmount() / 20;
               var4 = var3 / 10;
               if (var4 <= 0) {
                  var6 = 0;
                  var1.setAmount(var6);
                  Main.a.n().a(var2, 10.0D);
                  return;
               }

               var5 = var4 * 20;
               var1.setAmount(var5);
            }

         }
      }
   }

   @EventHandler
   public void a(PlayerItemConsumeEvent var1) {
      if (this.j.o() >= 50L && var1.getItem() != null) {
         if (var1.getItem().getType() == Material.MILK_BUCKET && var1.getPlayer().hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
            PotionEffect var2 = var1.getPlayer().getPotionEffect(PotionEffectType.SLOW_DIGGING);
            Bukkit.getScheduler().runTaskLater(this.j, new d(this, var1, var2), 10L);
         }

         if (var1.getItem().getType() == Material.PUMPKIN_PIE) {
            var1.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 100, 0));
         }

         if (var1.getItem().getType() == Material.SPIDER_EYE) {
            Bukkit.getScheduler().runTaskLater(Main.a, new e(this, var1), 5L);
         }

         if (var1.getItem().getType() == Material.PUFFERFISH) {
            Bukkit.getScheduler().runTaskLater(Main.a, new f(this, var1), 5L);
         }

         if (var1.getItem().getType() == Material.ROTTEN_FLESH) {
            Bukkit.getScheduler().runTaskLater(Main.a, new g(this, var1), 5L);
         }

         if (var1.getItem().getType() == Material.POISONOUS_POTATO) {
            Bukkit.getScheduler().runTaskLater(Main.a, new h(this, var1), 5L);
         }
      }

      if (this.j.o() >= 60L) {
         ItemStack var3 = var1.getItem();
         if (var3 != null && var3.getType() == Material.PUMPKIN_PIE) {
            var1.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1, 3));
         }
      }

   }

   @EventHandler
   public void a(PlayerTeleportEvent var1) {
      if (var1.getCause() == TeleportCause.ENDER_PEARL && Main.a.o() >= 60L) {
         var1.getPlayer().setCooldown(Material.ENDER_PEARL, 120);
      }

   }

   @EventHandler
   public void a(PlayerBucketFillEvent var1) {
      if (this.j.o() >= 50L) {
         var1.setCancelled(true);
      }

   }

   @EventHandler
   public void a(FurnaceSmeltEvent var1) {
      if (this.j.o() >= 50L && var1.getResult() != null) {
         ItemStack var2;
         if (var1.getResult().getType() == Material.IRON_INGOT) {
            var2 = var1.getResult();
            var2.setType(Material.IRON_NUGGET);
            var1.setResult(var2);
         }

         if (var1.getResult().getType() == Material.GOLD_INGOT) {
            var2 = var1.getResult();
            var2.setType(Material.GOLD_NUGGET);
            var1.setResult(var2);
         }
      }

   }

   public String a(String var1, Player var2) {
      return Main.a.e().a("Server-Messages." + var1, var2.getName());
   }

   public String a(String var1, Player var2, List var3) {
      return Main.a.e().a("Server-Messages." + var1, var2.getName(), var3);
   }

   public String a(String var1) {
      return Main.a.e().b("Server-Messages." + var1);
   }

   public void b(String var1) {
      Bukkit.getConsoleSender().sendMessage(var1);
   }

   // $FF: synthetic method
   static Main a(a var0) {
      return var0.j;
   }
}
