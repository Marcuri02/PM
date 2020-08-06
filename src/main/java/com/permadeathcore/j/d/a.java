package com.permadeathcore.j.d;

import com.permadeathcore.Main;
import com.permadeathcore.j.b.d;
import java.io.File;
import java.time.LocalDate;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class a {
   public static void a(CommandSender var0, Main var1) {
      var0.sendMessage(Main.a("&aSe ha recargado el archivo de configuración y los mensajes."));
      var0.sendMessage(Main.a("&eAlgunos cambios pueden requerir un reinicio para funcionar correctamente."));
   }

   public static void a(Main var0) {
      File var1 = new File(var0.getDataFolder(), "config.yml");
      YamlConfiguration var2 = YamlConfiguration.loadConfiguration(var1);
      d var3 = com.permadeathcore.j.b.a.a(var0, var1, var2);
      var3.a("ban-enabled", true);
      var3.a("anti-afk-enabled", false);
      var3.a("AntiAFK.DaysForBan", 7);
      var3.a("Toggles.Netherite.Helmet", 10);
      var3.a("Toggles.Netherite.Chestplate", 10);
      var3.a("Toggles.Netherite.Leggings", 10);
      var3.a("Toggles.Netherite.Boots", 10);
      var3.a("Toggles.End.Mob-Spawn-Limit", 70);
      var3.a("Toggles.End.Ender-Ghast-Count", 170);
      var3.a("Toggles.End.Ender-Creeper-Count", 20);
      var3.a("Toggles.End.Protect-End-Spawn", false);
      var3.a("Toggles.End.Protect-Radius", 10);
      var3.a("Toggles.End.PermadeathDemon.DisplayName", "&6&lPERMADEATH DEMON");
      var3.a("Toggles.End.PermadeathDemon.DisplayNameEnraged", "&6&lENRAGED PERMADEATH DEMON");
      var3.a("Toggles.End.PermadeathDemon.Health", 1350);
      var3.a("Toggles.End.PermadeathDemon.EnragedHealth", 1350);
      var3.a("Toggles.End.PermadeathDemon.Optimizar-TNT", false);
      var3.a("Toggles.TheBeginning.YticGenerateChance", 100000);
      var3.a("Toggles.Spider-Effect", true);
      var3.a("Toggles.OP-Ban", true);
      var3.a("Toggles.Mike-Creeper-Spawn", true);
      var3.a("Toggles.Optimizar-Mob-Spawns", false);
      var3.a("Toggles.Gatos-Supernova.Destruir-Bloques", true);
      var3.a("Toggles.Gatos-Supernova.Fuego", true);
      var3.a("Toggles.Gatos-Supernova.Explosion-Power", 200);
      var3.a("Server-Messages.coords-msg-enable", true);
      var3.a("TotemFail.Enable", true);
      var3.a("TotemFail.Medalla", "&7¡El jugador %player% ha usado su medalla de superviviente!");
      var3.a("TotemFail.ChatMessage", "&7¡El tótem de &c%player% &7ha fallado!");
      var3.a("TotemFail.ChatMessageTotems", "&7¡Los tótems de &c%player% &7han fallado!");
      var3.a("TotemFail.NotEnoughTotems", "&7¡%player% no tenía suficientes tótems en el inventario!");
      var3.a("TotemFail.PlayerUsedTotemMessage", "&7El jugador %player% ha consumido un tótem (Probabilidad: %totem_fail% %porcent% %number%)");
      var3.a("TotemFail.PlayerUsedTotemsMessage", "&7El jugador %player% ha usado {ammount} tótems (Probabilidad: %totem_fail% %porcent% %number%)");
      var3.a("Worlds.MainWorld", "world");
      var3.a("Worlds.EndWorld", "world_the_end");
      var3.b();
      var3.a();
   }

   public static String a() {
      LocalDate var0 = LocalDate.now();
      LocalDate var1 = var0.minusDays(1L);
      int var2 = var1.getMonthValue();
      int var3 = var1.getDayOfMonth();
      String var4 = "";
      if (var2 < 10) {
         var4 = var1.getYear() + "-0" + var2 + "-";
      } else {
         var4 = var1.getYear() + "-" + var2 + "-";
      }

      if (var3 < 10) {
         var4 = var4 + "0" + var3;
      } else {
         var4 = var4 + var3;
      }

      return var4;
   }

   public static String a(int var0) {
      long var1 = (long)(var0 * 20);
      long var3 = var1 % 86400L / 3600L;
      long var5 = var1 % 3600L / 60L;
      long var7 = var1 % 60L;
      long var9 = var1 / 86400L;
      String var11 = "";
      var11 = var9 >= 1L ? var11 + var9 + "d " : var11;
      String var12 = var3 > 10L ? "" + var3 : "0" + var3;
      String var13 = var5 > 10L ? "" + var5 : "0" + var5;
      String var14 = var7 > 10L ? "" + var7 : "0" + var7;
      var11 = var3 > 0L ? var11 + var12 + "h " : var11;
      var11 = var5 > 0L ? var11 + var13 + "m " : var11;
      var11 = var7 > 0L ? var11 + var14 + "s " : var11;
      return var11;
   }

   public static String b(int var0) {
      return a(var0 / 20);
   }

   public static void a(Player var0) {
   }
}
