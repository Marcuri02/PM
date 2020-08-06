package com.permadeathcore.g.a;

import com.permadeathcore.Main;
import com.permadeathcore.g.l;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Vindicator;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.world.ChunkLoadEvent;

public class a implements Listener {
   private Main a;
   private ArrayList b = new ArrayList();

   public a(Main var1) {
      this.a = var1;
      this.a();
   }

   public void a() {
      if (this.a.o() >= 20L) {
         Iterator var1 = Bukkit.getWorlds().iterator();

         while(var1.hasNext()) {
            World var2 = (World)var1.next();
            Iterator var3 = var2.getEntities().iterator();

            while(var3.hasNext()) {
               Entity var4 = (Entity)var3.next();
               EntityType var5 = var4.getType();
               if (!this.a(var5) && var4 instanceof LivingEntity) {
                  if (var5 == EntityType.ENDERMAN || var5 == EntityType.WITHER || var5 == EntityType.ENDER_DRAGON) {
                     return;
                  }

                  if (var5 == EntityType.DOLPHIN || var5 == EntityType.FOX || var5 == EntityType.WOLF || var5 == EntityType.CAT || var5 == EntityType.OCELOT || var5 == EntityType.PANDA || var5 == EntityType.POLAR_BEAR || var5 == EntityType.SNOWMAN) {
                     this.a.n().d(var4);
                     this.a(var4);
                     return;
                  }

                  this.a.n().d(var4);
                  this.a.n().a(Attribute.GENERIC_ATTACK_DAMAGE, 8.0D, var4);
                  this.a(var4);
               }
            }
         }
      }

   }

   private void a(Entity var1) {
   }

   public void b() {
   }

   @EventHandler
   public void a(CreatureSpawnEvent var1) {
      if (!var1.isCancelled()) {
         if (this.a.o() >= 20L) {
            LivingEntity var2 = var1.getEntity();
            if (var2 instanceof LivingEntity) {
               if (var2 instanceof Player) {
                  return;
               }

               if (!this.a(var1.getEntityType())) {
                  EntityType var3 = var1.getEntityType();
                  if (var3 == EntityType.ENDERMAN || var3 == EntityType.WITHER || var3 == EntityType.ENDER_DRAGON) {
                     return;
                  }

                  if (var3 == EntityType.DOLPHIN || var3 == EntityType.FOX || var3 == EntityType.WOLF || var3 == EntityType.CAT || var3 == EntityType.OCELOT || var3 == EntityType.PANDA || var3 == EntityType.POLAR_BEAR || var3 == EntityType.SNOWMAN) {
                     this.a.n().d(var2);
                     this.a((Entity)var2);
                     return;
                  }

                  this.a.n().d(var2);
                  this.a.n().a((Attribute)Attribute.GENERIC_ATTACK_DAMAGE, (Double)8.0D, (Entity)var2);
                  this.a((Entity)var2);
               }
            }
         }

      }
   }

   @EventHandler
   public void a(ChunkLoadEvent var1) {
      if (this.a.o() >= 20L) {
         if (!var1.isNewChunk()) {
            if (var1.getChunk().getEntities().length >= 1) {
               Entity[] var2 = var1.getChunk().getEntities();
               int var3 = var2.length;

               for(int var4 = 0; var4 < var3; ++var4) {
                  Entity var5 = var2[var4];
                  boolean var6 = false;
                  if (var5 == null) {
                     var6 = true;
                     return;
                  }

                  if (!var5.isValid() || var5.isDead()) {
                     var6 = true;
                  }

                  if (var5 instanceof Villager && this.a.o() >= 60L) {
                     Location var8 = var5.getLocation();
                     var5.remove();
                     var8.getWorld().spawn(var8, Vindicator.class);
                     return;
                  }

                  if (var5 instanceof LivingEntity && !var6) {
                     if (var5 instanceof Player) {
                        return;
                     }

                     EntityType var7 = var5.getType();
                     if (!this.a(var7)) {
                        if (var7 == EntityType.ENDERMAN || var7 == EntityType.WITHER || var7 == EntityType.ENDER_DRAGON) {
                           return;
                        }

                        if (var7 == EntityType.DOLPHIN || var7 == EntityType.FOX || var7 == EntityType.WOLF || var7 == EntityType.CAT || var7 == EntityType.OCELOT || var7 == EntityType.PANDA || var7 == EntityType.POLAR_BEAR || var7 == EntityType.SNOWMAN) {
                           this.a.n().d(var5);
                           this.a(var5);
                           return;
                        }

                        this.a.n().d(var5);
                        this.a.n().a(Attribute.GENERIC_ATTACK_DAMAGE, 8.0D, var5);
                        this.a(var5);
                     }
                  }
               }

            }
         }
      }
   }

