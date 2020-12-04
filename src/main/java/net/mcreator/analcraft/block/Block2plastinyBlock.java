
package net.mcreator.analcraft.block;

import net.minecraft.block.material.Material;

@AnalCraftModElements.ModElement.Tag
public class Block2plastinyBlock extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:block_2plastiny")
	public static final Block block = null;

	public Block2plastinyBlock(AnalCraftModElements instance) {
		super(instance, 131);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ANALTABItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1f, 10f).lightValue(0).harvestLevel(1)
							.harvestTool(ToolType.PICKAXE));

			setRegistryName("block_2plastiny");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Plastina2Item.block, (int) (1)));
		}

	}

}
