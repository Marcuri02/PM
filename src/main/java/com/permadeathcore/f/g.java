package com.permadeathcore.f;

import com.permadeathcore.Main;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class g {
   private String a;
   private String b;
   private String c;
   private String d;
   private String e;
   private File f;
   private FileConfiguration g;
   private Main h;

   public g(String var1, Main var2) {
      this.a = var1;
      this.h = var2;
      this.f = new File(var2.getDataFolder(), "jugadores.yml");
      this.g = YamlConfiguration.loadConfiguration(this.f);
      if (!this.f.exists()) {
         try {
            this.f.createNewFile();
         } catch (IOException var4) {
            System.out.println("[ERROR] Ha ocurrido un error al crear el archivo 'jugadores.yml'");
         }
      }

      if (this.g.contains("Players." + var1)) {
         this.b = this.g.getString("Players." + var1 + ".banDay");
         this.c = this.g.getString("Players." + var1 + ".banTime");
         this.d = this.g.getString("Players." + var1 + ".banCause");
         this.e = this.g.getString("Players." + var1 + ".coords");
      } else {
         this.c = "";
         this.b = "";
         this.d = "";
         this.e = "";
      }

      if (Bukkit.getPlayer(var1) != null) {
         this.a("Players." + this.h() + ".UUID", Bukkit.getPlayer(var1).getUniqueId().toString());
      }

      if (!this.g.contains("Players." + this.h() + ".HP")) {
         this.g.set("Players." + this.h() + ".HP", 0);
      }

      this.l();
      this.m();
   }

   private void a(String var1, Object var2) {
      if (!this.g.contains(var1)) {
         this.g.set(var1, var2);
      } else if (var1.equalsIgnoreCase("Players." + this.h() + ".Idioma")) {
         String var3 = this.g.getString("Players." + this.h() + ".Idioma");
         if (!var3.equalsIgnoreCase("SPANISH") && !var3.equalsIgnoreCase("ENGLISH")) {
            this.g.set("Players." + this.h() + ".Idioma", "SPANISH");
            this.l();
            this.m();
         }
      }

   }

   public com.permadeathcore.a.a a() {
      this.a("Players." + this.h() + ".Idioma", "SPANISH");
      return com.permadeathcore.a.a.valueOf(this.g.getString("Players." + this.h() + ".Idioma"));
   }

   public void a(com.permadeathcore.a.a var1) {
      this.g.set("Players." + this.a + ".Idioma", var1.toString());
      this.l();
      this.m();
   }

   public void b() {
      long var1 = this.h.o();
      if (!this.g.contains("Players." + this.a + ".LastDay")) {
         this.a(var1);
      }
   }

   public void a(long var1) {
      this.g.set("Players." + this.a + ".LastDay", var1);
      this.l();
      this.m();
   }

   public long c() {
      this.b();
      return this.g.getLong("Players." + this.a + ".LastDay");
   }

   public ItemStack d() {
      ItemStack var1 = new ItemStack(Material.PLAYER_HEAD);
      ItemMeta var2 = var1.getItemMeta();
      Main var10001 = this.h;
      var2.setDisplayName(Main.a("&c&l" + this.a));
      String[] var3 = new String[5];
      Main var10004 = this.h;
      var3[0] = Main.a("&c&lHA SIDO PERMABANEADO");
      var10004 = this.h;
      var3[1] = Main.a(" ");
      var10004 = this.h;
      var3[2] = Main.a("&7Fecha del Baneo: &c" + this.b);
      var10004 = this.h;
      var3[3] = Main.a("&7Hora del Baneo: &c" + this.c);
      var10004 = this.h;
      var3[4] = Main.a("&7Causa del Baneo: " + this.d);
      var2.setLore(Arrays.asList(var3));
      var1.setItemMeta(var2);
      return var1;
   }

   public ItemStack a(ItemStack var1) {
      ItemMeta var2 = var1.getItemMeta();
      Main var10001 = this.h;
      var2.setDisplayName(Main.a("&c&l" + this.a));
      String[] var3 = new String[5];
      Main var10004 = this.h;
      var3[0] = Main.a("&c&lHA SIDO PERMABANEADO");
      var10004 = this.h;
      var3[1] = Main.a(" ");
      var10004 = this.h;
      var3[2] = Main.a("&7Fecha del Baneo: &c" + this.b);
      var10004 = this.h;
      var3[3] = Main.a("&7Hora del Baneo: &c" + this.c);
      var10004 = this.h;
      var3[4] = Main.a("&7Causa de Muerte: " + this.d);
      var2.setLore(Arrays.asList(var3));
      var1.setItemMeta(var2);
      return var1;
   }

   public void a(int var1) {
      this.g.set("Players." + this.h() + ".HP", var1);
      this.l();
      this.m();
   }

   public int e() {
      return this.g.getInt("Players." + this.h() + ".HP");
   }

   public void f() {
      LocalDate var1 = LocalDate.now();
      int var2 = var1.getMonthValue();
      int var3 = var1.getDayOfMonth();
      String var4 = "";
      if (var2 < 10) {
         var4 = var1.getYear() + "-0" + var2 + "-";
      } else {
         var4 = var1.getYear() + "-" + var2 + "-";
      }

      if (var3 < 10) {
         var4 = var4 + "0" + var3;
      } else {
         var4 = var4 + var3;
      }

      this.a(var4);
   }

   public void g() {
      LocalDateTime var1 = LocalDateTime.now();
      int var2 = var1.getSecond();
      int var3 = var1.getMinute();
      int var4 = var1.getHour();
      String var5 = "";
      String var6 = "";
      String var7 = "";
      if (var2 < 10) {
         var5 = "0" + var2;
      } else {
         var5 = String.valueOf(var2);
      }

      if (var3 < 10) {
         var6 = "0" + var3;
      } else {
         var6 = String.valueOf(var3);
      }

      if (var4 < 10) {
         var7 = "0" + var4;
      } else {
         var7 = String.valueOf(var4);
      }

      String var8 = var7 + ":" + var6 + ":" + var5;
      this.b(var8);
   }

   public void a(DamageCause var1) {
      String var2 = "";
      if (var1 == DamageCause.WITHER) {
         var2 = "&0Efecto Wither";
      } else if (var1 == DamageCause.BLOCK_EXPLOSION) {
         var2 = "Explosión";
      } else if (var1 == DamageCause.DRAGON_BREATH) {
         var2 = "&dEnder Dragon (Breath)";
      } else if (var1 == DamageCause.ENTITY_ATTACK) {
         var2 = "Mobs";
      } else if (var1 == DamageCause.DROWNING) {
         var2 = "Ahogamiento";
      } else if (var1 == DamageCause.ENTITY_EXPLOSION) {
         var2 = "Explosión";
      } else if (var1 == DamageCause.FALL) {
         var2 = "Caída";
      } else if (var1 != DamageCause.FIRE && var1 != DamageCause.FIRE_TICK) {
         if (var1 != DamageCause.HOT_FLOOR && var1 != DamageCause.LAVA) {
            if (var1 == DamageCause.LIGHTNING) {
               var2 = "Trueno";
            } else if (var1 == DamageCause.POISON) {
               var2 = "Veneno";
            } else if (var1 == DamageCause.VOID) {
               var2 = "Vacío";
            } else if (var1 == DamageCause.SUFFOCATION) {
               var2 = "Sofocado";
            } else if (var1 == DamageCause.SUICIDE) {
               var2 = "Suicidio";
            } else if (var1 == DamageCause.THORNS) {
               var2 = "Espinas";
            } else if (var1 == DamageCause.PROJECTILE) {
               var2 = "Proyectil";
            } else {
               var2 = "Causa desconocida.";
            }
         } else {
            var2 = "Lava";
         }
      } else {
         var2 = "Fuego";
      }

      this.c(var2);
   }

   public String h() {
      return this.a;
   }

   public String i() {
      return this.g.getString("Players." + this.a + ".banDay");
   }

   public void a(String var1) {
      this.b = var1;
      this.g.set("Players." + this.h() + ".banDay", var1);
      this.l();
      this.m();
   }

   public void a(Location var1) {
      int var2 = (int)var1.getX();
      int var3 = (int)var1.getY();
      int var4 = (int)var1.getZ();
      String var5 = var2 + " " + var3 + " " + var4;
      this.e = var5;
      this.g.set("Players." + this.h() + ".coords", var5);
      this.l();
      this.m();
   }

   public String j() {
      return this.g.getString("Players." + this.a + ".banTime");
   }

   public void b(String var1) {
      this.c = var1;
      this.g.set("Players." + this.h() + ".banTime", var1);
      this.l();
      this.m();
   }

   public String k() {
      return this.g.getString("Players." + this.a + ".banCause");
   }

   public void c(String var1) {
      this.d = var1;
      this.g.set("Players." + this.h() + ".banCause", var1);
      this.l();
      this.m();
   }

   public void l() {
      try {
         this.g.save(this.f);
      } catch (IOException var2) {
         System.out.println("[ERROR] Ha ocurrido un error al guardar el archivo 'players.yml'");
      }

   }

   public void m() {
      try {
         this.g.load(this.f);
      } catch (IOException var2) {
         System.out.println("[ERROR] Ha ocurrido un error al guardar el archivo 'players.yml'");
      } catch (InvalidConfigurationException var3) {
         System.out.println("[ERROR] Ha ocurrido un error al guardar el archivo 'players.yml'");
      }

   }
}
