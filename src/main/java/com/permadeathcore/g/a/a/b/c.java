package com.permadeathcore.g.a.a.b;

import net.minecraft.server.v1_16_R1.AttributeBase;
import net.minecraft.server.v1_16_R1.AttributeMapBase;
import net.minecraft.server.v1_16_R1.AttributeModifiable;
import net.minecraft.server.v1_16_R1.AttributeProvider;
import net.minecraft.server.v1_16_R1.EntityHuman;
import net.minecraft.server.v1_16_R1.EntityInsentient;
import net.minecraft.server.v1_16_R1.EntityTypes;
import net.minecraft.server.v1_16_R1.EntityVillager;
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
import org.bukkit.craftbukkit.v1_16_R1.attribute.CraftAttributeMap;
import org.bukkit.entity.Villager;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class c extends EntityVillager {
   private Villager h;
   private String k;
   private AttributeMapBase l;
   public final CraftAttributeMap a;
   public static AttributeProvider g;

   public c(Location var1, EntityTypes var2, Villager var3) {
      super(var2, ((CraftWorld)var1.getWorld()).getHandle());
      g = EntityInsentient.p().a(GenericAttributes.ARMOR_TOUGHNESS).a(GenericAttributes.ATTACK_DAMAGE, 8.0D).a(GenericAttributes.ATTACK_KNOCKBACK, 1.0D).a(GenericAttributes.MOVEMENT_SPEED, 0.5D).a(GenericAttributes.FOLLOW_RANGE, 48.0D).a();
      this.l = new AttributeMapBase(g);
      this.a = new CraftAttributeMap(this.l);
      this.k = "villager";
      this.h = var3;
      this.a(var1);
   }

   public void a(Location var1) {
      this.setPositionRotation(var1.getX(), var1.getY(), var1.getZ(), var1.getYaw(), var1.getPitch());
      if (this.h != null) {
         Villager var2 = (Villager)this.getBukkitEntity();
         var2.setVillagerType(this.h.getVillagerType());
         var2.setProfession(this.h.getProfession());
         var2.setVillagerExperience(this.h.getVillagerExperience());
         var2.setRecipes(this.h.getRecipes());
         var2.setVillagerLevel(this.h.getVillagerLevel());
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

   public AttributeModifiable getAttributeInstance(AttributeBase var1) {
      return this.getAttributeMap().a(var1);
   }

   public AttributeMapBase getAttributeMap() {
      return this.l;
   }

   public void saveData(NBTTagCompound var1) {
      super.saveData(var1);
      var1.setString("id", "hostile_" + this.k);
   }
}
