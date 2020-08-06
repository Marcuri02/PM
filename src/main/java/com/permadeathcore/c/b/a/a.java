package com.permadeathcore.c.b.a;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;

public class a {
   private EntityType a;
   private String b;
   private boolean c;
   private boolean d;
   private Double e = 10.0D;
   private ArrayList f = new ArrayList();
   private Entity g;

   public a(EntityType var1) {
      this.a = var1;
      this.c = false;
      this.b = null;
      this.d = false;
   }

   public a a(Double var1) {
      this.e = var1;
      this.d = true;
      return this;
   }

   public a a(String var1) {
      this.b = var1;
      this.c = true;
      return this;
   }

   public EntityType a() {
      return this.a;
   }

   public boolean b() {
      return this.c;
   }

   public String c() {
      return this.b;
   }

   public a a(String var1, Object var2) {
      try {
         Field var3 = this.a.getEntityClass().getDeclaredField(var1);
         var3.setAccessible(true);
         var3.set(this.g, var2);
      } catch (NoSuchFieldException | IllegalAccessException var5) {
      }

      return this;
   }

   public a a(PotionEffect var1) {
      this.f.add(var1);
      return this;
   }

   public a a(Location var1) {
      if (var1 == null) {
         return null;
      } else {
         this.g = var1.getWorld().spawnEntity(var1, this.a);
         if (this.g instanceof LivingEntity && this.d) {
            ((LivingEntity)this.g).setHealth(this.e);
         }

         if (this.c) {
            this.g.setCustomName(this.b);
         }

         if (!this.f.isEmpty() && this.g instanceof LivingEntity) {
            Iterator var2 = this.f.iterator();

            while(var2.hasNext()) {
               PotionEffect var3 = (PotionEffect)var2.next();
               ((LivingEntity)this.g).addPotionEffect(var3);
            }
         }

         return this;
      }
   }
}
