package com.permadeathcore;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

class k implements Runnable {
   // $FF: synthetic field
   final Player a;
   // $FF: synthetic field
   final boolean b;
   // $FF: synthetic field
   final a c;

   k(a var1, Player var2, boolean var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void run() {
      this.a.spigot().respawn();
      if (!this.b) {
         if (Main.a.getConfig().getBoolean("ban-enabled") && !this.a.hasPermission("permadeathcore.banoverride")) {
            this.a.setGameMode(GameMode.SPECTATOR);
         } else {
            this.a.setGameMode(GameMode.SURVIVAL);
         }
      } else if (Main.a.getConfig().getBoolean("ban-enabled")) {
         this.a.setGameMode(GameMode.SPECTATOR);
      } else {
         this.a.setGameMode(GameMode.SURVIVAL);
      }

   }
}
