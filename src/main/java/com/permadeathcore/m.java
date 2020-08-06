package com.permadeathcore;

import java.util.Date;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.BanList.Type;
import org.bukkit.entity.Player;

class m implements Runnable {
   // $FF: synthetic field
   final Player a;
   // $FF: synthetic field
   final a b;

   m(a var1, Player var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      this.a.setGameMode(GameMode.SURVIVAL);
      this.a.kickPlayer(ChatColor.RED + "Has sido PERMABANEADO");
      Bukkit.getBanList(Type.NAME).addBan(this.a.getName(), ChatColor.RED + "Has sido PERMABANEADO", (Date)null, "console");
   }
}
