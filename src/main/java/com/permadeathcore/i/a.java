package com.permadeathcore.i;

import com.permadeathcore.Main;
import com.permadeathcore.j.c.d;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Color;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.block.EndGateway;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vex;
import org.bukkit.entity.Wither;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.Event.Result;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityPortalExitEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class a implements Listener {
   private Main a;
   private World b;
   private com.permadeathcore.f.a c;
   private boolean d = false;

   public a(Main var1) {
      this.a = var1;
      this.b = null;
      this.c = var1.j();
      if (var1.o() >= 40L) {
         this.e();
         var1.getServer().getPluginManager().registerEvents(this, var1);
      }

   }

   public World a() {
      return this.b;
   }

   private void e() {
      if (Bukkit.getWorld("pdc_the_beginning") == null) {
         WorldCreator var1 = new WorldCreator("pdc_the_beginning");
         var1.environment(Environment.THE_END);
         var1.generator(new com.permadeathcore.i.b.a.a());
         var1.generateStructures(false);
         this.b = var1.createWorld();
         this.b.setMonsterSpawnLimit(60);
         this.b.setGameRule(GameRule.MOB_GRIEFING, false);
      } else {
         this.b = Bukkit.getWorld("pdc_the_beginning");
      }

   }

   public void a(boolean var1, Location var2) {
      if (!this.c.a() && var1) {
         int var3 = this.a.getConfig().getInt("TheBeginning.X-Limit");
         int var4 = this.a.getConfig().getInt("TheBeginning.Z-Limit");
         int var5 = (new Random()).nextInt(var3);
         int var6 = (new Random()).nextInt(var4);
         if ((new Random()).nextBoolean()) {
            var5 *= -1;
         }

         if ((new Random()).nextBoolean()) {
            var6 *= -1;
         }

         Location var7 = new Location(this.a.h, (double)var5, 0.0D, (double)var6);
         int var8 = this.a.h.getHighestBlockAt(var7).getY();
         if (var8 == -1) {
            var8 = 50;
         }

         var8 += 15;
         var7.setY((double)var8);
         this.a(var7, new File(this.a.getDataFolder().getAbsolutePath() + "/schematics/beginning_portal.schem"));
         this.c.d(var7);
      }

      if (!this.c.b() && !var1) {
         this.b.loadChunk(var2.getChunk());
         this.a(var2, new File(this.a.getDataFolder().getAbsolutePath() + "/schematics/beginning_portal.schem"));
         this.c.c(var2);
      }

   }

   private void a(Location var1, File var2) {
      com.sk89q.worldedit.world.World var3 = BukkitAdapter.adapt(var1.getWorld());
      ClipboardFormat var4 = ClipboardFormats.findByFile(var2);

      try {
         ClipboardReader var5 = var4.getReader(new FileInputStream(var2));
         Throwable var6 = null;

         try {
            Clipboard var7 = var5.read();
            EditSession var8 = WorldEdit.getInstance().getEditSessionFactory().getEditSession(var3, -1);
            Throwable var9 = null;

            try {
               Operation var10 = (new ClipboardHolder(var7)).createPaste(var8).to(BlockVector3.at(var1.getX(), var1.getY(), var1.getZ())).ignoreAirBlocks(true).build();

               try {
                  Operations.complete(var10);
                  var8.flushSession();
               } catch (WorldEditException var39) {
                  var39.printStackTrace();
               }
            } catch (Throwable var40) {
               var9 = var40;
               throw var40;
            } finally {
               if (var8 != null) {
                  if (var9 != null) {
                     try {
                        var8.close();
                     } catch (Throwable var38) {
                        var9.addSuppressed(var38);
                     }
                  } else {
                     var8.close();
                  }
               }

            }
         } catch (Throwable var42) {
            var6 = var42;
            throw var42;
         } finally {
            if (var5 != null) {
               if (var6 != null) {
                  try {
                     var5.close();
                  } catch (Throwable var37) {
                     var6.addSuppressed(var37);
                  }
               } else {
                  var5.close();
               }
            }

         }
      } catch (FileNotFoundException var44) {
         var44.printStackTrace();
      } catch (IOException var45) {
         var45.printStackTrace();
      }

   }

   public void b() {
      if (this.b != null) {
         this.b.getPlayers().forEach((var1) -> {
            var1.teleport(this.a.h.getSpawnLocation());
            var1.playSound(var1.getLocation(), Sound.ITEM_TRIDENT_THUNDER, 1.0F, 1.0F);
         });
         Main var10000 = this.a;
         Bukkit.broadcastMessage(Main.a(this.a.g + "&eThe Beginning ha cerrado temporalmente (DeathTrain)."));
         this.d = true;
      }
   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void a(BlockExplodeEvent var1) {
      if (this.b != null) {
         if (var1.getBlock().getLocation().getWorld().getName().equalsIgnoreCase(this.b.getName())) {
            var1.setCancelled(true);
         }

      }
   }

   @EventHandler
   public void a(EntityPortalExitEvent var1) {
      Main var10000 = this.a;
      if (!Main.v()) {
         if (this.d()) {
            var1.setCancelled(true);
         } else {
            if (var1.getFrom().getWorld().getName().equalsIgnoreCase(this.b.getName())) {
               Entity var2 = var1.getEntity();
               if (var2.getType() != EntityType.PLAYER) {
                  Vector var3 = var2.getVelocity();
                  var2.teleport(this.a.h.getSpawnLocation());
                  var1.setAfter(var3);
               }

               var1.setCancelled(true);
            }

            Location var4 = var1.getFrom();
            if (var4.getBlock().getType() == Material.END_GATEWAY || var4.getBlock().getState() instanceof EndGateway) {
               EndGateway var5 = (EndGateway)var4.getBlock().getState();
               var5.setExitLocation((Location)null);
               var5.setExactTeleport(true);
            }

         }
      }
   }

   @EventHandler
   public void a(PlayerPortalEvent var1) {
      Main var10000 = this.a;
      if (!Main.v()) {
         Player var2 = var1.getPlayer();
         if (var1.getCause() == TeleportCause.END_GATEWAY) {
            if (var2.getWorld().getName().equalsIgnoreCase(this.a.h.getName())) {
               var1.setCanCreatePortal(false);
            }

            if (var2.getWorld().getName().equalsIgnoreCase(this.b.getName())) {
               if (var2.getLocation().getBlock().getState() instanceof EndGateway) {
                  EndGateway var3 = (EndGateway)var2.getLocation().getBlock().getState();
                  var3.setExitLocation((Location)null);
                  var3.update();
                  var2.getLocation().getBlock().getState().update();
               }

               var1.setCanCreatePortal(false);
            }

         }
      }
   }

   @EventHandler
   public void a(PlayerTeleportEvent var1) {
      Player var2 = var1.getPlayer();
      if (var1.getCause() == TeleportCause.END_GATEWAY) {
         if (this.d()) {
            var1.setCancelled(true);
         } else if (this.a.o() >= 50L) {
            if (var2.getWorld().getName().equalsIgnoreCase(this.a.h.getName())) {
               Player var6 = var1.getPlayer();
               Main var10001 = this.a;
               var6.sendMessage(Main.a("&eBienvenido a The Beginning."));
               var1.getPlayer().teleport(this.b.getSpawnLocation());
               var1.setCancelled(true);
               Bukkit.getScheduler().runTaskLater(this.a, new b(this, var1), 20L);
            }

            int var3 = (int)var2.getLocation().getX();
            int var4 = (int)var2.getLocation().getZ();
            if (var2.getWorld().getName().equalsIgnoreCase(this.b.getName()) && var3 != 200 && var4 != 200) {
               if (var2.getLocation().getBlock().getState() instanceof EndGateway) {
                  EndGateway var5 = (EndGateway)var2.getLocation().getBlock().getState();
                  var5.setExitLocation((Location)null);
                  var5.update();
                  var2.getLocation().getBlock().getState().update();
               }

               var1.getPlayer().teleport(this.a.h.getSpawnLocation(), TeleportCause.PLUGIN);
               var1.setCancelled(true);
            }

         } else {
            if (var1.getPlayer().getWorld().getName().equalsIgnoreCase(this.a.h.getName()) || var1.getPlayer().getWorld().getName().equalsIgnoreCase(this.b.getName())) {
               var1.getPlayer().damage(var1.getPlayer().getHealth());
               Main var10000 = this.a;
               Bukkit.broadcastMessage(Main.a("&c&lEl jugador &4&l" + var1.getPlayer().getName() + " &c&lentró a TheBeginning antes de tiempo."));
            }

         }
      }
   }

   @EventHandler
   public void a(BlockBreakEvent var1) {
      Player var2 = var1.getPlayer();
      if (var2.getWorld().getName().equalsIgnoreCase(this.b.getName()) && var1.getBlock().getState() instanceof Chest) {
         Chest var3 = (Chest)var1.getBlock().getState();
         this.a(var3);
      }

      if (var1.getBlock().getType() == Material.SPAWNER && this.a.x() != null) {
         this.a.x().a(var1);
      }

   }

   private void a(Chest var1) {
      if (this.c.h().contains("PopulatedChests")) {
         if (this.c.a(var1.getLocation())) {
            return;
         }

         if (this.a.o() < 60L) {
            (new com.permadeathcore.i.c.a(this)).a(var1);
         }

         this.c.b(var1.getLocation());
      }

   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void a(PrepareItemCraftEvent var1) {
      if (var1.getInventory().getResult() != null) {
         ItemStack var2 = var1.getInventory().getResult();
         int var4;
         int var5;
         int var7;
         if (var2.isSimilar(com.permadeathcore.j.c.a.b())) {
            ItemStack[] var3 = var1.getInventory().getMatrix();
            var4 = var3.length;

            for(var5 = 0; var5 < var4; ++var5) {
               ItemStack var6 = var3[var5];
               var7 = 0;
               if (var6 != null && var6.getAmount() == 64 && var6.getType() != Material.HEART_OF_THE_SEA) {
                  ++var7;
               }

               if (var7 >= 8) {
                  var1.getInventory().setResult(com.permadeathcore.j.c.a.b());
               } else {
                  var1.getInventory().setResult((ItemStack)null);
               }
            }
         }

         ItemStack var8;
         int var10;
         ItemStack[] var12;
         int var14;
         if (var2.isSimilar(com.permadeathcore.j.c.a.c())) {
            var10 = 0;
            var4 = 0;
            var12 = var1.getInventory().getMatrix();
            var14 = var12.length;

            for(var7 = 0; var7 < var14; ++var7) {
               var8 = var12[var7];
               if (var8 != null) {
                  if (var8.getType() == Material.DIAMOND_BLOCK && var8.getAmount() >= 32) {
                     ++var10;
                  }

                  if (com.permadeathcore.j.c.a.a((Player)null, var8)) {
                     ++var4;
                  }
               }
            }

            if (var10 < 4 || var4 < 1) {
               var1.getInventory().setResult((ItemStack)null);
            }

            if (var10 >= 4 && var4 >= 1) {
               var1.getInventory().setResult(com.permadeathcore.j.c.a.c());
            }
         }

         if (this.a.g().b(var2)) {
            if (var2.getType() == Material.ELYTRA) {
               return;
            }

            var10 = 0;
            boolean var11 = false;
            var12 = var1.getInventory().getMatrix();
            var14 = var12.length;

            for(var7 = 0; var7 < var14; ++var7) {
               var8 = var12[var7];
               if (var8 != null && var8.hasItemMeta()) {
                  ItemMeta var9 = var8.getItemMeta();
                  if (var8.getType() == Material.DIAMOND && var9.isUnbreakable() && ChatColor.stripColor(var8.getItemMeta().getDisplayName()).contains("Infernal")) {
                     ++var10;
                  }

                  if (this.a.g().a(var8)) {
                     var11 = true;
                  }
               }
            }

            if (var10 < 5 || !var11) {
               var1.getInventory().setResult((ItemStack)null);
            }

            if (var10 >= 4 && var11) {
               Material var15 = var2.getType();
               if (var15 == Material.LEATHER_HELMET) {
                  var1.getInventory().setResult(this.a.h().a());
               }

               if (var15 == Material.LEATHER_CHESTPLATE) {
                  var1.getInventory().setResult(this.a.h().b());
               }

               if (var15 == Material.LEATHER_LEGGINGS) {
                  var1.getInventory().setResult(this.a.h().c());
               }

               if (var15 == Material.LEATHER_BOOTS) {
                  var1.getInventory().setResult(this.a.h().d());
               }
            }
         }

         ItemStack[] var13;
         ItemStack var17;
         if (var2.getType() == Material.ELYTRA) {
            var10 = 0;
            var13 = var1.getInventory().getMatrix();
            var5 = var13.length;

            for(var14 = 0; var14 < var5; ++var14) {
               var17 = var13[var14];
               if (var17 != null && var17.hasItemMeta()) {
                  ItemMeta var16 = var17.getItemMeta();
                  if (var17.getType() == Material.DIAMOND && var16.isUnbreakable() && ChatColor.stripColor(var17.getItemMeta().getDisplayName()).contains("Infernal")) {
                     ++var10;
                  }
               }
            }

            if (var10 < 9) {
               var1.getInventory().setResult((ItemStack)null);
               return;
            }

            if (var10 >= 8) {
               var1.getInventory().setResult(com.permadeathcore.j.c.a.d());
            }
         }

         String var10000 = var2.getItemMeta().getDisplayName();
         Main var10001 = this.a;
         CraftingInventory var18;
         Main var10002;
         d var19;
         if (var10000.startsWith(Main.a("&6Hyper"))) {
            var10 = 0;
            var13 = var1.getInventory().getMatrix();
            var5 = var13.length;

            for(var14 = 0; var14 < var5; ++var14) {
               var17 = var13[var14];
               if (var17 != null && var17.getType() == Material.GOLD_BLOCK && var17.getAmount() >= 8) {
                  ++var10;
               }
            }

            if (var10 >= 8) {
               var18 = var1.getInventory();
               var19 = new d(Material.GOLDEN_APPLE, 1);
               var10002 = this.a;
               var18.setResult(var19.c(Main.a("&6Hyper Golden Apple +")).a(Enchantment.ARROW_INFINITE, 1).a(ItemFlag.HIDE_ENCHANTS).a());
            } else {
               var1.getInventory().setResult((ItemStack)null);
            }
         }

         var10000 = var2.getItemMeta().getDisplayName();
         var10001 = this.a;
         if (var10000.startsWith(Main.a("&6Super"))) {
            var10 = 0;
            var13 = var1.getInventory().getMatrix();
            var5 = var13.length;

            for(var14 = 0; var14 < var5; ++var14) {
               var17 = var13[var14];
               if (var17 != null && var17.getType() == Material.GOLD_INGOT && var17.getAmount() >= 8) {
                  ++var10;
               }
            }

            if (var10 < 8) {
               var1.getInventory().setResult((ItemStack)null);
               return;
            }

            if (var10 >= 8) {
               var18 = var1.getInventory();
               var19 = new d(Material.GOLDEN_APPLE, 1);
               var10002 = this.a;
               var18.setResult(var19.c(Main.a("&6Super Golden Apple +")).a(Enchantment.ARROW_INFINITE, 1).a(ItemFlag.HIDE_ENCHANTS).a());
            }
         }
      }

   }

   @EventHandler
   public void a(CraftItemEvent var1) {
      CraftingInventory var2 = var1.getInventory();
      if (var2.getResult() != null) {
         ItemStack var3 = var1.getRecipe().getResult();
         if (var1.isCancelled() || var1.getResult() != Result.ALLOW) {
            return;
         }

         if (var3.hasItemMeta()) {
            if (com.permadeathcore.j.c.a.a((Player)null, var3)) {
               ItemMeta var5 = var3.getItemMeta();
               var5.setLore(Arrays.asList(com.permadeathcore.j.c.b.a("{" + UUID.randomUUID().toString() + ": 0}")));
               var3.setItemMeta(var5);
               var1.setCurrentItem(var3);
               return;
            }

            Player var4;
            if ((var3.isSimilar(com.permadeathcore.j.c.a.c()) || var3.isSimilar(com.permadeathcore.j.c.a.b())) && var1.getWhoClicked() instanceof Player) {
               var1.getInventory().setMatrix(this.c());
               var4 = (Player)var1.getWhoClicked();
               var4.setItemOnCursor(var3);
            }

            if (!var3.getItemMeta().hasDisplayName()) {
               return;
            }

            String var10000 = var3.getItemMeta().getDisplayName();
            Main var10001 = this.a;
            if (!var10000.contains(Main.a("&6Hyper Golden Apple +"))) {
               var10000 = var3.getItemMeta().getDisplayName();
               var10001 = this.a;
               if (!var10000.contains(Main.a("&6Super Golden Apple +"))) {
                  return;
               }
            }

            if (var1.getWhoClicked() instanceof Player) {
               var1.getInventory().setMatrix(this.c());
               var4 = (Player)var1.getWhoClicked();
               var4.setItemOnCursor(var3);
            }
         }
      }

   }

   public ItemStack[] c() {
      return new ItemStack[]{new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR)};
   }

   @EventHandler
   public void a(PlayerInteractEvent var1) {
      Player var2 = var1.getPlayer();
      if (var1.getClickedBlock() != null && var2.getWorld().getName().equalsIgnoreCase(this.b.getName()) && (var1.getAction() == Action.LEFT_CLICK_BLOCK || var1.getAction() == Action.RIGHT_CLICK_BLOCK) && var1.getClickedBlock().getState() instanceof Chest) {
         Chest var3 = (Chest)var1.getClickedBlock().getState();
         this.a(var3);
      }

      if (var1.getAction() == Action.RIGHT_CLICK_BLOCK && var1.getPlayer().getInventory().getItemInMainHand() != null && var1.getClickedBlock() != null && var1.getBlockFace() != null && this.a.x() != null) {
         if (var1.getClickedBlock().getType() == Material.CHEST) {
            return;
         }

         ItemStack var4 = var1.getPlayer().getInventory().getItemInMainHand();
         if (var4.getType() == Material.DIAMOND && var4.getItemMeta().isUnbreakable()) {
            this.a.x().a(this.a.x().a(var1.getClickedBlock(), var1.getBlockFace()));
            if (var4.getAmount() > 0) {
               var4.setAmount(var4.getAmount() - 1);
            } else {
               var4 = null;
            }

            var1.getPlayer().getInventory().setItemInMainHand(var4);
            var1.getPlayer().updateInventory();
         }
      }

   }

   @EventHandler
   public void a(PlayerBucketEmptyEvent var1) {
      if (this.b != null) {
         if (var1.getPlayer().getWorld().getName().equalsIgnoreCase(this.b.getName())) {
            var1.setCancelled(true);
         }

      }
   }

   @EventHandler
   public void a(BlockDispenseEvent var1) {
      if (this.b != null) {
         if (var1.getItem() != null && (var1.getItem().getType() == Material.BUCKET || var1.getItem().getType() == Material.WATER_BUCKET) && var1.getBlock().getWorld().getName().equalsIgnoreCase(this.b.getName())) {
            var1.setCancelled(true);
         }

      }
   }

   @EventHandler
   public void a(PlayerJoinEvent var1) {
      if (this.b != null) {
         if (this.d() && var1.getPlayer().getWorld().getName().equalsIgnoreCase(this.b.getName())) {
            var1.getPlayer().teleport(this.a.h.getSpawnLocation());
         }

         if (!this.c.a()) {
            this.a(true, (Location)null);
         }

         if (!this.c.b()) {
            this.a(false, new Location(this.a(), 50.0D, 140.0D, 50.0D));
            this.a().setSpawnLocation(new Location(this.a(), 50.0D, 140.0D, 50.0D));
         }

      }
   }

   @EventHandler(
      priority = EventPriority.MONITOR
   )
   public void a(PlayerMoveEvent var1) {
      if (this.b != null) {
         Player var2 = var1.getPlayer();
         if (!this.c.e()) {
            Chunk var3 = this.b.getBlockAt(0, 100, 0).getChunk();

            for(int var4 = 0; var4 < 16; ++var4) {
               for(int var5 = this.b.getMaxHeight() - 1; var5 > 0; --var5) {
                  for(int var6 = 0; var6 < 16; ++var6) {
                     Block var7 = var3.getBlock(var4, var5, var6);
                     if (var7.getType() == Material.END_GATEWAY || var7.getType() == Material.BEDROCK) {
                        var7.setType(Material.AIR);
                     }
                  }
               }
            }

            if (this.b.getEntitiesByClass(EnderDragon.class).size() >= 1) {
               Iterator var9 = this.b.getEntities().iterator();

               while(var9.hasNext()) {
                  Entity var11 = (Entity)var9.next();
                  if (var11.getType() == EntityType.ENDER_DRAGON) {
                     var11.remove();
                  }
               }

               this.c.f();
            }
         }

         Location var8 = var1.getTo();
         Block var10;
         EndGateway var12;
         if (var8.getBlock() != null && var8.getWorld().getName().equalsIgnoreCase(this.b.getName())) {
            var10 = var8.getBlock();
            if (var10.getType() == Material.END_GATEWAY || var10.getState() instanceof EndGateway) {
               if (var10.getState() instanceof EndGateway) {
                  var12 = (EndGateway)var10.getState();
                  var12.setExitLocation(var12.getLocation());
                  var12.update();
                  var10.getState().update();
               }

               var1.setCancelled(true);
            }
         }

         if (var8.getBlock() != null && var8.getWorld().getName().equalsIgnoreCase(this.a.h.getName())) {
            var10 = var8.getBlock();
            if (var10.getType() == Material.END_GATEWAY || var10.getState() instanceof EndGateway) {
               if (var10.getState() instanceof EndGateway) {
                  var12 = (EndGateway)var10.getState();
                  var12.setExitLocation(var12.getLocation());
                  var12.update();
                  var10.getState().update();
               }

               var1.setCancelled(true);
            }
         }

      }
   }

   @EventHandler
   public void a(PlayerChangedWorldEvent var1) {
      if (this.b != null) {
         if (var1.getPlayer().getWorld().getName().equalsIgnoreCase(this.b.getName()) && !(Boolean)this.b.getGameRuleValue(GameRule.DO_MOB_SPAWNING) && var1.getPlayer().hasPotionEffect(PotionEffectType.INVISIBILITY)) {
            var1.getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);
         }

      }
   }

   @EventHandler
   public void a(PortalCreateEvent var1) {
      if (var1.getWorld().getName().equalsIgnoreCase(this.b.getName())) {
         Iterator var2 = var1.getBlocks().iterator();

         while(true) {
            BlockState var3;
            Block var4;
            do {
               if (!var2.hasNext()) {
                  var1.setCancelled(true);
                  return;
               }

               var3 = (BlockState)var2.next();
               var4 = var3.getBlock();
            } while(var4.getType() != Material.END_GATEWAY && var4.getType() != Material.BEDROCK && !(var3 instanceof EndGateway));

            if (var4.getChunk().getX() == 0 && var4.getChunk().getZ() == 0) {
               var1.getBlocks().remove(var3);
               var3.setType(Material.AIR);
            }
         }
      }
   }

   @EventHandler
   public void a(SpawnerSpawnEvent var1) {
      if (this.b != null) {
         if (!var1.isCancelled()) {
            CreatureSpawner var2 = var1.getSpawner();
            if (var1.getEntity().getWorld().getName().equalsIgnoreCase(this.b.getName())) {
               if (var1.getEntityType() != EntityType.ARMOR_STAND) {
                  var2.setSpawnedType(var1.getEntityType());
                  var2.update();
               }

               if (var1.getEntityType() == EntityType.WITHER) {
                  Wither var3 = (Wither)var1.getEntity();
                  var3.setRemoveWhenFarAway(true);
               }

               if (var1.getEntityType() == EntityType.GHAST) {
                  this.a.f().b(var1.getLocation().add(0.0D, 5.0D, 0.0D), SpawnReason.CUSTOM, true);
                  var1.setCancelled(true);
               }

               if (var1.getEntityType() == EntityType.CREEPER) {
                  Entity var10000 = var1.getEntity();
                  Main var10001 = this.a;
                  var10000.setCustomName(Main.a("&6Quantum Creeper"));
                  ((Creeper)var1.getEntity()).setPowered(true);
                  var1.getEntity().getPersistentDataContainer().set(new NamespacedKey(this.a, "quantum_creeper"), PersistentDataType.BYTE, (byte)1);
               }
            }

         }
      }
   }

   @EventHandler
   public void a(CreatureSpawnEvent var1) {
      if (this.b != null) {
         if (!var1.isCancelled()) {
            if (var1.getLocation().getWorld().getName().equalsIgnoreCase(this.b.getName())) {
               if (var1.getEntity().getType() == EntityType.VEX) {
                  Vex var2 = (Vex)var1.getEntity();
                  var2.getEquipment().setHelmet((new d(Material.HONEY_BLOCK)).a(Enchantment.PROTECTION_ENVIRONMENTAL, 4).a());
                  var2.getEquipment().setItemInMainHand((new d(Material.END_CRYSTAL)).a(Enchantment.KNOCKBACK, 10).a());
                  var2.getEquipment().setHelmetDropChance(0.0F);
                  var2.getEquipment().setItemInMainHandDropChance(0.0F);
                  Main var10001 = this.a;
                  var2.setCustomName(Main.a("&6Vex Definitivo"));
               }

               if (var1.getEntity().getType() == EntityType.WITHER_SKELETON) {
                  WitherSkeleton var8 = (WitherSkeleton)var1.getEntity();
                  ItemStack var3 = this.a.g().b();
                  LeatherArmorMeta var4 = (LeatherArmorMeta)var3.getItemMeta();
                  var4.setColor(Color.fromRGB(7229262));
                  var3.setItemMeta(var4);
                  ItemStack var5 = this.a.g().d();
                  LeatherArmorMeta var6 = (LeatherArmorMeta)var5.getItemMeta();
                  var6.setColor(Color.fromRGB(7229262));
                  var3.setItemMeta(var6);
                  var8.getEquipment().setChestplate(var3);
                  var8.getEquipment().setBoots(var5);
                  int var7 = (int)(Math.random() * 5.0D) + 1;
                  var8.getEquipment().setItemInMainHand((new d(com.permadeathcore.j.c.a.e())).a(Enchantment.DAMAGE_ALL, var7).a());
                  var8.getEquipment().setChestplateDropChance(0.0F);
                  var8.getEquipment().setBootsDropChance(0.0F);
                  var8.getEquipment().setItemInMainHandDropChance(0.0F);
                  var8.setRemoveWhenFarAway(true);
               }

               if (var1.getEntity().getType() == EntityType.ENDERMAN) {
                  SplittableRandom var9 = new SplittableRandom();
                  int var10 = var9.nextInt(250) + 1;
                  int var11 = var9.nextInt(500) + 1;
                  int var12 = var9.nextInt(290) + 1;
                  if (var10 <= 5) {
                     this.a.f().a("SkeletonWither", EntityType.WITHER_SKELETON, var1.getLocation(), SpawnReason.CUSTOM);
                  }

                  if (var11 == 1 && var1.getLocation().getY() >= 100.0D) {
                     this.a.f().b(var1.getLocation().add(0.0D, 5.0D, 0.0D), SpawnReason.CUSTOM, true);
                  }

                  if (var12 <= 5 && var1.getLocation().getY() >= 100.0D) {
                     this.a.d().c(var1.getLocation());
                  }

                  var1.setCancelled(true);
               }
            }

         }
      }
   }

   @EventHandler
   public void a(BlockPlaceEvent var1) {
      if (this.b != null) {
         if (var1.getPlayer().getWorld().getName().equalsIgnoreCase(this.b.getName()) && var1.getBlock().getState() instanceof Chest) {
            com.permadeathcore.f.a var2 = this.a.j();
            var2.b(var1.getBlock().getLocation());
         }

      }
   }

   public Location a(String var1) {
      String[] var2 = var1.split(";");
      Double var3 = Double.valueOf(var2[0]);
      Double var4 = Double.valueOf(var2[1]);
      Double var5 = Double.valueOf(var2[2]);
      World var6 = Bukkit.getWorld(var2[3]);
      return new Location(var6, var3, var4, var5);
   }

   private String a(Location var1) {
      return var1.getX() + ";" + var1.getY() + ";" + var1.getZ() + ";" + var1.getWorld().getName();
   }

   public boolean d() {
      return this.d;
   }

   public void a(boolean var1) {
      this.d = var1;
   }

   // $FF: synthetic method
   static World a(a var0) {
      return var0.b;
   }
}
