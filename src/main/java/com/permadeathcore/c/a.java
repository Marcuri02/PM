package com.permadeathcore.c;

import com.permadeathcore.Main;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class a implements Listener {
   private final Main a;

   public a(Main var1) {
      this.a = var1;
   }

   @EventHandler
   public void a(CreatureSpawnEvent var1) {
      if (!var1.isCancelled()) {
         this.b(var1);
      }
   }

   private void b(CreatureSpawnEvent var1) {
      int var2 = ThreadLocalRandom.current().nextInt(1, 6);
      ItemStack var9;
      ItemStack var10;
      ItemStack var11;
      LeatherArmorMeta var14;
      LeatherArmorMeta var15;
      ItemMeta var16;
      World var17;
      Location var18;
      Entity var19;
      LivingEntity var20;
      ItemStack var21;
      ItemStack var22;
      ItemMeta var23;
      LeatherArmorMeta var24;
      LeatherArmorMeta var25;
      if (this.a.o() >= 20L && this.a.o() <= 29L && var1.getEntity() instanceof Spider && !(var1.getEntity() instanceof CaveSpider)) {
         if (var2 == 1) {
            ItemStack var3 = new ItemStack(Material.WOODEN_HOE, 1, (short)1);
            ItemMeta var4 = var3.getItemMeta();
            var4.setUnbreakable(true);
            var4.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE});
            var3.setItemMeta(var4);
            World var5 = Main.a.h;
            Location var6 = var1.getLocation();
            Entity var7 = var5.spawnEntity(var6, EntityType.SKELETON);
            LivingEntity var8 = (LivingEntity)var7;
            ((Skeleton)var7).setMaxHealth(20.0D);
            ((Skeleton)var7).setHealth(((Skeleton)var7).getMaxHealth());
            var9 = new ItemStack(Material.DIAMOND_HELMET);
            var10 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            var11 = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemStack var12 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemStack var13 = new ItemStack(Material.BOW, 1);
            var8.getEquipment().setHelmet(var9);
            var8.getEquipment().setChestplate(var10);
            var8.getEquipment().setLeggings(var11);
            var8.getEquipment().setBoots(var12);
            var8.getEquipment().setItemInMainHand(var13);
            ((Skeleton)var7).getEquipment().setItemInMainHandDropChance(0.0F);
            ((Skeleton)var7).getEquipment().setItemInOffHandDropChance(0.0F);
            var1.getEntity().setPassenger(var8);
         }

         if (var2 == 2) {
            var17 = Main.a.h;
            var18 = var1.getLocation();
            var19 = var17.spawnEntity(var18, EntityType.WITHER_SKELETON);
            var20 = (LivingEntity)var19;
            ((Skeleton)var19).setMaxHealth(40.0D);
            ((Skeleton)var19).setHealth(((Skeleton)var19).getMaxHealth());
            var21 = new ItemStack(Material.CHAINMAIL_HELMET);
            var22 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            var9 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            var10 = new ItemStack(Material.CHAINMAIL_BOOTS);
            var11 = new ItemStack(Material.BOW, 1);
            var23 = var11.getItemMeta();
            var23.addEnchant(Enchantment.ARROW_KNOCKBACK, 20, true);
            var11.setItemMeta(var23);
            var20.getEquipment().setHelmet(var21);
            var20.getEquipment().setChestplate(var22);
            var20.getEquipment().setLeggings(var9);
            var20.getEquipment().setBoots(var10);
            var20.getEquipment().setItemInMainHand(var11);
            ((Skeleton)var19).getEquipment().setItemInMainHandDropChance(0.0F);
            ((Skeleton)var19).getEquipment().setItemInOffHandDropChance(0.0F);
            var1.getEntity().setPassenger(var20);
         }

         if (var2 == 3) {
            var17 = Main.a.h;
            var18 = var1.getLocation();
            var19 = var17.spawnEntity(var18, EntityType.SKELETON);
            var20 = (LivingEntity)var19;
            ((Skeleton)var19).setMaxHealth(20.0D);
            ((Skeleton)var19).setHealth(((Skeleton)var19).getMaxHealth());
            var21 = new ItemStack(Material.IRON_HELMET);
            var22 = new ItemStack(Material.IRON_CHESTPLATE);
            var9 = new ItemStack(Material.IRON_LEGGINGS);
            var10 = new ItemStack(Material.IRON_BOOTS);
            var11 = new ItemStack(Material.IRON_AXE, 1);
            var23 = var11.getItemMeta();
            var23.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
            var11.setItemMeta(var23);
            var20.getEquipment().setHelmet(var21);
            var20.getEquipment().setChestplate(var22);
            var20.getEquipment().setLeggings(var9);
            var20.getEquipment().setBoots(var10);
            var20.getEquipment().setItemInMainHand(var11);
            ((Skeleton)var19).getEquipment().setItemInMainHandDropChance(0.0F);
            ((Skeleton)var19).getEquipment().setItemInOffHandDropChance(0.0F);
            var1.getEntity().setPassenger(var20);
         }

         if (var2 == 4) {
            var17 = Main.a.h;
            var18 = var1.getLocation();
            var19 = var17.spawnEntity(var18, EntityType.SKELETON);
            var20 = (LivingEntity)var19;
            ((Skeleton)var19).setMaxHealth(40.0D);
            ((Skeleton)var19).setHealth(((Skeleton)var19).getMaxHealth());
            var21 = new ItemStack(Material.GOLDEN_HELMET);
            var22 = new ItemStack(Material.GOLDEN_CHESTPLATE);
            var9 = new ItemStack(Material.GOLDEN_LEGGINGS);
            var10 = new ItemStack(Material.GOLDEN_BOOTS);
            var11 = new ItemStack(Material.CROSSBOW, 1);
            var23 = var11.getItemMeta();
            var23.addEnchant(Enchantment.DAMAGE_ALL, 20, true);
            var11.setItemMeta(var23);
            var20.getEquipment().setHelmet(var21);
            var20.getEquipment().setChestplate(var22);
            var20.getEquipment().setLeggings(var9);
            var20.getEquipment().setBoots(var10);
            var20.getEquipment().setItemInMainHand(var11);
            ((Skeleton)var19).getEquipment().setItemInMainHandDropChance(0.0F);
            ((Skeleton)var19).getEquipment().setItemInOffHandDropChance(0.0F);
            var1.getEntity().setPassenger(var20);
         }

         if (var2 == 5) {
            var17 = Main.a.h;
            var18 = var1.getLocation();
            var19 = var17.spawnEntity(var18, EntityType.WITHER_SKELETON);
            var20 = (LivingEntity)var19;
            ((Skeleton)var19).setMaxHealth(40.0D);
            ((Skeleton)var19).setHealth(((Skeleton)var19).getMaxHealth());
            var21 = new ItemStack(Material.LEATHER_HELMET);
            var22 = new ItemStack(Material.LEATHER_CHESTPLATE);
            var9 = new ItemStack(Material.LEATHER_LEGGINGS);
            var10 = new ItemStack(Material.LEATHER_BOOTS);
            var11 = new ItemStack(Material.BOW, 1);
            var24 = (LeatherArmorMeta)var21.getItemMeta();
            var25 = (LeatherArmorMeta)var22.getItemMeta();
            var14 = (LeatherArmorMeta)var9.getItemMeta();
            var15 = (LeatherArmorMeta)var10.getItemMeta();
            var16 = var11.getItemMeta();
            var16.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
            var24.setColor(Color.fromRGB(16711680));
            var25.setColor(Color.fromRGB(16711680));
            var14.setColor(Color.fromRGB(16711680));
            var15.setColor(Color.fromRGB(16711680));
            var21.setItemMeta(var24);
            var22.setItemMeta(var25);
            var9.setItemMeta(var14);
            var10.setItemMeta(var15);
            var11.setItemMeta(var16);
            var20.getEquipment().setHelmet(var21);
            var20.getEquipment().setChestplate(var22);
            var20.getEquipment().setLeggings(var9);
            var20.getEquipment().setBoots(var10);
            var20.getEquipment().setItemInMainHand(var11);
            ((Skeleton)var19).getEquipment().setItemInMainHandDropChance(0.0F);
            ((Skeleton)var19).getEquipment().setItemInOffHandDropChance(0.0F);
            var1.getEntity().setPassenger(var20);
         }
      }

      if (this.a.o() >= 30L && this.a.o() < 50L && var1.getSpawnReason() != SpawnReason.CUSTOM && (var1.getEntity() instanceof Spider || var1.getEntity() instanceof CaveSpider || var1.getEntity().getType() == EntityType.SKELETON)) {
         if (var2 == 1) {
            var17 = Main.a.h;
            var18 = var1.getLocation();
            var19 = Main.a.f().a("Skeleton", EntityType.SKELETON, var18, SpawnReason.CUSTOM);
            var20 = (LivingEntity)var19;
            this.a(var19, 40.0D);
            ((Skeleton)var19).setHealth(40.0D);
            var21 = (new com.permadeathcore.j.c.d(Material.DIAMOND_HELMET)).a(Enchantment.PROTECTION_ENVIRONMENTAL, 4).a();
            var22 = (new com.permadeathcore.j.c.d(Material.DIAMOND_CHESTPLATE)).a(Enchantment.PROTECTION_ENVIRONMENTAL, 4).a();
            var9 = (new com.permadeathcore.j.c.d(Material.DIAMOND_LEGGINGS)).a(Enchantment.PROTECTION_ENVIRONMENTAL, 4).a();
            var10 = (new com.permadeathcore.j.c.d(Material.DIAMOND_BOOTS)).a(Enchantment.PROTECTION_ENVIRONMENTAL, 4).a();
            var11 = new ItemStack(Material.BOW, 1);
            var20.getEquipment().setHelmet(var21);
            var20.getEquipment().setChestplate(var22);
            var20.getEquipment().setLeggings(var9);
            var20.getEquipment().setBoots(var10);
            var20.getEquipment().setItemInMainHand(var11);
            ((Skeleton)var19).getEquipment().setItemInMainHandDropChance(0.0F);
            ((Skeleton)var19).getEquipment().setItemInOffHandDropChance(0.0F);
            var20.getEquipment().setItemInOffHand(this.a());
            ((Skeleton)var19).getEquipment().setItemInOffHandDropChance(0.0F);
            if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
               var1.getEntity().remove();
            } else {
               var1.getEntity().setPassenger(var20);
            }
         }

         if (var2 == 2) {
            var17 = Main.a.h;
            var18 = var1.getLocation();
            var19 = Main.a.f().a("Skeleton", EntityType.SKELETON, var18, SpawnReason.CUSTOM);
            this.a(var19, 40.0D);
            ((Skeleton)var19).setHealth(40.0D);
            var20 = (LivingEntity)var19;
            var21 = (new com.permadeathcore.j.c.d(Material.CHAINMAIL_HELMET)).a();
            var22 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            var9 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            var10 = new ItemStack(Material.CHAINMAIL_BOOTS);
            var11 = new ItemStack(Material.BOW, 1);
            var23 = var11.getItemMeta();
            var23.addEnchant(Enchantment.ARROW_DAMAGE, 25, true);
            var23.addEnchant(Enchantment.ARROW_KNOCKBACK, 30, true);
            var11.setItemMeta(var23);
            var20.getEquipment().setHelmet(var21);
            var20.getEquipment().setChestplate(var22);
            var20.getEquipment().setLeggings(var9);
            var20.getEquipment().setBoots(var10);
            var20.getEquipment().setItemInMainHand(var11);
            var20.getEquipment().setItemInMainHandDropChance(0.0F);
            var20.getEquipment().setItemInOffHand(this.a());
            if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
               var1.getEntity().remove();
            } else {
               var1.getEntity().setPassenger(var20);
            }
         }

         if (var2 == 3) {
            var17 = Main.a.h;
            var18 = var1.getLocation();
            var19 = Main.a.f().a("Skeleton", EntityType.SKELETON, var18, SpawnReason.CUSTOM);
            var20 = (LivingEntity)var19;
            this.a(var20, 40.0D);
            ((Skeleton)var19).setHealth(40.0D);
            var21 = new ItemStack(Material.IRON_HELMET);
            var22 = new ItemStack(Material.IRON_CHESTPLATE);
            var9 = new ItemStack(Material.IRON_LEGGINGS);
            var10 = new ItemStack(Material.IRON_BOOTS);
            var11 = new ItemStack(Material.IRON_AXE, 1);
            var23 = var11.getItemMeta();
            var23.addEnchant(Enchantment.FIRE_ASPECT, 10, true);
            var11.setItemMeta(var23);
            var20.getEquipment().setHelmet(var21);
            var20.getEquipment().setChestplate(var22);
            var20.getEquipment().setLeggings(var9);
            var20.getEquipment().setBoots(var10);
            var20.getEquipment().setItemInMainHand(var11);
            var20.getEquipment().setItemInMainHandDropChance(0.0F);
            var20.getEquipment().setItemInOffHand(this.a());
            if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
               var1.getEntity().remove();
            } else {
               var1.getEntity().setPassenger(var20);
            }
         }

         if (var2 == 4) {
            var17 = Main.a.h;
            var18 = var1.getLocation();
            var19 = Main.a.f().a("Skeleton", EntityType.SKELETON, var18, SpawnReason.CUSTOM);
            var20 = (LivingEntity)var19;
            this.a(var20, 40.0D);
            ((Skeleton)var19).setHealth(40.0D);
            ((Skeleton)var19).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
            var21 = new ItemStack(Material.GOLDEN_HELMET);
            var22 = new ItemStack(Material.GOLDEN_CHESTPLATE);
            var9 = new ItemStack(Material.GOLDEN_LEGGINGS);
            var10 = new ItemStack(Material.GOLDEN_BOOTS);
            var11 = new ItemStack(Material.CROSSBOW, 1);
            var23 = var11.getItemMeta();
            var23.addEnchant(Enchantment.DAMAGE_ALL, 25, true);
            var11.setItemMeta(var23);
            var20.getEquipment().setHelmet(var21);
            var20.getEquipment().setChestplate(var22);
            var20.getEquipment().setLeggings(var9);
            var20.getEquipment().setBoots(var10);
            var20.getEquipment().setItemInMainHand(var11);
            var20.getEquipment().setItemInMainHandDropChance(0.0F);
            var20.getEquipment().setItemInOffHand(this.a());
            var20.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
            if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
               var1.getEntity().remove();
            } else {
               var1.getEntity().setPassenger(var20);
            }
         }

         if (var2 == 5) {
            var17 = Main.a.h;
            var18 = var1.getLocation();
            var19 = Main.a.f().a("SkeletonWither", EntityType.WITHER_SKELETON, var18, SpawnReason.CUSTOM);
            var20 = (LivingEntity)var19;
            this.a(var19, 40.0D);
            ((Skeleton)var19).setHealth(40.0D);
            var21 = new ItemStack(Material.LEATHER_HELMET);
            var22 = new ItemStack(Material.LEATHER_CHESTPLATE);
            var9 = new ItemStack(Material.LEATHER_LEGGINGS);
            var10 = new ItemStack(Material.LEATHER_BOOTS);
            var11 = new ItemStack(Material.BOW, 1);
            var24 = (LeatherArmorMeta)var21.getItemMeta();
            var25 = (LeatherArmorMeta)var22.getItemMeta();
            var14 = (LeatherArmorMeta)var9.getItemMeta();
            var15 = (LeatherArmorMeta)var10.getItemMeta();
            var16 = var11.getItemMeta();
            var16.addEnchant(Enchantment.ARROW_DAMAGE, 50, true);
            var24.setColor(Color.fromRGB(16711680));
            var25.setColor(Color.fromRGB(16711680));
            var14.setColor(Color.fromRGB(16711680));
            var15.setColor(Color.fromRGB(16711680));
            var21.setItemMeta(var24);
            var22.setItemMeta(var25);
            var9.setItemMeta(var14);
            var10.setItemMeta(var15);
            var11.setItemMeta(var16);
            var20.getEquipment().setHelmet(var21);
            var20.getEquipment().setChestplate(var22);
            var20.getEquipment().setLeggings(var9);
            var20.getEquipment().setBoots(var10);
            var20.getEquipment().setItemInMainHand(var11);
            var20.getEquipment().setItemInMainHandDropChance(0.0F);
            var20.getEquipment().setItemInOffHand(this.a());
            if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
               var1.getEntity().remove();
            } else {
               var1.getEntity().setPassenger(var20);
            }
         }
      }

      if (this.a.o() >= 50L && var1.getSpawnReason() != SpawnReason.CUSTOM && (var1.getEntity() instanceof Spider || var1.getEntity() instanceof CaveSpider || var1.getEntity().getType() == EntityType.SKELETON)) {
         if (var2 == 1) {
            var17 = Main.a.h;
            var18 = var1.getLocation();
            var19 = Main.a.f().a("Skeleton", EntityType.SKELETON, var18, SpawnReason.CUSTOM);
            var20 = (LivingEntity)var19;
            this.a(var19, 100.0D);
            ((Skeleton)var19).setHealth(100.0D);
            var21 = (new com.permadeathcore.j.c.d(Material.DIAMOND_HELMET)).a(Enchantment.PROTECTION_ENVIRONMENTAL, 4).a();
            var22 = (new com.permadeathcore.j.c.d(Material.DIAMOND_CHESTPLATE)).a(Enchantment.PROTECTION_ENVIRONMENTAL, 4).a();
            var9 = (new com.permadeathcore.j.c.d(Material.DIAMOND_LEGGINGS)).a(Enchantment.PROTECTION_ENVIRONMENTAL, 4).a();
            var10 = (new com.permadeathcore.j.c.d(Material.DIAMOND_BOOTS)).a(Enchantment.PROTECTION_ENVIRONMENTAL, 4).a();
            var11 = new ItemStack(Material.BOW, 1);
            var20.getEquipment().setHelmet(var21);
            var20.getEquipment().setChestplate(var22);
            var20.getEquipment().setLeggings(var9);
            var20.getEquipment().setBoots(var10);
            var20.getEquipment().setItemInMainHand(var11);
            ((Skeleton)var19).getEquipment().setItemInMainHandDropChance(0.0F);
            ((Skeleton)var19).getEquipment().setItemInOffHandDropChance(0.0F);
            var20.getEquipment().setItemInOffHand(this.a());
            if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
               var1.getEntity().remove();
            } else {
               var1.getEntity().setPassenger(var20);
            }
         }

         if (var2 == 2) {
            var17 = Main.a.h;
            var18 = var1.getLocation();
            var19 = Main.a.f().a("Skeleton", EntityType.SKELETON, var18, SpawnReason.CUSTOM);
            this.a(var19, 40.0D);
            ((Skeleton)var19).setHealth(40.0D);
            var20 = (LivingEntity)var19;
            var21 = (new com.permadeathcore.j.c.d(Material.CHAINMAIL_HELMET)).a();
            var22 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            var9 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            var10 = new ItemStack(Material.CHAINMAIL_BOOTS);
            var11 = new ItemStack(Material.BOW, 1);
            var23 = var11.getItemMeta();
            var23.addEnchant(Enchantment.ARROW_DAMAGE, 40, true);
            var23.addEnchant(Enchantment.ARROW_KNOCKBACK, 50, true);
            var11.setItemMeta(var23);
            var20.getEquipment().setHelmet(var21);
            var20.getEquipment().setChestplate(var22);
            var20.getEquipment().setLeggings(var9);
            var20.getEquipment().setBoots(var10);
            var20.getEquipment().setItemInMainHand(var11);
            var20.getEquipment().setItemInMainHandDropChance(0.0F);
            var20.getEquipment().setItemInOffHand(this.a());
            if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
               var1.getEntity().remove();
            } else {
               var1.getEntity().setPassenger(var20);
            }
         }

         if (var2 == 3) {
            var17 = Main.a.h;
            var18 = var1.getLocation();
            var19 = Main.a.f().a("Skeleton", EntityType.SKELETON, var18, SpawnReason.CUSTOM);
            var20 = (LivingEntity)var19;
            this.a(var20, 40.0D);
            ((Skeleton)var19).setHealth(40.0D);
            ((Skeleton)var19).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
            var21 = new ItemStack(Material.IRON_HELMET);
            var22 = new ItemStack(Material.IRON_CHESTPLATE);
            var9 = new ItemStack(Material.IRON_LEGGINGS);
            var10 = new ItemStack(Material.IRON_BOOTS);
            var11 = new ItemStack(Material.DIAMOND_AXE, 1);
            var23 = var11.getItemMeta();
            var23.addEnchant(Enchantment.FIRE_ASPECT, 20, true);
            var23.addEnchant(Enchantment.DAMAGE_ALL, 25, true);
            var11.setItemMeta(var23);
            var20.getEquipment().setHelmet(var21);
            var20.getEquipment().setChestplate(var22);
            var20.getEquipment().setLeggings(var9);
            var20.getEquipment().setBoots(var10);
            var20.getEquipment().setItemInMainHand(var11);
            var20.getEquipment().setItemInMainHandDropChance(0.0F);
            var20.getEquipment().setItemInOffHand(this.a());
            if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
               var1.getEntity().remove();
            } else {
               var1.getEntity().setPassenger(var20);
            }
         }

         if (var2 == 4) {
            var17 = Main.a.h;
            var18 = var1.getLocation();
            var19 = Main.a.f().a("Skeleton", EntityType.SKELETON, var18, SpawnReason.CUSTOM);
            var20 = (LivingEntity)var19;
            this.a(var20, 40.0D);
            ((Skeleton)var19).setHealth(40.0D);
            var21 = new ItemStack(Material.GOLDEN_HELMET);
            var22 = new ItemStack(Material.GOLDEN_CHESTPLATE);
            var9 = new ItemStack(Material.GOLDEN_LEGGINGS);
            var10 = new ItemStack(Material.GOLDEN_BOOTS);
            var11 = new ItemStack(Material.CROSSBOW, 1);
            var23 = var11.getItemMeta();
            var23.addEnchant(Enchantment.DAMAGE_ALL, 50, true);
            var11.setItemMeta(var23);
            var20.getEquipment().setHelmet(var21);
            var20.getEquipment().setChestplate(var22);
            var20.getEquipment().setLeggings(var9);
            var20.getEquipment().setBoots(var10);
            var20.getEquipment().setItemInMainHand(var11);
            var20.getEquipment().setItemInMainHandDropChance(0.0F);
            var20.getEquipment().setItemInOffHand(this.a());
            var20.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
            if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
               var1.getEntity().remove();
            } else {
               var1.getEntity().setPassenger(var20);
            }
         }

         if (var2 == 5) {
            var17 = Main.a.h;
            var18 = var1.getLocation();
            var19 = Main.a.f().a("Skeleton", EntityType.SKELETON, var18, SpawnReason.CUSTOM);
            var20 = (LivingEntity)var19;
            this.a(var19, 40.0D);
            ((Skeleton)var19).setHealth(40.0D);
            var21 = new ItemStack(Material.LEATHER_HELMET);
            var22 = new ItemStack(Material.LEATHER_CHESTPLATE);
            var9 = new ItemStack(Material.LEATHER_LEGGINGS);
            var10 = new ItemStack(Material.LEATHER_BOOTS);
            var11 = new ItemStack(Material.BOW, 1);
            var24 = (LeatherArmorMeta)var21.getItemMeta();
            var25 = (LeatherArmorMeta)var22.getItemMeta();
            var14 = (LeatherArmorMeta)var9.getItemMeta();
            var15 = (LeatherArmorMeta)var10.getItemMeta();
            var16 = var11.getItemMeta();
            var16.addEnchant(Enchantment.ARROW_DAMAGE, 60, true);
            var24.setColor(Color.fromRGB(16711680));
            var25.setColor(Color.fromRGB(16711680));
            var14.setColor(Color.fromRGB(16711680));
            var15.setColor(Color.fromRGB(16711680));
            var21.setItemMeta(var24);
            var22.setItemMeta(var25);
            var9.setItemMeta(var14);
            var10.setItemMeta(var15);
            var11.setItemMeta(var16);
            var20.getEquipment().setHelmet(var21);
            var20.getEquipment().setChestplate(var22);
            var20.getEquipment().setLeggings(var9);
            var20.getEquipment().setBoots(var10);
            var20.getEquipment().setItemInMainHand(var11);
            var20.getEquipment().setItemInMainHandDropChance(0.0F);
            var20.getEquipment().setItemInOffHand(this.a());
            if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
               var1.getEntity().remove();
            } else {
               var1.getEntity().setPassenger(var20);
            }
         }
      }

      if (this.a.o() >= 60L && var1.getSpawnReason() != SpawnReason.CUSTOM && (var1.getEntity() instanceof Spider || var1.getEntity() instanceof CaveSpider || var1.getEntity().getType() == EntityType.SKELETON)) {
         var2 = ThreadLocalRandom.current().nextInt(1, 8);
         Main var10001;
         if ((new SplittableRandom()).nextInt(100) + 1 != 1) {
            if (var2 == 1) {
               var17 = Main.a.h;
               var18 = var1.getLocation();
               var19 = Main.a.f().a("Skeleton", EntityType.SKELETON, var18, SpawnReason.CUSTOM);
               var20 = (LivingEntity)var19;
               this.a(var19, 100.0D);
               ((Skeleton)var19).setHealth(100.0D);
               var21 = (new com.permadeathcore.j.c.d(Material.DIAMOND_HELMET)).a(Enchantment.PROTECTION_ENVIRONMENTAL, 4).a();
               var22 = (new com.permadeathcore.j.c.d(Material.DIAMOND_CHESTPLATE)).a(Enchantment.PROTECTION_ENVIRONMENTAL, 4).a();
               var9 = (new com.permadeathcore.j.c.d(Material.DIAMOND_LEGGINGS)).a(Enchantment.PROTECTION_ENVIRONMENTAL, 4).a();
               var10 = (new com.permadeathcore.j.c.d(Material.DIAMOND_BOOTS)).a(Enchantment.PROTECTION_ENVIRONMENTAL, 4).a();
               var11 = (new com.permadeathcore.j.c.d(Material.BOW, 1)).a(Enchantment.ARROW_DAMAGE, 50).a();
               var20.getEquipment().setHelmet(var21);
               var20.getEquipment().setChestplate(var22);
               var20.getEquipment().setLeggings(var9);
               var20.getEquipment().setBoots(var10);
               var20.getEquipment().setItemInMainHand(var11);
               ((Skeleton)var19).getEquipment().setItemInMainHandDropChance(0.0F);
               ((Skeleton)var19).getEquipment().setItemInOffHandDropChance(0.0F);
               var20.getEquipment().setItemInOffHand(this.a());
               if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
                  var1.getEntity().remove();
               } else {
                  var1.getEntity().addPassenger(var20);
               }
            }

            if (var2 == 2) {
               var17 = Main.a.h;
               var18 = var1.getLocation();
               var19 = Main.a.f().a("Skeleton", EntityType.SKELETON, var18, SpawnReason.CUSTOM);
               this.a(var19, 40.0D);
               ((Skeleton)var19).setHealth(40.0D);
               var20 = (LivingEntity)var19;
               var21 = (new com.permadeathcore.j.c.d(Material.CHAINMAIL_HELMET)).a();
               var22 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
               var9 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
               var10 = new ItemStack(Material.CHAINMAIL_BOOTS);
               var11 = new ItemStack(Material.BOW, 1);
               var23 = var11.getItemMeta();
               var23.addEnchant(Enchantment.ARROW_DAMAGE, 110, true);
               var23.addEnchant(Enchantment.ARROW_KNOCKBACK, 50, true);
               var11.setItemMeta(var23);
               var20.getEquipment().setHelmet(var21);
               var20.getEquipment().setChestplate(var22);
               var20.getEquipment().setLeggings(var9);
               var20.getEquipment().setBoots(var10);
               var20.getEquipment().setItemInMainHand(var11);
               var20.getEquipment().setItemInMainHandDropChance(0.0F);
               var20.getEquipment().setItemInOffHand(this.a());
               if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
                  var1.getEntity().remove();
               } else {
                  var1.getEntity().addPassenger(var20);
               }
            }

            if (var2 == 3) {
               var17 = Main.a.h;
               var18 = var1.getLocation();
               var19 = Main.a.f().a("Skeleton", EntityType.SKELETON, var18, SpawnReason.CUSTOM);
               var20 = (LivingEntity)var19;
               this.a(var20, 40.0D);
               ((Skeleton)var19).setHealth(40.0D);
               ((Skeleton)var19).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
               var21 = new ItemStack(Material.IRON_HELMET);
               var22 = new ItemStack(Material.IRON_CHESTPLATE);
               var9 = new ItemStack(Material.IRON_LEGGINGS);
               var10 = new ItemStack(Material.IRON_BOOTS);
               var11 = new ItemStack(Material.DIAMOND_AXE, 1);
               var23 = var11.getItemMeta();
               var23.addEnchant(Enchantment.FIRE_ASPECT, 20, true);
               var23.addEnchant(Enchantment.DAMAGE_ALL, 100, true);
               var11.setItemMeta(var23);
               var20.getEquipment().setHelmet(var21);
               var20.getEquipment().setChestplate(var22);
               var20.getEquipment().setLeggings(var9);
               var20.getEquipment().setBoots(var10);
               var20.getEquipment().setItemInMainHand(var11);
               var20.getEquipment().setItemInMainHandDropChance(0.0F);
               var20.getEquipment().setItemInOffHand(this.a());
               if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
                  var1.getEntity().remove();
               } else {
                  var1.getEntity().setPassenger(var20);
               }
            }

            if (var2 == 4) {
               var17 = Main.a.h;
               var18 = var1.getLocation();
               var19 = Main.a.f().a("Skeleton", EntityType.SKELETON, var18, SpawnReason.CUSTOM);
               var20 = (LivingEntity)var19;
               this.a(var20, 40.0D);
               ((Skeleton)var19).setHealth(40.0D);
               var21 = new ItemStack(Material.GOLDEN_HELMET);
               var22 = new ItemStack(Material.GOLDEN_CHESTPLATE);
               var9 = new ItemStack(Material.GOLDEN_LEGGINGS);
               var10 = new ItemStack(Material.GOLDEN_BOOTS);
               var11 = new ItemStack(Material.CROSSBOW, 1);
               var23 = var11.getItemMeta();
               var23.addEnchant(Enchantment.DAMAGE_ALL, 100, true);
               var11.setItemMeta(var23);
               var20.getEquipment().setHelmet(var21);
               var20.getEquipment().setChestplate(var22);
               var20.getEquipment().setLeggings(var9);
               var20.getEquipment().setBoots(var10);
               var20.getEquipment().setItemInMainHand(var11);
               var20.getEquipment().setItemInMainHandDropChance(0.0F);
               var20.getEquipment().setItemInOffHand(this.a());
               var20.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
               if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
                  var1.getEntity().remove();
               } else {
                  var1.getEntity().setPassenger(var20);
               }
            }

            if (var2 == 5) {
               var17 = Main.a.h;
               var18 = var1.getLocation();
               var19 = Main.a.f().a("SkeletonWither", EntityType.WITHER_SKELETON, var18, SpawnReason.CUSTOM);
               var20 = (LivingEntity)var19;
               this.a(var19, 40.0D);
               ((Skeleton)var19).setHealth(40.0D);
               var21 = new ItemStack(Material.LEATHER_HELMET);
               var22 = new ItemStack(Material.LEATHER_CHESTPLATE);
               var9 = new ItemStack(Material.LEATHER_LEGGINGS);
               var10 = new ItemStack(Material.LEATHER_BOOTS);
               var11 = new ItemStack(Material.BOW, 1);
               var24 = (LeatherArmorMeta)var21.getItemMeta();
               var25 = (LeatherArmorMeta)var22.getItemMeta();
               var14 = (LeatherArmorMeta)var9.getItemMeta();
               var15 = (LeatherArmorMeta)var10.getItemMeta();
               var16 = var11.getItemMeta();
               var16.addEnchant(Enchantment.ARROW_DAMAGE, 150, true);
               var24.setColor(Color.fromRGB(16711680));
               var25.setColor(Color.fromRGB(16711680));
               var14.setColor(Color.fromRGB(16711680));
               var15.setColor(Color.fromRGB(16711680));
               var21.setItemMeta(var24);
               var22.setItemMeta(var25);
               var9.setItemMeta(var14);
               var10.setItemMeta(var15);
               var11.setItemMeta(var16);
               var20.getEquipment().setHelmet(var21);
               var20.getEquipment().setChestplate(var22);
               var20.getEquipment().setLeggings(var9);
               var20.getEquipment().setBoots(var10);
               var20.getEquipment().setItemInMainHand(var11);
               var20.getEquipment().setItemInMainHandDropChance(0.0F);
               var20.getEquipment().setItemInOffHand(this.a());
               if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
                  var1.getEntity().remove();
               } else {
                  var1.getEntity().setPassenger(var20);
               }
            }

            if (var2 == 6) {
               var17 = Main.a.h;
               var18 = var1.getLocation();
               var19 = Main.a.f().a("Skeleton", EntityType.SKELETON, var18, SpawnReason.CUSTOM);
               var20 = (LivingEntity)var19;
               this.a(var19, 40.0D);
               ((Skeleton)var19).setHealth(40.0D);
               var10001 = Main.a;
               var19.setCustomName(Main.a("&6Ultra Esqueleto Científico"));
               var21 = new ItemStack(Material.LEATHER_HELMET);
               var22 = new ItemStack(Material.LEATHER_CHESTPLATE);
               var9 = new ItemStack(Material.LEATHER_LEGGINGS);
               var10 = new ItemStack(Material.LEATHER_BOOTS);
               var11 = new ItemStack(Material.BOW, 1);
               var24 = (LeatherArmorMeta)var21.getItemMeta();
               var25 = (LeatherArmorMeta)var22.getItemMeta();
               var14 = (LeatherArmorMeta)var9.getItemMeta();
               var15 = (LeatherArmorMeta)var10.getItemMeta();
               var16 = var11.getItemMeta();
               var24.setColor(Color.GREEN);
               var25.setColor(Color.GREEN);
               var14.setColor(Color.GREEN);
               var15.setColor(Color.GREEN);
               var21.setItemMeta(var24);
               var22.setItemMeta(var25);
               var9.setItemMeta(var14);
               var10.setItemMeta(var15);
               var11.setItemMeta(var16);
               var20.getEquipment().setHelmet(var21);
               var20.getEquipment().setChestplate(var22);
               var20.getEquipment().setLeggings(var9);
               var20.getEquipment().setBoots(var10);
               var20.getEquipment().setItemInMainHand(var11);
               var20.getEquipment().setItemInOffHand(this.b());
               var20.getEquipment().setItemInMainHandDropChance(0.0F);
               var20.getEquipment().setItemInOffHandDropChance(0.0F);
               if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
                  var1.getEntity().remove();
               } else {
                  var1.getEntity().addPassenger(var20);
               }
            }

            if (var2 == 7) {
               var17 = Main.a.h;
               var18 = var1.getLocation();
               var19 = Main.a.f().a("Skeleton", EntityType.SKELETON, var18, SpawnReason.CUSTOM);
               var20 = (LivingEntity)var19;
               this.a(var19, 40.0D);
               ((Skeleton)var19).setHealth(40.0D);
               var10001 = Main.a;
               var19.setCustomName(Main.a("&6Ultra Esqueleto Demoníaco"));
               var21 = new ItemStack(Material.LEATHER_HELMET);
               var22 = new ItemStack(Material.LEATHER_CHESTPLATE);
               var9 = new ItemStack(Material.LEATHER_LEGGINGS);
               var10 = new ItemStack(Material.LEATHER_BOOTS);
               var11 = new ItemStack(Material.BOW, 1);
               var24 = (LeatherArmorMeta)var21.getItemMeta();
               var25 = (LeatherArmorMeta)var22.getItemMeta();
               var14 = (LeatherArmorMeta)var9.getItemMeta();
               var15 = (LeatherArmorMeta)var10.getItemMeta();
               var16 = var11.getItemMeta();
               var24.setColor(Color.BLUE);
               var25.setColor(Color.BLUE);
               var14.setColor(Color.BLUE);
               var15.setColor(Color.BLUE);
               var21.setItemMeta(var24);
               var22.setItemMeta(var25);
               var9.setItemMeta(var14);
               var10.setItemMeta(var15);
               var11.setItemMeta(var16);
               var20.getEquipment().setHelmet(var21);
               var20.getEquipment().setChestplate(var22);
               var20.getEquipment().setLeggings(var9);
               var20.getEquipment().setBoots(var10);
               var20.getEquipment().setItemInMainHand(var11);
               var20.getEquipment().setItemInMainHandDropChance(0.0F);
               var20.getEquipment().setItemInOffHand(this.a());
               var20.getPersistentDataContainer().set(new NamespacedKey(Main.a, "demon_skeleton"), PersistentDataType.BYTE, (byte)1);
               if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
                  var1.getEntity().remove();
               } else {
                  var1.getEntity().addPassenger(var20);
               }
            }
         } else {
            var17 = Main.a.h;
            var18 = var1.getLocation();
            var19 = Main.a.f().a("SkeletonWither", EntityType.WITHER_SKELETON, var18, SpawnReason.CUSTOM);
            var20 = (LivingEntity)var19;
            this.a(var19, 400.0D);
            ((Skeleton)var19).setHealth(400.0D);
            var10001 = Main.a;
            var19.setCustomName(Main.a("&6Ultra Esqueleto Definitivo"));
            var21 = new ItemStack(Material.BOW, 1);
            ItemMeta var26 = var21.getItemMeta();
            var26.addEnchant(Enchantment.ARROW_DAMAGE, 37625, true);
            var21.setItemMeta(var26);
            var20.getEquipment().setItemInMainHand(var21);
            var20.getEquipment().setItemInMainHandDropChance(0.0F);
            var20.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
            var20.setRemoveWhenFarAway(false);
            if (!(var1.getEntity() instanceof CaveSpider) && !(var1.getEntity() instanceof Spider)) {
               var1.setCancelled(true);
            } else {
               var1.getEntity().addPassenger(var20);
            }
         }
      }

   }

   @EventHandler
   public void a(ProjectileHitEvent var1) {
      if (var1.getEntity().getShooter() instanceof Skeleton) {
         Skeleton var2 = (Skeleton)var1.getEntity().getShooter();
         if (Main.a.o() >= 60L && var2.getPersistentDataContainer().has(new NamespacedKey(Main.a, "demon_skeleton"), PersistentDataType.BYTE)) {
            if (var1.getEntity() != null) {
               Entity var3 = var1.getHitEntity();
               var3.getWorld().createExplosion(var3.getLocation(), 3.0F, true, true, var2);
            } else if (var1.getHitBlock() != null) {
               var1.getEntity().getWorld().createExplosion(var1.getHitBlock().getLocation(), 3.0F, true, true, var2);
            }
         }

      }
   }

   public ItemStack a() {
      ItemStack var1 = new ItemStack(Material.TIPPED_ARROW);
      PotionMeta var2 = (PotionMeta)var1.getItemMeta();
      var2.setBasePotionData(new PotionData(PotionType.INSTANT_DAMAGE, false, true));
      var1.setItemMeta(var2);
      return var1;
   }

   public ItemStack b() {
      ItemStack var1 = new ItemStack(Material.TIPPED_ARROW);
      PotionMeta var2 = (PotionMeta)var1.getItemMeta();
      var2.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 3600, 2), false);
      var2.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, 3600, 0), false);
      var2.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, 3600, 0), false);
      var2.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 3600, 2), false);
      var1.setItemMeta(var2);
      return var1;
   }

   public ItemStack c() {
      ItemStack var1 = new ItemStack(Material.TIPPED_ARROW);
      PotionMeta var2 = (PotionMeta)var1.getItemMeta();
      var2.setBasePotionData(new PotionData(PotionType.JUMP, false, false));
      var2.clearCustomEffects();
      if (var2.hasCustomEffect(PotionEffectType.JUMP)) {
         var2.removeCustomEffect(PotionEffectType.JUMP);
      }

      var1.setItemMeta(var2);
      return var1;
   }

   private Double a(LivingEntity var1) {
      return Main.a.n().a((Entity)var1);
   }

   private void a(Entity var1, Double var2) {
      Main.a.n().a(var1, var2, false);
   }
}
