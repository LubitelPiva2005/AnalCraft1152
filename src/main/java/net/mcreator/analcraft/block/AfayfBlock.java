
package net.mcreator.analcraft.block;

import net.minecraft.block.material.Material;

@AnalCraftModElements.ModElement.Tag
public class AfayfBlock extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:afayf")
	public static final Block block = null;

	public AfayfBlock(AnalCraftModElements instance) {
		super(instance, 212);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ANALTABItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).lightValue(0).harvestLevel(1)
							.harvestTool(ToolType.AXE));

			setRegistryName("afayf");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
