package com.permadeathcore.g.a.a.b;

import net.minecraft.server.v1_16_R1.EntityBee;
import net.minecraft.server.v1_16_R1.EntityHuman;
import net.minecraft.server.v1_16_R1.EntityTypes;
import net.minecraft.server.v1_16_R1.GenericAttributes;
import net.minecraft.server.v1_16_R1.NBTTagCompound;
import net.minecraft.server.v1_16_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_16_R1.PathfinderGoalNearestAttackableTarget;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class a extends EntityBee {
   private String a;
   private SpawnReason g;

   public a(Location var1, EntityTypes var2, SpawnReason var3, String var4) {
      super(var2, ((CraftWorld)var1.getWorld()).getHandle());
      this.a = var4;
      this.g = var3;
      if (!this.a()) {
         this.getAttributeMap().b(GenericAttributes.ATTACK_DAMAGE);
      }

      this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(8.0D);
      this.a(var1);
   }

   public void a(Location var1) {
      this.setPositionRotation(var1.getX(), var1.getY(), var1.getZ(), var1.getYaw(), var1.getPitch());
      this.world.addEntity(this, this.g);
   }

   protected void initDatawatcher() {
      super.initDatawatcher();
   }

   protected void initPathfinder() {
      super.initPathfinder();
      this.goalSelector.a(0, new PathfinderGoalMeleeAttack(this, 1.0D, true));
      this.targetSelector.a(0, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, true));
   }

   public void saveData(NBTTagCompound var1) {
      super.saveData(var1);
      var1.setString("id", "hostile_" + this.a);
   }

   public boolean a() {
      EntityType var1 = this.getBukkitEntity().getType();
      return var1 != EntityType.CHICKEN && var1 != EntityType.COW && var1 != EntityType.MUSHROOM_COW && var1 != EntityType.PIG && var1 != EntityType.SHEEP && var1 != EntityType.SQUID && var1 != EntityType.WANDERING_TRADER && var1 != EntityType.VILLAGER && var1 != EntityType.BAT && var1 != EntityType.HORSE && var1 != EntityType.DONKEY && var1 != EntityType.MULE && var1 != EntityType.RABBIT && var1 != EntityType.PARROT && var1 != EntityType.TURTLE;
   }
}
