package com.permadeathcore.j.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class d {
   protected ItemStack a;
   protected ItemMeta b;

   public d() {
   }

   public d(ItemStack var1) {
      this.a = new ItemStack(var1);
   }

   public d(Material var1) {
      this.a = new ItemStack(var1);
   }

   public d(Material var1, int var2) {
      this.a = new ItemStack(var1, var2);
   }

   public d(Material var1, int var2, int var3) {
      this.a = new ItemStack(var1, var2, (short)var3);
   }

   public static ItemStack a(String var0) {
      var0 = var0.replace("\\n", "\n");
      String[] var1 = var0.split(" : ");
      String var2 = var1[0].split(":")[0];
      ItemStack var3 = new ItemStack(Material.matchMaterial(var2.toUpperCase()));
      if (var1[0].split(":").length > 1) {
         var3.setDurability((short)Integer.parseInt(var1[0].split(":")[1]));
      }

      ItemMeta var4 = var3.getItemMeta();
      if (var1.length > 1) {
         var3.setAmount(Integer.parseInt(var1[1]) > 64 ? 64 : Integer.parseInt(var1[1]));
      }

      ArrayList var5 = new ArrayList();

      for(int var6 = 2; var6 < var1.length; ++var6) {
         String var7 = var1[var6];
         if (var7.startsWith("name=")) {
            var4.setDisplayName(d(var7.split("=")[1]));
         }

         String[] var9;
         int var10;
         int var11;
         String var12;
         if (var7.startsWith("lore=")) {
            var9 = var7.split("=")[1].split("\\n");
            var10 = var9.length;

            for(var11 = 0; var11 < var10; ++var11) {
               var12 = var9[var11];
               var5.add(d(var12));
            }
         }

         if (var7.startsWith("enchant=")) {
            var9 = var7.split("=")[1].split("\\n");
            var10 = var9.length;

            for(var11 = 0; var11 < var10; ++var11) {
               var12 = var9[var11];
               var4.addEnchant(Enchantment.getByName(var12.split(":")[0]), Integer.parseInt(var12.split(":")[1]), true);
            }
         }
      }

      if (!var5.isEmpty()) {
         var4.setLore(var5);
      }

      var3.setItemMeta(var4);
      return var3;
   }

   public static ItemStack b(String var0) {
      var0 = var0.replace("\\n", "\n");
      String[] var1 = var0.split(" : ");
      ItemStack var2 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short)Integer.parseInt(var1[0]));
      SkullMeta var3 = (SkullMeta)var2.getItemMeta();
      ArrayList var4 = new ArrayList();

      for(int var5 = 1; var5 < var1.length; ++var5) {
         String var6 = var1[var5];
         if (var6.startsWith("owner=")) {
            var3.setOwner(var6.split("=")[1]);
         }

         if (var6.startsWith("name=")) {
            var3.setDisplayName(d(var6.split("=")[1]));
         }

         String[] var8;
         int var9;
         int var10;
         String var11;
         if (var6.startsWith("lore=")) {
            var8 = var6.split("=")[1].split("\\n");
            var9 = var8.length;

            for(var10 = 0; var10 < var9; ++var10) {
               var11 = var8[var10];
               var4.add(d(var11));
            }
         }

         if (var6.startsWith("enchant=")) {
            var8 = var6.split("=")[1].split("\\n");
            var9 = var8.length;

            for(var10 = 0; var10 < var9; ++var10) {
               var11 = var8[var10];
               var3.addEnchant(Enchantment.getByName(var11.split(":")[0]), Integer.parseInt(var11.split(":")[1]), true);
            }
         }
      }

      if (!var4.isEmpty()) {
         var3.setLore(var4);
      }

      var2.setItemMeta(var3);
      return var2;
   }

   public d a(int var1) {
      this.a.setDurability((short)var1);
      return this;
   }

   public d a(boolean var1) {
      this.b = this.a.getItemMeta();
      this.b.setUnbreakable(var1);
      this.a.setItemMeta(this.b);
      return this;
   }

   public d c(String var1) {
      this.b = this.a.getItemMeta();
      this.b.setDisplayName(var1);
      this.a.setItemMeta(this.b);
      return this;
   }

   public d a(Enchantment var1, int var2) {
      this.b = this.a.getItemMeta();
      this.b.addEnchant(var1, var2, true);
      this.a.setItemMeta(this.b);
      return this;
   }

   public d a(Map var1) {
      this.b = this.a.getItemMeta();
      if (!var1.isEmpty()) {
         Iterator var2 = var1.keySet().iterator();

         while(var2.hasNext()) {
            Enchantment var3 = (Enchantment)var2.next();
            this.b.addEnchant(var3, (Integer)var1.get(var3), true);
         }
      }

      this.a.setItemMeta(this.b);
      return this;
   }

   public d a(ItemFlag var1) {
      this.b = this.a.getItemMeta();
      this.b.addItemFlags(new ItemFlag[]{var1});
      this.a.setItemMeta(this.b);
      return this;
   }

   public d a(List var1) {
      this.b = this.a.getItemMeta();
      this.b.setLore(var1);
      this.a.setItemMeta(this.b);
      return this;
   }

   public static String d(String var0) {
      return ChatColor.translateAlternateColorCodes('&', var0);
   }

   public ItemStack a() {
      return this.a;
   }
}
