package com.permadeathcore.g.a.a.a;

import net.minecraft.server.v1_15_R1.EntityHuman;
import net.minecraft.server.v1_15_R1.EntityTypes;
import net.minecraft.server.v1_15_R1.EntityVillagerTrader;
import net.minecraft.server.v1_15_R1.GenericAttributes;
import net.minecraft.server.v1_15_R1.PathfinderGoalFloat;
import net.minecraft.server.v1_15_R1.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_15_R1.PathfinderGoalLookAtTradingPlayer;
import net.minecraft.server.v1_15_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_15_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_15_R1.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_15_R1.PathfinderGoalRandomStrollLand;
import net.minecraft.server.v1_15_R1.PathfinderGoalTradeWithPlayer;
import net.minecraft.server.v1_15_R1.World;
import org.bukkit.entity.WanderingTrader;

public class y extends EntityVillagerTrader {
   private WanderingTrader a;
   private String g;

   public y(EntityTypes var1, World var2) {
      this(var2);
   }

   public y(World var1) {
      super(EntityTypes.WANDERING_TRADER, var1);
   }

   protected void initAttributes() {
      super.initAttributes();
      this.getAttributeMap().b(GenericAttributes.ATTACK_DAMAGE);
      this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(8.0D);
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
}
