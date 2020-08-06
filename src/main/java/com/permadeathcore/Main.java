package com.permadeathcore;

import com.permadeathcore.g.a.a.a.C;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Filter;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {
   public static Main a;
   private com.permadeathcore.g.c l;
   private com.permadeathcore.g.b m;
   private a n;
   private com.permadeathcore.g.a.a o;
   private com.permadeathcore.j.c.f p;
   private com.permadeathcore.j.c.c q;
   private com.permadeathcore.j.f.a r;
   private com.permadeathcore.i.a.a s;
   private com.permadeathcore.a.b t;
   public LocalDate b;
   public LocalDate c = LocalDate.now();
   String d;
   private long u;
   public long e;
   public long f;
   public String g;
   public World h = Bukkit.getWorld("world");
   public World i = Bukkit.getWorld("world_the_end");
   private com.permadeathcore.h.a v = null;
   private com.permadeathcore.b.a w;
   private com.permadeathcore.c.a.a x;
   private com.permadeathcore.i.a y;
   private com.permadeathcore.f.a z;
   private com.permadeathcore.f.b A;
   public static boolean j = false;
   private boolean B = false;
   private Map C = new HashMap();
   private ArrayList D = new ArrayList();
   private boolean E = false;
   private boolean F = false;
   private boolean G = false;
   int k = 0;
   private com.permadeathcore.d.b H;
   private boolean I = false;
   private boolean J = false;
   private File K;
   private FileConfiguration L;

   public void onEnable() {
      this.saveDefaultConfig();
      a = this;
      this.t();
      new C();
      this.K = new File(this.getDataFolder(), "fecha.yml");
      this.L = YamlConfiguration.loadConfiguration(this.K);
      if (!this.K.exists()) {
         this.saveResource("fecha.yml", false);
         this.L.set("Fecha", this.C());
         this.D();
         this.E();
      }

      Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new q(this), 0L, 20L);
      if (this.I && !this.J) {
         Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new r(this), 0L, 72000L);
      }

   }

   public void onLoad() {
      a = this;
      com.permadeathcore.j.a.e var1 = new com.permadeathcore.j.a.e(this);
      this.l = (com.permadeathcore.g.c)var1.a();
      this.m = (com.permadeathcore.g.b)var1.b();
      this.s = (com.permadeathcore.i.a.a)var1.c();
      this.m.a();
   }

   public void onDisable() {
      Bukkit.getConsoleSender().sendMessage(a("&f&m------------------------------------------"));
      Bukkit.getConsoleSender().sendMessage(a("         &c&lPERMADEATH&4&lCORE &e&lRELOADED"));
      Bukkit.getConsoleSender().sendMessage(a("     &7- Desactivando el Plugin."));
      Bukkit.getConsoleSender().sendMessage(a("&f&m------------------------------------------"));
      if (this.o != null) {
         this.o.b();
      }

      a = null;
   }

   private void z() {
      if (this.L.getString("Fecha").isEmpty()) {
         this.L.set("Fecha", this.C());
         this.D();
         this.E();
      }

      this.d = this.L.getString("Fecha");
      LocalDate var1 = LocalDate.now();
      this.c = var1.minusDays(1L);

      try {
         this.b = LocalDate.parse(this.L.getString("Fecha"));
      } catch (DateTimeParseException var12) {
         Bukkit.getConsoleSender().sendMessage(a(this.g + "&4&lERROR: &eLa fecha en config.yml estaba mal configurada &7(" + this.L.getString("Fecha") + ")&e."));
         Bukkit.getConsoleSender().sendMessage(a(this.g + "&eSe ha establecido el día: &b1"));
         this.b = LocalDate.parse(this.C());
         this.L.set("Fecha", this.C());
         this.D();
         this.E();
      }

      this.u = this.b.until(this.c, ChronoUnit.DAYS);
      new com.permadeathcore.j.a.b(this);
      this.t = new com.permadeathcore.a.b(this);
      this.H = new com.permadeathcore.d.b(this);
      this.x = new com.permadeathcore.c.a.a(this);
      new com.permadeathcore.j.b.b(a, "beginning_portal.schem", "schematics/", true);
      new com.permadeathcore.j.b.b(a, "ytic.schem", "schematics/", true);
      new com.permadeathcore.j.b.b(a, "island1.schem", "schematics/", true);
      new com.permadeathcore.j.b.b(a, "island2.schem", "schematics/", true);
      new com.permadeathcore.j.b.b(a, "island3.schem", "schematics/", true);
      new com.permadeathcore.j.b.b(a, "island4.schem", "schematics/", true);
      new com.permadeathcore.j.b.b(a, "island5.schem", "schematics/", true);
      int var2 = Integer.parseInt((String)Objects.requireNonNull(a.getConfig().getString("Toggles.Netherite.Helmet")));
      int var3 = Integer.parseInt((String)Objects.requireNonNull(a.getConfig().getString("Toggles.Netherite.Chestplate")));
      int var4 = Integer.parseInt((String)Objects.requireNonNull(a.getConfig().getString("Toggles.Netherite.Leggings")));
      int var5 = Integer.parseInt((String)Objects.requireNonNull(a.getConfig().getString("Toggles.Netherite.Boots")));
      if (var2 > 100 || var2 < 1) {
         System.out.println("[ERROR] Error al cargar la probabilidad de 'Helmet' en 'config.yml', asegurate de introducir un numero valido del 1 al 100.");
         System.out.println("[ERROR] Ha ocurrido un error al cargar el archivo config.yml, si este error persiste avisanos por discord.");
      }

      if (var3 > 100 || var3 < 1) {
         System.out.println("[ERROR] Error al cargar la probabilidad de 'Chestplate' en 'config.yml', asegurate de introducir un numero valido del 1 al 100.");
         System.out.println("[ERROR] Ha ocurrido un error al cargar el archivo config.yml, si este error persiste avisanos por discord.");
      }

      if (var4 > 100 || var4 < 1) {
         System.out.println("[ERROR] Error al cargar la probabilidad de 'Leggings' en 'config.yml', asegurate de introducir un numero valido del 1 al 100.");
         System.out.println("[ERROR] Ha ocurrido un error al cargar el archivo config.yml, si este error persiste avisanos por discord.");
      }

      if (var5 > 100 || var5 < 1) {
         System.out.println("[ERROR] Error al cargar la probabilidad de 'BootsValue' en 'config.yml', asegurate de introducir un numero valido del 1 al 100.");
         System.out.println("[ERROR] Ha ocurrido un error al cargar el archivo config.yml, si este error persiste avisanos por discord.");
      }

      String var6 = this.c();
      String var7 = "&cIncompatible";
      if (com.permadeathcore.g.l.b().equalsIgnoreCase("1.15.x") || com.permadeathcore.g.l.b().equalsIgnoreCase("1.14.x") || com.permadeathcore.g.l.b().equalsIgnoreCase("1.16.x")) {
         var7 = "&aCompatible";
      }

      String var8 = "";

      try {
         if (Class.forName("org.spigotmc.SpigotConfig") != null) {
            var8 = "SpigotMC (Compatible)";
         }
      } catch (ClassNotFoundException var11) {
         var8 = "Bukkit";
      }

      try {
         if (Class.forName("com.destroystokyo.paper.PaperConfig") != null) {
            var8 = "PaperMC (Compatible)";
            j = true;
         }
      } catch (ClassNotFoundException var10) {
      }

      Bukkit.getConsoleSender().sendMessage(a("&f&m------------------------------------------"));
      Bukkit.getConsoleSender().sendMessage(a("         &c&lPERMADEATH&4&lCORE &e&lRELOADED"));
      Bukkit.getConsoleSender().sendMessage(a("     &7- Creador: &eSebazCRC"));
      Bukkit.getConsoleSender().sendMessage(a("     &7- Versión: &e" + this.getDescription().getVersion()));
      Bukkit.getConsoleSender().sendMessage(a("     &7- Versión del Servidor: &e" + com.permadeathcore.g.l.b()));
      Bukkit.getConsoleSender().sendMessage(a("&f&m------------------------------------------"));
      Bukkit.getConsoleSender().sendMessage(a(" &7>> &e&lINFORME DE ESTADO"));
      Bukkit.getConsoleSender().sendMessage(a("&7> &bEstado de mundos: " + var6));
      Bukkit.getConsoleSender().sendMessage(a("    &7> &eEnd&7: &8" + this.i.getName()));
      Bukkit.getConsoleSender().sendMessage(a("    &7> &aOverworld&7: &8" + this.h.getName()));
      Bukkit.getConsoleSender().sendMessage(a("&7> &bEstado de Compatibilidad: " + var7));
      Bukkit.getConsoleSender().sendMessage(a("&7> &bSoftware: " + var8));
      Bukkit.getConsoleSender().sendMessage(a("&7> &b&lCambios:"));
      Bukkit.getConsoleSender().sendMessage(a("&7>   &aEstables: &710-50"));
      Bukkit.getConsoleSender().sendMessage(a("&7>   &eBETA: &760"));
      if (Bukkit.getPluginManager().getPlugin("WorldEdit") == null) {
         Bukkit.getConsoleSender().sendMessage(a("&7> &4&lADVERTENCIA: &7No se ha encontrado el Plugin &7World Edit"));
         Bukkit.getConsoleSender().sendMessage(a("&7> &7Si deseas usar PermadeathCore instala &e&lWorldEdit&7."));
      }

      if (var8.contains("Bukkit")) {
         Bukkit.broadcastMessage(a("&7> &4&lADVERTENCIA&7: &eEl plugin NO es compatible con CraftBukkit, cambia a SpigotMC o PaperSpigot"));
         this.B = true;
      }

      (new com.permadeathcore.j.c(this)).a((var1x) -> {
         if (this.getDescription().getVersion().equalsIgnoreCase(var1x)) {
            Bukkit.getConsoleSender().sendMessage(a("&7> &bEstado de Actualización: &aVersión más reciente."));
         } else {
            Bukkit.getConsoleSender().sendMessage(a("&7> &eNueva versión detectada."));
            Bukkit.getConsoleSender().sendMessage(a("&7> &aDescarga: &7https://www.spigotmc.org/resources/permadeathcore-reloaded-%E2%98%A0%EF%B8%8F.81231/"));
         }

      });
      this.b();
      this.A();
   }

   protected void a() {
      if (!this.F) {
         this.getServer().getPluginManager().registerEvents(this, this);
         this.getServer().getPluginManager().registerEvents(new com.permadeathcore.c.b(a), a);
         this.getServer().getPluginManager().registerEvents(new com.permadeathcore.c.a(a), a);
         this.n = new a(a);
         this.getServer().getPluginManager().registerEvents(this.n, a);
         this.C.put(20, false);
         this.C.put(30, false);
         this.C.put(40, false);
         this.C.put(50, false);
         this.C.put(60, false);
         this.F = true;
      }

      String var1 = "&e[PermadeathCore Reloaded] &7> ";
      if (this.p == null) {
         this.p = new com.permadeathcore.j.c.f(a);
         this.getServer().getPluginManager().registerEvents(this.p, a);
      }

      if (this.q == null) {
         this.q = new com.permadeathcore.j.c.c(a);
         this.getServer().getPluginManager().registerEvents(this.q, a);
      }

      if (this.u >= 20L && !(Boolean)this.C.get(20)) {
         this.o = new com.permadeathcore.g.a.a(this);
         this.getServer().getPluginManager().registerEvents(this.o, a);
         Bukkit.getConsoleSender().sendMessage(a(var1 + "&eSe han registrado los cambios de Mobs pacíficos hostiles."));
         this.C.replace(20, true);
      }

      if (this.u >= 30L && this.w == null && this.A == null && !(Boolean)this.C.get(30)) {
         this.w = new com.permadeathcore.b.a(a);
         this.getServer().getPluginManager().registerEvents(this.w, a);
         this.A = new com.permadeathcore.f.b(a);
         this.getServer().getPluginManager().registerEvents(new com.permadeathcore.f.c(a), a);
         if (j) {
            this.getServer().getPluginManager().registerEvents(new com.permadeathcore.e.c(a), a);
            Bukkit.getConsoleSender().sendMessage(a(var1 + "&eSe han registrado cambios especiales para &c&lPaperMC&e."));
            this.C.replace(30, true);
         }
      }

      if (this.u >= 40L && !(Boolean)this.C.get(40)) {
         this.getServer().getPluginManager().registerEvents(new com.permadeathcore.e.a(a), a);
         this.z = new com.permadeathcore.f.a(this);
         this.y = new com.permadeathcore.i.a(this);
         this.r = new com.permadeathcore.j.f.a(this);
         this.r.a();
         this.f().b();
         Bukkit.getConsoleSender().sendMessage(a(var1 + "&eSe han registrado cambios para el día &b40"));
         this.C.replace(40, true);
      }

      if (this.u >= 50L && !(Boolean)this.C.get(50)) {
         if (Bukkit.getPluginManager().getPlugin("WorldEdit") == null) {
            Bukkit.broadcastMessage(a(var1 + "&4&lNo se pudo registrar TheBeginning ya que no se ha encontrado el plugin &7WorldEdit"));
            Bukkit.broadcastMessage(a(var1 + "&7Si necesitas soporte entra a este discord: &ediscord.gg/InfernalCore"));
            return;
         }

         Bukkit.getConsoleSender().sendMessage(a(var1 + "&eSe han registrado cambios para el día &b50"));
         this.r.b();
         this.C.replace(50, true);
      }

      if (this.u >= 60L && !(Boolean)this.C.get(60)) {
         this.r.c();
         Bukkit.getConsoleSender().sendMessage(a(var1 + "&eSe han registrado cambios para el día &b60"));
         this.C.put(60, true);
      }

   }

   protected void b() {
      if (!this.G) {
         this.G = true;
      }
   }

   private void A() {
      OfflinePlayer[] var1 = Bukkit.getOfflinePlayers();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         OfflinePlayer var4 = var1[var3];
         if (var4 == null) {
            return;
         }

         com.permadeathcore.f.g var5 = new com.permadeathcore.f.g(var4.getName(), this);
         var5.b();
      }

   }

   protected String c() {
      if (Bukkit.getWorld((String)Objects.requireNonNull(a.getConfig().getString("Worlds.MainWorld"))) == null) {
         System.out.println("[ERROR] Error al cargar el mundo principal, esto hará que los Death Train no se presenten.");
         System.out.println("[ERROR] Tan solo ve a config.yml y establece el mundo principal en la opción: MainWorld");
         this.h = (World)Bukkit.getWorlds().get(0);
         System.out.println("[INFO] El plugin utilizará el mundo " + this.h.getName() + " como mundo principal.");
         System.out.println("[INFO] Si deseas utilizar otro mundo, configura en el archivo config.yml.");
         return "&eError al cargar mundo.";
      } else {
         this.h = Bukkit.getWorld((String)Objects.requireNonNull(a.getConfig().getString("Worlds.MainWorld")));
         if (Bukkit.getWorld((String)Objects.requireNonNull(a.getConfig().getString("Worlds.EndWorld"))) == null) {
            System.out.println("[ERROR] Error al cargar el mundo del end, esto hará que el end no funcione como debe.");
            System.out.println("[ERROR] Tan solo ve a config.yml y establece el mundo del end en la opción: EndWorld");
            Iterator var1 = Bukkit.getWorlds().iterator();

            while(var1.hasNext()) {
               World var2 = (World)var1.next();
               if (var2.getName().endsWith("the_end")) {
                  this.i = this.h;
                  System.out.println("[INFO] El plugin utilizará el mundo " + var2.getName() + " como mundo del End.");
               }
            }

            if (this.i == null) {
               System.out.println("[ERROR] El plugin no pudo encontrar un mundo para el End, esto generará errores.");
            }

            return "&eError al cargar mundo.";
         } else {
            this.i = Bukkit.getWorld((String)Objects.requireNonNull(a.getConfig().getString("Worlds.EndWorld")));
            return "&aCorrecto";
         }
      }
   }

   protected void a(CommandSender var1, String var2) {
      Main var10001;
      int var3;
      try {
         int var4 = Integer.parseInt(var2);
         if (var4 <= 120 && var4 >= 0) {
            var3 = var4;
         } else {
            var3 = 0;
         }
      } catch (NumberFormatException var8) {
         var10001 = a;
         var1.sendMessage(a("&cNecesitas ingresar un número válido."));
         return;
      }

      if (var3 == 0) {
         var10001 = a;
         var1.sendMessage(a("&cHas ingresado un número no válido, o ni siquiera un número."));
      } else {
         LocalDate var9 = this.c.minusDays((long)var3);
         int var5 = var9.getMonthValue();
         int var6 = var9.getDayOfMonth();
         String var7;
         if (var5 < 10) {
            var7 = var9.getYear() + "-0" + var5 + "-";
         } else {
            var7 = var9.getYear() + "-" + var5 + "-";
         }

         if (var6 < 10) {
            var7 = var7 + "0" + var6;
         } else {
            var7 = var7 + var6;
         }

         this.L.set("Fecha", var7);
         this.D();
         this.E();
         var10001 = a;
         var1.sendMessage(a("&eSe han actualizado los días a: &7" + var3));
         var1.sendMessage(a("&c&lNota importante: &7Algunos cambios pueden requerir un reinicio y la fecha puede no ser exacta."));
         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pdc reload");
      }
   }

   protected void a(CommandSender var1) {
      this.reloadConfig();
      this.E();
      this.t.c();
      com.permadeathcore.j.d.a.a(this);
      com.permadeathcore.j.d.a.a(var1, this);
      this.d = this.L.getString("Fecha");
      this.b = LocalDate.parse(this.L.getString("Fecha"));
      this.c = LocalDate.now();
      this.u = this.b.until(this.c, ChronoUnit.DAYS) + 1L;
      var1.sendMessage(a("&c&lNota importante: &7Algunos cambios pueden requerir un reinicio y la fecha puede no ser exacta."));
      a.c();
   }

   public com.permadeathcore.c.a.a d() {
      return this.x;
   }

   public static String a(String var0) {
      return ChatColor.translateAlternateColorCodes('&', var0);
   }

   public com.permadeathcore.a.b e() {
      return this.t;
   }

   public com.permadeathcore.g.c f() {
      return this.l;
   }

   public com.permadeathcore.j.c.f g() {
      return this.p;
   }

   public com.permadeathcore.j.c.c h() {
      return this.q;
   }

   public com.permadeathcore.i.a i() {
      return this.y;
   }

   public com.permadeathcore.f.a j() {
      return this.z;
   }

   public com.permadeathcore.f.b k() {
      return this.A;
   }

   public com.permadeathcore.h.a l() {
      return this.v;
   }

   public com.permadeathcore.b.a m() {
      return this.w;
   }

   public void a(com.permadeathcore.h.a var1) {
      this.v = var1;
   }

   public com.permadeathcore.g.b n() {
      return this.m;
   }

   public long o() {
      return this.u;
   }

   public static Main p() {
      return a;
   }

   public com.permadeathcore.g.a.a q() {
      return this.o;
   }

   public ArrayList r() {
      return this.D;
   }

   public a s() {
      return this.n;
   }

   public void t() {
      try {
         Class.forName("org.apache.logging.log4j.core.filter.AbstractFilter");
         this.B();
      } catch (NoClassDefFoundError | ClassNotFoundException var4) {
         new com.permadeathcore.j.b();
         Filter var3 = (Filter)(new com.permadeathcore.j.b());
         Bukkit.getLogger().setFilter(var3);
         Logger.getLogger("Minecraft").setFilter(var3);
      }

   }

   private void B() {
      org.apache.logging.log4j.core.Logger var1 = (org.apache.logging.log4j.core.Logger)LogManager.getRootLogger();
      var1.addFilter(new com.permadeathcore.j.b());
   }

   public com.permadeathcore.d.b u() {
      return this.H;
   }

   public static boolean v() {
      return j;
   }

   public boolean w() {
      return this.B;
   }

   public com.permadeathcore.i.a.a x() {
      return this.s;
   }

   public boolean y() {
      return this.u < 60L;
   }

   private String C() {
      return com.permadeathcore.j.d.a.a();
   }

   private void D() {
      try {
         this.L.save(this.K);
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }

   private void E() {
      try {
         this.L.load(this.K);
      } catch (IOException var2) {
         var2.printStackTrace();
      } catch (InvalidConfigurationException var3) {
         var3.printStackTrace();
      }

   }

   // $FF: synthetic method
   static boolean a(Main var0) {
      return var0.E;
   }

   // $FF: synthetic method
   static void b(Main var0) {
      var0.z();
   }

   // $FF: synthetic method
   static boolean a(Main var0, boolean var1) {
      return var0.E = var1;
   }

   // $FF: synthetic method
   static boolean c(Main var0) {
      return var0.B;
   }

   // $FF: synthetic method
   static File d(Main var0) {
      return var0.getFile();
   }

   // $FF: synthetic method
   static long a(Main var0, long var1) {
      return var0.u = var1;
   }

   // $FF: synthetic method
   static long e(Main var0) {
      return var0.u;
   }

   // $FF: synthetic method
   static FileConfiguration f(Main var0) {
      return var0.L;
   }

   // $FF: synthetic method
   static boolean g(Main var0) {
      return var0.I;
   }

   // $FF: synthetic method
   static boolean b(Main var0, boolean var1) {
      return var0.I = var1;
   }

   // $FF: synthetic method
   static a h(Main var0) {
      return var0.n;
   }

   // $FF: synthetic method
   static boolean i(Main var0) {
      return var0.J;
   }

   // $FF: synthetic method
   static boolean c(Main var0, boolean var1) {
      return var0.J = var1;
   }
}
