
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

import net.mcreator.analcraft.procedures.SpermsrmHelmetTickEventProcedure;
import net.mcreator.analcraft.itemgroup.ANALTABItemGroup;
import net.mcreator.analcraft.AnalCraftModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@AnalCraftModElements.ModElement.Tag
public class SpermsrmItem extends AnalCraftModElements.ModElement {
	@ObjectHolder("anal_craft:spermsrm_helmet")
	public static final Item helmet = null;
	@ObjectHolder("anal_craft:spermsrm_chestplate")
	public static final Item body = null;
	@ObjectHolder("anal_craft:spermsrm_leggings")
	public static final Item legs = null;
	@ObjectHolder("anal_craft:spermsrm_boots")
	public static final Item boots = null;
	public SpermsrmItem(AnalCraftModElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 100;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 5}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 35;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.slime.squish"));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(BlackleatherItem.block, (int) (1)), new ItemStack(SemenItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "spermsrm";
			}

			public float getToughness() {
				return 1.5f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ANALTABItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedHead = new Modelhelmet().Head;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "anal_craft:textures/spermhelm.png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				super.onArmorTick(itemstack, world, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					SpermsrmHelmetTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("spermsrm_helmet"));
	}
	public static class Modelhelmet extends EntityModel<Entity> {
		private final ModelRenderer Head;
		public Modelhelmet() {
			textureWidth = 64;
			textureHeight = 64;
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 0.0F, 0.0F);
			addBoxHelper(Head, 0, 0, -5.0F, -9.0F, -5.0F, 10, 10, 10, 0.0F, false);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			Head.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta) {
		addBoxHelper(renderer, texU, texV, x, y, z, dx, dy, dz, delta, renderer.mirror);
	}

	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta,
			boolean mirror) {
		renderer.mirror = mirror;
		renderer.addBox("", x, y, z, dx, dy, dz, delta, texU, texV);
	}
}
