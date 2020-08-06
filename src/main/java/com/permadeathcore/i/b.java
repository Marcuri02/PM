package com.permadeathcore.i;

import org.bukkit.event.player.PlayerTeleportEvent;

class b implements Runnable {
   // $FF: synthetic field
   final PlayerTeleportEvent a;
   // $FF: synthetic field
   final a b;

   b(a var1, PlayerTeleportEvent var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      this.a.getPlayer().teleport(com.permadeathcore.i.a.a(this.b).getSpawnLocation());
   }
}
