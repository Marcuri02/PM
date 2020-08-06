package com.permadeathcore.g;

import java.lang.reflect.Constructor;

public class g {
   private final Constructor a;

   public Constructor a() {
      return this.a;
   }

   public f b() {
      return new f(this.a.getDeclaringClass(), (e)null);
   }

   private g(Constructor var1) {
      this.a = var1;
      var1.setAccessible(true);
   }

   public Object a(Object... var1) {
      try {
         return this.a.newInstance(var1);
      } catch (Exception var3) {
         throw new RuntimeException(var3);
      }
   }

   // $FF: synthetic method
   g(Constructor var1, e var2) {
      this(var1);
   }
}
