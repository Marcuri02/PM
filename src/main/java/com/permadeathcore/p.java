package com.permadeathcore;

import org.bukkit.Location;
import org.bukkit.entity.PolarBear;

class p implements Runnable {
   // $FF: synthetic field
   final Location a;
   // $FF: synthetic field
   final PolarBear b;
   // $FF: synthetic field
   final a c;

   p(a var1, Location var2, PolarBear var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void run() {
      this.a.getWorld().createExplosion(this.a, 1.5F, true, false, this.b);
      this.b.remove();
   }
}
