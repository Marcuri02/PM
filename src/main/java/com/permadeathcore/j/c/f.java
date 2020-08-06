package com.permadeathcore.j.c;

import com.permadeathcore.Main;
import com.permadeathcore.f.g;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class f implements Listener {
   private final Main a;
   private Color b;
   private String c;
   private String d;
   private String e;
   private String f;

   public f(Main var1) {
      this.a = var1;
      this.b = Color.fromRGB(6116957);
      this.c = Main.a("&dNetherite Helmet");
      this.d = Main.a("&dNetherite Chestplate");
      this.e = Main.a("&dNetherite Leggings");
      this.f = Main.a("&dNetherite Boots");
   }

   @EventHandler
   public void a(EntityDeathEvent var1) {
      LivingEntity var2 = var1.getEntity();
      int var3 = Integer.parseInt((String)Objects.requireNonNull(Main.a.getConfig().getString("Toggles.Netherite.Helmet")));
      int var4 = Integer.parseInt((String)Objects.requireNonNull(Main.a.getConfig().getString("Toggles.Netherite.Chestplate")));
      int var5 = Integer.parseInt((String)Objects.requireNonNull(Main.a.getConfig().getString("Toggles.Netherite.Leggings")));
      int var6 = Integer.parseInt((String)Objects.requireNonNull(Main.a.getConfig().getString("Toggles.Netherite.Boots")));
      int var7 = ThreadLocalRandom.current().nextInt(1, 101);
      if (var2 instanceof CaveSpider && this.a.o() >= 25L && this.a.o() < 30L && var7 < var3 && var1.getEntity().getKiller() != null) {
         var1.getDrops().clear();
         var1.getDrops().add(this.a());
      }

      if (var2 instanceof Slime && this.a.o() >= 25L && this.a.o() < 30L && var7 < var4 && var1.getEntity().getKiller() != null) {
         var1.getDrops().clear();
         var1.getDrops().add(this.b());
      }

      if (var2 instanceof MagmaCube && this.a.o() >= 25L && this.a.o() < 30L && var7 < var5 && var1.getEntity().getKiller() != null) {
         var1.getDrops().clear();
         var1.getDrops().add(this.c());
      }

      if (var2 instanceof Ghast && this.a.o() >= 25L && this.a.o() < 30L && var7 < var6 && var1.getEntity().getKiller() != null) {
         var1.getDrops().clear();
         var1.getDrops().add(this.d());
      }

   }

   @EventHandler
   public void a(CreatureSpawnEvent var1) {
      if (!var1.isCancelled()) {
         LivingEntity var2;
         Double var3;
         if (var1.getEntity() instanceof Slime && this.a.o() >= 25L) {
            if (var1.getSpawnReason() == SpawnReason.SLIME_SPLIT) {
               return;
            }

            var2 = var1.getEntity();
            var3 = this.a.n().a((Entity)var2);
            this.a.n().a(var2, var3 * 2.0D, true);
            ((Slime)var2).setSize(15);
            var2.setCustomName(ChatColor.GOLD + "Giga Slime");
            var2.setCustomNameVisible(false);
            if (this.a.o() >= 50L) {
               this.a.n().a(var2, this.a.n().a((Entity)var2) * 2.0D, true);
            }
         }

         if (var1.getEntity() instanceof MagmaCube && this.a.o() >= 25L) {
            var2 = var1.getEntity();
            ((Slime)var2).setSize(16);
            var2.setCustomName(ChatColor.GOLD + "Giga MagmaCube");
            var2.setCustomNameVisible(false);
            if (this.a.o() >= 50L) {
               this.a.n().a(var2, this.a.n().a((Entity)var2) * 2.0D, true);
            }
         }

         if (var1.getEntity() instanceof Ghast && this.a.o() >= 25L && (var1.getEntity().getWorld().getName().endsWith("nether") || var1.getEntity().getWorld().getName().equalsIgnoreCase(Main.p().h.getName()))) {
            if (this.a.o() < 40L) {
               if (var1.getSpawnReason() == SpawnReason.CUSTOM) {
                  return;
               }

               Double var5 = ThreadLocalRandom.current().nextDouble(40.0D, 61.0D);
               LivingEntity var7 = var1.getEntity();
               this.a.n().a(var7, var5, true);
               var7.setHealth(var5);
               var7.setCustomName(ChatColor.GOLD + "Ghast Demoníaco");
            } else {
               if (var1.getSpawnReason() == SpawnReason.CUSTOM) {
                  return;
               }

               int var6 = (new Random()).nextInt(100) + 1;
               var3 = ThreadLocalRandom.current().nextDouble(40.0D, 61.0D);
               LivingEntity var4 = var1.getEntity();
               this.a.n().a(var4, var3, true);
               var4.setHealth(var3);
               if (var6 <= 75) {
                  var4.setCustomName(ChatColor.GOLD + "Demonio flotante");
                  var4.getPersistentDataContainer().set(new NamespacedKey(this.a, "demonio_flotante"), PersistentDataType.BYTE, (byte)1);
               } else {
                  var4.setCustomName(ChatColor.GOLD + "Ghast Demoníaco");
                  var4.getPersistentDataContainer().set(new NamespacedKey(this.a, "ghast_demoniaco"), PersistentDataType.BYTE, (byte)1);
               }
            }
         }

      }
   }

   @EventHandler
   public void a(ProjectileLaunchEvent var1) {
      if (var1.getEntity().getShooter() instanceof Ghast && this.a.o() >= 25L && var1.getEntity() instanceof Fireball) {
         Fireball var2 = (Fireball)var1.getEntity();
         int var3 = ThreadLocalRandom.current().nextInt(3, 6);
         Fireball var4 = (Fireball)var1.getEntity();
         var4.setYield((float)var3);
      }

   }

   @EventHandler
   public void a(EntityExplodeEvent var1) {
      if (var1.getEntity().getType() == EntityType.FIREBALL) {
         Fireball var2 = (Fireball)var1.getEntity();
         if (var2.getShooter() instanceof Ghast) {
            Ghast var3 = (Ghast)var2.getShooter();
            if (var3.getCustomName() == null) {
               return;
            }

            if (var3.getPersistentDataContainer().has(new NamespacedKey(this.a, "demonio_flotante"), PersistentDataType.BYTE)) {
               var1.setCancelled(true);
            } else {
               int var4 = ThreadLocalRandom.current().nextInt(3, 6);
               var1.getLocation().getWorld().createExplosion(var1.getLocation(), (float)var4, true, true, (Entity)var2.getShooter());
            }
         }
      }

   }

   @EventHandler
   public void a(EntityDamageByEntityEvent var1) {
      if (var1.getDamager().getType() == EntityType.FIREBALL) {
         Fireball var2 = (Fireball)var1.getDamager();
         if (var2.getShooter() instanceof Ghast) {
            Ghast var3 = (Ghast)var2.getShooter();
            if (var3.getCustomName() == null) {
               return;
            }

            if (var3.getCustomName().contains(ChatColor.GOLD + "Demonio flotante")) {
               Entity var4 = var1.getEntity();
               if (var4 instanceof LivingEntity) {
                  LivingEntity var5 = (LivingEntity)var4;
                  var5.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 100, 49));
                  var5.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 400, 4));
               }

               var1.setDamage(0.1D);
            }
         }
      }

   }

   @EventHandler
   public void a(InventoryClickEvent var1) {
      Player var2 = (Player)var1.getWhoClicked();
      if (var1.getCurrentItem() != null) {
         if (var1.getCurrentItem().getType() != Material.AIR) {
            if (var1.getInventory().getType() == InventoryType.ANVIL && var1.getSlotType() == SlotType.RESULT) {
               if (var1.getCurrentItem().getItemMeta() == null) {
                  return;
               }

               Main var10000;
               LeatherArmorMeta var3;
               ItemStack var4;
               String var5;
               Material var6;
               if (var1.getCurrentItem().getItemMeta().hasDisplayName()) {
                  if (var1.getCurrentItem().getType() == Material.LEATHER_HELMET || var1.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE || var1.getCurrentItem().getType() == Material.LEATHER_LEGGINGS || var1.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
                     var3 = (LeatherArmorMeta)var1.getCurrentItem().getItemMeta();
                     var4 = var1.getCurrentItem();
                     var5 = "";
                     var6 = var4.getType();
                     if (var3.isUnbreakable() && var6 == Material.LEATHER_BOOTS) {
                        var5 = this.c;
                     } else if (var3.isUnbreakable() && var6 == Material.LEATHER_HELMET) {
                        var5 = this.d;
                     } else if (var3.isUnbreakable() && var6 == Material.LEATHER_CHESTPLATE) {
                        var5 = this.e;
                     } else if (var3.isUnbreakable() && var6 == Material.LEATHER_LEGGINGS) {
                        var5 = this.f;
                     }

                     if ((var3.getColor().equals(Color.fromRGB(16711680)) || var3.getColor() == Color.fromRGB(16711680)) && !var5.isEmpty()) {
                        var10000 = this.a;
                        var5 = Main.a("&dInfernal " + ChatColor.stripColor(var5));
                     }

                     if (!var5.isEmpty()) {
                        var3.setDisplayName(var5);
                        var1.getCurrentItem().setItemMeta(var3);
                     }
                  }
               } else if ((var1.getCurrentItem().getType() == Material.LEATHER_HELMET || var1.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE || var1.getCurrentItem().getType() == Material.LEATHER_LEGGINGS || var1.getCurrentItem().getType() == Material.LEATHER_BOOTS) && var1.getCurrentItem().getItemMeta().isUnbreakable()) {
                  var3 = (LeatherArmorMeta)var1.getCurrentItem().getItemMeta();
                  var4 = var1.getCurrentItem();
                  var5 = "";
                  var6 = var4.getType();
                  if (var3.isUnbreakable() && var6 == Material.LEATHER_BOOTS) {
                     var5 = this.c;
                  } else if (var3.isUnbreakable() && var6 == Material.LEATHER_HELMET) {
                     var5 = this.d;
                  } else if (var3.isUnbreakable() && var6 == Material.LEATHER_CHESTPLATE) {
                     var5 = this.e;
                  } else if (var3.isUnbreakable() && var6 == Material.LEATHER_LEGGINGS) {
                     var5 = this.f;
                  }

                  if ((var3.getColor().equals(Color.fromRGB(16711680)) || var3.getColor() == Color.fromRGB(16711680)) && !var5.isEmpty()) {
                     var10000 = this.a;
                     var5 = Main.a("&dInfernal " + ChatColor.stripColor(var5));
                  }

                  if (!var5.isEmpty()) {
                     var3.setDisplayName(var5);
                     var1.getCurrentItem().setItemMeta(var3);
                  }
               }
            }

         }
      }
   }

   @EventHandler
   public void a(PrepareItemCraftEvent var1) {
      if (var1.getInventory().getResult() != null) {
         if (var1.getInventory().getResult().getType() == Material.LEATHER_HELMET || var1.getInventory().getResult().getType() == Material.LEATHER_CHESTPLATE || var1.getInventory().getResult().getType() == Material.LEATHER_LEGGINGS || var1.getInventory().getResult().getType() == Material.LEATHER_BOOTS) {
            LeatherArmorMeta var2 = (LeatherArmorMeta)var1.getInventory().getResult().getItemMeta();
            if (var2.getColor() != this.b && !var2.isUnbreakable()) {
               var1.getInventory().setResult(new ItemStack(Material.AIR));
            }
         }

      }
   }

   public ItemStack a() {
      ItemStack var1 = (new e(Material.LEATHER_HELMET, 1)).a(this.b).c(this.c).a();
      ItemMeta var2 = var1.getItemMeta();
      EquipmentSlot var3 = EquipmentSlot.HEAD;
      AttributeModifier var4 = new AttributeModifier(UUID.randomUUID(), "generic.armor", 3.0D, Operation.ADD_NUMBER, var3);
      var2.addAttributeModifier(Attribute.GENERIC_ARMOR, var4);
      AttributeModifier var5 = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", 3.0D, Operation.ADD_NUMBER, var3);
      var2.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, var5);
      var2.setUnbreakable(true);
      var1.setItemMeta(var2);
      return var1;
   }

   public ItemStack b() {
      ItemStack var1 = (new e(Material.LEATHER_CHESTPLATE, 1)).a(this.b).c(this.d).a();
      ItemMeta var2 = var1.getItemMeta();
      EquipmentSlot var3 = EquipmentSlot.CHEST;
      AttributeModifier var4 = new AttributeModifier(UUID.randomUUID(), "generic.armor", 8.0D, Operation.ADD_NUMBER, var3);
      var2.addAttributeModifier(Attribute.GENERIC_ARMOR, var4);
      AttributeModifier var5 = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", 3.0D, Operation.ADD_NUMBER, var3);
      var2.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, var5);
      var2.setUnbreakable(true);
      var1.setItemMeta(var2);
      return var1;
   }

   public ItemStack c() {
      ItemStack var1 = (new e(Material.LEATHER_LEGGINGS, 1)).a(this.b).c(this.e).a();
      ItemMeta var2 = var1.getItemMeta();
      EquipmentSlot var3 = EquipmentSlot.LEGS;
      AttributeModifier var4 = new AttributeModifier(UUID.randomUUID(), "generic.armor", 6.0D, Operation.ADD_NUMBER, var3);
      var2.addAttributeModifier(Attribute.GENERIC_ARMOR, var4);
      AttributeModifier var5 = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", 3.0D, Operation.ADD_NUMBER, var3);
      var2.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, var5);
      var2.setUnbreakable(true);
      var1.setItemMeta(var2);
      return var1;
   }

   public ItemStack d() {
      ItemStack var1 = (new e(Material.LEATHER_BOOTS, 1)).a(this.b).c(this.f).a();
      ItemMeta var2 = var1.getItemMeta();
      EquipmentSlot var3 = EquipmentSlot.FEET;
      AttributeModifier var4 = new AttributeModifier(UUID.randomUUID(), "generic.armor", 3.0D, Operation.ADD_NUMBER, var3);
      var2.addAttributeModifier(Attribute.GENERIC_ARMOR, var4);
      AttributeModifier var5 = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", 3.0D, Operation.ADD_NUMBER, var3);
      var2.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, var5);
      var2.setUnbreakable(true);
      var1.setItemMeta(var2);
      return var1;
   }

   public boolean a(ItemStack var1) {
      if (var1 == null) {
         return false;
      } else {
         return var1.hasItemMeta() && var1.getItemMeta().isUnbreakable() && ChatColor.stripColor(var1.getItemMeta().getDisplayName()).startsWith("Netherite");
      }
   }

   public boolean b(ItemStack var1) {
      if (var1 == null) {
         return false;
      } else {
         if (var1.hasItemMeta()) {
            if (var1.getType() == Material.ELYTRA && var1.getItemMeta().isUnbreakable()) {
               return true;
            }

            if (var1.getItemMeta().isUnbreakable() && ChatColor.stripColor(var1.getItemMeta().getDisplayName()).startsWith("Infernal")) {
               return true;
            }
         }

         return false;
      }
   }

   public void a(Player var1) {
      int var2 = 0;
      int var3 = 0;
      ItemStack[] var4 = var1.getInventory().getArmorContents();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ItemStack var7 = var4[var6];
         if (this.a(var7)) {
            ++var2;
         }

         if (this.b(var7)) {
            ++var3;
         }
      }

      g var8;
      if (var2 >= 4 && var3 < 4) {
         if (this.a.o() <= 39L) {
            var1.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(28.0D);
            var1.setHealthScale(28.0D);
            return;
         }

         if (this.a.o() >= 40L) {
            var8 = new g(var1.getName(), this.a);
            if ((double)var8.e() == 4.0D) {
               var1.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(24.0D);
               var1.setHealthScale(24.0D);
            } else {
               var1.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0D);
               var1.setHealthScale(20.0D);
            }
         }
      } else if (var3 < 4 && var3 < 4) {
         if (this.a.o() <= 39L) {
            var1.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0D);
            var1.setHealthScale(20.0D);
            return;
         }

         if (this.a.o() >= 40L) {
            var8 = new g(var1.getName(), this.a);
            if ((double)var8.e() == 4.0D) {
               var1.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(16.0D);
               var1.setHealthScale(16.0D);
            } else {
               var1.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(12.0D);
               var1.setHealthScale(12.0D);
            }
         }
      } else if (var3 >= 4 && var2 < 4) {
         var8 = new g(var1.getName(), this.a);
         if ((double)var8.e() == 4.0D) {
            var1.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(26.0D);
            var1.setHealthScale(26.0D);
         } else {
            var1.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(22.0D);
            var1.setHealthScale(22.0D);
         }

         if (!var1.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
            var1.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 300, 0));
         }
      }

   }
}
