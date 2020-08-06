package com.permadeathcore;

import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

class j implements Runnable {
   // $FF: synthetic field
   final a a;

   j(a var1) {
      this.a = var1;
   }

   public void run() {
      this.a.a();
      if (com.permadeathcore.a.a(this.a).o() < 50L) {
         Iterator var1 = Bukkit.getOnlinePlayers().iterator();

         while(var1.hasNext()) {
            Player var2 = (Player)var1.next();
            String var3 = this.a.a("DeathTrainMessage", var2).replace("%tiempo%", String.valueOf(this.a.f));
            var2.sendMessage(var3);
            var2.playSound(var2.getLocation(), Sound.ENTITY_SKELETON_HORSE_DEATH, 10.0F, 1.0F);
         }

         this.a.b(this.a.a("DeathTrainMessage").replace("%tiempo%", String.valueOf(this.a.f)));
      } else {
         long var11 = this.a.e / 60L / 60L;
         long var12 = this.a.e / 60L % 60L;
         String var5 = String.valueOf(var11);
         String var6 = "DeathTrainMessage";
         if (var12 == 30L || var12 == 60L) {
            var6 = var6 + "Minutes";
            if (var11 >= 1L) {
               var5 = "" + var11 + " horas y " + var12;
            } else {
               var5 = String.valueOf(var12);
            }
         }

         if (var12 == 0L) {
            var5 = String.valueOf(var11);
         }

         String var7 = var5;
         Iterator var8 = Bukkit.getOnlinePlayers().iterator();

         while(var8.hasNext()) {
            Player var9 = (Player)var8.next();
            String var10 = this.a.a(var6, var9).replace("%tiempo%", var7);
            var9.sendMessage(var10);
            var9.playSound(var9.getLocation(), Sound.ENTITY_SKELETON_HORSE_DEATH, 10.0F, 1.0F);
         }

         this.a.b(this.a.a(var6).replace("%tiempo%", var7));
      }

   }
}
