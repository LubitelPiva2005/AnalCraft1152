
package net.mcreator.analcraft.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.analcraft.itemgroup.AnalCraftMobsItemGroup;
import net.mcreator.analcraft.item.SemenItem;
import net.mcreator.analcraft.AnalCraftModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@AnalCraftModElements.ModElement.Tag
public class KrisaEntity extends AnalCraftModElements.ModElement {
	public static EntityType entity = null;
	public KrisaEntity(AnalCraftModElements instance) {
		super(instance, 100);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("krisa")
						.setRegistryName("krisa");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16777216, -10066330, new Item.Properties().group(AnalCraftMobsItemGroup.tab))
				.setRegistryName("krisa_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 5, 1, 2));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
		DungeonHooks.addDungeonMob(entity, 180);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelmish(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("anal_craft:textures/etjhej.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new AvoidEntityGoal(this, PlayerEntity.class, (float) 6, 0.8, 0.8));
			this.goalSelector.addGoal(2, new AvoidEntityGoal(this, ServerPlayerEntity.class, (float) 6, 0.8, 0.8));
			this.goalSelector.addGoal(3, new TemptGoal(this, 0.2, Ingredient.fromItems(new ItemStack(SemenItem.block, (int) (1)).getItem()), false));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.8);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelmish extends EntityModel<Entity> {
		private final ModelRenderer leftleg2;
		private final ModelRenderer righthand;
		private final ModelRenderer lefthand;
		private final ModelRenderer rightleg2;
		private final ModelRenderer head2;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer body2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		public Modelmish() {
			textureWidth = 64;
			textureHeight = 64;
			leftleg2 = new ModelRenderer(this);
			leftleg2.setRotationPoint(3.0F, 21.0F, 5.0F);
			leftleg2.setTextureOffset(0, 0).addBox(0.0F, -1.0F, -1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
			leftleg2.setTextureOffset(0, 60).addBox(0.0F, 2.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			righthand = new ModelRenderer(this);
			righthand.setRotationPoint(-2.0F, 21.0F, -2.0F);
			righthand.setTextureOffset(58, 61).addBox(-1.0F, 2.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			righthand.setTextureOffset(58, 0).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			lefthand = new ModelRenderer(this);
			lefthand.setRotationPoint(2.0F, 21.0F, -2.0F);
			lefthand.setTextureOffset(58, 61).addBox(0.0F, 2.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			lefthand.setTextureOffset(58, 0).addBox(0.0F, 0.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			rightleg2 = new ModelRenderer(this);
			rightleg2.setRotationPoint(-3.0F, 21.0F, 5.0F);
			rightleg2.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
			rightleg2.setTextureOffset(0, 60).addBox(-1.0F, 2.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			head2 = new ModelRenderer(this);
			head2.setRotationPoint(0.0F, 19.0F, -4.0F);
			setRotationAngle(head2, 0.2618F, 0.0F, 0.0F);
			head2.setTextureOffset(23, 57).addBox(-1.5F, -1.1022F, -3.7765F, 3.0F, 3.0F, 4.0F, 0.0F, false);
			head2.setTextureOffset(25, 52).addBox(-1.5F, -0.1022F, -5.7765F, 3.0F, 2.0F, 2.0F, 0.0F, false);
			head2.setTextureOffset(60, 30).addBox(-0.5F, -0.1022F, -6.7765F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head2.setTextureOffset(28, 32).addBox(1.0F, -0.6022F, -2.7765F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head2.setTextureOffset(28, 32).addBox(-2.0F, -0.6022F, -2.7765F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head2.setTextureOffset(0, 0).addBox(-3.0F, -1.1022F, -4.7765F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			head2.setTextureOffset(0, 0).addBox(-3.0F, 0.8978F, -4.7765F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			head2.setTextureOffset(0, 0).addBox(-2.0F, -0.1022F, -4.7765F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			head2.setTextureOffset(0, 0).addBox(2.0F, 0.8978F, -4.7765F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			head2.setTextureOffset(0, 0).addBox(2.0F, -1.1022F, -4.7765F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			head2.setTextureOffset(0, 0).addBox(1.0F, -0.1022F, -4.7765F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(2.0F, -0.1022F, 2.2235F);
			head2.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, -0.2182F, 0.0F);
			cube_r1.setTextureOffset(34, 39).addBox(-1.5F, -3.0F, -3.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-1.0F, -0.1022F, 2.2235F);
			head2.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.2182F, 0.0F);
			cube_r2.setTextureOffset(34, 37).addBox(-1.5F, -3.0F, -3.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
			body2 = new ModelRenderer(this);
			body2.setRotationPoint(0.0F, 20.0F, 1.0F);
			body2.setTextureOffset(20, 0).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);
			body2.setTextureOffset(25, 11).addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(1.0F, -2.0F, 4.0F);
			body2.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0436F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(54, 41).addBox(-1.5F, 4.5F, 6.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, -5.0F, 3.0F);
			body2.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.3927F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(54, 41).addBox(-0.7F, 3.5F, 6.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r4.setTextureOffset(54, 35).addBox(-1.0F, 3.0F, 3.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			leftleg2.render(matrixStack, buffer, packedLight, packedOverlay);
			righthand.render(matrixStack, buffer, packedLight, packedOverlay);
			lefthand.render(matrixStack, buffer, packedLight, packedOverlay);
			rightleg2.render(matrixStack, buffer, packedLight, packedOverlay);
			head2.render(matrixStack, buffer, packedLight, packedOverlay);
			body2.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.lefthand.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightleg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.righthand.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.head2.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head2.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leftleg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
