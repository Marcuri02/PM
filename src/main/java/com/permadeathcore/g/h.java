package com.permadeathcore.g;

import java.lang.reflect.Field;

public class h {
   private Field a;

   public Field a() {
      return this.a;
   }

   public f b() {
      return new f(this.a.getDeclaringClass(), (e)null);
   }

   public f c() {
      return new f(this.a.getType(), (e)null);
   }

   private h(Field var1) {
      this.a = var1;
      var1.setAccessible(true);
   }

   public i a(Object var1) {
      return new i(this, var1);
   }

   // $FF: synthetic method
   h(Field var1, e var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Field a(h var0) {
      return var0.a;
   }
}
