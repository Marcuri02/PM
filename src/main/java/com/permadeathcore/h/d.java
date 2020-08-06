package com.permadeathcore.h;

import com.permadeathcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class d extends BukkitRunnable {
   private Main a;
   private com.permadeathcore.d.b b;

   public d(Main var1) {
      this.a = var1;
      this.b = var1.u();
   }

   public void run() {
      if (!this.b.b()) {
         this.cancel();
      } else {
         if (this.b.b()) {
            if (this.b.c() > 0) {
               this.b.a(this.b.c() - 1);
               int var1 = this.b.c();
               int var2 = var1 / 3600;
               int var3 = var1 % 3600;
               int var4 = var3 / 60;
               int var5 = var3 % 60;
               String var6 = (var2 > 9 ? var2 : "0" + var2) + "h " + (var4 > 9 ? var4 : "0" + var4) + "min " + (var5 > 9 ? var5 : "0" + var5) + "seg";
               Main var10001 = this.a;
               this.b.a(Main.a("&e&lX2 Shulker Shells: &b&n" + var6));
            } else {
               Main var10000 = this.a;
               Bukkit.broadcastMessage(Main.a(this.a.g + "&eEl evento de &c&lX2 Shulker Shells &eha acabado."));
               this.b.a(false);
               this.b.a();
               this.b.a(14400);
               this.cancel();
            }
         }

      }
   }
}
