package com.permadeathcore;

import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;

class d implements Runnable {
   // $FF: synthetic field
   final PlayerItemConsumeEvent a;
   // $FF: synthetic field
   final PotionEffect b;
   // $FF: synthetic field
   final a c;

   d(a var1, PlayerItemConsumeEvent var2, PotionEffect var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void run() {
      this.a.getPlayer().addPotionEffect(this.b);
   }
}
