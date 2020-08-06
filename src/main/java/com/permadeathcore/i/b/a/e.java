package com.permadeathcore.i.b.a;

class e {
   public final int a;
   public final int b;
   // $FF: synthetic field
   final c c;

   public e(c var1, int var2, int var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public e a() {
      return new e(this.c, this.a - 1, this.b);
   }

   public e b() {
      return new e(this.c, this.a + 1, this.b);
   }

   public e c() {
      return new e(this.c, this.a, this.b - 1);
   }

   public e d() {
      return new e(this.c, this.a, this.b + 1);
   }

   public e e() {
      return new e(this.c, this.a - 1, this.b - 1);
   }

   public e f() {
      return new e(this.c, this.a + 1, this.b - 1);
   }

   public e g() {
      return new e(this.c, this.a - 1, this.b + 1);
   }

   public e h() {
      return new e(this.c, this.a + 1, this.b + 1);
   }

   public int hashCode() {
      return (this.a + this.b) * (this.a + this.b + 1) / 2 + this.a;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 == null) {
         return false;
      } else if (this.getClass() != var1.getClass()) {
         return false;
      } else {
         e var2 = (e)var1;
         if (this.a != var2.a) {
            return false;
         } else {
            return this.b == var2.b;
         }
      }
   }
}
