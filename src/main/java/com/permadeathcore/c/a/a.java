package com.permadeathcore.c.a;

import com.permadeathcore.Main;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class a {
   private Main a;

   public a(Main var1) {
      this.a = var1;
   }

   public Creeper a(Location var1) {
      Creeper var2 = (Creeper)this.a.f().a(var1, SpawnReason.CUSTOM, true);
      var2.setPowered(true);
      var2.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));
      var2.setCustomName(this.a("&6Ender Creeper"));
      this.b(var2, "ender_creeper");
      return var2;
   }

   public Creeper b(Location var1) {
      Creeper var2 = (Creeper)this.a.f().a(var1, SpawnReason.CUSTOM, false);
      var2.setPowered(true);
      var2.setCustomName(this.a("&6Quantum Creeper"));
      this.b(var2, "quantum_creeper");
      return var2;
   }

   public Creeper c(Location var1) {
      Creeper var2 = (Creeper)this.a.f().a(var1, SpawnReason.CUSTOM, true);
      var2.setPowered(true);
      var2.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));
      var2.setCustomName(this.a("&6Ender Quantum Creeper"));
      this.b(var2, "ender_quantum_creeper");
      return var2;
   }

   public boolean a(Entity var1, String var2) {
      return var1.getPersistentDataContainer().has(new NamespacedKey(this.a, var2), PersistentDataType.BYTE);
   }

   public void b(Entity var1, String var2) {
      var1.getPersistentDataContainer().set(new NamespacedKey(this.a, var2), PersistentDataType.BYTE, (byte)1);
   }

   public String a(String var1) {
      Main var10000 = this.a;
      return Main.a(var1);
   }
}
