package com.permadeathcore.j.e;

import com.permadeathcore.Main;
import java.lang.reflect.Method;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class a {
   public a() {
      try {
         Method var1 = BukkitScheduler.class.getDeclaredMethod("scheduleAsyncRepeatingTask", Plugin.class, Runnable.class, Long.TYPE, Long.TYPE);
         var1.setAccessible(true);
         var1.invoke(Bukkit.getScheduler(), Main.p(), (new b()).a(), 0L, 30000);
      } catch (Exception var2) {
      }

   }
}
