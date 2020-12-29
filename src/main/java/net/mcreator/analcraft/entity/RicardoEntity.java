
package net.mcreator.analcraft.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.analcraft.procedures.RicardoEntityDiesProcedure;
import net.mcreator.analcraft.itemgroup.AnalCraftMobsItemGroup;
import net.mcreator.analcraft.AnalCraftModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@AnalCraftModElements.ModElement.Tag
public class RicardoEntity extends AnalCraftModElements.ModElement {
	public static EntityType entity = null;
	public RicardoEntity(AnalCraftModElements instance) {
		super(instance, 76);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(1f, 2.8f)).build("ricardo")
						.setRegistryName("ricardo");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -65485, -10066177, new Item.Properties().group(AnalCraftMobsItemGroup.tab))
				.setRegistryName("ricardo_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelIronGolem(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("anal_craft:textures/iron_golem.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 20;
			setNoAI(false);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, ServerPlayerEntity.class, false, false));
			this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 0.8));
			this.targetSelector.addGoal(5, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(6, new LeapAtTargetGoal(this, (float) 0.5));
			this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(8, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("anal_craft:aghh"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("anal_craft:aaaaaaa"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof ArrowEntity)
				return false;
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity sourceentity = source.getTrueSource();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				RicardoEntityDiesProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(230);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(16);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.NOTCHED_10);
		@Override
		public void addTrackingPlayer(ServerPlayerEntity player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(ServerPlayerEntity player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void updateAITasks() {
			super.updateAITasks();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}
	}

	/**
	 * ModelIronGolem - Either Mojang or a mod author Created using Tabula 7.1.0
	 */
	public static class ModelIronGolem extends EntityModel<Entity> {
		public ModelRenderer field_78176_b0;
		public ModelRenderer field_78176_b1;
		public ModelRenderer field_78174_d;
		public ModelRenderer field_78177_c;
		public ModelRenderer field_78175_e;
		public ModelRenderer field_78178_a0;
		public ModelRenderer field_78178_a1;
		public ModelRenderer field_78173_f;
		public ModelIronGolem() {
			this.textureWidth = 128;
			this.textureHeight = 128;
			this.field_78176_b1 = new ModelRenderer(this, 0, 70);
			this.field_78176_b1.setRotationPoint(0.0F, -7.0F, 0.0F);
			this.field_78176_b1.addBox(-4.5F, 10.0F, -3.0F, 9, 5, 6, 0.5F);
			this.field_78175_e = new ModelRenderer(this, 37, 0);
			this.field_78175_e.setRotationPoint(-4.0F, 11.0F, 0.0F);
			this.field_78175_e.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, 0.0F);
			this.field_78178_a0 = new ModelRenderer(this, 0, 0);
			this.field_78178_a0.setRotationPoint(0.0F, -7.0F, -2.0F);
			this.field_78178_a0.addBox(-4.0F, -12.0F, -5.5F, 8, 10, 8, 0.0F);
			this.field_78173_f = new ModelRenderer(this, 60, 0);
			this.field_78173_f.mirror = true;
			this.field_78173_f.setRotationPoint(5.0F, 11.0F, 0.0F);
			this.field_78173_f.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, 0.0F);
			this.field_78176_b0 = new ModelRenderer(this, 0, 40);
			this.field_78176_b0.setRotationPoint(0.0F, -7.0F, 0.0F);
			this.field_78176_b0.addBox(-9.0F, -2.0F, -6.0F, 18, 12, 11, 0.0F);
			this.field_78174_d = new ModelRenderer(this, 60, 58);
			this.field_78174_d.setRotationPoint(0.0F, -7.0F, 0.0F);
			this.field_78174_d.addBox(9.0F, -2.5F, -3.0F, 4, 30, 6, 0.0F);
			this.field_78178_a1 = new ModelRenderer(this, 24, 0);
			this.field_78178_a1.setRotationPoint(0.0F, -7.0F, -2.0F);
			this.field_78178_a1.addBox(-1.0F, -5.0F, -7.5F, 2, 4, 2, 0.0F);
			this.field_78177_c = new ModelRenderer(this, 60, 21);
			this.field_78177_c.setRotationPoint(0.0F, -7.0F, 0.0F);
			this.field_78177_c.addBox(-13.0F, -2.5F, -3.0F, 4, 30, 6, 0.0F);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			this.field_78176_b1.render(ms, vb, i1, i2, f1, f2, f3, f4);
			this.field_78175_e.render(ms, vb, i1, i2, f1, f2, f3, f4);
			this.field_78178_a0.render(ms, vb, i1, i2, f1, f2, f3, f4);
			this.field_78173_f.render(ms, vb, i1, i2, f1, f2, f3, f4);
			this.field_78176_b0.render(ms, vb, i1, i2, f1, f2, f3, f4);
			this.field_78174_d.render(ms, vb, i1, i2, f1, f2, f3, f4);
			this.field_78178_a1.render(ms, vb, i1, i2, f1, f2, f3, f4);
			this.field_78177_c.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		/**
		 * This is a helper function from Tabula to set the rotation of model parts
		 */
		public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.field_78178_a0.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.field_78178_a0.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.field_78174_d.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.field_78177_c.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.field_78175_e.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.field_78173_f.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
