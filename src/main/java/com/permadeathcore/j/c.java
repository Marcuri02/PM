package com.permadeathcore.j;

import com.permadeathcore.Main;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Consumer;

public class c {
   private Plugin a;
   private int b;
   private boolean c = true;

   public c(Plugin var1) {
      this.a = var1;
      this.b = 81231;
   }

   public void a(Consumer var1) {
      Bukkit.getScheduler().runTaskAsynchronously(this.a, () -> {
         try {
            InputStream var2 = (new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.b)).openStream();
            Throwable var3 = null;

            try {
               Scanner var4 = new Scanner(var2);
               Throwable var5 = null;

               try {
                  if (var4.hasNext()) {
                     var1.accept(var4.next());
                  }
               } catch (Throwable var30) {
                  var5 = var30;
                  throw var30;
               } finally {
                  if (var4 != null) {
                     if (var5 != null) {
                        try {
                           var4.close();
                        } catch (Throwable var29) {
                           var5.addSuppressed(var29);
                        }
                     } else {
                        var4.close();
                     }
                  }

               }
            } catch (Throwable var32) {
               var3 = var32;
               throw var32;
            } finally {
               if (var2 != null) {
                  if (var3 != null) {
                     try {
                        var2.close();
                     } catch (Throwable var28) {
                        var3.addSuppressed(var28);
                     }
                  } else {
                     var2.close();
                  }
               }

            }
         } catch (IOException var34) {
            this.a.getServer().getConsoleSender().sendMessage(Main.a("&7> &4&lNO SE HA PODIDO VERIFICAR UNA ACTUALIZACIÓN"));
            this.c = false;
         }

      });
   }

   public boolean a() {
      return this.c;
   }
}
