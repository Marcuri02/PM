package com.permadeathcore.g.a.a.a;

import com.permadeathcore.Main;
import java.util.ArrayList;
import java.util.SplittableRandom;
import org.bukkit.Bukkit;

public class A {
   public static void a() {
      ArrayList var0 = new ArrayList();
      var0.add(Main.p().g + "&e¡Este servidor utiliza &c&lPermadeathCoreReloaded&e!, gracias por usar nuestro plugin.");
      var0.add(Main.p().g + "&e¡Tenemos discord! Entra ya: &9discord.gg/InfernalCore");
      var0.add(Main.p().g + "&eEste plugin ha sido creado por &f&lSebazCRC &ey &f&lvo1d_dev");
      var0.add(Main.p().g + "&eEste plugin ha sido creado por &f&lSebazCRC &ey &f&lvo1d_dev");
      var0.add(Main.p().g + "&e¡Yeah! +2500 descargas en SpigotMC");
      var0.add(Main.p().g + "&eVisita nuestra página web: www.infernalcore.net");
      var0.add(Main.p().g + "&e¿Algún problema?, ¡prueba usar /pdc o unirte a nuestro discord!");
      var0.add(Main.p().g + "&e¡Gratis para todos!");
      var0.add(Main.p().g + "&eTexture pack creado por &f&l@UnTrapoAHR");
      var0.add(Main.p().g + "&e¿Deseas quitar los anuncios? puedes ir sin ningún problema a nuestro discord y saber cómo.");
      var0.add(Main.p().g + "&eEyEyEy aaaaquí Rich ennnnnn Minecraft, y esta vez os traigo.... ¿Permadeath para todos?");
      var0.add(Main.p().g + "&eEyEyEy aaaaquí Rich ennnnnn Minecraft, y esta vez os traigo.... ¿Permadeath para todos?");
      Bukkit.broadcastMessage(Main.a((String)var0.get((new SplittableRandom()).nextInt(var0.size()))));
   }
}
