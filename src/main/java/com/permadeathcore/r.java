package com.permadeathcore;

import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;

class r implements Runnable {
   // $FF: synthetic field
   final Main a;

   r(Main var1) {
      this.a = var1;
   }

   public void run() {
      if (!Main.i(this.a)) {
         Main.c(this.a, true);
      }

      Iterator var1 = Bukkit.getOnlinePlayers().iterator();

      while(var1.hasNext()) {
         Player var2 = (Player)var1.next();
         Bukkit.broadcastMessage(Main.a(this.a.g + "&e¡Se ha spawneado un Wither Boss!"));
         var2.getWorld().spawn(var2.getLocation(), Wither.class);
      }

   }
}
