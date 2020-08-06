package com.permadeathcore.j.a;

import com.permadeathcore.Main;
import com.permadeathcore.s;
import com.permadeathcore.t;

public class b {
   public b(Main var1) {
      var1.getCommand("pdc").setExecutor(new t(var1));
      var1.getCommand("pdc").setTabCompleter(new s());
      var1.getServer().getPluginManager().registerEvents(new d(), var1);
   }
}
