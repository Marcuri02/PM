package com.permadeathcore.e;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.util.Vector;

class d implements Runnable {
   // $FF: synthetic field
   final Vector a;
   // $FF: synthetic field
   final Float b;
   // $FF: synthetic field
   final Float c;
   // $FF: synthetic field
   final Entity d;
   // $FF: synthetic field
   final Vector e;
   // $FF: synthetic field
   final c f;

   d(c var1, Vector var2, Float var3, Float var4, Entity var5, Vector var6) {
      this.f = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var6;
   }

   public void run() {
      Location var1 = com.permadeathcore.e.c.a(this.f).h.getSpawnLocation();
      var1.setDirection(this.a);
      var1.setPitch(this.b);
      var1.setYaw(this.c);
      this.d.teleport(var1, TeleportCause.PLUGIN);
      this.d.setVelocity(this.e);
   }
}
