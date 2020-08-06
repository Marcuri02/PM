package com.permadeathcore.j.b;

import com.permadeathcore.Main;
import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class d implements c {
   private Main a;
   private File b;
   private FileConfiguration c;

   public d(Main var1, File var2, FileConfiguration var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void a(String var1, boolean var2) {
      this.b = new File(this.a.getDataFolder(), var1);
      this.c = new YamlConfiguration();
      if (!this.b.exists()) {
         this.b.getParentFile().mkdirs();
         if (!var2) {
            try {
               this.b.createNewFile();
            } catch (IOException var4) {
               var4.printStackTrace();
            }
         } else if (this.a.getResource(var1) == null) {
            this.a.saveResource(var1, true);
         } else {
            this.a.saveResource(var1, false);
         }

         this.a();
      }

   }

   public void a() {
      try {
         this.c.load(this.b);
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public void b() {
      try {
         this.c.save(this.b);
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public File c() {
      return this.b;
   }

   public FileConfiguration d() {
      return this.c;
   }

   public void a(String var1, Object var2) {
      if (!this.c.contains(var1)) {
         this.c.set(var1, var2);
      }

   }
}
