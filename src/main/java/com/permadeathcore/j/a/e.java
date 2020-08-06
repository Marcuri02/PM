package com.permadeathcore.j.a;

import com.permadeathcore.Main;
import com.permadeathcore.g.l;

public class e {
   private Main a;

   public e(Main var1) {
      this.a = var1;
   }

   public Object a() {
      if (l.e()) {
         return (new com.permadeathcore.g.b.a()).a();
      } else if (l.d()) {
         return (new com.permadeathcore.g.b.b()).a();
      } else {
         return l.c() ? (new com.permadeathcore.g.b.c()).a() : null;
      }
   }

   public Object b() {
      if (l.e()) {
         return (new com.permadeathcore.g.b.a()).b();
      } else if (l.d()) {
         return (new com.permadeathcore.g.b.b()).b();
      } else {
         return l.c() ? (new com.permadeathcore.g.b.c()).b() : null;
      }
   }

   public Object c() {
      if (l.e()) {
         return (new com.permadeathcore.g.b.a()).c();
      } else if (l.d()) {
         return (new com.permadeathcore.g.b.b()).c();
      } else {
         return l.c() ? (new com.permadeathcore.g.b.c()).c() : null;
      }
   }
}
