
package net.mcreator.analcraft.itemgroup;

@AnalCraftModElements.ModElement.Tag
public class PotomUbratItemGroup extends AnalCraftModElements.ModElement {

	public PotomUbratItemGroup(AnalCraftModElements instance) {
		super(instance, 237);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabpotom_ubrat") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.LAVA, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
