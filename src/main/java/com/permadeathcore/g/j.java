package com.permadeathcore.g;

import java.lang.reflect.Method;

public class j {
   private final Method a;

   public Method a() {
      return this.a;
   }

   public f b() {
      return new f(this.a.getDeclaringClass(), (e)null);
   }

   public f c() {
      return new f(this.a.getReturnType(), (e)null);
   }

   private j(Method var1) {
      this.a = var1;
      var1.setAccessible(true);
   }

   public k a(Object var1) {
      return new k(this, var1);
   }

   public Object a(Object... var1) {
      try {
         return this.a.invoke((Object)null, var1);
      } catch (Exception var3) {
         throw new RuntimeException(var3);
      }
   }

   // $FF: synthetic method
   j(Method var1, e var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Method a(j var0) {
      return var0.a;
   }
}
