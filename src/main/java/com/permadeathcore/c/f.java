package com.permadeathcore.c;

import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

class f implements Runnable {
   // $FF: synthetic field
   final b a;

   f(b var1) {
      this.a = var1;
   }

   public void run() {
      Iterator var1 = Bukkit.getWorlds().iterator();

      label52:
      while(var1.hasNext()) {
         World var2 = (World)var1.next();
         Iterator var3 = var2.getEntities().iterator();

         label50:
         while(true) {
            Entity var4;
            do {
               do {
                  if (!var3.hasNext()) {
                     continue label52;
                  }

                  var4 = (Entity)var3.next();
               } while(!(var4 instanceof LivingEntity));
            } while(!b.a(this.a, var4.getType()));

            LivingEntity var5 = (LivingEntity)var4;
            Iterator var6 = var5.getActivePotionEffects().iterator();

            while(true) {
               PotionEffect var7;
               do {
                  if (!var6.hasNext()) {
                     continue label50;
                  }

                  var7 = (PotionEffect)var6.next();
                  if (var7.getAmplifier() != 1) {
                     return;
                  }
               } while(var7.getType() != PotionEffectType.INCREASE_DAMAGE && var7.getType() != PotionEffectType.SPEED && var7.getType() != PotionEffectType.DAMAGE_RESISTANCE);

               var5.removePotionEffect(var7.getType());
            }
         }
      }

      System.out.println("[PermadeathCore] Se han eliminado todos los efectos de poción del Death Train");
   }
}
