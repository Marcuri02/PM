package com.permadeathcore;

import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

class e implements Runnable {
   // $FF: synthetic field
   final PlayerItemConsumeEvent a;
   // $FF: synthetic field
   final a b;

   e(a var1, PlayerItemConsumeEvent var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      this.a.getPlayer().removePotionEffect(PotionEffectType.POISON);
      this.a.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, Integer.MAX_VALUE, 0));
   }
}
