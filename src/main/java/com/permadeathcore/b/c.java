package com.permadeathcore.b;

import org.bukkit.Location;

class c implements Runnable {
   // $FF: synthetic field
   final Location a;
   // $FF: synthetic field
   final a b;

   c(a var1, Location var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      if (com.permadeathcore.b.a.b(this.b).contains(this.a)) {
         com.permadeathcore.b.a.b(this.b).remove(this.a);
      }

   }
}
