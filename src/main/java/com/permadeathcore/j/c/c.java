package com.permadeathcore.j.c;

import com.permadeathcore.Main;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class c implements Listener {
   private final Main a;
   private Color b;
   private String c;
   private String d;
   private String e;
   private String f;

   public c(Main var1) {
      this.a = var1;
      this.b = Color.fromRGB(16711680);
      this.c = Main.a("&dInfernal Netherite Helmet");
      this.d = Main.a("&dInfernal Netherite Chestplate");
      this.e = Main.a("&dInfernal Netherite Leggings");
      this.f = Main.a("&dInfernal Netherite Boots");
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
      ItemStack var1 = (new e(Material.LEATHER_BOOTS, 1)).a(Color.fromRGB(11277847)).a(this.b).c(this.f).a();
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
}
