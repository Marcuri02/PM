package com.permadeathcore.g;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public interface c {
   EntityType a(Object var1);

   Class a();

   Class a(String var1);

   Object a(EntityType var1);

   Object b(String var1);

   void a(Player var1, String var2);

   void a(Player var1, String var2, String var3, int var4, int var5, int var6);

   Object a(World var1);

   Entity a(String var1, EntityType var2, Location var3, SpawnReason var4);

   Entity a(Location var1);

   Entity a(EntityType var1, Location var2, SpawnReason var3);

   Entity b(String var1, EntityType var2, Location var3, SpawnReason var4);

   Entity a(Location var1, SpawnReason var2, boolean var3);

   Entity b(Location var1, SpawnReason var2, boolean var3);

   void b();
}
