package com.permadeathcore.j.c;

import java.nio.charset.Charset;
import org.bukkit.ChatColor;

public class b {
   private static final String a;
   private static final String b;

   public static String a(String var0) {
      return d(f(var0));
   }

   public static boolean b(String var0) {
      if (var0 == null) {
         return false;
      } else {
         return var0.indexOf(a) > -1 && var0.indexOf(b) > -1;
      }
   }

   public static String c(String var0) {
      return g(e(var0));
   }

   public static String a(String var0, String var1) {
      if (var0 == null) {
         return null;
      } else {
         int var2 = var0.indexOf(a);
         int var3 = var0.indexOf(b);
         return var2 >= 0 && var3 >= 0 ? var0.substring(0, var2 + a.length()) + f(var1) + var0.substring(var3, var0.length()) : null;
      }
   }

   private static String d(String var0) {
      return var0 == null ? null : a + var0 + b;
   }

   private static String e(String var0) {
      if (var0 == null) {
         return null;
      } else {
         int var1 = var0.indexOf(a);
         int var2 = var0.indexOf(b);
         return var1 >= 0 && var2 >= 0 ? var0.substring(var1 + a.length(), var2) : null;
      }
   }

   private static String f(String var0) {
      if (var0 == null) {
         return null;
      } else {
         byte[] var1 = var0.getBytes(Charset.forName("UTF-8"));
         char[] var2 = new char[var1.length * 4];

         for(int var3 = 0; var3 < var1.length; ++var3) {
            char[] var4 = a(var1[var3]);
            var2[var3 * 4] = 167;
            var2[var3 * 4 + 1] = var4[0];
            var2[var3 * 4 + 2] = 167;
            var2[var3 * 4 + 3] = var4[1];
         }

         return new String(var2);
      }
   }

   private static String g(String var0) {
      if (var0 == null) {
         return null;
      } else {
         var0 = var0.toLowerCase().replace("§", "");
         if (var0.length() % 2 != 0) {
            var0 = var0.substring(0, var0.length() / 2 * 2);
         }

         char[] var1 = var0.toCharArray();
         byte[] var2 = new byte[var1.length / 2];

         for(int var3 = 0; var3 < var1.length; var3 += 2) {
            var2[var3 / 2] = a(var1[var3], var1[var3 + 1]);
         }

         return new String(var2, Charset.forName("UTF-8"));
      }
   }

   private static int a(char var0) {
      if (var0 >= '0' && var0 <= '9') {
         return var0 - 48;
      } else if (var0 >= 'a' && var0 <= 'f') {
         return var0 - 87;
      } else {
         throw new IllegalArgumentException("Invalid hex char: out of range");
      }
   }

   private static char a(int var0) {
      if (var0 >= 0 && var0 <= 9) {
         return (char)(var0 + 48);
      } else if (var0 >= 10 && var0 <= 15) {
         return (char)(var0 + 87);
      } else {
         throw new IllegalArgumentException("Invalid hex int: out of range");
      }
   }

   private static byte a(char var0, char var1) {
      return (byte)((a(var0) << 4 | a(var1)) + -128);
   }

   private static char[] a(byte var0) {
      int var1 = var0 - -128;
      return new char[]{a(var1 >> 4 & 15), a(var1 & 15)};
   }

   static {
      a = "" + ChatColor.RESET + ChatColor.UNDERLINE + ChatColor.RESET;
      b = "" + ChatColor.RESET + ChatColor.ITALIC + ChatColor.RESET;
   }
}
