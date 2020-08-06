package com.permadeathcore.e;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.util.Vector;

class e implements Runnable {
   // $FF: synthetic field
   final Vector a;
   // $FF: synthetic field
   final Player b;
   // $FF: synthetic field
   final Vector c;
   // $FF: synthetic field
   final c d;

   e(c var1, Vector var2, Player var3, Vector var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public void run() {
      Location var1 = com.permadeathcore.e.c.a(this.d).j().c();
      var1.setDirection(this.a);
      this.b.teleport(var1, TeleportCause.PLUGIN);
      this.b.setVelocity(this.c);
   }
}
