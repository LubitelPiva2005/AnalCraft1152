
package net.mcreator.analcraft.block;

import net.minecraft.block.material.Material;

@AnalCraftModElements.ModElement.Tag
public class MarkkhuiesosBlock extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:markkhuiesos")
	public static final Block block = null;

	public MarkkhuiesosBlock(AnalCraftModElements instance) {
		super(instance, 78);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ANALTABItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f).lightValue(0));

			setRegistryName("markkhuiesos");
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
