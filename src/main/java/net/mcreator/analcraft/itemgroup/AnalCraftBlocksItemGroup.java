
package net.mcreator.analcraft.itemgroup;

@AnalCraftModElements.ModElement.Tag
public class AnalCraftBlocksItemGroup extends AnalCraftModElements.ModElement {

	public AnalCraftBlocksItemGroup(AnalCraftModElements instance) {
		super(instance, 236);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabanal_craft_blocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SpermegrassBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
