package com.permadeathcore.j.a;

import com.permadeathcore.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class d implements Listener {
   @EventHandler
   public void a(PlayerJoinEvent var1) {
      Player var2 = var1.getPlayer();
      var2.sendMessage(Main.a("&9&l---------------------------------------------"));
      var2.sendMessage(Main.a("                  &4&lPERMADEATH CORE RELOADED"));
      var2.sendMessage(Main.a("&3  Creado por &f&l@SebazCRC#2005 &3y &f&lvo1d#0002"));
      var2.sendMessage(Main.a("&3  Enlace a nuestro discord: &f&lhttps://discord.gg/InfernalCore"));
      var2.sendMessage(Main.a("&3  Sitio web: &f&linfernalcore.net"));
      var2.sendMessage(Main.a("&3  Utiliza el comando /pdc para más información"));
      var2.sendMessage(Main.a("&9&l---------------------------------------------"));
   }
}
