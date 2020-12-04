
package net.mcreator.analcraft.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.analcraft.itemgroup.ANALTABItemGroup;
import net.mcreator.analcraft.AnalCraftModElements;

import java.util.List;
import java.util.Collections;

@AnalCraftModElements.ModElement.Tag
public class BlackstoneBlock extends AnalCraftModElements.ModElement {
	@ObjectHolder("anal_craft:blackstone")
	public static final Block block = null;
	public BlackstoneBlock(AnalCraftModElements instance) {
		super(instance, 133);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ANALTABItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f, 10f).lightValue(0).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("blackstone");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(BlackmodeBlock.block, (int) (1)));
		}
	}
}
