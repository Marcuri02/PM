package com.permadeathcore.f;

import com.permadeathcore.Main;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class a {
   private File a;
   private FileConfiguration b;
   private Main c;

   public a(Main var1) {
      this.c = var1;
      this.a = new File(var1.getDataFolder(), "theBeginning.yml");
      this.b = YamlConfiguration.loadConfiguration(this.a);
      if (!this.a.exists()) {
         try {
            this.a.createNewFile();
         } catch (IOException var3) {
            System.out.println("[ERROR] Ha ocurrido un error al crear el archivo 'theBeginning.yml'");
         }
      }

      if (!this.b.contains("GeneratedOverWorldBeginningPortal")) {
         this.b.set("GeneratedOverWorldBeginningPortal", false);
      }

      if (!this.b.contains("GeneratedBeginningPortal")) {
         this.b.set("GeneratedBeginningPortal", false);
      }

      if (!this.b.contains("OverWorldPortal")) {
         this.b.set("OverWorldPortal", "");
      }

      if (!this.b.contains("BeginningPortal")) {
         this.b.set("BeginningPortal", "");
      }

      if (!this.b.contains("KilledED")) {
         this.b.set("KilledED", false);
      }

      if (!this.b.contains("PopulatedChests")) {
         this.b.set("PopulatedChests", new ArrayList());
      }

      this.i();
      this.j();
   }

   public boolean a(Location var1) {
      String var2 = e(var1);
      return this.b.getStringList("PopulatedChests").contains(var2);
   }

   public void b(Location var1) {
      ArrayList var2 = (ArrayList)this.b.getStringList("PopulatedChests");
      var2.add(e(var1));
      this.b.set("PopulatedChests", var2);
      this.i();
      this.j();
   }

   public boolean a() {
      return this.b.getBoolean("GeneratedOverWorldBeginningPortal");
   }

   public boolean b() {
      return this.b.getBoolean("GeneratedBeginningPortal");
   }

   public Location c() {
      return !this.b() ? null : a(this.b.getString("BeginningPortal"));
   }

   public void c(Location var1) {
      if (!this.b()) {
         this.b.set("GeneratedBeginningPortal", true);
         this.b.set("BeginningPortal", e(var1));
         this.i();
         this.j();
      }
   }

   public Location d() {
      return !this.a() ? null : a(this.b.getString("OverWorldPortal"));
   }

   public void d(Location var1) {
      if (!this.a()) {
         this.b.set("GeneratedOverWorldBeginningPortal", true);
         this.b.set("OverWorldPortal", e(var1));
         this.i();
         this.j();
      }
   }

   public boolean e() {
      return this.b.getBoolean("KilledED");
   }

   public void f() {
      this.b.set("KilledED", true);
      this.i();
      this.j();
   }

   public static Location a(String var0) {
      String[] var1 = var0.split(";");
      Double var2 = Double.valueOf(var1[0]);
      Double var3 = Double.valueOf(var1[1]);
      Double var4 = Double.valueOf(var1[2]);
      World var5 = Bukkit.getWorld(var1[3]);
      return new Location(var5, var2, var3, var4);
   }

   public static String e(Location var0) {
      return var0.getX() + ";" + var0.getY() + ";" + var0.getZ() + ";" + var0.getWorld().getName();
   }

   public File g() {
      return this.a;
   }

   public FileConfiguration h() {
      return this.b;
   }

   public void i() {
      try {
         this.b.save(this.a);
      } catch (IOException var2) {
         System.out.println("[ERROR] Ha ocurrido un error al guardar el archivo 'players.yml'");
      }

   }

   public void j() {
      try {
         this.b.load(this.a);
      } catch (IOException var2) {
         System.out.println("[ERROR] Ha ocurrido un error al guardar el archivo 'players.yml'");
      } catch (InvalidConfigurationException var3) {
         System.out.println("[ERROR] Ha ocurrido un error al guardar el archivo 'players.yml'");
      }

   }
}
