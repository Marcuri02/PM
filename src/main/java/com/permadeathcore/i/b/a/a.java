package com.permadeathcore.i.b.a;

import com.permadeathcore.Main;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sun.istack.internal.NotNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.SplittableRandom;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.ChunkGenerator.BiomeGrid;
import org.bukkit.generator.ChunkGenerator.ChunkData;
import org.bukkit.util.noise.SimplexOctaveGenerator;

public class a extends ChunkGenerator {
   private static final int b = 100;
   private static final boolean c = Main.p().y();
   private final SplittableRandom d = new SplittableRandom();

   public ChunkData generateChunkData(World var1, Random var2, int var3, int var4, BiomeGrid var5) {
      SimplexOctaveGenerator var6 = new SimplexOctaveGenerator(new Random(var1.getSeed()), 8);
      ChunkData var7 = this.createChunkData(var1);
      var6.setScale(0.02D);

      for(int var8 = 0; var8 < 16; ++var8) {
         for(int var9 = 0; var9 < 16; ++var9) {
            int var10 = (int)(var6.noise((double)(var3 * 16 + var8), (double)(var4 * 16 + var9), 0.5D, 0.5D) * 15.0D);
            if (var10 <= 0) {
               if (c && var8 == 8 && var9 == 8 && this.d.nextInt(20) == 0) {
                  Bukkit.getScheduler().runTaskLater(Main.p(), () -> {
                     this.a(var1, var3 * 16 + var8, var4 * 16 + var9, this.d);
                  }, 20L);
               }
            } else {
               int var11 = Main.p().getConfig().getInt("Toggles.TheBeginning.YticGenerateChance");
               if (var11 > 1000000 || var11 < 1) {
                  var11 = 100000;
               }

               if (this.d.nextInt(var11) == 0) {
                  Bukkit.getScheduler().runTaskLater(Main.p(), () -> {
                     this.a(var1, var3 * 16 + var8, var4 * 16 + var9);
                  }, 20L);
               }

               int var12;
               for(var12 = 0; var12 < var10 / 3; ++var12) {
                  var7.setBlock(var8, var12 + 100, var9, Material.PURPUR_BLOCK);
               }

               for(var12 = 0; var12 < var10; ++var12) {
                  var7.setBlock(var8, 100 - var12 - 1, var9, Material.PURPUR_BLOCK);
               }
            }
         }
      }

      return var7;
   }

   private void a(World var1, int var2, int var3, SplittableRandom var4) {
      File var6;
      switch(var4.nextInt(6)) {
      case 0:
         var6 = new File(Main.p().getDataFolder(), "schematics/island1.schem");
         break;
      case 1:
         var6 = new File(Main.p().getDataFolder(), "schematics/island2.schem");
         break;
      case 2:
         var6 = new File(Main.p().getDataFolder(), "schematics/island3.schem");
         break;
      case 3:
         var6 = new File(Main.p().getDataFolder(), "schematics/island4.schem");
         break;
      default:
         var6 = new File(Main.p().getDataFolder(), "schematics/island5.schem");
      }

      ClipboardFormat var7 = ClipboardFormats.findByFile(var6);

      assert var7 != null;

      Clipboard var5;
      Throwable var9;
      try {
         ClipboardReader var8 = var7.getReader(new FileInputStream(var6));
         var9 = null;

         try {
            var5 = var8.read();
         } catch (Throwable var37) {
            var9 = var37;
            throw var37;
         } finally {
            if (var8 != null) {
               if (var9 != null) {
                  try {
                     var8.close();
                  } catch (Throwable var34) {
                     var9.addSuppressed(var34);
                  }
               } else {
                  var8.close();
               }
            }

         }
      } catch (IOException var39) {
         var39.printStackTrace();
         return;
      }

      try {
         EditSession var42 = WorldEdit.getInstance().getEditSessionFactory().getEditSession(new BukkitWorld(var1), -1);
         var9 = null;

         try {
            Operation var10 = (new ClipboardHolder(var5)).createPaste(var42).to(BlockVector3.at(var2, 120, var3)).ignoreAirBlocks(true).build();
            Operations.complete(var10);
         } catch (Throwable var36) {
            var9 = var36;
            throw var36;
         } finally {
            if (var42 != null) {
               if (var9 != null) {
                  try {
                     var42.close();
                  } catch (Throwable var35) {
                     var9.addSuppressed(var35);
                  }
               } else {
                  var42.close();
               }
            }

         }
      } catch (WorldEditException var41) {
         var41.printStackTrace();
      }

   }

   private void a(World var1, int var2, int var3) {
      File var5 = new File(Main.p().getDataFolder(), "schematics/ytic.schem");
      ClipboardFormat var6 = ClipboardFormats.findByFile(var5);

      assert var6 != null;

      Clipboard var4;
      Throwable var8;
      try {
         ClipboardReader var7 = var6.getReader(new FileInputStream(var5));
         var8 = null;

         try {
            var4 = var7.read();
         } catch (Throwable var36) {
            var8 = var36;
            throw var36;
         } finally {
            if (var7 != null) {
               if (var8 != null) {
                  try {
                     var7.close();
                  } catch (Throwable var33) {
                     var8.addSuppressed(var33);
                  }
               } else {
                  var7.close();
               }
            }

         }
      } catch (IOException var38) {
         var38.printStackTrace();
         return;
      }

      try {
         EditSession var41 = WorldEdit.getInstance().getEditSessionFactory().getEditSession(new BukkitWorld(var1), -1);
         var8 = null;

         try {
            ClipboardHolder var9 = new ClipboardHolder(var4);
            Operation var10 = var9.createPaste(var41).to(BlockVector3.at(var2, 134, var3)).ignoreAirBlocks(true).copyEntities(true).build();
            Operations.complete(var10);
         } catch (Throwable var35) {
            var8 = var35;
            throw var35;
         } finally {
            if (var41 != null) {
               if (var8 != null) {
                  try {
                     var41.close();
                  } catch (Throwable var34) {
                     var8.addSuppressed(var34);
                  }
               } else {
                  var41.close();
               }
            }

         }
      } catch (WorldEditException var40) {
         var40.printStackTrace();
      }

   }

   @NotNull
   public List getDefaultPopulators(World var1) {
      return Collections.singletonList(new c());
   }
}
