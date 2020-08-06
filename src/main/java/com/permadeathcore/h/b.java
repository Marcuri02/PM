package com.permadeathcore.h;

import com.permadeathcore.Main;
import com.permadeathcore.g.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Cat;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.PufferFish;
import org.bukkit.entity.Ravager;
import org.bukkit.entity.Villager;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.EnderDragon.Phase;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class b extends BukkitRunnable {
   private Location b;
   private Main c;
   int a = 5;

   public b(Location var1, Main var2) {
      this.b = var1;
      this.c = var2;
   }

   public void run() {
      Main var10000;
      if (this.a > 0) {
         var10000 = this.c;
         Bukkit.broadcastMessage(Main.a("&eUn gato galáctico invocará un mob al azar en: &b" + this.a));
         Iterator var1 = Bukkit.getOnlinePlayers().iterator();

         while(var1.hasNext()) {
            Player var2 = (Player)var1.next();
            var2.playSound(var2.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 100.0F, 100.0F);
         }

         --this.a;
      }

      if (this.a == 0) {
         String var11 = "";
         ArrayList var12 = new ArrayList();
         var12.add(EntityType.CAT);
         var12.add(EntityType.PUFFERFISH);
         var12.add(EntityType.RAVAGER);
         var12.add(EntityType.ENDER_DRAGON);
         var12.add(EntityType.SKELETON);
         var12.add(EntityType.SLIME);
         var12.add(EntityType.MAGMA_CUBE);
         var12.add(EntityType.WITCH);
         var12.add(EntityType.SPIDER);
         var12.add(EntityType.SILVERFISH);
         var12.add(EntityType.ENDERMITE);
         var12.add(EntityType.PHANTOM);
         var12.add(EntityType.GHAST);
         var12.add(EntityType.CREEPER);
         var12.add(EntityType.SHULKER);
         var12.add(EntityType.GIANT);
         var12.add(EntityType.WITHER_SKELETON);
         int var3 = (new Random()).nextInt(var12.size());
         EntityType var4 = (EntityType)var12.get(var3);
         SplittableRandom var5 = new SplittableRandom();
         Main var10001;
         if (var4 == EntityType.CAT) {
            var11 = "Gato Supernova";
            Cat var6 = (Cat)this.b.getWorld().spawnEntity(this.b, EntityType.CAT);
            var6.setAdult();
            var10001 = this.c;
            var6.setCustomName(Main.a("&6" + var11));
         } else if (var4 == EntityType.PUFFERFISH) {
            var11 = "Pufferfish invulnerable";
            PufferFish var23 = (PufferFish)this.b.getWorld().spawnEntity(this.b, EntityType.PUFFERFISH);
         } else {
            LivingEntity var8;
            if (var4 == EntityType.RAVAGER) {
               EntityType var13;
               if (l.c()) {
                  var13 = EntityType.valueOf("ZOMBIFIED_PIGLIN");
               } else {
                  var13 = EntityType.valueOf("PIG_ZOMBIE");
               }

               var11 = "Ultra Ravager";
               Ravager var7 = (Ravager)this.b.getWorld().spawn(this.b, Ravager.class);
               var8 = (LivingEntity)this.b.getWorld().spawnEntity(this.b, var13);
               Villager var9 = (Villager)this.b.getWorld().spawn(this.b, Villager.class);
               var8.addPassenger(var9);
               var7.addPassenger(var8);
               Main.a.n().a(var9, 500.0D, true);
               Main.a.n().a(var8, 150.0D, true);
               Main.a.n().a(var7, 240.0D, true);
               var9.setCustomName(ChatColor.GREEN + "Jess la Emperatriz");
               var8.setCustomName(ChatColor.GREEN + "Carlos el Esclavo");
               var7.setCustomName(ChatColor.GREEN + "Ultra Ravager");
               var9.getEquipment().setItemInMainHand(new ItemStack(Material.GOLDEN_APPLE, 2));
               var9.getEquipment().setItemInMainHandDropChance(0.0F);
               var8.getEquipment().setItemInMainHand(new ItemStack(Material.GOLD_INGOT, 32));
               var8.getEquipment().setItemInMainHandDropChance(0.0F);
               var7.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
               var7.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
               var7.getPersistentDataContainer().set(new NamespacedKey(Main.a, "ultra_ravager"), PersistentDataType.BYTE, (byte)1);
            } else if (var4 == EntityType.ENDER_DRAGON) {
               var11 = "Permadeath Demon";
               EnderDragon var14 = (EnderDragon)this.b.getWorld().spawnEntity(this.b, EntityType.ENDER_DRAGON);
               var14.setPhase(Phase.LEAVE_PORTAL);
               var14.setAI(true);
               var10001 = this.c;
               var14.setCustomName(Main.a("&6&lPERMADEATH DEMON"));
               this.c.n().a(var14, 1350.0D, true);
            } else if (var4 == EntityType.SKELETON) {
               var11 = "Esqueleto de Clase";
               Main.a.f().a("Skeleton", EntityType.SKELETON, this.b, SpawnReason.NATURAL);
            } else if (var4 == EntityType.SLIME) {
               var11 = "Giga Slime";
               this.b.getWorld().spawnEntity(this.b, EntityType.SLIME);
            } else if (var4 == EntityType.MAGMA_CUBE) {
               var11 = "Giga MagmaCube";
               this.b.getWorld().spawnEntity(this.b, EntityType.MAGMA_CUBE);
            } else if (var4 == EntityType.WITCH) {
               var11 = "Bruja Imposible";
               this.b.getWorld().spawnEntity(this.b, EntityType.WITCH);
            } else if (var4 == EntityType.PHANTOM) {
               var11 = "Giga Phantom";
               Main.a.f().a("Phantom", EntityType.PHANTOM, this.b, SpawnReason.NATURAL);
            } else if (var4 == EntityType.SPIDER) {
               var11 = "Araña con Efectos";
               this.b.getWorld().spawnEntity(this.b, EntityType.CAVE_SPIDER);
            } else if (var4 == EntityType.SILVERFISH) {
               var11 = "Silverfish de la Muerte";
               this.b.getWorld().spawnEntity(this.b, EntityType.SILVERFISH);
            } else if (var4 == EntityType.ENDERMITE) {
               var11 = "Endermite Misterioso";
               this.b.getWorld().spawnEntity(this.b, EntityType.ENDERMITE);
            } else if (var4 == EntityType.SHULKER) {
               var11 = "Shulker Tnt";
               this.b.getWorld().spawnEntity(this.b, EntityType.SHULKER);
            } else {
               int var16;
               if (var4 == EntityType.GHAST) {
                  var16 = var5.nextInt(3) + 1;
                  if (var16 == 1) {
                     var11 = "Ender Ghast";
                     this.c.f().b(this.b, SpawnReason.CUSTOM, true);
                  }

                  if (var16 == 2) {
                     var11 = "Ghast Demoníaco";
                     Ghast var15 = (Ghast)this.b.getWorld().spawnEntity(this.b, EntityType.GHAST);
                     Double var19 = ThreadLocalRandom.current().nextDouble(40.0D, 61.0D);
                     this.c.n().a(var15, var19, true);
                     var15.setHealth(var19);
                     var15.setCustomName(ChatColor.GOLD + "Ghast Demoníaco");
                  }

                  if (var16 == 3) {
                     var11 = "Demonio Flotante";
                     Double var17 = ThreadLocalRandom.current().nextDouble(40.0D, 61.0D);
                     var8 = (LivingEntity)this.b.getWorld().spawnEntity(this.b, EntityType.GHAST);
                     this.c.n().a(var8, var17, true);
                     var8.setHealth(var17);
                     var8.setCustomName(ChatColor.GOLD + "Demonio flotante");
                  }
               } else if (var4 == EntityType.CREEPER) {
                  if (Main.a.o() < 60L) {
                     var16 = var5.nextInt(3) + 1;
                  } else {
                     var16 = var5.nextInt(2) + 1;
                  }

                  if (var16 == 1) {
                     var11 = "Ender Quantum Creeper";
                     this.c.d().c(this.b);
                  }

                  if (var16 == 2) {
                     var11 = "Quantum Creeper";
                     this.c.d().b(this.b);
                  }

                  if (var16 == 3) {
                     var11 = "Ender Creeper";
                     this.c.d().a(this.b);
                  }
               }
            }
         }

         if (var4 == EntityType.GIANT) {
            var11 = "Gigante";
            Main.a.f().b("CustomGiant", EntityType.GIANT, this.b, SpawnReason.CUSTOM);
         }

         if (var4 == EntityType.WITHER_SKELETON) {
            var11 = "Wither Skeleton Emperador";
            WitherSkeleton var20 = (WitherSkeleton)Main.a.f().a("SkeletonWither", EntityType.WITHER_SKELETON, this.b, SpawnReason.CUSTOM);
            EntityEquipment var18 = var20.getEquipment();
            Main.a.n().a(var20, 80.0D, true);
            var10001 = Main.a;
            var20.setCustomName(Main.a("&6Wither Skeleton Emperador"));
            var20.setCollidable(false);
            ItemStack var21 = new ItemStack(Material.BLACK_BANNER, 1);
            BannerMeta var22 = (BannerMeta)var21.getItemMeta();
            ArrayList var10 = new ArrayList();
            var10.add(new Pattern(DyeColor.YELLOW, PatternType.STRAIGHT_CROSS));
            var10.add(new Pattern(DyeColor.BLACK, PatternType.BRICKS));
            var10.add(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
            var10.add(new Pattern(DyeColor.YELLOW, PatternType.FLOWER));
            var10.add(new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_TOP));
            var10.add(new Pattern(DyeColor.RED, PatternType.GRADIENT_UP));
            var22.setPatterns(var10);
            var21.setItemMeta(var22);
            var18.setHelmet(var21);
            var18.setHelmetDropChance(0.0F);
            var18.setChestplate(new ItemStack(Material.GOLDEN_CHESTPLATE));
            var18.setLeggings(new ItemStack(Material.GOLDEN_LEGGINGS));
            var18.setBoots(new ItemStack(Material.GOLDEN_BOOTS));
            var18.setItemInMainHand((new com.permadeathcore.j.c.d(Material.BOW)).a(Enchantment.ARROW_KNOCKBACK, 5).a(Enchantment.ARROW_DAMAGE, 100).a());
            var18.setItemInMainHandDropChance(0.0F);
         }

         var10000 = this.c;
         Bukkit.broadcastMessage(Main.a("&eUn gato galáctico ha invicado un(a) &c&l" + var11 + " &7(" + this.b.getX() + ", " + this.b.getY() + ", " + this.b.getZ()));
         this.cancel();
      }

   }
}
