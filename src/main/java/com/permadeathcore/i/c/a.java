package com.permadeathcore.i.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.SplittableRandom;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class a {
   private List a = new ArrayList();
   private List b;
   private List c;
   private com.permadeathcore.i.a d;
   private SplittableRandom e;

   public a(com.permadeathcore.i.a var1) {
      this.d = var1;

      for(int var2 = 0; var2 < 27; ++var2) {
         this.a.add(var2);
      }

      this.b = new ArrayList();
      this.c = new ArrayList();
      this.e = new SplittableRandom();
      this.a(this.b, Material.GOLD_INGOT, 5, 50, 60);
      this.a(this.b, Material.GOLDEN_APPLE, 60, 1, 8);
      this.a(this.b, Material.DIAMOND, 60, 16, 24);
      this.a(this.b, Material.ARROW, 10, 10, 16);
      this.a(this.b, Material.FIREWORK_ROCKET, 20, 55, 64);
      this.a(this.b, Material.TOTEM_OF_UNDYING, 5, 1, 2);
      this.a(this.b, Material.STRUCTURE_VOID, 1, 1, 1);
   }

   public void a(Chest var1) {
      World var2 = var1.getWorld();
      Inventory var3 = var1.getBlockInventory();
      if (var2.getName().equalsIgnoreCase("pdc_the_beginning")) {
         if (!var3.contains(Material.DIAMOND_PICKAXE)) {
            this.b(var1);
         }
      }
   }

   private List a(List var1, Material var2, int var3, int var4, int var5) {
      var1.add(var2.toString() + ";" + var3 + ";" + var4 + ";" + var5);
      return var1;
   }

   private void b(Chest var1) {
      int var2 = this.e.nextInt(3) + 1;
      boolean var3;
      switch(var2) {
      case 1:
         var3 = true;
      case 2:
         var3 = true;
      default:
         byte var5 = 3;

         for(int var4 = 0; var4 < var5; ++var4) {
            this.c(var1);
         }

      }
   }

   private void c(Chest var1) {
      Iterator var2 = this.b.iterator();

      while(true) {
         if (var2.hasNext()) {
            String[] var3 = String.valueOf(var2.next()).split(";");
            Inventory var4 = var1.getBlockInventory();
            byte var5 = 0;
            Collections.shuffle(this.a);
            SplittableRandom var6 = new SplittableRandom();
            if (var6.nextInt(100) + 1 > this.c(var3) || this.c.contains(this.d(var3))) {
               continue;
            }

            if (this.d(var3) == Material.TOTEM_OF_UNDYING || this.d(var3) == Material.STRUCTURE_VOID) {
               var4.setItem((Integer)this.a.get(var5), new ItemStack(this.d(var3)));
               return;
            }

            int var7 = this.a(this.a(var3), this.b(var3));
            ItemStack var8 = new ItemStack(this.d(var3), var7);
            int var9 = var7 + this.a(var3) / 2;
            ItemStack var10 = new ItemStack(var8.getType(), var9);
            var4.setItem((Integer)this.a.get(var5), var8);
            if (var5 + 5 <= var4.getSize() - 1) {
               var4.setItem((Integer)this.a.get(var5 + 5), var10);
            }

            byte var10000 = var5;
            int var11 = var5 + 1;
            if (var10000 < var4.getSize() - 1) {
               this.c.add(var8.getType());
               continue;
            }
         }

         return;
      }
   }

   private void a(Chest var1, String[] var2) {
      if (this.a(this.c(var2))) {
         int var3 = (int)(Math.random() * 5.0D);
         int var4 = this.a(this.a(var2), this.b(var2));
         int var5 = var4 / var3;
         int var6;
         if (this.d(var2) == Material.TOTEM_OF_UNDYING) {
            if (var4 == 1) {
               var1.getBlockInventory().addItem(new ItemStack[]{new ItemStack(Material.TOTEM_OF_UNDYING)});
            } else {
               for(var6 = 0; var6 < 1; ++var6) {
                  var1.getBlockInventory().addItem(new ItemStack[]{new ItemStack(Material.TOTEM_OF_UNDYING)});
               }
            }

            return;
         }

         if (this.d(var2) == Material.STRUCTURE_VOID) {
            var1.getBlockInventory().addItem(new ItemStack[]{new ItemStack(Material.STRUCTURE_VOID)});
            return;
         }

         for(var6 = 0; var6 < var3; ++var6) {
            if (this.a(var1.getBlockInventory())) {
               int var7 = var5;
               int var8 = (int)(Math.random() * 100.0D) + 1;
               if (var8 <= 25) {
                  var7 = var5 + 1;
               }

               if (var8 >= 26 && var8 <= 35) {
                  var7 += 2;
               }

               if (var8 >= 45 && var8 <= 60) {
                  var7 -= 2;
               }

               if (var7 > 0) {
                  Collections.shuffle(this.a);
                  boolean var9 = false;
                  int var10 = this.d(var1);
                  if (var1.getBlockInventory().getItem(var10) == null) {
                     var9 = true;
                  }

                  while(!var9 && this.a(var1.getBlockInventory())) {
                     var10 = this.d(var1);
                     if (var1.getBlockInventory().getItem(var10) == null) {
                        var9 = true;
                     }
                  }

                  var1.getBlockInventory().setItem(var10, new ItemStack(this.d(var2), var7));
               }
            }
         }
      }

   }

   private boolean a(Inventory var1) {
      boolean var2 = false;

      for(int var3 = 0; var3 < var1.getSize(); ++var3) {
         if (var1.getItem(var3) == null) {
            var2 = true;
         }
      }

      return var2;
   }

   private int d(Chest var1) {
      return (new SplittableRandom()).nextInt(var1.getBlockInventory().getSize() - 1) + 1;
   }

   private boolean a(int var1) {
      int var2 = (int)(Math.random() * 100.0D) + 1;
      return var2 <= var1;
   }

   private int a(String[] var1) {
      return Integer.valueOf(var1[2]);
   }

   private int b(String[] var1) {
      return Integer.valueOf(var1[3]);
   }

   private int c(String[] var1) {
      return Integer.valueOf(var1[1]);
   }

   private Material d(String[] var1) {
      return Material.valueOf(var1[0]);
   }

   private int a(int var1, int var2) {
      SplittableRandom var3 = new SplittableRandom();
      return var3.nextInt(var2 - var1) + var3.nextInt(var1) + 1;
   }
}
