package com.permadeathcore.f;

import com.permadeathcore.Main;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class b {
   private File a;
   private FileConfiguration b;
   private Main c;
   private ArrayList d;

   public b(Main var1) {
      this.c = var1;
      this.a = new File(var1.getDataFolder(), "endConfig.yml");
      this.b = YamlConfiguration.loadConfiguration(this.a);
      if (!this.a.exists()) {
         try {
            this.a.createNewFile();
         } catch (IOException var3) {
            System.out.println("[ERROR] Ha ocurrido un error al crear el archivo 'endConfig.yml'");
         }
      }

      if (!this.b.contains("EnderCrystalRegenTime")) {
         this.b.set("EnderCrystalRegenTimeINFO", "La siguiente es una lista de números en segundos del tiempo que toma regenerar un End Crystal.");
         this.b.set("EnderCrystalRegenTime", Arrays.asList(60, 90, 120, 30, 240, 150));
      }

      if (!this.b.contains("PlacedObsidian")) {
         this.b.set("PlacedObsidian", new ArrayList());
      }

      if (!this.b.contains("ReplacedObsidian")) {
         this.b.set("ReplacedObsidian", true);
      }

      if (!this.b.contains("CreatedRegenZone")) {
         this.b.set("CreatedRegenZone", false);
      }

      if (!this.b.contains("DecoratedEndSpawn")) {
         this.b.set("DecoratedEndSpawn", true);
      }

      this.e();
      this.f();
      this.c();
   }

   public File a() {
      return this.a;
   }

   public FileConfiguration b() {
      return this.b;
   }

   public void c() {
      this.d = (ArrayList)this.b.getIntegerList("EnderCrystalRegenTime");
   }

   public ArrayList d() {
      return this.d;
   }

   public void e() {
      try {
         this.b.save(this.a);
      } catch (IOException var2) {
         System.out.println("[ERROR] Ha ocurrido un error al guardar el archivo 'endConfig.yml'");
      }

   }

   public void f() {
      try {
         this.b.load(this.a);
      } catch (IOException var2) {
         System.out.println("[ERROR] Ha ocurrido un error al guardar el archivo 'endConfig.yml'");
      } catch (InvalidConfigurationException var3) {
         System.out.println("[ERROR] Ha ocurrido un error al guardar el archivo 'endConfig.yml'");
      }

      this.c();
   }
}
