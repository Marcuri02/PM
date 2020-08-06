package com.permadeathcore.g;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class f {
   private final Class a;

   public Class a() {
      return this.a;
   }

   private f(Class var1) {
      this.a = var1;
   }

   public boolean a(Object var1) {
      return this.a.isInstance(var1);
   }

   public j a(String var1, Object... var2) {
      try {
         Class[] var3 = new Class[var2.length];
         int var4 = 0;
         Object[] var5 = var2;
         int var6 = var2.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            Object var8 = var5[var7];
            if (var8 instanceof Class) {
               var3[var4++] = (Class)var8;
            } else if (var8 instanceof f) {
               var3[var4++] = ((f)var8).a();
            } else {
               var3[var4++] = var8.getClass();
            }
         }

         try {
            return new j(this.a.getMethod(var1, var3), (e)null);
         } catch (NoSuchMethodException var9) {
            return new j(this.a.getDeclaredMethod(var1, var3), (e)null);
         }
      } catch (Exception var10) {
         throw new RuntimeException(var10);
      }
   }

   public g a(Object... var1) {
      try {
         Class[] var2 = new Class[var1.length];
         int var3 = 0;
         Object[] var4 = var1;
         int var5 = var1.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            Object var7 = var4[var6];
            if (var7 instanceof Class) {
               var2[var3++] = (Class)var7;
            } else if (var7 instanceof f) {
               var2[var3++] = ((f)var7).a();
            } else {
               var2[var3++] = var7.getClass();
            }
         }

         try {
            return new g(this.a.getConstructor(var2), (e)null);
         } catch (NoSuchMethodException var8) {
            return new g(this.a.getDeclaredConstructor(var2), (e)null);
         }
      } catch (Exception var9) {
         throw new RuntimeException(var9);
      }
   }

   public j b(Object... var1) {
      Class[] var2 = new Class[var1.length];
      int var3 = 0;
      Object[] var4 = var1;
      int var5 = var1.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Object var7 = var4[var6];
         if (var7 instanceof Class) {
            var2[var3++] = (Class)var7;
         } else if (var7 instanceof f) {
            var2[var3++] = ((f)var7).a();
         } else {
            var2[var3++] = var7.getClass();
         }
      }

      ArrayList var9 = new ArrayList();
      Collections.addAll(var9, this.a.getMethods());
      Collections.addAll(var9, this.a.getDeclaredMethods());
      Iterator var10 = var9.iterator();

      while(var10.hasNext()) {
         Method var11 = (Method)var10.next();
         Class[] var12 = var11.getParameterTypes();
         if (var12.length == var2.length) {
            byte var8 = 0;
            if (var8 < var2.length && var2.equals(var12)) {
               return new j(var11, (e)null);
            }
         }
      }

      throw new RuntimeException("no such method");
   }

   public j a(String... var1) {
      ArrayList var2 = new ArrayList();
      Collections.addAll(var2, this.a.getMethods());
      Collections.addAll(var2, this.a.getDeclaredMethods());
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Method var4 = (Method)var3.next();
         String[] var5 = var1;
         int var6 = var1.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            String var8 = var5[var7];
            if (var4.getName().equals(var8)) {
               return new j(var4, (e)null);
            }
         }
      }

      throw new RuntimeException("no such method");
   }

   public j a(f var1) {
      return this.a(var1.a);
   }

   public j a(Class var1) {
      if (var1 == null) {
         var1 = Void.TYPE;
      }

      ArrayList var2 = new ArrayList();
      Collections.addAll(var2, this.a.getMethods());
      Collections.addAll(var2, this.a.getDeclaredMethods());
      Iterator var3 = var2.iterator();

      Method var4;
      do {
         if (!var3.hasNext()) {
            throw new RuntimeException("no such method");
         }

         var4 = (Method)var3.next();
      } while(!var1.equals(var4.getReturnType()));

      return new j(var4, (e)null);
   }

   public g a(int var1) {
      ArrayList var2 = new ArrayList();
      Collections.addAll(var2, this.a.getConstructors());
      Collections.addAll(var2, this.a.getDeclaredConstructors());
      Iterator var3 = var2.iterator();

      Constructor var4;
      do {
         if (!var3.hasNext()) {
            throw new RuntimeException("no such constructor");
         }

         var4 = (Constructor)var3.next();
      } while(var4.getParameterTypes().length != var1);

      return new g(var4, (e)null);
   }

   public h a(String var1) {
      try {
         try {
            return new h(this.a.getField(var1), (e)null);
         } catch (NoSuchFieldException var3) {
            return new h(this.a.getDeclaredField(var1), (e)null);
         }
      } catch (Exception var4) {
         throw new RuntimeException(var4);
      }
   }

   public h b(f var1) {
      return this.b(var1.a);
   }

   public h b(Class var1) {
      if (var1 == null) {
         var1 = Void.TYPE;
      }

      ArrayList var2 = new ArrayList();
      Collections.addAll(var2, this.a.getFields());
      Collections.addAll(var2, this.a.getDeclaredFields());
      Iterator var3 = var2.iterator();

      Field var4;
      do {
         if (!var3.hasNext()) {
            throw new RuntimeException("no such field");
         }

         var4 = (Field)var3.next();
      } while(!var1.equals(var4.getType()));

      return new h(var4, (e)null);
   }

   // $FF: synthetic method
   f(Class var1, e var2) {
      this(var1);
   }
}
