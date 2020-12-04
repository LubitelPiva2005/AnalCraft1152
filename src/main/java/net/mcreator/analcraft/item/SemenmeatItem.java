
package net.mcreator.analcraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.analcraft.procedures.SemenmeatFoodEatenProcedure;
import net.mcreator.analcraft.itemgroup.ANALTABItemGroup;
import net.mcreator.analcraft.AnalCraftModElements;

import java.util.Map;
import java.util.HashMap;

@AnalCraftModElements.ModElement.Tag
public class SemenmeatItem extends AnalCraftModElements.ModElement {
	@ObjectHolder("anal_craft:semenmeat")
	public static final Item block = null;
	public SemenmeatItem(AnalCraftModElements instance) {
		super(instance, 129);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ANALTABItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(7).saturation(1.1f).setAlwaysEdible().meat().build()));
			setRegistryName("semenmeat");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 42;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				SemenmeatFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
