
package net.mcreator.analcraft.itemgroup;

@AnalCraftModElements.ModElement.Tag
public class AnalCraftMusicItemGroup extends AnalCraftModElements.ModElement {

	public AnalCraftMusicItemGroup(AnalCraftModElements instance) {
		super(instance, 234);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabanal_craft_music") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(OfitsieryItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
