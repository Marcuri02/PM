package com.permadeathcore.i.b.a;

import io.netty.util.internal.ConcurrentSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class c extends BlockPopulator {
   private static Set a = new ConcurrentSet();
   private static Set b = new ConcurrentSet();

   public void populate(World var1, Random var2, Chunk var3) {
      int var4 = var3.getX();
      int var5 = var3.getZ();
      e var6 = new e(this, var4, var5);
      if (!a.contains(var6)) {
         a.add(var6);
         b.add(var6);
      }

      Iterator var7 = b.iterator();

      while(var7.hasNext()) {
         e var8 = (e)var7.next();
         if (a.contains(var8.a()) && a.contains(var8.b()) && a.contains(var8.c()) && a.contains(var8.d()) && a.contains(var8.e()) && a.contains(var8.f()) && a.contains(var8.g()) && a.contains(var8.h())) {
            this.a(var1, var2, var1.getChunkAt(var8.a, var8.b));
            b.remove(var8);
         }
      }

   }

   private void a(World var1, Random var2, Chunk var3) {
      int var4 = var2.nextInt(16);
      int var5 = var2.nextInt(16);

      int var6;
      for(var6 = var1.getMaxHeight() - 1; var6 > 0 && var3.getBlock(var4, var6, var5).getType() == Material.AIR; --var6) {
      }

      if (var6 > 0 && var6 < 255 && var6 >= 100 && var6 < 105) {
         var1.generateTree(var3.getBlock(var4, var6 + 1, var5).getLocation(), TreeType.CHORUS_PLANT, new d(this, var1));
      }

   }
}
