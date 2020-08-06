package com.permadeathcore;

import java.util.Iterator;
import org.bukkit.entity.Player;
import org.bukkit.event.raid.RaidFinishEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

class c implements Runnable {
   // $FF: synthetic field
   final RaidFinishEvent a;
   // $FF: synthetic field
   final a b;

   c(a var1, RaidFinishEvent var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      Iterator var1 = this.a.getWinners().iterator();

      while(var1.hasNext()) {
         Player var2 = (Player)var1.next();
         if (var2.hasPotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE)) {
            PotionEffect var3 = var2.getPotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE);
            var2.removePotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE);
            short var4 = 300;
            var2.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, var4, var3.getAmplifier()));
         }
      }

   }
}
