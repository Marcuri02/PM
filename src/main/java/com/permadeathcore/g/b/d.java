package com.permadeathcore.g.b;

import com.permadeathcore.Main;
import com.permadeathcore.CustomMobs.v1_14_R1.CustomCreeper;
import com.permadeathcore.CustomMobs.v1_14_R1.CustomGhast;
import com.permadeathcore.g.l;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import net.minecraft.server.v1_14_R1.BlockPosition;
import net.minecraft.server.v1_14_R1.ChatMessageType;
import net.minecraft.server.v1_14_R1.EntityHuman;
import net.minecraft.server.v1_14_R1.EntityTypes;
import net.minecraft.server.v1_14_R1.EntityWither;
import net.minecraft.server.v1_14_R1.EnumMobSpawn;
import net.minecraft.server.v1_14_R1.GenericAttributes;
import net.minecraft.server.v1_14_R1.IChatBaseComponent;
import net.minecraft.server.v1_14_R1.NBTTagCompound;
import net.minecraft.server.v1_14_R1.PacketPlayOutChat;
import net.minecraft.server.v1_14_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_14_R1.World;
import net.minecraft.server.v1_14_R1.WorldServer;
import net.minecraft.server.v1_14_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_14_R1.PacketPlayOutTitle.EnumTitleAction;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_14_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.persistence.PersistentDataType;

public class d implements com.permadeathcore.g.c {
   public Class c(String var1) {
      Class var2 = null;

      try {
         var2 = Class.forName("org.bukkit.craftbukkit.v1_14_R1.entity." + var1);
      } catch (ClassNotFoundException var4) {
         var4.printStackTrace();
      }

      return var2;
   }

