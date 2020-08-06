package com.permadeathcore.e;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

class b implements Runnable {
   // $FF: synthetic field
   final Entity a;
   // $FF: synthetic field
   final World b;
   // $FF: synthetic field
   final Location c;
   // $FF: synthetic field
   final a d;

   b(a var1, Entity var2, World var3, Location var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public void run() {
      if (com.permadeathcore.e.a.a(this.d).contains(this.a)) {
         float var1 = Float.valueOf((float)com.permadeathcore.e.a.b(this.d).getConfig().getInt("Toggles.Gatos-Supernova.Explosion-Power"));
         boolean var2 = com.permadeathcore.e.a.b(this.d).getConfig().getBoolean("Toggles.Gatos-Supernova.Destruir-Bloques");
         boolean var3 = com.permadeathcore.e.a.b(this.d).getConfig().getBoolean("Toggles.Gatos-Supernova.Fuego");
         this.b.createExplosion(this.c, var1, var3, var2, this.a);
         com.permadeathcore.e.a.a(this.d).remove(this.a);
         this.a.remove();
      }
   }
}
