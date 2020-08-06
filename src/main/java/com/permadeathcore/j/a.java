package com.permadeathcore.j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.util.Vector;

public class a implements Cloneable, Iterable, ConfigurationSerializable {
   protected String a;
   protected final Vector b;
   protected final Vector c;

   public a(a var1) {
      this(var1.a, var1.b.getX(), var1.b.getY(), var1.b.getZ(), var1.c.getX(), var1.c.getY(), var1.c.getZ());
   }

   public a(Location var1) {
      this(var1, var1);
   }

   public a(Location var1, Location var2) {
      if (var1 != null && var2 != null) {
         if (var1.getWorld() != null && var2.getWorld() != null) {
            if (!var1.getWorld().getUID().equals(var2.getWorld().getUID())) {
               throw new IllegalStateException("Ambos lugares deben encontrarse en el mismo mundo");
            } else {
               this.a = var1.getWorld().getName();
               double var3 = Math.min(var1.getX(), var2.getX());
               double var5 = Math.min(var1.getY(), var2.getY());
               double var7 = Math.min(var1.getZ(), var2.getZ());
               double var9 = Math.max(var1.getX(), var2.getX());
               double var11 = Math.max(var1.getY(), var2.getY());
               double var13 = Math.max(var1.getZ(), var2.getZ());
               this.b = new Vector(var3, var5, var7);
               this.c = new Vector(var9, var11, var13);
            }
         } else {
            throw new NullPointerException("Uno o ambos mundos es/son nulo(s)");
         }
      } else {
         throw new NullPointerException("Una o ambas localizaciones son nulas.");
      }
   }

   public a(String var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      if (var1 != null && Bukkit.getServer().getWorld(var1) != null) {
         this.a = var1;
         double var14 = Math.min(var2, var8);
         double var16 = Math.max(var2, var8);
         double var18 = Math.min(var4, var10);
         double var20 = Math.max(var4, var10);
         double var22 = Math.min(var6, var12);
         double var24 = Math.max(var6, var12);
         this.b = new Vector(var14, var18, var22);
         this.c = new Vector(var16, var20, var24);
      } else {
         throw new NullPointerException("Uno o ambos mundos son nulos");
      }
   }

   public boolean a(Location var1) {
      return var1 != null && var1.getWorld().getName().equals(this.a) && var1.toVector().isInAABB(this.b, this.c);
   }

   public boolean a(Vector var1) {
      return var1 != null && var1.isInAABB(this.b, this.c);
   }

   public List a() {
      ArrayList var1 = new ArrayList();
      World var2 = this.k();
      if (var2 != null) {
         for(int var3 = this.b.getBlockX(); var3 <= this.c.getBlockX(); ++var3) {
            for(int var4 = this.b.getBlockY(); var4 <= this.c.getBlockY() && var4 <= var2.getMaxHeight(); ++var4) {
               for(int var5 = this.b.getBlockZ(); var5 <= this.c.getBlockZ(); ++var5) {
                  var1.add(var2.getBlockAt(var3, var4, var5));
               }
            }
         }
      }

      return var1;
   }

   public Location b() {
      return this.b.toLocation(this.k());
   }

   public double c() {
      return this.b.getX();
   }

   public double d() {
      return this.b.getY();
   }

   public double e() {
      return this.b.getZ();
   }

   public Location f() {
      return this.c.toLocation(this.k());
   }

   public double g() {
      return this.c.getX();
   }

   public double h() {
      return this.c.getY();
   }

   public double i() {
      return this.c.getZ();
   }

   public double j() {
      return (this.g() - this.c() + 1.0D) * (this.h() - this.d() + 1.0D) * (this.i() - this.e() + 1.0D);
   }

   public World k() {
      World var1 = Bukkit.getServer().getWorld(this.a);
      if (var1 == null) {
         throw new NullPointerException("El mundo '" + this.a + "' no ha sido cargado.");
      } else {
         return var1;
      }
   }

   public void a(World var1) {
      if (var1 != null) {
         this.a = var1.getName();
      } else {
         throw new NullPointerException("El mundo no puede ser nulo..");
      }
   }

   public a l() {
      return new a(this);
   }

   public ListIterator m() {
      return this.a().listIterator();
   }

   public Map serialize() {
      HashMap var1 = new HashMap();
      var1.put("worldName", this.a);
      var1.put("x1", this.b.getX());
      var1.put("x2", this.c.getX());
      var1.put("y1", this.b.getY());
      var1.put("y2", this.c.getY());
      var1.put("z1", this.b.getZ());
      var1.put("z2", this.c.getZ());
      return var1;
   }

   public static a a(Map var0) {
      try {
         String var1 = (String)var0.get("worldName");
         double var2 = (Double)var0.get("x1");
         double var4 = (Double)var0.get("x2");
         double var6 = (Double)var0.get("y1");
         double var8 = (Double)var0.get("y2");
         double var10 = (Double)var0.get("z1");
         double var12 = (Double)var0.get("z2");
         return new a(var1, var2, var6, var10, var4, var8, var12);
      } catch (Exception var14) {
         var14.printStackTrace();
         return null;
      }
   }

   // $FF: synthetic method
   public Object clone() throws CloneNotSupportedException {
      return this.l();
   }

   // $FF: synthetic method
   public Iterator iterator() {
      return this.m();
   }
}
