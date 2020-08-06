package com.permadeathcore.g;

import java.lang.reflect.Method;
import org.bukkit.Bukkit;
import org.bukkit.Server;

public class d {
   private static String a = "org.bukkit.craftbukkit";
   private static String b = "net.minecraft.server";
   private static boolean c = false;

   public static boolean a() {
      return c;
   }

   public static f a(String... var0) {
      String[] var1 = var0;
      int var2 = var0.length;
      int var3 = 0;

      while(var3 < var2) {
         String var4 = var1[var3];

         try {
            var4 = var4.replace("{cb}", a).replace("{nms}", b).replace("{nm}", "net.minecraft");
            return a(Class.forName(var4));
         } catch (ClassNotFoundException var6) {
            ++var3;
         }
      }

      throw new RuntimeException("no class found");
   }

   public static f a(Class var0) {
      return new f(var0, (e)null);
   }

   static {
      if (Bukkit.getServer() != null) {
         if (Bukkit.getVersion().contains("MCPC") || Bukkit.getVersion().contains("Forge")) {
            c = true;
         }

         Server var0 = Bukkit.getServer();
         Class var1 = var0.getClass();
         String[] var2 = var1.getName().split("\\.");
         if (var2.length == 5) {
            String var3 = var2[3];
            a = a + "." + var3;
         }

         try {
            Method var8 = var1.getDeclaredMethod("getHandle");
            Object var4 = var8.invoke(var0);
            Class var5 = var4.getClass();
            var2 = var5.getName().split("\\.");
            if (var2.length == 5) {
               String var6 = var2[3];
               b = b + "." + var6;
            }
         } catch (Exception var7) {
         }
      }

   }
}
