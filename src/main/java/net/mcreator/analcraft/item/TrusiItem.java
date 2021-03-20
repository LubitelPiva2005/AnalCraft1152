
package net.mcreator.analcraft.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.analcraft.procedures.TrusiLeggingsTickEventProcedure;
import net.mcreator.analcraft.itemgroup.AnalCraftSnariazhenieItemGroup;
import net.mcreator.analcraft.AnalCraftModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@AnalCraftModElements.ModElement.Tag
public class TrusiItem extends AnalCraftModElements.ModElement {
	@ObjectHolder("anal_craft:trusi_helmet")
	public static final Item helmet = null;
	@ObjectHolder("anal_craft:trusi_chestplate")
	public static final Item body = null;
	@ObjectHolder("anal_craft:trusi_leggings")
	public static final Item legs = null;
	@ObjectHolder("anal_craft:trusi_boots")
	public static final Item boots = null;
	public TrusiItem(AnalCraftModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 7, 6, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 50;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(BlackleatherItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "trusi";
			}

			public float getToughness() {
				return 2f;
			}
		};
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(AnalCraftSnariazhenieItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedLeftLeg = new Modeltrusiliwewe().LeftLeg;
						armorModel.bipedRightLeg = new Modeltrusiliwewe().RightLeg;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "anal_craft:textures/1textur.png";
					}

					@Override
					public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
						double x = entity.getPosX();
						double y = entity.getPosY();
						double z = entity.getPosZ();
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("entity", entity);
							TrusiLeggingsTickEventProcedure.executeProcedure($_dependencies);
						}
					}
				}.setRegistryName("trusi_leggings"));
	}
	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modeltrusiliwewe extends EntityModel<Entity> {
		private final ModelRenderer RightLeg;
		private final ModelRenderer LeftLeg;
		public Modeltrusiliwewe() {
			textureWidth = 64;
			textureHeight = 64;
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
			RightLeg.setTextureOffset(0, 13).addBox(0.9F, 3.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			RightLeg.setTextureOffset(4, 5).addBox(0.9F, 2.0F, 2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			RightLeg.setTextureOffset(20, 3).addBox(-1.1F, 1.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			RightLeg.setTextureOffset(0, 3).addBox(-1.1F, 1.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			RightLeg.setTextureOffset(0, 5).addBox(0.9F, 2.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			RightLeg.setTextureOffset(0, 27).addBox(-3.1F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			RightLeg.setTextureOffset(20, 1).addBox(-2.1F, 0.0F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			RightLeg.setTextureOffset(0, 1).addBox(-2.1F, 0.0F, -3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
			LeftLeg.setTextureOffset(8, 5).addBox(-1.9F, 2.0F, 2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			LeftLeg.setTextureOffset(8, 3).addBox(-1.9F, 1.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			LeftLeg.setTextureOffset(8, 3).addBox(-1.9F, 1.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			LeftLeg.setTextureOffset(8, 5).addBox(-1.9F, 2.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			LeftLeg.setTextureOffset(10, 13).addBox(-1.9F, 3.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			LeftLeg.setTextureOffset(0, 20).addBox(2.1F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			LeftLeg.setTextureOffset(24, 1).addBox(-1.9F, 0.0F, -3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			LeftLeg.setTextureOffset(24, 1).addBox(-1.9F, 0.0F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
