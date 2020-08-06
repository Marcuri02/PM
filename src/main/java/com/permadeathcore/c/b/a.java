package com.permadeathcore.c.b;

import com.permadeathcore.Main;
import java.util.ArrayList;
import java.util.Iterator;
import org.bukkit.entity.EntityType;

public class a {
   public ArrayList a = new ArrayList();
   private Main b;

   public a(Main var1) {
      this.b = var1;
   }

   public void a(com.permadeathcore.c.b.a.a var1) {
      this.a.add(var1);
   }

   public com.permadeathcore.c.b.a.a a(String var1) {
      if (this.a != null && !this.a.isEmpty()) {
         com.permadeathcore.c.b.a.a var2 = null;
         Iterator var3 = this.a.iterator();

         while(var3.hasNext()) {
            com.permadeathcore.c.b.a.a var4 = (com.permadeathcore.c.b.a.a)var3.next();
            if (var4.b() && var4.c().equalsIgnoreCase(var1)) {
               var2 = var4;
            }
         }

         return var2 != null ? var2 : null;
      } else {
         return null;
      }
   }

   public com.permadeathcore.c.b.a.a a(String var1, EntityType var2, Double var3) {
      boolean var4 = var3 != 0.0D;
      boolean var5 = var1 != null;
      com.permadeathcore.c.b.a.a var6 = new com.permadeathcore.c.b.a.a(var2);
      if (var4) {
         var6.a(var3);
      }

      if (var5) {
         var6.a(Main.a(var1));
      }

      return var6;
   }
}
