package com.permadeathcore.j.c;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class e extends d {
   private LeatherArmorMeta c;

   public e(ItemStack var1) {
      super(var1);
   }

   public e(Material var1, int var2) {
      super(var1, var2);
   }

   public e a(Color var1) {
      this.c = (LeatherArmorMeta)this.a.getItemMeta();
      this.c.setColor(var1);
      this.a.setItemMeta(this.c);
      return this;
   }
}
