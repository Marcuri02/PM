package com.permadeathcore;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class s implements TabCompleter {
   public List onTabComplete(CommandSender var1, Command var2, String var3, String[] var4) {
      ArrayList var5 = new ArrayList();
      if (var4.length == 1) {
         var5.add("dias");
         var5.add("duracion");
         var5.add("awake");
         var5.add("info");
         var5.add("discord");
         var5.add("mensaje");
         var5.add("Creado por SebazCRC");
         if (var1.hasPermission("permadeathcore.cambiardia")) {
            var5.add("cambiardia");
         }

         if (var1.hasPermission("permadeathcore.reload")) {
            var5.add("reload");
         }

         if (var1.hasPermission("permadeathcore.give")) {
            var5.add("give");
         }

         if (var1.hasPermission("permadeathcore.locate")) {
            var5.add("locate");
         }
      }

      if (var4.length == 2) {
         if (var4[1].equalsIgnoreCase("give")) {
            var5.add("netheriteArmor");
            var5.add("infernalArmor");
            var5.add("medalla");
            var5.add("netheriteTools");
         }

         if (var4[1].equalsIgnoreCase("locate")) {
            var5.add("beginning");
         }

         if (var4[1].equalsIgnoreCase("cambiardia")) {
            var5.add("<día>");
         }
      }

      return var5;
   }
}
