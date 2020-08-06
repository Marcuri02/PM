package com.permadeathcore;

import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

class f implements Runnable {
   // $FF: synthetic field
   final PlayerItemConsumeEvent a;
   // $FF: synthetic field
   final a b;

   f(a var1, PlayerItemConsumeEvent var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      this.a.getPlayer().removePotionEffect(PotionEffectType.CONFUSION);
      this.a.getPlayer().removePotionEffect(PotionEffectType.POISON);
      this.a.getPlayer().removePotionEffect(PotionEffectType.HUNGER);
      this.a.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, Integer.MAX_VALUE, 3));
      this.a.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, Integer.MAX_VALUE, 2));
      this.a.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, Integer.MAX_VALUE, 1));
   }
}
