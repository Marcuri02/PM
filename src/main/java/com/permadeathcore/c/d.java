package com.permadeathcore.c;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pig;

class d implements Runnable {
   // $FF: synthetic field
   final Pig a;
   // $FF: synthetic field
   final LivingEntity b;
   // $FF: synthetic field
   final b c;

   d(b var1, Pig var2, LivingEntity var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void run() {
      this.a.setSaddle(true);
      this.b.teleport(this.a.getLocation());
      this.a.addPassenger(this.b);
   }
}
