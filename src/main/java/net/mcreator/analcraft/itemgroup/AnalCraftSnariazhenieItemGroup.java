
package net.mcreator.analcraft.itemgroup;

@AnalCraftModElements.ModElement.Tag
public class AnalCraftSnariazhenieItemGroup extends AnalCraftModElements.ModElement {

	public AnalCraftSnariazhenieItemGroup(AnalCraftModElements instance) {
		super(instance, 238);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabanal_craft_snariazhenie") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GachiItem.helmet, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
