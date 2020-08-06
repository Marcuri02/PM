package com.permadeathcore;

import java.time.LocalTime;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.World.Environment;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class t implements CommandExecutor {
   private Main b;
   public static int a;

   public t(Main var1) {
      this.b = var1;
   }

   public boolean onCommand(CommandSender var1, Command var2, String var3, String[] var4) {
      if (var2.getName().equalsIgnoreCase("pdc")) {
         World var5 = this.b.h;
         World var6 = this.b.i;
         if (var4.length == 0) {
            this.a(var1);
            return false;
         }

         if (var4.length > 0) {
            Player var8;
            String var9;
            if (var4[0].equalsIgnoreCase("placeblock")) {
               var8 = (Player)var1;
               if (var8.isOp()) {
                  var9 = var4[1];
                  Location var10 = this.b.i().a(var9);
                  this.b.x().a(var10);
               }
            }

            if (var4[0].equalsIgnoreCase("generateworld")) {
               var8 = (Player)var1;
               if (var8.isOp()) {
                  WorldCreator var15 = (new WorldCreator("pruebas")).generator(new com.permadeathcore.i.b.a.b()).environment(Environment.THE_END).generateStructures(false);
                  World var19 = var15.createWorld();
                  var19.setGameRule(GameRule.MOB_GRIEFING, false);
                  var19.setGameRule(GameRule.DO_MOB_SPAWNING, false);
                  var19.getBlockAt(0, 99, 0).setType(Material.BEDROCK);
                  var19.setSpawnLocation(new Location(var19, 0.0D, 100.0D, 0.0D));
               }
            }

            if (var4[0].equalsIgnoreCase("tp")) {
               var8 = (Player)var1;
               if (var8.isOp()) {
                  var8.teleport(Bukkit.getWorld("pruebas").getSpawnLocation());
               }
            }

            int var14;
            if (var4[0].equalsIgnoreCase("awake")) {
               if (var1 instanceof Player) {
                  var14 = ((Player)var1).getStatistic(Statistic.TIME_SINCE_REST) / 20;
                  var1.sendMessage(this.b.g + ChatColor.RED + "Tiempo despierto: " + ChatColor.GRAY + com.permadeathcore.j.d.a.a(var14));
               }
            } else {
               int var11;
               int var17;
               int var20;
               if (var4[0].equalsIgnoreCase("duracion")) {
                  boolean var16 = var5.hasStorm();
                  var17 = var5.getWeatherDuration();
                  var20 = var17 / 20;
                  var11 = var20;
                  if (var16) {
                     LocalTime var12;
                     String var13;
                     if (var20 < 86400) {
                        var12 = LocalTime.ofSecondOfDay((long)var20);
                        var13 = var12.toString();
                        var1.sendMessage(this.b.g + ChatColor.RED + "Quedan " + ChatColor.GRAY + var13);
                     } else {
                        for(a = 0; var11 > 86400; ++a) {
                           var11 -= 86400;
                        }

                        var12 = LocalTime.ofSecondOfDay((long)var11);
                        var13 = var12.toString();
                        var1.sendMessage(this.b.g + ChatColor.RED + "Quedan " + ChatColor.GRAY + a + "d " + var13);
                     }
                  } else {
                     var1.sendMessage(this.b.g + ChatColor.RED + "¡No hay ninguna tormenta en marcha!");
                  }
               } else {
                  Main var10001;
                  if (var4[0].equalsIgnoreCase("idioma")) {
                     if (!(var1 instanceof Player)) {
                        return false;
                     }

                     var8 = (Player)var1;
                     if (var4.length == 1) {
                        var10001 = this.b;
                        var1.sendMessage(Main.a("&ePor favor ingresa un idioma."));
                        var10001 = this.b;
                        var8.sendMessage(Main.a("&7Ejemplo: &b/pdc idioma es"));
                        var10001 = this.b;
                        var8.sendMessage(Main.a("&eArgumentos válidos: &b<es, en>"));
                        return false;
                     }

                     var9 = var4[1];
                     com.permadeathcore.f.g var22 = new com.permadeathcore.f.g(var8.getName(), this.b);
                     if (var9.equalsIgnoreCase("es")) {
                        if (var22.a() == com.permadeathcore.a.a.a) {
                           var10001 = this.b;
                           var8.sendMessage(Main.a("&c¡Ya estás usando el idioma español!"));
                           return false;
                        }

                        var22.a(com.permadeathcore.a.a.a);
                        var10001 = this.b;
                        var8.sendMessage(Main.a("&eHas cambiado tu idioma a: &bEspañol"));
                     } else if (var9.equalsIgnoreCase("en")) {
                        if (var22.a() == com.permadeathcore.a.a.b) {
                           var10001 = this.b;
                           var8.sendMessage(Main.a("&cYou're already using the English Language"));
                           return false;
                        }

                        var22.a(com.permadeathcore.a.a.b);
                        var10001 = this.b;
                        var8.sendMessage(Main.a("&eYou've changed your language sucessfully to: &bEnglish"));
                     } else {
                        var10001 = this.b;
                        var8.sendMessage(Main.a("&cNo has ingresado un idioma válido."));
                     }
                  } else if (var4[0].equalsIgnoreCase("cambiarDia")) {
                     if (!var1.hasPermission("permadeathcore.cambiardia")) {
                        var10001 = this.b;
                        var1.sendMessage(Main.a("&cNo tienes permiso para hacer esto"));
                        return false;
                     }

                     if (var4.length <= 1) {
                        var10001 = this.b;
                        var1.sendMessage(Main.a("&cNecesitas agregar un día"));
                        var10001 = this.b;
                        var1.sendMessage(Main.a("&eEjemplo: &7/pdc cambiarDia <día>"));
                        return false;
                     }

                     this.b.a(var1, var4[1]);
                  } else if (var4[0].equalsIgnoreCase("reload")) {
                     if (var1.hasPermission("permadeathcore.reload")) {
                        this.b.a(var1);
                     } else {
                        var10001 = this.b;
                        var1.sendMessage(Main.a("&cNo tienes permiso para utilizar este comando."));
                     }
                  } else {
                     String var24;
                     if (var4[0].equalsIgnoreCase("mensaje")) {
                        if (!(var1 instanceof Player)) {
                           return false;
                        }

                        if (var4.length == 1) {
                           var10001 = this.b;
                           var1.sendMessage(Main.a("&cDebes escribir un mensaje, ejemplo: /ic mensaje He muerto"));
                           if (this.b.getConfig().contains("Server-Messages.CustomDeathMessages." + var1.getName())) {
                              var10001 = this.b;
                              var1.sendMessage(Main.a("&eTu mensaje de muerte actual es: &7" + this.b.getConfig().getString("Server-Messages.CustomDeathMessages." + var1.getName())));
                           } else {
                              var10001 = this.b;
                              var1.sendMessage(Main.a("&eTu mensaje de muerte actual es: &7" + this.b.getConfig().getString("Server-Messages.DefaultDeathMessage")));
                           }

                           return false;
                        }

                        String var18 = "";

                        for(var17 = 0; var17 < var4.length; ++var17) {
                           if (!var4[var17].equalsIgnoreCase(var4[0])) {
                              var24 = var4[var17];
                              var18 = var18 + " " + var24;
                           }
                        }

                        if (var18.contains("&")) {
                           var1.sendMessage(ChatColor.RED + "No se admite el uso de " + ChatColor.GOLD + "&");
                           return false;
                        }

                        this.b.getConfig().set("Server-Messages.CustomDeathMessages." + var1.getName(), "&7" + var18);
                        this.b.saveConfig();
                        this.b.reloadConfig();
                        if (var1 instanceof Player) {
                           ((Player)var1).playSound(((Player)var1).getLocation(), Sound.ENTITY_BLAZE_DEATH, 10.0F, -5.0F);
                        }

                        var10001 = this.b;
                        var1.sendMessage(Main.a("&eHas cambiado tu mensaje de muerte a: &7" + var18));
                     } else if (var4[0].equalsIgnoreCase("dias")) {
                        if (this.b.o() < 1L) {
                           var1.sendMessage(this.b.g + ChatColor.DARK_RED + "[ERROR!] Se ha producido un error al cargar el dia, config.yml mal configurado.");
                        } else {
                           var1.sendMessage(this.b.g + ChatColor.RED + "Estamos en el día: " + ChatColor.GRAY + this.b.o());
                        }
                     } else if (var4[0].equalsIgnoreCase("info")) {
                        var1.sendMessage(this.b.g + ChatColor.RED + "Version Info:");
                        var1.sendMessage(ChatColor.GRAY + "- Nombre: " + ChatColor.GREEN + "PermaDeathCoreReloaded.jar");
                        var1.sendMessage(ChatColor.GRAY + "- Versión: " + ChatColor.GREEN + "PermaDeathCoreReloaded v" + this.b.getDescription().getVersion());
                        var1.sendMessage(ChatColor.GRAY + "- Dificultades: " + ChatColor.GREEN + "Soportado de día 1 a día 50 (día 60 fase beta)");
                        var1.sendMessage(ChatColor.GRAY + "- Autor: " + ChatColor.GREEN + "SebazCRC");
                        var1.sendMessage(ChatColor.GRAY + "- Autor original (días 1 - 20): " + ChatColor.GREEN + "vo1d_dev");
                        var1.sendMessage(ChatColor.GRAY + "- Página web: " + ChatColor.GREEN + "http://infernalcore.net/");
                     } else if (var4[0].equalsIgnoreCase("discord")) {
                        var1.sendMessage(this.b.g + ChatColor.BLUE + "https://discord.gg/EPtg96t");
                     } else if (var4[0].equalsIgnoreCase("cambios")) {
                        this.a(var4, var1);
                     } else if (var4[0].equalsIgnoreCase("event")) {
                        if (!var1.hasPermission("permadeathcore.event")) {
                           var10001 = this.b;
                           var1.sendMessage(Main.a("&cNo tienes permiso para ejecutar este comando."));
                           return false;
                        }

                        if (var4.length == 1) {
                           var10001 = this.b;
                           var1.sendMessage(Main.a("&cPor favor introduce un evento, ejemplo: &e/pdc event shulkershell"));
                           return false;
                        }

                        if (var4[1].equalsIgnoreCase("shulkershell")) {
                           if (this.b.u().b()) {
                              var10001 = this.b;
                              var1.sendMessage(Main.a("&cEse evento ya está en ejecución."));
                              return false;
                           }

                           this.b.u().a(true);
                           (new com.permadeathcore.h.d(this.b)).runTaskTimer(this.b, 0L, 20L);
                           var10001 = this.b;
                           var1.sendMessage(Main.a("&aSe ha iniciado el evento correctamente."));
                           Iterator var21 = Bukkit.getOnlinePlayers().iterator();

                           while(var21.hasNext()) {
                              Player var23 = (Player)var21.next();
                              this.b.u().a(var23);
                           }
                        } else {
                           var10001 = this.b;
                           var1.sendMessage(Main.a("&cNo hemos podido encontrar ese evento."));
                        }
                     } else if (var4[0].equalsIgnoreCase("locate")) {
                        if (!var1.hasPermission("permadeathcore.locate")) {
                           var10001 = this.b;
                           var1.sendMessage(Main.a("&cNo tienes permiso para ejecutar este comando."));
                           return false;
                        }

                        if (var4.length == 1) {
                           var10001 = this.b;
                           var1.sendMessage(Main.a("&eDebes introducir una palabra clave."));
                           var10001 = this.b;
                           var1.sendMessage(Main.a("&eEjemplo: &7/pdc locate beginning"));
                           return false;
                        }

                        if (!var4[1].equalsIgnoreCase("beginning")) {
                           var10001 = this.b;
                           var1.sendMessage(Main.a("&cDebes introducir una palabra clave correcta."));
                           var10001 = this.b;
                           var1.sendMessage(Main.a("&eEjemplo: &7beginning"));
                           return false;
                        }

                        if (this.b.o() < 40L) {
                           var10001 = this.b;
                           var1.sendMessage(Main.a("&c&lERROR&7: &eNo existe el portal a The Beginning, por que estamos en el día &b" + this.b.o()));
                           return false;
                        }

                        if (this.b.j() == null) {
                           var10001 = this.b;
                           var1.sendMessage(Main.a("&c&lERROR&7: &eNo pudimos encontrar The Beginning, por favor reinicia el servidor."));
                           var10001 = this.b;
                           var1.sendMessage(Main.a("&bPasos para generar la dimensión:"));
                           var10001 = this.b;
                           var1.sendMessage(Main.a("&e1. Debería generarse cuando un jugador entra en el día indicado (40)"));
                           return false;
                        }

                        if (!(var1 instanceof Player)) {
                           if (!this.b.j().a()) {
                              var10001 = this.b;
                              var1.sendMessage(Main.a("&c&lERROR&7: &eNo se ha generado el portal a The Beginning aún, reinicia el servidor."));
                              return false;
                           }

                           var14 = (int)this.b.j().d().getX();
                           var17 = (int)this.b.j().d().getY();
                           var20 = (int)this.b.j().d().getZ();
                           var10001 = this.b;
                           var1.sendMessage(Main.a("&eCoordenadas del portal a The Beginning (overworld) &b" + var14 + " " + var17 + " " + var20));
                        } else {
                           var8 = (Player)var1;
                           if (var8.getWorld().getName().equalsIgnoreCase(this.b.h.getName())) {
                              if (!this.b.j().a()) {
                                 var10001 = this.b;
                                 var1.sendMessage(Main.a("&c&lERROR&7: &eNo se ha generado el portal a The Beginning aún, reinicia el servidor."));
                                 return false;
                              }

                              var17 = (int)this.b.j().d().getX();
                              var20 = (int)this.b.j().d().getY();
                              var11 = (int)this.b.j().d().getZ();
                              var10001 = this.b;
                              var1.sendMessage(Main.a("&eCoordenadas del portal a The Beginning (overworld) &b" + var17 + " " + var20 + " " + var11));
                           } else if (var8.getWorld().getName().equalsIgnoreCase("pdc_the_beginning")) {
                              if (!this.b.j().b()) {
                                 var10001 = this.b;
                                 var1.sendMessage(Main.a("&c&lERROR&7: &eNo se ha generado el portal a The Beginning aún, reinicia el servidor."));
                                 return false;
                              }

                              var17 = (int)this.b.j().c().getX();
                              var20 = (int)this.b.j().c().getY();
                              var11 = (int)this.b.j().c().getZ();
                              var10001 = this.b;
                              var1.sendMessage(Main.a("&eCoordenadas del portal a The Beginning (dimensión) &b" + var17 + " " + var20 + " " + var11));
                           } else {
                              var10001 = this.b;
                              var1.sendMessage(Main.a("&c&lERROR&7: &eEste comando no puede ser ejecutado en tu mundo actual."));
                              var10001 = this.b;
                              var1.sendMessage(Main.a("&eRecuerda escribir correctamente el nombre de los mundos en config.yml"));
                           }
                        }
                     } else if (var4[0].equalsIgnoreCase("give")) {
                        if (!(var1 instanceof Player)) {
                           var10001 = this.b;
                           var1.sendMessage(Main.a("&cNecesitas ser un jugador."));
                           return false;
                        }

                        var8 = (Player)var1;
                        if (!var8.hasPermission("permadeathcore.give")) {
                           var10001 = this.b;
                           var8.sendMessage(Main.a("&cNo tienes permisos."));
                           return false;
                        }

                        if (var4.length == 1) {
                           var10001 = this.b;
                           var8.sendMessage(Main.a("&ePor favor introduce el ítem deseado"));
                           var10001 = this.b;
                           var8.sendMessage(Main.a("&eEjemplos: &7medalla - netheriteArmor - infernalArmor - netheriteTools"));
                           return false;
                        }

                        var9 = var4[1];
                        if (var9.toLowerCase().equalsIgnoreCase("netheritearmor")) {
                           var8.getInventory().addItem(new ItemStack[]{this.b.g().a()});
                           var8.getInventory().addItem(new ItemStack[]{this.b.g().b()});
                           var8.getInventory().addItem(new ItemStack[]{this.b.g().c()});
                           var8.getInventory().addItem(new ItemStack[]{this.b.g().d()});
                           var10001 = this.b;
                           var8.sendMessage(Main.a("&eHas recibido la armadura de Netherite (comprueba no tener el inventario lleno)"));
                        } else if (var9.toLowerCase().equalsIgnoreCase("medalla")) {
                           Main var10000 = this.b;
                           var24 = Main.a("&4&l[&c&l☠&4&l] &e&ki &r&6&lMedalla de Superviviente &e&ki &r&4&l[&c&l☠&4&l]");
                           var8.getInventory().addItem(new ItemStack[]{(new com.permadeathcore.j.c.d(Material.TOTEM_OF_UNDYING)).a(true).a(ItemFlag.HIDE_UNBREAKABLE).c(var24).a()});
                           var10001 = this.b;
                           var8.sendMessage(Main.a("&eHas recibido la medalla de superviviente (comprueba no tener el inventario lleno)"));
                        } else if (var9.toLowerCase().equalsIgnoreCase("infernalarmor")) {
                           var8.getInventory().addItem(new ItemStack[]{this.b.h().a()});
                           var8.getInventory().addItem(new ItemStack[]{this.b.h().b()});
                           var8.getInventory().addItem(new ItemStack[]{this.b.h().c()});
                           var8.getInventory().addItem(new ItemStack[]{this.b.h().d()});
                           var10001 = this.b;
                           var8.sendMessage(Main.a("&eHas recibido la armadura de Netherite Infernal (comprueba no tener el inventario lleno)"));
                        } else if (var9.toLowerCase().equalsIgnoreCase("netheritetools")) {
                           var8.getInventory().addItem(new ItemStack[]{com.permadeathcore.j.c.a.f()});
                           var8.getInventory().addItem(new ItemStack[]{com.permadeathcore.j.c.a.e()});
                           var8.getInventory().addItem(new ItemStack[]{com.permadeathcore.j.c.a.h()});
                           var8.getInventory().addItem(new ItemStack[]{com.permadeathcore.j.c.a.i()});
                           var8.getInventory().addItem(new ItemStack[]{com.permadeathcore.j.c.a.g()});
                           var10001 = this.b;
                           var8.sendMessage(Main.a("&eHas recibido las herramientas de Netherite (comprueba no tener el inventario lleno)"));
                        } else {
                           var10001 = this.b;
                           var8.sendMessage(Main.a("&ePor favor introduce el ítem deseado"));
                           var10001 = this.b;
                           var8.sendMessage(Main.a("&eEjemplos: &7medalla - netheriteArmor - infernalArmor - netheriteTools"));
                        }
                     } else {
                        this.a(var1);
                     }
                  }
               }
            }
         }
      }

      return false;
   }

   private void a(CommandSender var1) {
      var1.sendMessage(this.b.g + ChatColor.RED + "Comandos disponibles:");
      var1.sendMessage(ChatColor.RED + "/pdc idioma <es, en>" + ChatColor.GRAY + ChatColor.ITALIC + "(Cambia tu idioma)");
      var1.sendMessage(ChatColor.RED + "/pdc dias " + ChatColor.GRAY + ChatColor.ITALIC + "(Muestra el día en el que está el plugin)");
      var1.sendMessage(ChatColor.RED + "/pdc cambios <día> " + ChatColor.GRAY + ChatColor.ITALIC + "(Te otorga la lista de cambios para cierto día.)");
      var1.sendMessage(ChatColor.RED + "/pdc duracion " + ChatColor.GRAY + ChatColor.ITALIC + "(Muestra la duración de la tormenta)");
      if (var1 instanceof Player) {
         var1.sendMessage(ChatColor.RED + "/pdc mensaje <mensaje> " + ChatColor.GRAY + ChatColor.ITALIC + "(Cambia tu mensaje de muerte)");
         var1.sendMessage(ChatColor.RED + "/pdc awake " + ChatColor.GRAY + ChatColor.ITALIC + "(Muestra el tiempo despierto)");
      }

      var1.sendMessage(ChatColor.RED + "/pdc info " + ChatColor.GRAY + ChatColor.ITALIC + "(Información general)");
      var1.sendMessage(ChatColor.RED + "/pdc discord " + ChatColor.GRAY + ChatColor.ITALIC + "(Discord oficial del plugin)");
      if (var1.hasPermission("permadeathcore.admin")) {
         var1.sendMessage("");
         var1.sendMessage(this.b.g + ChatColor.RED + "Comandos de administrador:");
         var1.sendMessage(ChatColor.RED + "/pdc cambiarDia <dia> " + ChatColor.GRAY + ChatColor.ITALIC + "(Cambia el día actual, pd: puede que requiera un reinicio)");
         var1.sendMessage(ChatColor.RED + "/pdc reload " + ChatColor.GRAY + ChatColor.ITALIC + "(Recarga el archivo config.yml)");
         var1.sendMessage(ChatColor.RED + "/pdc event <shulkershell> " + ChatColor.GRAY + ChatColor.ITALIC + "(Comienza un evento)");
         var1.sendMessage(ChatColor.RED + "/pdc locate <beginning> " + ChatColor.GRAY + ChatColor.ITALIC + "(Localiza el portal a The Beginning)");
         if (var1 instanceof Player) {
            var1.sendMessage(ChatColor.RED + "/pdc give <netheriteArmor, infernalArmor, netheriteTools> " + ChatColor.GRAY + ChatColor.ITALIC + "(Obtén ítems especiales de Permadeath)");
         }
      }

   }

   private void a(String[] var1, CommandSender var2) {
      Main var10001;
      try {
         if (var1.length == 1) {
            var10001 = this.b;
            var2.sendMessage(Main.a(this.b.g + "&eEl uso correcto de este comando es: &7/pdc cambios <día>"));
            return;
         }

         if (var1.length >= 2) {
            int var3 = Integer.parseInt(var1[1]);
            String var4 = "✓";
            String var5 = "❌";
            if (var3 < 1 || var3 > 60) {
               var10001 = this.b;
               var2.sendMessage(Main.a("&cNo hemos encontrado información para este día."));
               return;
            }

            var10001 = this.b;
            var2.sendMessage(Main.a(this.b.g + "&eMostrando cambios para el día: &7" + var3));
            if (var3 >= 1 && var3 <= 9) {
               var10001 = this.b;
               var2.sendMessage(Main.a(this.b.g + "&c&lNo hay cambios disponibles para este día (Minecraft Vanilla)"));
            }

            if (var3 >= 10 && var3 <= 19) {
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Ahora todas las arañas tienen efectos de poción."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Se necesitan mínimo &74 &a&ljugadores para pasar la noche."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&c&l" + var5 + " Doble de mobs (se necesita configurarlo en bukkit.yml)."));
            }

            if (var3 >= 20 && var3 <= 29) {
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Drops de Mobs eliminados (los de la lista oficial)."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " No se puede saltar la noche."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Pigmans enojados por defecto."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Ahora las arañas tienen 3 - 5 efectos."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " 1 de cada 100 Ravagers otorga un Tótem de la Inmortalidad."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Ahora los Phantoms son de tamaño 9 y tienen el doble de vida."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Arañas con un esqueleto de clase."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Entidades pacíficas agresivas."));
            }

            if (var3 >= 25 && var3 <= 29) {
               var10001 = this.b;
               var2.sendMessage(Main.a("&e&lCAMBIOS EXTRAS PARA EL DÍA 25"));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Death Train Reset (y este otorga efectos a los mobs)"));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Ahora todas las arañas tienen 5 efectos."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Ahora los Ravagers tienen Fuerza II y Velocidad I, con un 20% de Drop de Tótem."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " GigaSlimes, GigaMagmaCubes y Ghasts Demoníacos."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Armadura de Netherite."));
            }

            if (var3 >= 30 && var3 <= 39) {
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Ahora todos los esqueletos tienen clases y llevan una flecha de daño II."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Ya no se puede obtener la armadura de Netherite."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Los calamares son guardianes con Speed II."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Los murciélagos son blazes con resistencia II"));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Ahora los Creepers son eléctricos"));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Los Pillagers ahora son invisibles."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Los Pigmans ahora tienen armadura de Diamante."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Los Gólems ahora tienen Velocidad IV."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Los Silverfish y Endermites tienen 5 efectos, de la misma lista que las arañas"));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Los Shulkers ahora son Shulkers Explosivos y poseen un 20% de dropear un Shulker Shell."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Aparecen Ender Creepers y Ender Ghasts en el End"));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " La batalla contra el Ender Dragon está completamente modificada."));
               var10001 = this.b;
               var2.sendMessage(Main.a("&a&l" + var4 + " Ahora los Tótems tienen 1% de fallar (puedes configurarlo en la configuración a tu gusto)"));
            }

            if (var3 >= 40 && var3 <= 49) {
               if (var1.length == 2) {
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Todos los jugadores pierden 5 slots de su inventario."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Se habilita el fuego amigo."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Ya no se pueden craftear Antorchas / Antorchas de Redstone."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Todos los jugadores pierden 4 contenedores de vida."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Los Tótems tienen 3% de fallar y al activarse consumen 2 en lugar de 1."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Las Elytras en los Barcos ahora aparecen rotas."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Ahora los Shulkers dropean Shells con un 2%."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Ahora los Phantoms llevan encima un esqueleto de clase."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Los Creepers ahora tienen Velocidad II y Resistencia II."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Los Guardianes ahora tienen Velocidad II y Resistencia III y su rayo es el doble de rápido."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Las arañas ahora son arañas de cueva."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Los Zombies son Vindicators con Fuerza I y doble de vida."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Los Perros ahora son Gatos."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Las vacas, ovejas, cerdos, pollos y vacasetas ahora son Ravagers"));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Los Endermans del Nether son ahora Ender Creepers."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&2&lPÁGINA 1/2 &f&l- &7Si deseas ver la página 2 de los cambios escribe: /pdc cambios" + var3 + " 2"));
               } else {
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " La Tormenta puede dar ceguera."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Super Golden Apple+ & Hyper Golden Apple+"));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Los gatos ahora son Gatos Supernova."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Reliquia del Fin (elimina la maldición de la pérdida de slots)."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Se pueden descraftear los shulkers."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&e&l" + var4 + " El Portal a The Beginning será generado el día 50"));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&c&l" + var4 + " El 75% de los Ghasts Demoníacos son Demonios Flotantes,"));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Pigman Jockeys."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Jess la Emperatriz."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " El 1% de los Endermans spawnea hostil."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Las Brujas son ahora Brujas Imposibles."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&2&lPÁGINA 2/2 &f&l- &7Si deseas ver la página 1 de los cambios escribe: /pdc cambios" + var3 + " 1"));
               }
            }

            if (var3 >= 50 && var3 <= 59) {
               if (var1.length == 2) {
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " The Beginning (y sus respectivos mobs)."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Bacalao de la Muerte."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Gatos Galácticos."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Ya no se pueden obtener cubos de agua / lava."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&e&l- Los tótems tienen un 5% de fallar y estos consumen 3."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Las Raid dan Hero of The Village durante 5min."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Picar bloques quitan medio corazón cada uno."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Fundir Hierro y Oro da Pepitas."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Te ahogas 5 veces más rápido."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Estar en Soulsand da Lentitud II."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Al estar en el overworld puedes obtener Levitación de 3 a 20 segundos por las noches."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " En el Nether ahora llueven mobs."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Hay más probabilidad de recibir ceguera por la lluvia."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Ahora los mobs hostiles tienen resistencia contra el fuego."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Las Arañas de Cueva ya no pueden tener Glowing."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&2&lPÁGINA 1/2 &f&l- &7Si deseas ver la página 2 de los cambios escribe: /pdc cambios" + var3 + " 2"));
               } else {
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Los Creepers Eléctricos son ahora Quantum Creepers y el 20% son Ender Creepers."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Los Phantoms son GigaPhantoms y tienen 1/100 de que aparezcan 4 Ender Ghasts."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Los Pollos ahora son Silverfishs."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " El 20% de los Pigmans son ahora Pigmans Jockeys, los drops están al 33%."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " El 1% de los Pillagers son Evokers."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Los Gólems de Hierro tienen ahora Resistencia II."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Ahora los Ahogados Siempre llevan un Tridente."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Las abejas hacen 15 de daño base."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " El Efecto Fatiga Minera no se puede quitar con Leche y dura el doble."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Dormir tiene un 10% de reiniciar el contador de Phatnoms."));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Armadura de Netherite Infernal"));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Reset del Death Train (de nuevo)"));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Gigantes"));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&a&l" + var4 + " Wither Skeleton Emperador"));
                  var10001 = this.b;
                  var2.sendMessage(Main.a("&2&lPÁGINA 2/2 &f&l- &7Si deseas ver la página 1 de los cambios escribe: /pdc cambios" + var3 + " 1"));
               }
            }

            if (var3 == 60) {
               var10001 = this.b;
               var2.sendMessage(Main.a("&c&l" + var5 + " PRONTO"));
            }
         }
      } catch (ArrayIndexOutOfBoundsException | NumberFormatException var6) {
         var10001 = this.b;
         var2.sendMessage(Main.a(this.b.g + "&c¡Vaya!, parece que &7" + var1[2] + " &cno es un número, prueba con: &e1, 5, 10"));
      }

   }
}
