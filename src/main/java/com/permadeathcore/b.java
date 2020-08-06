package com.permadeathcore;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class b extends BukkitRunnable {
   // $FF: synthetic field
   final int a;
   // $FF: synthetic field
   final Location b;
   // $FF: synthetic field
   final int c;
   // $FF: synthetic field
   final int d;
   // $FF: synthetic field
   final Player e;
   // $FF: synthetic field
   final int f;
   // $FF: synthetic field
   final int g;
   // $FF: synthetic field
   final a h;

   b(a var1, int var2, Location var3, int var4, int var5, Player var6, int var7, int var8) {
      this.h = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var6;
      this.f = var7;
      this.g = var8;
   }

   public void run() {
      Block var1;
      BlockState var2;
      Skull var3;
      UUID var4;
      if (this.a > 0) {
         var1 = this.b.getWorld().getBlockAt(this.c, this.a, this.d);
         var1.setType(Material.PLAYER_HEAD);
         var2 = var1.getState();
         var3 = (Skull)var2;
         var4 = this.e.getUniqueId();
         var3.setOwningPlayer(Bukkit.getServer().getOfflinePlayer(var4));
         var3.update();
         this.b.getWorld().getBlockAt(this.c, this.f, this.d).setType(Material.BEDROCK);
         this.b.getWorld().getBlockAt(this.c, this.g, this.d).setType(Material.NETHER_BRICK_FENCE);
      } else {
         var1 = this.b.getWorld().getBlockAt(this.c, 10, this.d);
         var1.setType(Material.PLAYER_HEAD);
         var2 = var1.getState();
         var3 = (Skull)var2;
         var4 = this.e.getUniqueId();
         var3.setOwningPlayer(Bukkit.getServer().getOfflinePlayer(var4));
         var3.update();
         var1.getRelative(BlockFace.DOWN).setType(Material.NETHER_BRICK_FENCE);
         var1.getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).setType(Material.BEDROCK);
      }

   }
}
