package com.permadeathcore.c;

import org.bukkit.entity.LivingEntity;

class c implements Runnable {
   // $FF: synthetic field
   final LivingEntity a;
   // $FF: synthetic field
   final LivingEntity b;
   // $FF: synthetic field
   final b c;

   c(b var1, LivingEntity var2, LivingEntity var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void run() {
      this.a.teleport(this.b.getLocation());
      this.b.addPassenger(this.a);
   }
}