   public EntityType a(Object var1) {
      EntityTypes var2 = (EntityTypes)var1;
      if (var2 != null) {
         if (var2 == EntityTypes.IRON_GOLEM) {
            return EntityType.IRON_GOLEM;
         }

         if (var2 == EntityTypes.SNOW_GOLEM) {
            return EntityType.SNOWMAN;
         }

         if (var2 == EntityTypes.WITHER) {
            return EntityType.WITHER;
         }

         if (var2 == EntityTypes.CHICKEN) {
            return EntityType.CHICKEN;
         }

         if (var2 == EntityTypes.COW) {
            return EntityType.COW;
         }

         if (var2 == EntityTypes.MOOSHROOM) {
            return EntityType.MUSHROOM_COW;
         }

         if (var2 == EntityTypes.PIG) {
            return EntityType.PIG;
         }

         if (var2 == EntityTypes.SHEEP) {
            return EntityType.SHEEP;
         }

         if (var2 == EntityTypes.SQUID) {
            return EntityType.SQUID;
         }

         if (var2 == EntityTypes.VILLAGER) {
            return EntityType.VILLAGER;
         }

         if (var2 == EntityTypes.WANDERING_TRADER) {
            return EntityType.WANDERING_TRADER;
         }

         if (var2 == EntityTypes.BAT) {
            return EntityType.BAT;
         }

         if (var2 == EntityTypes.OCELOT) {
            return EntityType.OCELOT;
         }

         if (var2 == EntityTypes.CAT) {
            return EntityType.CAT;
         }

         if (var2 == EntityTypes.DONKEY) {
            return EntityType.DONKEY;
         }

         if (var2 == EntityTypes.HORSE) {
            return EntityType.HORSE;
         }

         if (var2 == EntityTypes.MULE) {
            return EntityType.MULE;
         }

         if (var2 == EntityTypes.SKELETON_HORSE) {
            return EntityType.SKELETON_HORSE;
         }

         if (var2 == EntityTypes.ZOMBIE_HORSE) {
            return EntityType.ZOMBIE_HORSE;
         }

         if (var2 == EntityTypes.WOLF) {
            return EntityType.WOLF;
         }

         if (var2 == EntityTypes.FOX) {
            return EntityType.FOX;
         }

         if (var2 == EntityTypes.RABBIT) {
            return EntityType.RABBIT;
         }

         if (var2 == EntityTypes.PARROT) {
            return EntityType.PARROT;
         }

         if (var2 == EntityTypes.TURTLE) {
            return EntityType.TURTLE;
         }

         if (var2 == EntityTypes.COD) {
            return EntityType.COD;
         }

         if (var2 == EntityTypes.SALMON) {
            return EntityType.SALMON;
         }

         if (var2 == EntityTypes.PUFFERFISH) {
            return EntityType.PUFFERFISH;
         }

         if (var2 == EntityTypes.TROPICAL_FISH) {
            return EntityType.TROPICAL_FISH;
         }

         if (var2 == EntityTypes.ZOMBIE) {
            return EntityType.ZOMBIE;
         }

         if (var2 == EntityTypes.ENDERMAN) {
            return EntityType.ENDERMAN;
         }

         if (var2 == EntityTypes.DOLPHIN) {
            return EntityType.DOLPHIN;
         }

         if (var2 == EntityTypes.SPIDER) {
            return EntityType.SPIDER;
         }

         if (var2 == EntityTypes.CAVE_SPIDER) {
            return EntityType.CAVE_SPIDER;
         }

         if (var2 == EntityTypes.POLAR_BEAR) {
            return EntityType.POLAR_BEAR;
         }

         if (var2 == EntityTypes.LLAMA) {
            return EntityType.LLAMA;
         }

         if (var2 == EntityTypes.PANDA) {
            return EntityType.PANDA;
         }

         if (var2 == EntityTypes.BLAZE) {
            return EntityType.BLAZE;
         }

         if (var2 == EntityTypes.CREEPER) {
            return EntityType.CREEPER;
         }

         if (var2 == EntityTypes.GHAST) {
            return EntityType.GHAST;
         }

         if (var2 == EntityTypes.MAGMA_CUBE) {
            return EntityType.MAGMA_CUBE;
         }

         if (var2 == EntityTypes.SILVERFISH) {
            return EntityType.SILVERFISH;
         }

         if (var2 == EntityTypes.SKELETON) {
            return EntityType.SKELETON;
         }

         if (var2 == EntityTypes.SLIME) {
            return EntityType.SLIME;
         }

         if (var2 == EntityTypes.ZOMBIE_VILLAGER) {
            return EntityType.ZOMBIE_VILLAGER;
         }

         if (var2 == EntityTypes.DROWNED) {
            return EntityType.DROWNED;
         }

         if (var2 == EntityTypes.WITHER_SKELETON) {
            return EntityType.WITHER_SKELETON;
         }

         if (var2 == EntityTypes.VINDICATOR) {
            return EntityType.VINDICATOR;
         }

         if (var2 == EntityTypes.EVOKER) {
            return EntityType.EVOKER;
         }

         if (var2 == EntityTypes.PILLAGER) {
            return EntityType.PILLAGER;
         }

         if (var2 == EntityTypes.RAVAGER) {
            return EntityType.RAVAGER;
         }

         if (var2 == EntityTypes.WITCH) {
            return EntityType.WITCH;
         }

         if (var2 == EntityTypes.VEX) {
            return EntityType.VEX;
         }

         if (var2 == EntityTypes.ENDERMITE) {
            return EntityType.ENDERMITE;
         }

         if (var2 == EntityTypes.GUARDIAN) {
            return EntityType.GUARDIAN;
         }

         if (var2 == EntityTypes.ELDER_GUARDIAN) {
            return EntityType.ELDER_GUARDIAN;
         }

         if (var2 == EntityTypes.SHULKER) {
            return EntityType.SHULKER;
         }

         if (var2 == EntityTypes.HUSK) {
            return EntityType.HUSK;
         }

         if (var2 == EntityTypes.STRAY) {
            return EntityType.STRAY;
         }

         if (var2 == EntityTypes.PHANTOM) {
            return EntityType.PHANTOM;
         }
      }

      return null;
   }

