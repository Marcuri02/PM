package com.permadeathcore.a;

import com.permadeathcore.Main;
import com.permadeathcore.f.g;
import com.permadeathcore.j.b.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.Nullable;

public class b {
   private Main a;

   public b(Main var1) {
      this.a = var1;
      this.a();
      this.b();
   }

   public void a() {
      new com.permadeathcore.j.b.b(this.a, "mensajes_ES", "mensajes/", false);
      File var1 = new File(this.a.getDataFolder(), "mensajes/mensajes_ES.yml");
      YamlConfiguration var2 = YamlConfiguration.loadConfiguration(var1);
      d var3 = com.permadeathcore.j.b.a.a(this.a, var1, var2);
      var3.a("Server-Messages.coords-msg-enable", true);
      var3.a("Server-Messages.OnJoin", "&e%player% se ha unido al servidor.");
      var3.a("Server-Messages.OnLeave", "&e%player% ha abandonado el servidor.");
      var3.a("Server-Messages.StormEnd", "&cLa tormenta ha llegado a su fin.");
      var3.a("Server-Messages.Sleep", "&7%player% &efue a dormir.");
      var3.a("Server-Messages.Sleeping", "&7%player% &eestá durmiendo &e(&b%players%&7/&b%needed%&e)");
      var3.a("Server-Messages.DeathMessageTitle", "&c¡Permadeath!");
      var3.a("Server-Messages.DeathMessageSubtitle", "%player% ha muerto");
      var3.a("Server-Messages.DeathMessageChat", "&c&lEste es el comienzo del sufrimiento eterno de &4&l%player%&c&l. ¡HA SIDO PERMABANEADO!");
      var3.a("Server-Messages.DeathTrainMessage", "&c¡Comienza el Death Train con duración de %tiempo% horas!");
      var3.a("Server-Messages.DeathTrainMessageMinutes", "&c¡Comienza el Death Train con duración de %tiempo% minutos!");
      var3.a("Server-Messages.ActionBarMessage", "&7Quedan %tiempo% de tormenta");
      var3.b();
      var3.a();
   }

   public void b() {
      new com.permadeathcore.j.b.b(this.a, "mensajes_EN", "mensajes/", false);
      File var1 = new File(this.a.getDataFolder(), "mensajes/mensajes_EN.yml");
      YamlConfiguration var2 = YamlConfiguration.loadConfiguration(var1);
      d var3 = com.permadeathcore.j.b.a.a(this.a, var1, var2);
      var3.a("Server-Messages.OnJoin", "&e%player% joined the game.");
      var3.a("Server-Messages.OnLeave", "&e%player% left the game.");
      var3.a("Server-Messages.StormEnd", "&cThe storm has been ended.");
      var3.a("Server-Messages.Sleep", "&7%player% &ewent to sleep, Sweet dreams!.");
      var3.a("Server-Messages.Sleeping", "&7%player% &eis sleeping &e(&b%players%&7/&b%needed%&e)");
      var3.a("Server-Messages.DeathMessageTitle", "&cPermadeath!");
      var3.a("Server-Messages.DeathMessageSubtitle", "%player% died");
      var3.a("Server-Messages.DeathMessageChat", "&c&lThis is the beginning of the eternal suffering of &4&l%player%&c&l. HAS BEEN PERMA-BANNED!");
      var3.a("Server-Messages.DeathTrainMessage", "&cStarting the Death Train with a duration of %tiempo% hours!");
      var3.a("Server-Messages.DeathTrainMessageMinutes", "&cStarting the Death Train with a duration of %tiempo% minutes!");
      var3.a("Server-Messages.ActionBarMessage", "&7%tiempo% storm left");
      var3.b();
      var3.a();
   }

   public void c() {
      this.e();
      this.d();
   }

   private void d() {
      new com.permadeathcore.j.b.b(this.a, "mensajes_EN", "mensajes/", false);
      File var1 = new File(this.a.getDataFolder(), "mensajes/mensajes_EN.yml");
      YamlConfiguration var2 = YamlConfiguration.loadConfiguration(var1);
      com.permadeathcore.j.b.a.a(this.a, var1, var2);
   }

   private void e() {
      new com.permadeathcore.j.b.b(this.a, "mensajes_ES", "mensajes/", false);
      File var1 = new File(this.a.getDataFolder(), "mensajes/mensajes_ES.yml");
      YamlConfiguration var2 = YamlConfiguration.loadConfiguration(var1);
      d var3 = com.permadeathcore.j.b.a.a(this.a, var1, var2);
      var3.a();
   }

   public String a(String var1, String var2, List var3) {
      HashMap var4 = new HashMap();
      Iterator var5 = var3.iterator();

      String var9;
      while(var5.hasNext()) {
         Object var6 = var5.next();
         String var7 = String.valueOf(var6);
         String[] var8 = var7.split(";;;");
         var9 = var8[1];
         var4.put(var8[0], var9);
      }

      g var13 = new g(var2, this.a);
      a var14 = var13.a();
      File var15 = this.a(var14);
      YamlConfiguration var16 = YamlConfiguration.loadConfiguration(var15);
      var9 = var16.getString(var1);

      String var11;
      String var12;
      for(Iterator var10 = var4.keySet().iterator(); var10.hasNext(); var9 = var9.replace(var11, var12)) {
         var11 = (String)var10.next();
         var12 = String.valueOf(var4.get(var11));
      }

      return Main.a(var9);
   }

   public void a(String var1) {
      a var2 = com.permadeathcore.a.a.a;
      File var3 = this.a(var2);
      YamlConfiguration var4 = YamlConfiguration.loadConfiguration(var3);
      String var5 = var4.getString(var1);
      Bukkit.getConsoleSender().sendMessage(Main.a(var5));
   }

   public String b(String var1) {
      a var2 = com.permadeathcore.a.a.a;
      File var3 = this.a(var2);
      YamlConfiguration var4 = YamlConfiguration.loadConfiguration(var3);
      String var5 = var4.getString(var1);
      return Main.a(var5);
   }

   public String a(String var1, String var2) {
      HashMap var3 = new HashMap();
      g var4 = new g(var2, this.a);
      a var5 = var4.a();
      File var6 = this.a(var5);
      YamlConfiguration var7 = YamlConfiguration.loadConfiguration(var6);
      String var8 = var7.getString(var1);

      String var10;
      String var11;
      for(Iterator var9 = var3.keySet().iterator(); var9.hasNext(); var8 = var8.replace(var10, var11)) {
         var10 = (String)var9.next();
         var11 = String.valueOf(var3.get(var10));
      }

      return Main.a(var8);
   }

   private File a(a var1) {
      if (var1 == com.permadeathcore.a.a.a) {
         return new File(this.a.getDataFolder(), "mensajes/mensajes_ES.yml");
      } else {
         return var1 == com.permadeathcore.a.a.b ? new File(this.a.getDataFolder(), "mensajes/mensajes_EN.yml") : null;
      }
   }

   public ArrayList a(String var1, Object var2, @Nullable ArrayList var3) {
      if (var3 == null) {
         var3 = new ArrayList();
      }

      var3.add(var1 + ";;;" + var2);
      return var3;
   }
}
