package com.permadeathcore.g;

public class i {
   Object a;
   // $FF: synthetic field
   final h b;

   public i(h var1, Object var2) {
      this.b = var1;
      this.a = var2;
   }

   public void a(Object var1) {
      try {
         h.a(this.b).set(this.a, var1);
      } catch (Exception var3) {
         throw new RuntimeException(var3);
      }
   }

   public Object a() {
      try {
         return h.a(this.b).get(this.a);
      } catch (Exception var2) {
         throw new RuntimeException(var2);
      }
   }
}
