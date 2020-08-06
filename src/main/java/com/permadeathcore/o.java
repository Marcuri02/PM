package com.permadeathcore;

import java.util.Iterator;
import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerBedEnterEvent;

class o implements Runnable {
   // $FF: synthetic field
   final PlayerBedEnterEvent a;
   // $FF: synthetic field
   final a b;

   o(a var1, PlayerBedEnterEvent var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      if (this.b.d.size() >= 4) {
         this.a.getPlayer().getWorld().setTime(0L);
         Iterator var1 = Bukkit.getOnlinePlayers().iterator();

         Main var10000;
         while(var1.hasNext()) {
            Player var2 = (Player)var1.next();
            if (var2.isSleeping()) {
               var2.setStatistic(Statistic.TIME_SINCE_REST, 0);
               var2.damage(0.1D);
               var10000 = Main.a;
               Bukkit.broadcastMessage(Main.a((String)Objects.requireNonNull(Main.a.getConfig().getString("Server-Messages.Sleep").replace("%player%", var2.getName()))));
            }
         }

         var10000 = Main.a;
         Bukkit.broadcastMessage(Main.a("&eHan dormido suficientes jugadores (&b4&e)."));
         this.b.d.clear();
      }

   }
}
