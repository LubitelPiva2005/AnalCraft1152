
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

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.analcraft.item.BillystatueitemItem;
import net.mcreator.analcraft.AnalCraftModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@AnalCraftModElements.ModElement.Tag
public class BillystatueEntity extends AnalCraftModElements.ModElement {
	public static EntityType entity = null;
	public BillystatueEntity(AnalCraftModElements instance) {
		super(instance, 114);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 2.3f)).build("billystatue")
						.setRegistryName("billystatue");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -13159, -1, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("billystatue_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelbillystatue(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("anal_craft:textures/ee.png");
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
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(BillystatueitemItem.block, (int) (1)));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(3);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
			this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(100D);
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelbillystatue extends EntityModel<Entity> {
		private final ModelRenderer group;
		private final ModelRenderer pol;
		private final ModelRenderer neck;
		private final ModelRenderer head;
		private final ModelRenderer face;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer hair;
		private final ModelRenderer cube_r3;
		private final ModelRenderer hand1;
		private final ModelRenderer cube_r4;
		private final ModelRenderer spear;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer hand2;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer leg1;
		private final ModelRenderer cube_r9;
		private final ModelRenderer leg2;
		private final ModelRenderer cube_r10;
		private final ModelRenderer body;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer wing2;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		private final ModelRenderer cube_r16;
		private final ModelRenderer wing1;
		private final ModelRenderer cube_r17;
		private final ModelRenderer cube_r18;
		private final ModelRenderer cube_r19;
		private final ModelRenderer cube_r20;
		public Modelbillystatue() {
			textureWidth = 128;
			textureHeight = 128;
			group = new ModelRenderer(this);
			group.setRotationPoint(2.0F, 16.0F, 0.0F);
			pol = new ModelRenderer(this);
			pol.setRotationPoint(0.0F, 0.0F, 0.0F);
			group.addChild(pol);
			pol.setTextureOffset(0, 24).addBox(0.0F, 4.0F, -6.0F, 6.0F, 2.0F, 5.0F, 0.0F, false);
			pol.setTextureOffset(0, 20).addBox(-13.0F, 7.0F, -8.0F, 21.0F, 1.0F, 16.0F, 0.0F, false);
			pol.setTextureOffset(0, 20).addBox(-12.0F, 6.0F, -7.0F, 19.0F, 1.0F, 14.0F, 0.0F, false);
			neck = new ModelRenderer(this);
			neck.setRotationPoint(-9.0F, -26.0F, 7.0F);
			group.addChild(neck);
			neck.setTextureOffset(7, 6).addBox(5.0F, 2.0F, -10.0F, 4.0F, 5.0F, 2.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(-2.0F, -29.0F, 8.0F);
			group.addChild(head);
			face = new ModelRenderer(this);
			face.setRotationPoint(5.0F, 0.0F, 3.0F);
			head.addChild(face);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-5.5766F, 14.0753F, -13.8596F);
			face.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, -0.7854F, 0.0F);
			cube_r1.setTextureOffset(4, 7).addBox(2.7435F, -11.0753F, -0.1431F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-5.5766F, 14.0753F, -13.8596F);
			face.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.7854F, 0.0F);
			cube_r2.setTextureOffset(0, 0).addBox(-3.2712F, -14.0753F, -2.4992F, 6.0F, 7.0F, 6.0F, 0.0F, true);
			cube_r2.setTextureOffset(4, 7).addBox(-0.8569F, -11.0753F, -2.9134F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			hair = new ModelRenderer(this);
			hair.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(hair);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(-0.5766F, 14.0753F, -10.8596F);
			hair.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 0.7854F, 0.0F);
			cube_r3.setTextureOffset(35, 5).addBox(0.7288F, -11.0753F, -2.9134F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(31, 6).addBox(-1.2712F, -15.0753F, -2.9134F, 3.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(28, 6).addBox(1.7288F, -15.0753F, -2.9134F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(29, 5).addBox(-3.5996F, -15.0753F, -2.9134F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(25, 0).addBox(-3.5996F, -15.0753F, -2.2565F, 0.0F, 8.0F, 5.0F, 0.0F, false);
			cube_r3.setTextureOffset(32, 7).addBox(0.6217F, -16.5753F, -1.292F, 3.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r3.setTextureOffset(29, 9).addBox(-1.7712F, -15.0753F, -2.4992F, 5.0F, 1.0F, 6.0F, 0.0F, false);
			cube_r3.setTextureOffset(24, 3).addBox(-3.2712F, -16.0753F, -2.4992F, 6.0F, 1.0F, 6.0F, 0.0F, false);
			cube_r3.setTextureOffset(29, 1).addBox(-3.5996F, -15.0753F, 2.7435F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(30, 1).addBox(1.7288F, -15.0753F, 2.7435F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(28, 0).addBox(-1.2712F, -15.0753F, 2.7435F, 3.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(24, 0).addBox(0.7288F, -11.0753F, 2.7435F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			hand1 = new ModelRenderer(this);
			hand1.setRotationPoint(-13.0F, -24.0F, 1.0F);
			group.addChild(hand1);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(10.4234F, 9.0753F, -3.8596F);
			hand1.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.0F, -0.3927F);
			cube_r4.setTextureOffset(84, 6).addBox(0.2257F, -6.2972F, -7.1404F, 5.0F, 6.0F, 4.0F, 0.0F, false);
			cube_r4.setTextureOffset(79, 7).addBox(0.843F, 4.6267F, -6.6404F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r4.setTextureOffset(67, 4).addBox(0.843F, -5.3733F, -6.1404F, 3.0F, 12.0F, 3.0F, 0.0F, false);
			spear = new ModelRenderer(this);
			spear.setRotationPoint(7.0F, -17.0F, 2.0F);
			group.addChild(spear);
			spear.setTextureOffset(0, 64).addBox(-31.0F, 7.0F, -10.0F, 38.0F, 1.0F, 1.0F, 0.0F, false);
			spear.setTextureOffset(1, 68).addBox(7.0F, 6.0F, -10.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);
			spear.setTextureOffset(0, 71).addBox(13.0F, 7.0F, -10.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			spear.setTextureOffset(2, 68).addBox(6.0F, 7.0F, -11.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
			spear.setTextureOffset(3, 68).addBox(6.0F, 7.0F, -9.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-9.5766F, 2.0753F, -4.8596F);
			spear.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0F, 0.7854F);
			cube_r5.setTextureOffset(0, 68).addBox(18.5469F, -6.896F, -5.1404F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r5.setTextureOffset(7, 69).addBox(13.7185F, -7.896F, -5.1404F, 5.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(-9.5766F, 2.0753F, -4.8596F);
			spear.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, 0.0F, -0.7854F);
			cube_r6.setTextureOffset(0, 70).addBox(10.8752F, 13.4256F, -5.1404F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r6.setTextureOffset(1, 70).addBox(6.0467F, 13.4256F, -5.1404F, 5.0F, 2.0F, 1.0F, 0.0F, false);
			hand2 = new ModelRenderer(this);
			hand2.setRotationPoint(-6.0F, -30.0F, 12.0F);
			group.addChild(hand2);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(3.4234F, 15.0753F, -14.8596F);
			hand2.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0F, 0.0F, 0.3927F);
			cube_r7.setTextureOffset(79, 7).addBox(-2.9318F, -5.6177F, 4.8596F, 5.0F, 6.0F, 4.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(3.4234F, 15.0753F, -14.8596F);
			hand2.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0F, 0.0F, -0.3927F);
			cube_r8.setTextureOffset(70, 7).addBox(-2.377F, -0.2127F, 4.8596F, 3.0F, 6.0F, 3.0F, 0.0F, false);
			cube_r8.setTextureOffset(79, 6).addBox(-2.3113F, 4.4025F, 4.8596F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(1.0F, 13.0F, 8.0F);
			group.addChild(leg1);
			leg1.setTextureOffset(71, 6).addBox(-11.0F, -9.0F, -10.0F, 5.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(-3.5766F, -27.9247F, -10.8596F);
			leg1.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.0F, 0.0F, 0.3927F);
			cube_r9.setTextureOffset(82, 7).addBox(0.7093F, 12.8516F, 0.8596F, 3.0F, 7.0F, 3.0F, 0.0F, false);
			cube_r9.setTextureOffset(75, 5).addBox(0.261F, 7.5429F, 0.8596F, 4.0F, 6.0F, 3.0F, 0.0F, false);
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(11.0F, 11.0F, 5.0F);
			group.addChild(leg2);
			leg2.setTextureOffset(72, 5).addBox(-11.0F, -15.0F, -10.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);
			leg2.setTextureOffset(97, 9).addBox(-11.0F, -9.0F, -10.0F, 5.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(-13.5766F, -25.9247F, -7.8596F);
			leg2.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.0F, 0.0F, -0.7854F);
			cube_r10.setTextureOffset(74, 4).addBox(-6.9741F, 5.8901F, -2.1404F, 4.0F, 6.0F, 3.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(-9.0F, -20.0F, 7.0F);
			group.addChild(body);
			body.setTextureOffset(76, 7).addBox(3.0F, 10.0F, -9.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			body.setTextureOffset(76, 7).addBox(4.0F, 10.0F, -13.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			body.setTextureOffset(76, 7).addBox(6.0F, 2.0F, -13.0F, 4.0F, 5.0F, 8.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(6.4234F, 5.0753F, -9.8596F);
			body.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.0F, 0.0F, -0.3927F);
			cube_r11.setTextureOffset(76, 7).addBox(0.0078F, -5.147F, -3.1404F, 6.0F, 5.0F, 8.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(6.4234F, 5.0753F, -9.8596F);
			body.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.0F, 0.0F, 0.3927F);
			cube_r12.setTextureOffset(76, 7).addBox(0.2777F, 0.545F, -2.1404F, 4.0F, 5.0F, 6.0F, 0.0F, false);
			wing2 = new ModelRenderer(this);
			wing2.setRotationPoint(-9.0F, -23.0F, 8.0F);
			group.addChild(wing2);
			wing2.setTextureOffset(0, 53).addBox(0.0F, 5.0F, -13.0F, 6.0F, 3.0F, 1.0F, 0.0F, true);
			wing2.setTextureOffset(4, 48).addBox(-4.0F, 1.0F, -13.0F, 7.0F, 7.0F, 1.0F, 0.0F, true);
			wing2.setTextureOffset(8, 51).addBox(-1.0F, 8.0F, -13.0F, 4.0F, 7.0F, 1.0F, 0.0F, true);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(6.4234F, 8.0753F, -10.8596F);
			wing2.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.0F, 0.0F, 0.3927F);
			cube_r13.setTextureOffset(2, 45).addBox(-13.2509F, -0.1672F, -2.1404F, 5.0F, 15.0F, 1.0F, 0.0F, true);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(6.4234F, 8.0753F, -10.8596F);
			wing2.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.0F, 0.0F, -0.3927F);
			cube_r14.setTextureOffset(0, 47).addBox(-26.3134F, -12.6142F, -2.1404F, 21.0F, 5.0F, 1.0F, 0.0F, true);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(6.4234F, 8.0753F, -10.8596F);
			wing2.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.0F, 0.0F, 0.7854F);
			cube_r15.setTextureOffset(0, 45).addBox(-13.4947F, 7.4177F, -2.1404F, 5.0F, 15.0F, 1.0F, 0.0F, true);
			cube_r15.setTextureOffset(2, 51).addBox(-6.8379F, 4.8319F, -2.1404F, 5.0F, 3.0F, 1.0F, 0.0F, true);
			cube_r15.setTextureOffset(6, 50).addBox(-13.9089F, 0.1751F, -2.1404F, 4.0F, 1.0F, 1.0F, 0.0F, true);
			cube_r15.setTextureOffset(4, 51).addBox(-6.545F, -1.9462F, -2.1404F, 5.0F, 3.0F, 1.0F, 0.0F, true);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(6.4234F, 8.0753F, -10.8596F);
			wing2.addChild(cube_r16);
			setRotationAngle(cube_r16, 0.0F, 0.0F, -0.7854F);
			cube_r16.setTextureOffset(3, 46).addBox(-4.0243F, -3.9592F, -2.1404F, 4.0F, 3.0F, 1.0F, 0.0F, true);
			wing1 = new ModelRenderer(this);
			wing1.setRotationPoint(-9.0F, -23.0F, 8.0F);
			group.addChild(wing1);
			wing1.setTextureOffset(0, 48).addBox(0.0F, 5.0F, -8.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);
			wing1.setTextureOffset(12, 49).addBox(-4.0F, 1.0F, -8.0F, 7.0F, 7.0F, 1.0F, 0.0F, false);
			wing1.setTextureOffset(0, 48).addBox(-25.0F, -3.0F, -8.0F, 21.0F, 5.0F, 1.0F, 0.0F, false);
			wing1.setTextureOffset(12, 46).addBox(-1.0F, 8.0F, -8.0F, 4.0F, 7.0F, 1.0F, 0.0F, false);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(6.4234F, 8.0753F, -10.8596F);
			wing1.addChild(cube_r17);
			setRotationAngle(cube_r17, 0.0F, 0.0F, 0.3927F);
			cube_r17.setTextureOffset(7, 47).addBox(-13.2509F, -0.1672F, 2.8596F, 5.0F, 15.0F, 1.0F, 0.0F, false);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(6.4234F, 8.0753F, -10.8596F);
			wing1.addChild(cube_r18);
			setRotationAngle(cube_r18, 0.0F, 0.0F, -0.3927F);
			cube_r18.setTextureOffset(4, 45).addBox(-21.694F, -10.7008F, 2.8596F, 15.0F, 5.0F, 1.0F, 0.0F, false);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(6.4234F, 8.0753F, -10.8596F);
			wing1.addChild(cube_r19);
			setRotationAngle(cube_r19, 0.0F, 0.0F, -0.7854F);
			cube_r19.setTextureOffset(15, 48).addBox(-4.0243F, -3.9592F, 2.8596F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(6.4234F, 8.0753F, -10.8596F);
			wing1.addChild(cube_r20);
			setRotationAngle(cube_r20, 0.0F, 0.0F, 0.7854F);
			cube_r20.setTextureOffset(12, 46).addBox(-6.8379F, 4.8319F, 2.8596F, 5.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r20.setTextureOffset(14, 45).addBox(-13.9089F, 0.1751F, 2.8596F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r20.setTextureOffset(15, 47).addBox(-6.545F, -1.9462F, 2.8596F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			group.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
