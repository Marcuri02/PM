package com.permadeathcore.h;

import com.permadeathcore.Main;
import java.util.ArrayList;
import java.util.Iterator;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.EnderDragon.Phase;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class c extends BukkitRunnable {
   private float e;
   private Main f;
   private EnderDragon g;
   int a = 0;
   int b = -360;
   Location c;
   boolean d = false;

   public c(Main var1, EnderDragon var2, Location var3) {
      this.f = var1;
      this.g = var2;
      this.c = var3;
   }

   public void run() {
      if (!this.g.isDead() && this.f.l() != null) {
         short var1 = 300;
         if (this.a == var1) {
            this.cancel();
         } else {
            this.a += 5;
            if (this.b >= 0) {
               this.b = -360;
            }

            if (this.b < 0) {
               if (this.g.getPhase() != Phase.LAND_ON_PORTAL) {
                  this.g.setPhase(Phase.LAND_ON_PORTAL);
               }

               this.g.setRotation((float)this.b, 0.0F);
               this.b += 30;
               if (!this.d) {
                  this.d = true;
                  ArrayList var2 = new ArrayList();
                  var2.add(this.f.i.getHighestBlockAt(this.g.getLocation().add(7.0D, 0.0D, 7.0D)).getLocation());
                  var2.add(this.f.i.getHighestBlockAt(this.g.getLocation().add(7.0D, 0.0D, 0.0D)).getLocation());
                  var2.add(this.f.i.getHighestBlockAt(this.g.getLocation().add(7.0D, 0.0D, -7.0D)).getLocation());
                  var2.add(this.f.i.getHighestBlockAt(this.g.getLocation().add(0.0D, 0.0D, -7.0D)).getLocation());
                  var2.add(this.f.i.getHighestBlockAt(this.g.getLocation().add(0.0D, 0.0D, 7.0D)).getLocation());
                  var2.add(this.f.i.getHighestBlockAt(this.g.getLocation().add(-7.0D, 0.0D, 7.0D)).getLocation());
                  var2.add(this.f.i.getHighestBlockAt(this.g.getLocation().add(-7.0D, 0.0D, 0.0D)).getLocation());
                  var2.add(this.f.i.getHighestBlockAt(this.g.getLocation().add(-7.0D, 0.0D, -7.0D)).getLocation());
                  Iterator var3 = var2.iterator();

                  while(var3.hasNext()) {
                     Location var4 = (Location)var3.next();
                     AreaEffectCloud var5 = (AreaEffectCloud)var4.getWorld().spawnEntity(var4.add(0.0D, 1.0D, 0.0D), EntityType.AREA_EFFECT_CLOUD);
                     var5.setParticle(Particle.CLOUD);
                     var5.setRadius(5.0F);
                     var5.setDuration(300);
                     var5.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 5, 3), false);
                     var5.setColor(Color.WHITE);
                  }
               }
            }

         }
      } else {
         this.cancel();
      }
   }
}
