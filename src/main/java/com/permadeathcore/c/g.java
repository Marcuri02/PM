package com.permadeathcore.c;

import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

class g implements Runnable {
   // $FF: synthetic field
   final WeatherChangeEvent a;
   // $FF: synthetic field
   final b b;

   g(b var1, WeatherChangeEvent var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      Iterator var1 = Bukkit.getWorlds().iterator();

      while(var1.hasNext()) {
         World var2 = (World)var1.next();
         if (this.a.getWorld().getName().endsWith("end") || this.a.getWorld().getName().endsWith("beginning")) {
            return;
         }

         Iterator var3 = var2.getEntities().iterator();

         while(var3.hasNext()) {
            Entity var4 = (Entity)var3.next();
            if (var4 instanceof LivingEntity && com.permadeathcore.c.b.a(this.b, var4.getType())) {
               LivingEntity var5 = (LivingEntity)var4;
               var5.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
               var5.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 1));
               var5.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
            }
         }
      }

      System.out.println("[PermadeathCore] Se han otorgado los efectos de poción debido al Death Train");
   }
}
