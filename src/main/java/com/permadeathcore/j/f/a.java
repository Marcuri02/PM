package com.permadeathcore.j.f;

import com.permadeathcore.Main;
import com.permadeathcore.j.c.d;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class a {
   private Main a;

   public a(Main var1) {
      this.a = var1;
   }

   public void a() {
      this.m();
      this.n();
      this.l();
      this.k();
   }

   public void b() {
      this.g();
      this.h();
      this.i();
      this.j();
   }

   public void c() {
      this.f();
      this.e();
      this.d();
   }

   private void d() {
      ItemStack var1 = com.permadeathcore.j.c.a.c();
      NamespacedKey var2 = new NamespacedKey(this.a, "PERMADEATHCORE_BR");
      ShapedRecipe var3 = new ShapedRecipe(var2, var1);
      var3.shape(new String[]{"SBS", "BDB", "SBS"});
      var3.setIngredient('B', Material.DIAMOND_BLOCK);
      var3.setIngredient('D', Material.LIGHT_BLUE_DYE);
      var3.setIngredient('S', Material.SHULKER_SHELL);
      this.a.getServer().addRecipe(var3);
   }

   private void e() {
      ItemStack var1 = com.permadeathcore.j.c.a.b();
      NamespacedKey var2 = new NamespacedKey(this.a, "PERMADEATHCORE_LIFO");
      ShapedRecipe var3 = new ShapedRecipe(var2, var1);
      var3.shape(new String[]{"DGB", "RSE", "NOL"});
      var3.setIngredient('D', Material.DIAMOND);
      var3.setIngredient('G', Material.GOLD_INGOT);
      var3.setIngredient('B', Material.BONE_BLOCK);
      var3.setIngredient('R', Material.BLAZE_ROD);
      var3.setIngredient('S', Material.HEART_OF_THE_SEA);
      var3.setIngredient('E', Material.END_STONE);
      var3.setIngredient('N', Material.NETHER_BRICK);
      var3.setIngredient('O', Material.OBSIDIAN);
      var3.setIngredient('L', Material.LAPIS_BLOCK);
      this.a.getServer().addRecipe(var3);
   }

   private void f() {
      ItemStack var1 = com.permadeathcore.j.c.a.d();
      NamespacedKey var2 = new NamespacedKey(this.a, "PERMADEATHCORE_EI");
      ShapedRecipe var3 = new ShapedRecipe(var2, var1);
      var3.shape(new String[]{"III", "IPI", "III"});
      var3.setIngredient('I', Material.DIAMOND);
      var3.setIngredient('P', Material.ELYTRA);
      this.a.getServer().addRecipe(var3);
   }

   private void g() {
      ItemStack var1 = this.a.h().a();
      NamespacedKey var2 = new NamespacedKey(this.a, "PERMADEATHCORE_INH");
      ShapedRecipe var3 = new ShapedRecipe(var2, var1);
      var3.shape(new String[]{" I ", "IPI", " I "});
      var3.setIngredient('I', Material.DIAMOND);
      var3.setIngredient('P', Material.LEATHER_HELMET);
      this.a.getServer().addRecipe(var3);
   }

   private void h() {
      ItemStack var1 = this.a.h().b();
      NamespacedKey var2 = new NamespacedKey(this.a, "PERMADEATHCORE_INC");
      ShapedRecipe var3 = new ShapedRecipe(var2, var1);
      var3.shape(new String[]{" I ", "IPI", " I "});
      var3.setIngredient('I', Material.DIAMOND);
      var3.setIngredient('P', Material.LEATHER_CHESTPLATE);
      this.a.getServer().addRecipe(var3);
   }

   private void i() {
      ItemStack var1 = this.a.h().c();
      NamespacedKey var2 = new NamespacedKey(this.a, "PERMADEATHCORE_INL");
      ShapedRecipe var3 = new ShapedRecipe(var2, var1);
      var3.shape(new String[]{" I ", "IPI", " I "});
      var3.setIngredient('I', Material.DIAMOND);
      var3.setIngredient('P', Material.LEATHER_LEGGINGS);
      this.a.getServer().addRecipe(var3);
   }

   private void j() {
      ItemStack var1 = this.a.h().d();
      NamespacedKey var2 = new NamespacedKey(this.a, "PERMADEATHCORE_INB");
      ShapedRecipe var3 = new ShapedRecipe(var2, var1);
      var3.shape(new String[]{" I ", "IPI", " I "});
      var3.setIngredient('I', Material.DIAMOND);
      var3.setIngredient('P', Material.LEATHER_BOOTS);
      this.a.getServer().addRecipe(var3);
   }

   private void k() {
      ItemStack var1 = com.permadeathcore.j.c.a.a();
      ItemMeta var2 = var1.getItemMeta();
      var2.setUnbreakable(true);
      var1.setItemMeta(var2);
      NamespacedKey var3 = new NamespacedKey(this.a, "PERMADEATHCORE_ER");
      ShapedRecipe var4 = new ShapedRecipe(var3, var1);
      var4.shape(new String[]{" S ", " D ", " S "});
      var4.setIngredient('S', Material.SHULKER_SHELL);
      var4.setIngredient('D', Material.DIAMOND_BLOCK);
      this.a.getServer().addRecipe(var4);
   }

   private void l() {
      ItemStack var1 = (new d(Material.SHULKER_SHELL, 2)).a();
      NamespacedKey var2 = new NamespacedKey(this.a, "PERMADEATHCORE_SU");
      ShapedRecipe var3 = new ShapedRecipe(var2, var1);
      var3.shape(new String[]{"   ", " A ", "   "});
      var3.setIngredient('A', Material.SHULKER_BOX);
      this.a.getServer().addRecipe(var3);
   }

   private void m() {
      d var10000 = new d(Material.GOLDEN_APPLE, 1);
      Main var10001 = this.a;
      ItemStack var1 = var10000.c(Main.a("&6Hyper Golden Apple +")).a(Enchantment.ARROW_INFINITE, 1).a(ItemFlag.HIDE_ENCHANTS).a();
      NamespacedKey var2 = new NamespacedKey(this.a, "PERMADEATHCORE_HG");
      ShapedRecipe var3 = new ShapedRecipe(var2, var1);
      var3.shape(new String[]{"GGG", "GAG", "GGG"});
      var3.setIngredient('G', Material.GOLD_BLOCK);
      var3.setIngredient('A', Material.GOLDEN_APPLE);
      this.a.getServer().addRecipe(var3);
   }

   private void n() {
      d var10000 = new d(Material.GOLDEN_APPLE, 1);
      Main var10001 = this.a;
      ItemStack var1 = var10000.c(Main.a("&6Super Golden Apple +")).a(Enchantment.ARROW_INFINITE, 1).a(ItemFlag.HIDE_ENCHANTS).a();
      NamespacedKey var2 = new NamespacedKey(this.a, "PERMADEATHCORE_SG");
      ShapedRecipe var3 = new ShapedRecipe(var2, var1);
      var3.shape(new String[]{"GGG", "GAG", "GGG"});
      var3.setIngredient('G', Material.GOLD_INGOT);
      var3.setIngredient('A', Material.GOLDEN_APPLE);
      this.a.getServer().addRecipe(var3);
   }
}
