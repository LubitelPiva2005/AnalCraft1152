
package net.mcreator.analcraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.analcraft.itemgroup.ANALTABItemGroup;
import net.mcreator.analcraft.AnalCraftModElements;

@AnalCraftModElements.ModElement.Tag
public class ZasokhshaiaspiermaItem extends AnalCraftModElements.ModElement {
	@ObjectHolder("anal_craft:zasokhshaiaspierma")
	public static final Item block = null;
	public ZasokhshaiaspiermaItem(AnalCraftModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ANALTABItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("zasokhshaiaspierma");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
