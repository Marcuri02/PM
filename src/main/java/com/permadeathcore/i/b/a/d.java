package com.permadeathcore.i.b.a;

import com.sun.istack.internal.NotNull;
import org.bukkit.BlockChangeDelegate;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;

class d implements BlockChangeDelegate {
   // $FF: synthetic field
   final World a;
   // $FF: synthetic field
   final c b;

   d(c var1, World var2) {
      this.b = var1;
      this.a = var2;
   }

   public boolean setBlockData(int var1, int var2, int var3, @NotNull BlockData var4) {
      if (var4.getMaterial() == Material.CHORUS_FLOWER) {
         this.a.getBlockAt(var1, var2, var3).setType(Material.SEA_LANTERN);
      } else if (var4.getMaterial() == Material.CHORUS_PLANT) {
         this.a.getBlockAt(var1, var2, var3).setType(Material.END_STONE_BRICK_WALL);
      }

      return true;
   }

   @NotNull
   public BlockData getBlockData(int var1, int var2, int var3) {
      return null;
   }

   public int getHeight() {
      return 255;
   }

   public boolean isEmpty(int var1, int var2, int var3) {
      return false;
   }
}