   public Class a() {
      Class var1 = null;

      try {
         var1 = Class.forName("net.minecraft.server.v1_14_R1.EntityTypes");
      } catch (ClassNotFoundException var3) {
         var3.printStackTrace();
      }

      return var1;
   }

   public Class a(String var1) {
      try {
         return Class.forName("net.minecraft.server.v1_14_R1." + var1);
      } catch (ClassNotFoundException var3) {
         var3.printStackTrace();
         return null;
      }
   }

   public EntityTypes b(EntityType var1) {
      if (var1 == EntityType.IRON_GOLEM) {
         return EntityTypes.IRON_GOLEM;
      } else if (var1 == EntityType.SNOWMAN) {
         return EntityTypes.SNOW_GOLEM;
      } else if (var1 == EntityType.WITHER) {
         return EntityTypes.WITHER;
      } else if (var1 == EntityType.CHICKEN) {
         return EntityTypes.CHICKEN;
      } else if (var1 == EntityType.COW) {
         return EntityTypes.COW;
      } else if (var1 == EntityType.MUSHROOM_COW) {
         return EntityTypes.MOOSHROOM;
      } else if (var1 == EntityType.PIG) {
         return EntityTypes.PIG;
      } else if (var1 == EntityType.SHEEP) {
         return EntityTypes.SHEEP;
      } else if (var1 == EntityType.SQUID) {
         return EntityTypes.SQUID;
      } else if (var1 == EntityType.VILLAGER) {
         return EntityTypes.VILLAGER;
      } else if (var1 == EntityType.WANDERING_TRADER) {
         return EntityTypes.WANDERING_TRADER;
      } else if (var1 == EntityType.BAT) {
         return EntityTypes.BAT;
      } else if (var1 == EntityType.OCELOT) {
         return EntityTypes.OCELOT;
      } else if (var1 == EntityType.CAT) {
         return EntityTypes.CAT;
      } else if (var1 == EntityType.DONKEY) {
         return EntityTypes.DONKEY;
      } else if (var1 == EntityType.HORSE) {
         return EntityTypes.HORSE;
      } else if (var1 == EntityType.MULE) {
         return EntityTypes.MULE;
      } else if (var1 == EntityType.SKELETON_HORSE) {
         return EntityTypes.SKELETON_HORSE;
      } else if (var1 == EntityType.ZOMBIE_HORSE) {
         return EntityTypes.ZOMBIE_HORSE;
      } else if (var1 == EntityType.WOLF) {
         return EntityTypes.WOLF;
      } else if (var1 == EntityType.FOX) {
         return EntityTypes.FOX;
      } else if (var1 == EntityType.RABBIT) {
         return EntityTypes.RABBIT;
      } else if (var1 == EntityType.PARROT) {
         return EntityTypes.PARROT;
      } else if (var1 == EntityType.TURTLE) {
         return EntityTypes.TURTLE;
      } else if (var1 == EntityType.COD) {
         return EntityTypes.COD;
      } else if (var1 == EntityType.SALMON) {
         return EntityTypes.SALMON;
      } else if (var1 == EntityType.PUFFERFISH) {
         return EntityTypes.PUFFERFISH;
      } else if (var1 == EntityType.TROPICAL_FISH) {
         return EntityTypes.TROPICAL_FISH;
      } else if (var1 == EntityType.ZOMBIE) {
         return EntityTypes.ZOMBIE;
      } else if (var1 == EntityType.ENDERMAN) {
         return EntityTypes.ENDERMAN;
      } else if (var1 == EntityType.DOLPHIN) {
         return EntityTypes.DOLPHIN;
      } else if (var1 == EntityType.SPIDER) {
         return EntityTypes.SPIDER;
      } else if (var1 == EntityType.CAVE_SPIDER) {
         return EntityTypes.CAVE_SPIDER;
      } else if (var1 == EntityType.POLAR_BEAR) {
         return EntityTypes.POLAR_BEAR;
      } else if (var1 == EntityType.LLAMA) {
         return EntityTypes.LLAMA;
      } else if (var1 == EntityType.PANDA) {
         return EntityTypes.PANDA;
      } else if (var1 == EntityType.BLAZE) {
         return EntityTypes.BLAZE;
      } else if (var1 == EntityType.CREEPER) {
         return EntityTypes.CREEPER;
      } else if (var1 == EntityType.GHAST) {
         return EntityTypes.GHAST;
      } else if (var1 == EntityType.MAGMA_CUBE) {
         return EntityTypes.MAGMA_CUBE;
      } else if (var1 == EntityType.SILVERFISH) {
         return EntityTypes.SILVERFISH;
      } else if (var1 == EntityType.SKELETON) {
         return EntityTypes.SKELETON;
      } else if (var1 == EntityType.SLIME) {
         return EntityTypes.SLIME;
      } else if (var1 == EntityType.ZOMBIE_VILLAGER) {
         return EntityTypes.ZOMBIE_VILLAGER;
      } else if (var1 == EntityType.DROWNED) {
         return EntityTypes.DROWNED;
      } else if (var1 == EntityType.WITHER_SKELETON) {
         return EntityTypes.WITHER_SKELETON;
      } else if (var1 == EntityType.VINDICATOR) {
         return EntityTypes.VINDICATOR;
      } else if (var1 == EntityType.EVOKER) {
         return EntityTypes.EVOKER;
      } else if (var1 == EntityType.PILLAGER) {
         return EntityTypes.PILLAGER;
      } else if (var1 == EntityType.RAVAGER) {
         return EntityTypes.RAVAGER;
      } else if (var1 == EntityType.WITCH) {
         return EntityTypes.WITCH;
      } else if (var1 == EntityType.VEX) {
         return EntityTypes.VEX;
      } else if (var1 == EntityType.ENDERMITE) {
         return EntityTypes.ENDERMITE;
      } else if (var1 == EntityType.GUARDIAN) {
         return EntityTypes.GUARDIAN;
      } else if (var1 == EntityType.ELDER_GUARDIAN) {
         return EntityTypes.ELDER_GUARDIAN;
      } else if (var1 == EntityType.SHULKER) {
         return EntityTypes.SHULKER;
      } else if (var1 == EntityType.HUSK) {
         return EntityTypes.HUSK;
      } else if (var1 == EntityType.STRAY) {
         return EntityTypes.STRAY;
      } else {
         return var1 == EntityType.PHANTOM ? EntityTypes.PHANTOM : null;
      }
   }

