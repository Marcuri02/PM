package com.permadeathcore.g.a.a.b;

import net.minecraft.server.v1_16_R1.EntityHuman;
import net.minecraft.server.v1_16_R1.EntityTypes;
import net.minecraft.server.v1_16_R1.EntityVillagerTrader;
import net.minecraft.server.v1_16_R1.GenericAttributes;
import net.minecraft.server.v1_16_R1.NBTTagCompound;
import net.minecraft.server.v1_16_R1.PathfinderGoalFloat;
import net.minecraft.server.v1_16_R1.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_16_R1.PathfinderGoalLookAtTradingPlayer;
import net.minecraft.server.v1_16_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_16_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_16_R1.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_16_R1.PathfinderGoalRandomStrollLand;
import net.minecraft.server.v1_16_R1.PathfinderGoalTradeWithPlayer;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class d extends EntityVillagerTrader {
   private WanderingTrader a;
   private String g = "wandering_trader";

   public d(Location var1, EntityTypes var2, WanderingTrader var3) {
      super(var2, ((CraftWorld)var1.getWorld()).getHandle());
      this.a = var3;
      this.getAttributeMap().b(GenericAttributes.ATTACK_DAMAGE);
      this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(8.0D);
      this.a(var1);
   }

   public void a(Location var1) {
      this.setPositionRotation(var1.getX(), var1.getY(), var1.getZ(), var1.getYaw(), var1.getPitch());
      if (this.a != null) {
         WanderingTrader var2 = (WanderingTrader)this.getBukkitEntity();
         var2.setRecipes(this.a.getRecipes());
      }

      this.world.addEntity(this, SpawnReason.CUSTOM);
   }

   protected void initPathfinder() {
      this.goalSelector.a(0, new PathfinderGoalFloat(this));
      this.goalSelector.a(1, new PathfinderGoalRandomStrollLand(this, 1.0D));
      this.goalSelector.a(2, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
      this.goalSelector.a(3, new PathfinderGoalRandomLookaround(this));
      this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, 1.0D, true));
      this.goalSelector.a(5, new PathfinderGoalTradeWithPlayer(this));
      this.goalSelector.a(5, new PathfinderGoalLookAtTradingPlayer(this));
      this.targetSelector.a(0, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, true));
   }

   public void saveData(NBTTagCompound var1) {
      super.saveData(var1);
      var1.setString("id", "hostile_" + this.g);
   }
}
