package com.permadeathcore.c;

import com.permadeathcore.Main;
import org.bukkit.Location;

class e implements Runnable {
   // $FF: synthetic field
   final Location a;
   // $FF: synthetic field
   final b b;

   e(b var1, Location var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      Main.a.d().a(this.a);
   }
}
