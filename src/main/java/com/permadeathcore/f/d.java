package com.permadeathcore.f;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

class d implements Runnable {
   // $FF: synthetic field
   final c a;

   d(c var1) {
      this.a = var1;
   }

   public void run() {
      Iterator var1 = c.a(this.a).i.getEntities().iterator();

      while(true) {
         Entity var2;
         do {
            if (!var1.hasNext()) {
               System.out.println("[INFO] Se han colocado ladrillos de END STONE por el Spawn del Mundo.");
               return;
            }

            var2 = (Entity)var1.next();
         } while(var2.getType() != EntityType.ENDERMAN && var2.getType() != EntityType.CREEPER);

         Block var3 = var2.getLocation().getBlock().getRelative(BlockFace.DOWN);
         int var4 = (new Random()).nextInt(4);
         ArrayList var5 = new ArrayList();
         if (var4 == 0) {
            var5.add(var3.getRelative(BlockFace.NORTH));
            var5.add(var3.getRelative(BlockFace.NORTH).getRelative(BlockFace.WEST));
            var5.add(var3.getRelative(BlockFace.SOUTH));
            var5.add(var3.getRelative(BlockFace.SOUTH_EAST));
            var5.add(var3.getRelative(BlockFace.SOUTH_WEST));
            var5.add(var3.getRelative(BlockFace.SOUTH_EAST).getRelative(BlockFace.SOUTH));
            var5.add(var3.getRelative(BlockFace.SOUTH_EAST).getRelative(BlockFace.NORTH));
            var5.add(var3.getRelative(BlockFace.NORTH).getRelative(BlockFace.NORTH));
         } else if (var4 == 1) {
            var5.add(var3.getRelative(BlockFace.NORTH));
            var5.add(var3.getRelative(BlockFace.NORTH_EAST));
            var5.add(var3);
         } else if (var4 == 2) {
            var5.add(var3.getRelative(BlockFace.SOUTH));
            var5.add(var3.getRelative(BlockFace.SOUTH_WEST));
            var5.add(var3);
         } else if (var4 == 3) {
            var5.add(var3.getRelative(BlockFace.NORTH));
            var5.add(var3.getRelative(BlockFace.NORTH_EAST));
            var5.add(var3);
            var5.add(var3.getRelative(BlockFace.SOUTH));
            var5.add(var3.getRelative(BlockFace.EAST));
         } else if (var4 == 4) {
            var5.add(var3.getRelative(BlockFace.SOUTH));
            var5.add(var3.getRelative(BlockFace.NORTH_WEST));
            var5.add(var3);
            var5.add(var3.getRelative(BlockFace.NORTH));
            var5.add(var3.getRelative(BlockFace.WEST));
         }

         Iterator var6 = var5.iterator();

         while(var6.hasNext()) {
            Block var7 = (Block)var6.next();
            Location var8 = c.a(this.a).i.getHighestBlockAt(new Location(c.a(this.a).i, (double)var7.getX(), (double)var7.getY(), (double)var7.getZ())).getLocation();
            Block var9 = c.a(this.a).i.getBlockAt(var8);
            if (var9.getType() == Material.END_STONE) {
               var9.setType(Material.END_STONE_BRICKS);
            }
         }
      }
   }
}
