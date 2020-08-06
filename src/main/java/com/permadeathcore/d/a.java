package com.permadeathcore.d;

import com.permadeathcore.Main;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class a {
   private Main a;
   private boolean b;
   private int c;
   private BossBar d;
   private String e;

   public a(Main var1) {
      this.a = var1;
      this.c = 14400;
      this.e = Main.a("&6Tiempo para Life Orb: &b&n");
      this.d = Bukkit.createBossBar(this.e, BarColor.RED, BarStyle.SEGMENTED_6, new BarFlag[0]);
   }

   public void a(Player var1) {
      this.d.addPlayer(var1);
   }

   public void a() {
      Iterator var1 = this.d.getPlayers().iterator();

      while(var1.hasNext()) {
         Player var2 = (Player)var1.next();
         this.d.removePlayer(var2);
      }

   }

   public void a(String var1) {
      this.e = var1;
      this.d.setTitle(var1);
   }

   public boolean b() {
      return this.b;
   }

   public void a(boolean var1) {
      this.b = var1;
   }

   public int c() {
      return this.c;
   }

   public void a(int var1) {
      this.c = var1;
   }

   public void d() {
      --this.c;
   }

   public void b(Player var1) {
      if (!this.d.getPlayers().contains(var1)) {
         this.d.addPlayer(var1);
      }
   }
}