   private void a(LivingEntity var1, Location var2, CreatureSpawnEvent var3) {
      boolean var5 = false;
      boolean var6 = false;
      if (var1 == null) {
         var6 = true;
      }

      if (!var1.isValid() || var1.isDead()) {
         var6 = true;
      }

      if (var3 != null && var3.getSpawnReason() == SpawnReason.BEEHIVE) {
         var5 = true;
      }

      if (!var5 && !var6) {
         String var4;
         String var7;
         String[] var8;
         String var9;
         String var10;
         boolean var26;
         Class var28;
         if (var1.getType() == EntityType.VILLAGER) {
            var7 = var1.getType().toString().toLowerCase();
            if (var7.contains("_")) {
               var8 = var7.split("_");
               var9 = var8[0].toLowerCase();
               var10 = var8[1].toLowerCase();
               var4 = StringUtils.capitalize(var9) + StringUtils.capitalize(var10);
            } else {
               var4 = StringUtils.capitalize(var7);
            }

            Villager var27 = (Villager)var1;
            var26 = true;

            try {
               var28 = Class.forName("com.permadeathcore.NMS.EntityRegistry.Entities.v" + l.a() + ".Hostile" + var4);
               var28.getConstructor(Location.class, Main.p().f().a("EntityTypes"), Villager.class).newInstance(var2, Main.p().f().a(var1.getType()), var27);
            } catch (NoSuchMethodException | ClassNotFoundException var15) {
               var26 = false;
            } catch (IllegalAccessException var16) {
            } catch (InstantiationException var17) {
            } catch (InvocationTargetException var18) {
            }

            if (var3 != null) {
               if (var26) {
                  var3.setCancelled(true);
               }
            } else if (var26) {
               var1.remove();
            }
         } else if (var1.getType() == EntityType.WANDERING_TRADER) {
            var7 = var1.getType().toString().toLowerCase();
            if (var7.contains("_")) {
               var8 = var7.split("_");
               var9 = var8[0].toLowerCase();
               var10 = var8[1].toLowerCase();
               var4 = StringUtils.capitalize(var9) + StringUtils.capitalize(var10);
            } else {
               var4 = StringUtils.capitalize(var7);
            }

            WanderingTrader var25 = (WanderingTrader)var1;
            var26 = true;

            try {
               var28 = Class.forName("com.permadeathcore.NMS.EntityRegistry.Entities.v" + l.a() + ".Hostile" + var4);
               var28.getConstructor(Location.class, Main.p().f().a("EntityTypes"), WanderingTrader.class).newInstance(var2, Main.p().f().a(var1.getType()), var25);
            } catch (NoSuchMethodException | ClassNotFoundException var11) {
               var26 = false;
            } catch (IllegalAccessException var12) {
            } catch (InstantiationException var13) {
            } catch (InvocationTargetException var14) {
            }

            if (var3 != null) {
               if (var26) {
                  var3.setCancelled(true);
               }
            } else if (var26) {
               var1.remove();
            }
         } else {
            var7 = var1.getType().toString().toLowerCase();
            if (var7.contains("_")) {
               var8 = var7.split("_");
               var9 = var8[0].toLowerCase();
               var10 = var8[1].toLowerCase();
               var4 = StringUtils.capitalize(var9) + StringUtils.capitalize(var10);
            } else {
               var4 = StringUtils.capitalize(var7);
            }

            boolean var23 = true;

            try {
               if (var4.toLowerCase().contains("bee") && l.a().equalsIgnoreCase("1_14_R1")) {
                  return;
               }

               if (var4.toLowerCase().contains("cod") && this.a.o() >= 50L) {
                  return;
               }

               Class var24 = Class.forName("com.permadeathcore.NMS.EntityRegistry.Entities.v" + l.a() + ".Hostile" + var4);
               if (var4.toLowerCase().contains("bat") || var4.toLowerCase().contains("cod") || var4.toLowerCase().contains("salmon") || var4.toLowerCase().contains("squid") || var4.toLowerCase().contains("pufferfish") || var4.toLowerCase().contains("tropicalfish")) {
                  if ((new Random()).nextInt(499) <= 10) {
                     var24.getConstructor(Location.class, Main.p().f().a("EntityTypes")).newInstance(var2, Main.p().f().a(var1.getType()));
                  }

                  return;
               }

               var24.getConstructor(Location.class, Main.p().f().a("EntityTypes")).newInstance(var2, Main.p().f().a(var1.getType()));
            } catch (NoSuchMethodException | ClassNotFoundException var19) {
               var23 = false;
            } catch (IllegalAccessException var20) {
            } catch (InstantiationException var21) {
            } catch (InvocationTargetException var22) {
            }

            if (var3 != null) {
               if (var23) {
                  var3.setCancelled(true);
               }
            } else if (var23) {
               var1.remove();
            }
         }

      }
   }

   public boolean a(EntityType var1) {
      return var1 == EntityType.ENDER_DRAGON || var1 == EntityType.WITHER || var1 == EntityType.BLAZE || var1 == EntityType.CREEPER || var1 == EntityType.GHAST || var1 == EntityType.MAGMA_CUBE || var1 == EntityType.SILVERFISH || var1 == EntityType.SKELETON || var1 == EntityType.SLIME || var1 == EntityType.ZOMBIE || var1 == EntityType.ZOMBIE_VILLAGER || var1 == EntityType.DROWNED || var1 == EntityType.WITHER_SKELETON || var1 == EntityType.WITCH || var1 == EntityType.PILLAGER || var1 == EntityType.EVOKER || var1 == EntityType.VINDICATOR || var1 == EntityType.RAVAGER || var1 == EntityType.VEX || var1 == EntityType.GUARDIAN || var1 == EntityType.ELDER_GUARDIAN || var1 == EntityType.SHULKER || var1 == EntityType.HUSK || var1 == EntityType.STRAY || var1 == EntityType.PHANTOM;
   }
}
