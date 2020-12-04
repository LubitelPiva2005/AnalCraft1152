
package net.mcreator.analcraft.block;

import net.minecraft.block.material.Material;

@AnalCraftModElements.ModElement.Tag
public class SpermastupenkiBlock extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:spermastupenki")
	public static final Block block = null;

	public SpermastupenkiBlock(AnalCraftModElements instance) {
		super(instance, 124);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ANALTABItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends StairsBlock {

		public CustomBlock() {
			super(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 10f)).getDefaultState(),

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f, 10f).lightValue(0));

			setRegistryName("spermastupenki");
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
