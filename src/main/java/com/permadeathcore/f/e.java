package com.permadeathcore.f;

import com.permadeathcore.Main;
import java.util.SplittableRandom;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class e {
   private Entity a;
   private EntityDamageEvent b;
   private World c;
   private Main d;
   private double e;
   private double f;
   private double g;
   private SplittableRandom h;

   public e(Entity var1, EntityDamageEvent var2) {
      this.a = var1;
      this.b = var2;
      this.c = var1.getWorld();
      this.d = Main.p();
      this.e = var1.getLocation().getX();
      this.f = var1.getLocation().getY();
      this.g = var1.getLocation().getZ();
      this.h = new SplittableRandom();
      if (var2.getCause() != DamageCause.ENTITY_ATTACK && var2.getCause() != DamageCause.FIRE && (this.d.d().a(var2.getEntity(), "ender_quantum_creeper") || this.d.d().a(var2.getEntity(), "ender_ghast") || this.d.d().a(var2.getEntity(), "tp_ghast"))) {
         var2.setCancelled(true);
      }

      this.a();
   }

   public boolean a() {
      int var1;
      if (this.d.d().a(this.b.getEntity(), "ender_quantum_creeper") && this.b.getCause() != DamageCause.ENTITY_ATTACK && this.b.getCause() != DamageCause.FIRE) {
         for(var1 = 0; var1 < 64; ++var1) {
            if (this.b()) {
               return true;
            }
         }
      }

      if (this.d.d().a(this.b.getEntity(), "ender_ghast") && this.b.getCause() != DamageCause.ENTITY_ATTACK && this.b.getCause() != DamageCause.FIRE && this.h.nextInt(100) + 1 <= 20) {
         for(var1 = 0; var1 < 64; ++var1) {
            if (this.b()) {
               return true;
            }
         }
      }

      if (this.d.d().a(this.b.getEntity(), "tp_ghast") && this.b.getCause() != DamageCause.ENTITY_ATTACK && this.b.getCause() != DamageCause.FIRE && this.h.nextInt(100) + 1 <= 80) {
         for(var1 = 0; var1 < 64; ++var1) {
            if (this.b()) {
               return true;
            }
         }
      }

      return false;
   }

   private boolean b() {
      double var1 = this.e + (this.h.nextDouble() - 0.5D) * 64.0D;
      double var3 = this.f + (double)(this.h.nextInt(64) - 32);
      double var5 = this.g + (this.h.nextDouble() - 0.5D) * 64.0D;
      return this.a(var1, var3, var5);
   }

   private boolean a(double var1, double var3, double var5) {
      f var7 = new f(this, this.c.getBlockAt((int)var1, (int)var3, (int)var5));

      Block var8;
      for(var8 = var7.b(); var8.getY() > 0 && !var8.getType().isSolid(); var8 = var7.b()) {
         var7 = var7.a();
      }

      return var8.getY() == 0 ? false : this.a.teleport(new Location(this.c, var1, (double)(var8.getY() + 1), var5));
   }
}
