package com.permadeathcore.g;

public class k {
   Object a;
   // $FF: synthetic field
   final j b;

   public k(j var1, Object var2) {
      this.b = var1;
      this.a = var2;
   }

   public Object a(Object... var1) {
      try {
         return j.a(this.b).invoke(this.a, var1);
      } catch (Exception var3) {
         throw new RuntimeException(var3);
      }
   }
}
