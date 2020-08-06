package com.permadeathcore.i.a;

import net.minecraft.server.v1_16_R1.BlockPosition;
import net.minecraft.server.v1_16_R1.NBTTagCompound;
import net.minecraft.server.v1_16_R1.NBTTagList;
import net.minecraft.server.v1_16_R1.TileEntityMobSpawner;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.event.block.BlockBreakEvent;

public class f implements a {
   public Location a(Block var1, BlockFace var2) {
      // $FF: Couldn't be decompiled
   }

   public void a(Location var1) {
      Block var2 = var1.getBlock();
      var2.setType(Material.SPAWNER);
      BlockPosition var3 = new BlockPosition(var1.getBlockX(), var1.getBlockY(), var1.getBlockZ());
      TileEntityMobSpawner var4 = (TileEntityMobSpawner)((CraftWorld)var1.getWorld()).getHandle().getTileEntity(var3);
      NBTTagCompound var5 = var4.b();
      NBTTagCompound var6 = new NBTTagCompound();
      NBTTagList var7 = new NBTTagList();
      NBTTagCompound var8 = new NBTTagCompound();
      NBTTagCompound var9 = new NBTTagCompound();
      var5.setBoolean("InfernalNetherite", true);
      var9.setInt("Unbreakable", 1);
      var8.setString("id", "minecraft:structure_block");
      var8.setByte("Count", (byte)1);
      var8.set("tag", var9);
      var7.add(new NBTTagCompound());
      var7.add(new NBTTagCompound());
      var7.add(new NBTTagCompound());
      var7.add(var8);
      var6.set("ArmorItems", var7);
      var6.setString("id", "minecraft:armor_stand");
      var6.setByte("Marker", (byte)1);
      var6.setInt("Invisible", 1);
      var5.setShort("SpawnRange", (short)0);
      var5.setShort("SpawnCount", (short)0);
      var5.setShort("RequiredPlayerRange", (short)0);
      var5.setShort("MaxNearbyEntities", (short)0);
      var5.set("SpawnData", var6);
      var4.load(var4.getBlock(), var5);
      var1.getWorld().playSound(var1, Sound.BLOCK_STONE_BREAK, 1.0F, 1.0F);
   }

   public void a(BlockBreakEvent var1) {
      if (var1 != null) {
         if (!var1.isCancelled()) {
            if (this.b(var1.getBlock().getLocation())) {
               var1.setDropItems(false);
               var1.setExpToDrop(0);
               var1.getBlock().getWorld().dropItemNaturally(var1.getBlock().getLocation().add(0.0D, 0.5D, 0.0D), com.permadeathcore.j.c.a.j());
            }

         }
      }
   }

   public boolean b(Location var1) {
      if (var1 == null) {
         return false;
      } else {
         BlockPosition var2 = new BlockPosition(var1.getBlockX(), var1.getBlockY(), var1.getBlockZ());
         TileEntityMobSpawner var3 = (TileEntityMobSpawner)((CraftWorld)var1.getWorld()).getHandle().getTileEntity(var2);
         NBTTagCompound var4 = var3.b();
         boolean var5 = false;

         try {
            if (var4.getBoolean("InfernalNetherite")) {
               var5 = true;
            }
         } catch (Exception var7) {
         }

         return var5;
      }
   }
}
