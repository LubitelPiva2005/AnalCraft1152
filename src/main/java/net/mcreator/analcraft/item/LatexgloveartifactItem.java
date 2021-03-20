
package net.mcreator.analcraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.analcraft.itemgroup.AnalCraftSnariazhenieItemGroup;
import net.mcreator.analcraft.AnalCraftModElements;

import java.util.List;

@AnalCraftModElements.ModElement.Tag
public class LatexgloveartifactItem extends AnalCraftModElements.ModElement {
	@ObjectHolder("anal_craft:latexgloveartifact")
	public static final Item block = null;
	public LatexgloveartifactItem(AnalCraftModElements instance) {
		super(instance, 397);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AnalCraftSnariazhenieItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
			setRegistryName("latexgloveartifact");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent(
					"\u041D\u0430\u0436\u043C\u0438 \"B\" \u0447\u0442\u043E\u0431\u044B \u0432\u0441\u0442\u0430\u0432\u0438\u0442\u044C \u0430\u0440\u0442\u0435\u0444\u0430\u043A\u0442"));
		}
	}
}
