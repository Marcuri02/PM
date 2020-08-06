package com.permadeathcore.b;

import java.util.Iterator;
import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

class d extends BukkitRunnable {
   // $FF: synthetic field
   final List a;
   // $FF: synthetic field
   final a b;

   d(a var1, List var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      Iterator var1 = this.a.iterator();

      while(var1.hasNext()) {
         Block var2 = (Block)var1.next();
         var2.getState().update();
         this.cancel();
      }

   }
}
