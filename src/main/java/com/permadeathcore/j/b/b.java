package com.permadeathcore.j.b;

import com.sun.istack.internal.NotNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import org.bukkit.plugin.Plugin;

public class b {
   public b(Plugin var1, @NotNull String var2, String var3, boolean var4) {
      this.a(var1, var2, var3, var4);
   }

   private void a(Plugin var1, @NotNull String var2, String var3, boolean var4) {
      if (var2 != null && !var2.equals("")) {
         var2 = var2.replace('\\', '/');
         InputStream var5 = var1.getResource(var2);
         if (var5 != null) {
            File var6 = new File(var1.getDataFolder(), var3 + var2);
            int var7 = var2.lastIndexOf(47);
            File var8 = new File(var1.getDataFolder(), var3 + var2.substring(0, var7 >= 0 ? var7 : 0));
            if (!var8.exists()) {
               var8.mkdirs();
            }

            try {
               if (!var6.exists() || var4) {
                  FileOutputStream var9 = new FileOutputStream(var6);
                  byte[] var10 = new byte[1024];

                  int var11;
                  while((var11 = var5.read(var10)) > 0) {
                     var9.write(var10, 0, var11);
                  }

                  var9.close();
                  var5.close();
               }
            } catch (IOException var12) {
               var1.getLogger().log(Level.SEVERE, "Could not save " + var6.getName() + " to " + var6, var12);
            }
         }

      } else {
         throw new IllegalArgumentException("ResourcePath cannot be null or empty");
      }
   }
}