   public void a(Player var1, String var2) {
      IChatBaseComponent var3 = ChatSerializer.a("{\"text\": \"" + var2 + "\"}");
      PacketPlayOutChat var4 = new PacketPlayOutChat(var3, ChatMessageType.GAME_INFO);
      CraftPlayer var5 = (CraftPlayer)var1;
      var5.getHandle().playerConnection.sendPacket(var4);
   }

   public void a(Player var1, String var2, String var3, int var4, int var5, int var6) {
      IChatBaseComponent var7 = ChatSerializer.a("{\"text\": \"" + var2 + "\"}");
      IChatBaseComponent var8 = ChatSerializer.a("{\"text\": \"" + var3 + "\"}");
      PacketPlayOutTitle var9 = new PacketPlayOutTitle(EnumTitleAction.TITLE, var7);
      PacketPlayOutTitle var10 = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, var8);
      PacketPlayOutTitle var11 = new PacketPlayOutTitle(var4, var5, var6);
      ((CraftPlayer)var1).getHandle().playerConnection.sendPacket(var9);
      ((CraftPlayer)var1).getHandle().playerConnection.sendPacket(var10);
      ((CraftPlayer)var1).getHandle().playerConnection.sendPacket(var11);
   }

   public Entity a(String var1, EntityType var2, Location var3, SpawnReason var4) {
      WorldServer var5 = ((CraftWorld)var3.getWorld()).getHandle();
      net.minecraft.server.v1_14_R1.Entity var6 = null;

      try {
         if (var1.toLowerCase().contains("bee") && l.a().equalsIgnoreCase("1_14_R1")) {
            return null;
         }

         Class var7 = this.a("Entity" + var1);
         if (!var1.toLowerCase().contains("bat") && !var1.toLowerCase().contains("cod") && !var1.toLowerCase().contains("salmon") && !var1.toLowerCase().contains("squid") && !var1.toLowerCase().contains("pufferfish") && !var1.toLowerCase().contains("tropicalfish")) {
            var6 = (net.minecraft.server.v1_14_R1.Entity)var7.getConstructor(this.a("EntityTypes"), this.a("World")).newInstance(this.b(var2), var5);
         } else if (var4 == SpawnReason.SPAWNER_EGG) {
            if ((new Random()).nextInt(499) <= 10) {
               var6 = (net.minecraft.server.v1_14_R1.Entity)var7.getConstructor(this.a("EntityTypes"), this.a("World")).newInstance(this.b(var2), var5);
            }
         } else {
            var6 = (net.minecraft.server.v1_14_R1.Entity)var7.getConstructor(this.a("EntityTypes"), this.a("World")).newInstance(this.b(var2), var5);
         }
      } catch (NoSuchMethodException var8) {
      } catch (IllegalAccessException var9) {
      } catch (InstantiationException var10) {
      } catch (InvocationTargetException var11) {
      }

      if (var6 == null) {
         return null;
      } else {
         var6.setPositionRotation(var3.getX(), var3.getY(), var3.getZ(), var3.getYaw(), var3.getPitch());
         var5.addEntity(var6, var4);
         return var6 == null ? null : var6.getBukkitEntity();
      }
   }

   public Entity a(Location var1) {
      WorldServer var2 = ((CraftWorld)var1.getWorld()).getHandle();
      NBTTagCompound var3 = new NBTTagCompound();
      var3.setInt("Invul", 160);
      EntityWither var4 = (EntityWither)EntityTypes.WITHER.spawnCreature(var2, var3, (IChatBaseComponent)null, (EntityHuman)null, new BlockPosition(var1.getBlockX(), var1.getBlockY(), var1.getBlockZ()), EnumMobSpawn.EVENT, true, false);
      return var4 == null ? null : var4.getBukkitEntity();
   }

   public Entity a(EntityType var1, Location var2, SpawnReason var3) {
      String var5 = var1.toString().toLowerCase();
      net.minecraft.server.v1_14_R1.Entity var6 = null;
      String var4;
      if (var5.contains("_")) {
         String[] var7 = var5.split("_");
         String var8 = var7[0].toLowerCase();
         String var9 = var7[1].toLowerCase();
         var4 = StringUtils.capitalize(var8) + StringUtils.capitalize(var9);
      } else {
         var4 = StringUtils.capitalize(var5);
      }

      try {
         if (var4.toLowerCase().contains("bee") && l.a().equalsIgnoreCase("1_14_R1")) {
            return null;
         }

         if (var4.toLowerCase().contains("cod") && Main.p().o() >= 50L) {
            return null;
         }

         Class var14 = Class.forName("com.permadeathcore.NMS.EntityRegistry.Entities.v" + l.a() + ".Hostile" + var4);
         if (!var4.toLowerCase().contains("villager") && !var4.toLowerCase().contains("wanderingtrader")) {
            if (!var4.toLowerCase().contains("bat") && !var4.toLowerCase().contains("cod") && !var4.toLowerCase().contains("salmon") && !var4.toLowerCase().contains("squid") && !var4.toLowerCase().contains("pufferfish") && !var4.toLowerCase().contains("tropicalfish")) {
               var6 = (net.minecraft.server.v1_14_R1.Entity)var14.getConstructor(Location.class, Main.p().f().a("EntityTypes")).newInstance(var2, Main.p().f().a(var1));
            } else if ((new Random()).nextInt(499) <= 10) {
               var6 = (net.minecraft.server.v1_14_R1.Entity)var14.getConstructor(Location.class, Main.p().f().a("EntityTypes")).newInstance(var2, Main.p().f().a(var1));
            }
         } else if (var4.toLowerCase().contains("villager")) {
            var6 = (net.minecraft.server.v1_14_R1.Entity)var14.getConstructor(Location.class, Main.p().f().a("EntityTypes"), Villager.class).newInstance(var2, Main.p().f().a(var1), null);
         } else {
            var6 = (net.minecraft.server.v1_14_R1.Entity)var14.getConstructor(Location.class, Main.p().f().a("EntityTypes"), WanderingTrader.class).newInstance(var2, Main.p().f().a(var1), null);
         }
      } catch (NoSuchMethodException | ClassNotFoundException var10) {
      } catch (IllegalAccessException var11) {
      } catch (InstantiationException var12) {
      } catch (InvocationTargetException var13) {
      }

      return var6 == null ? null : var6.getBukkitEntity();
   }

   public Entity b(String var1, EntityType var2, Location var3, SpawnReason var4) {
      WorldServer var5 = ((CraftWorld)var3.getWorld()).getHandle();
      net.minecraft.server.v1_14_R1.Entity var6 = null;

      try {
         if (var1.toLowerCase().contains("bee") && l.a().equalsIgnoreCase("1_14_R1")) {
            return null;
         }

         Class var7 = Class.forName("com.permadeathcore.CustomMobs.v" + l.a() + "." + var1);
         var6 = (net.minecraft.server.v1_14_R1.Entity)var7.getConstructor(Location.class).newInstance(var3);
      } catch (ClassNotFoundException | NoSuchMethodException var8) {
      } catch (IllegalAccessException var9) {
      } catch (InstantiationException var10) {
      } catch (InvocationTargetException var11) {
      }

      if (var6 == null) {
         return null;
      } else {
         var6.setPositionRotation(var3.getX(), var3.getY(), var3.getZ(), var3.getYaw(), var3.getPitch());
         var5.addEntity(var6, var4);
         return var6 == null ? null : var6.getBukkitEntity();
      }
   }

   public Entity a(Location var1, SpawnReason var2, boolean var3) {
      WorldServer var4 = ((CraftWorld)var1.getWorld()).getHandle();
      CustomCreeper var5 = new CustomCreeper(EntityTypes.CREEPER, var4, var3);
      var5.setPosition(var1.getX(), var1.getY(), var1.getZ());
      var4.addEntity(var5, var2);
      return var5 == null ? null : var5.getBukkitEntity();
   }

   public Entity b(Location var1, SpawnReason var2, boolean var3) {
      WorldServer var4 = ((CraftWorld)var1.getWorld()).getHandle();
      CustomGhast var5 = new CustomGhast(EntityTypes.GHAST, var4);
      var5.setPosition(var1.getX(), var1.getY(), var1.getZ());
      var4.addEntity(var5, var2);
      if (var3) {
         var5.getAttributeInstance(GenericAttributes.MAX_HEALTH).setValue(200.0D);
         LivingEntity var6 = (LivingEntity)var5.getBukkitEntity();
         var6.setHealth(200.0D);
         var6.setCustomName("§6Ender Ghast");
         var6.getPersistentDataContainer().set(new NamespacedKey(Main.p(), "ender_ghast"), PersistentDataType.BYTE, (byte)1);
         var6.setCustomNameVisible(false);
      }

      return var5 == null ? null : var5.getBukkitEntity();
   }

   public void b() {
   }

   public World b(org.bukkit.World var1) {
      return ((CraftWorld)var1).getHandle();
   }

   // $FF: synthetic method
   public Object a(org.bukkit.World var1) {
      return this.b(var1);
   }

   // $FF: synthetic method
   public Object b(String var1) {
      return this.c(var1);
   }

   // $FF: synthetic method
   public Object a(EntityType var1) {
      return this.b(var1);
   }
}
