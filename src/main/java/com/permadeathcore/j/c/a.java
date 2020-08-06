package com.permadeathcore.j.c;

import java.util.Arrays;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class a {
   public static void a(Player var0) {
      if (var0.getGameMode() != GameMode.SPECTATOR && !var0.isDead() && var0.isOnline()) {
         boolean var1 = false;
         boolean var2 = false;
         if (var0.getInventory().getItemInOffHand() != null && a(var0, var0.getInventory().getItemInOffHand())) {
            var1 = true;
         }

         ItemStack[] var3 = var0.getInventory().getContents();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            ItemStack var6 = var3[var5];
            if (a(var0, var6)) {
               var2 = true;
            }
         }

         if (!var2 && !var1) {
            ItemStack var7 = new ItemStack(Material.STRUCTURE_VOID);
            if (var0.getInventory().getItemInOffHand() == null) {
               var0.getInventory().setItemInOffHand(var7);
               var0.updateInventory();
            } else {
               if (var0.getInventory().getItemInOffHand().getType() == Material.AIR) {
                  var0.getInventory().setItemInOffHand(var7);
                  var0.updateInventory();
                  return;
               }

               if (var0.getInventory().getItemInOffHand().getType() != Material.STRUCTURE_VOID && var0.getInventory().getItemInOffHand().getType() != Material.AIR) {
                  var0.getWorld().dropItemNaturally(var0.getLocation().add(0.0D, 0.5D, 0.0D), var0.getInventory().getItemInOffHand());
                  var0.getInventory().setItemInOffHand(var7);
                  var0.updateInventory();
               }
            }

            if (var0.getInventory().getItem(4) == null) {
               var0.getInventory().setItem(4, var7);
               var0.updateInventory();
            } else if (var0.getInventory().getItem(4).getType() != Material.STRUCTURE_VOID && var0.getInventory().getItem(4).getType() != Material.AIR) {
               var0.getWorld().dropItemNaturally(var0.getLocation().add(0.0D, 0.5D, 0.0D), var0.getInventory().getItem(4));
               var0.updateInventory();
               var0.getInventory().setItem(4, var7);
               var0.updateInventory();
            }

            if (var0.getInventory().getItem(13) == null) {
               var0.getInventory().setItem(13, var7);
               var0.updateInventory();
            } else if (var0.getInventory().getItem(13).getType() != Material.STRUCTURE_VOID && var0.getInventory().getItem(13).getType() != Material.AIR) {
               var0.getWorld().dropItemNaturally(var0.getLocation().add(0.0D, 0.5D, 0.0D), var0.getInventory().getItem(13));
               var0.getInventory().setItem(13, var7);
               var0.updateInventory();
            }

            if (var0.getInventory().getItem(22) == null) {
               var0.getInventory().setItem(22, var7);
               var0.updateInventory();
            } else if (var0.getInventory().getItem(22).getType() != Material.STRUCTURE_VOID && var0.getInventory().getItem(22).getType() != Material.AIR) {
               var0.getWorld().dropItemNaturally(var0.getLocation().add(0.0D, 0.5D, 0.0D), var0.getInventory().getItem(22));
               var0.getInventory().setItem(22, var7);
               var0.updateInventory();
            }

            if (var0.getInventory().getItem(31) == null) {
               var0.getInventory().setItem(31, var7);
               var0.updateInventory();
            } else if (var0.getInventory().getItem(31).getType() != Material.STRUCTURE_VOID && var0.getInventory().getItem(31).getType() != Material.AIR) {
               var0.getWorld().dropItemNaturally(var0.getLocation().add(0.0D, 0.5D, 0.0D), var0.getInventory().getItem(31));
               var0.getInventory().setItem(31, var7);
               var0.updateInventory();
            }
         }

         if (var1 || var2) {
            if (var0.getInventory().contains(Material.STRUCTURE_VOID)) {
               var0.getInventory().remove((new d(Material.STRUCTURE_VOID)).a(false).a());
            }

            if (var0.getInventory().getItemInOffHand() != null && var0.getInventory().getItemInOffHand().getType() == Material.STRUCTURE_VOID) {
               var0.getInventory().setItemInOffHand((ItemStack)null);
            }
         }

      }
   }

   public static boolean a(Player var0, ItemStack var1) {
      if (var1 == null) {
         return false;
      } else if (!var1.hasItemMeta()) {
         return false;
      } else {
         return var1.getType() == Material.LIGHT_BLUE_DYE && var1.getItemMeta().getDisplayName().endsWith(a("&6Reliquia Del Fin"));
      }
   }

   public static ItemStack a() {
      ItemStack var0 = (new d(Material.LIGHT_BLUE_DYE)).c(a("&6Reliquia Del Fin")).a();
      ItemMeta var1 = var0.getItemMeta();
      var1.setUnbreakable(true);
      var1.setLore(Arrays.asList(b.a("{" + UUID.randomUUID().toString() + ": 0}")));
      var0.setItemMeta(var1);
      return var0;
   }

   public static ItemStack b() {
      ItemStack var0 = (new d(Material.BROWN_DYE)).a(true).c(a("&6Orbe de Vida")).a();
      return var0;
   }

   public static ItemStack c() {
      return (new d(Material.CYAN_DYE)).a(true).c(a("&6Reliquia del Comienzo")).a();
   }

   public static ItemStack d() {
      ItemStack var0 = (new d(Material.ELYTRA)).c(a("&6Elytras de Netherite Infernal")).a(true).a();
      ItemMeta var1 = var0.getItemMeta();
      AttributeModifier var2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", 8.0D, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
      AttributeModifier var3 = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", 3.0D, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
      var1.addAttributeModifier(Attribute.GENERIC_ARMOR, var2);
      var1.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, var3);
      var0.setItemMeta(var1);
      return var0;
   }

   public static ItemStack e() {
      ItemStack var0 = (new d(Material.DIAMOND_SWORD)).c(a("&6Espada de Netherite")).a();
      ItemMeta var1 = var0.getItemMeta();
      AttributeModifier var2 = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 7.0D, Operation.ADD_NUMBER, EquipmentSlot.HAND);
      AttributeModifier var3 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -2.4D, Operation.ADD_NUMBER, EquipmentSlot.HAND);
      var1.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, var2);
      var1.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, var3);
      var1.setUnbreakable(true);
      var0.setItemMeta(var1);
      return var0;
   }

   public static ItemStack f() {
      ItemStack var0 = (new d(Material.DIAMOND_PICKAXE)).c(a("&6Pico de Netherite")).a();
      ItemMeta var1 = var0.getItemMeta();
      var1.setUnbreakable(true);
      var0.setItemMeta(var1);
      return var0;
   }

   public static ItemStack g() {
      ItemStack var0 = (new d(Material.DIAMOND_HOE)).c(a("&6Azada de Netherite")).a();
      ItemMeta var1 = var0.getItemMeta();
      var1.setUnbreakable(true);
      var0.setItemMeta(var1);
      return var0;
   }

   public static ItemStack h() {
      ItemStack var0 = (new d(Material.DIAMOND_AXE)).c(a("&6Hacha de Netherite")).a();
      ItemMeta var1 = var0.getItemMeta();
      var1.setUnbreakable(true);
      var0.setItemMeta(var1);
      return var0;
   }

   public static ItemStack i() {
      ItemStack var0 = (new d(Material.DIAMOND_SHOVEL)).c(a("&6Pala de Netherite")).a();
      ItemMeta var1 = var0.getItemMeta();
      var1.setUnbreakable(true);
      var0.setItemMeta(var1);
      return var0;
   }

   public static ItemStack j() {
      ItemStack var0 = (new d(Material.DIAMOND)).c(a("&6Infernal Netherite Block")).a();
      ItemMeta var1 = var0.getItemMeta();
      var1.setUnbreakable(true);
      var1.setLore(Arrays.asList(b.a("{" + UUID.randomUUID().toString() + ": 0}")));
      var0.setItemMeta(var1);
      return var0;
   }

   private static String a(String var0) {
      return ChatColor.translateAlternateColorCodes('&', var0);
   }
}
