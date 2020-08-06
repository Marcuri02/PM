package com.permadeathcore.g;

import org.bukkit.Bukkit;

public class l {
   public static String a() {
      String var0 = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3].substring(1);
      return var0;
   }

   public static String b() {
      String var0 = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3].substring(1);
      String var1 = "";
      if (var0.equalsIgnoreCase("1_16_R1")) {
         var1 = "1.16.x";
      }

      if (var0.equalsIgnoreCase("1_15_R1")) {
         var1 = "1.15.x";
      }

      if (var0.equalsIgnoreCase("1_14_R1")) {
         var1 = "1.14.x";
      }

      return var1;
   }

   public static boolean c() {
      return a().equalsIgnoreCase("1_16_R1");
   }

   public static boolean d() {
      return a().equalsIgnoreCase("1_15_R1");
   }

   public static boolean e() {
      return a().equalsIgnoreCase("1_14_R1");
   }
}
