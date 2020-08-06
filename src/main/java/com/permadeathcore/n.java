package com.permadeathcore;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerBedEnterEvent;

class n implements Runnable {
   // $FF: synthetic field
   final PlayerBedEnterEvent a;
   // $FF: synthetic field
   final Player b;
   // $FF: synthetic field
   final ArrayList c;
   // $FF: synthetic field
   final a d;

   n(a var1, PlayerBedEnterEvent var2, Player var3, ArrayList var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public void run() {
      this.a.getPlayer().getWorld().setTime(0L);
      this.b.setStatistic(Statistic.TIME_SINCE_REST, 0);
      if (!this.c.contains(this.b)) {
         Bukkit.getOnlinePlayers().forEach((var2) -> {
            String var3 = this.d.a("Sleep", var2).replace("%player%", var1.getName());
            var2.sendMessage(var3);
         });
         this.d.b(this.d.a("Sleep").replace("%player%", this.b.getName()));
         this.c.add(this.b);
         this.b.damage(0.1D);
      }

   }
}
