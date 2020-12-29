
package net.mcreator.analcraft.itemgroup;

@AnalCraftModElements.ModElement.Tag
public class AnalCraftMobsItemGroup extends AnalCraftModElements.ModElement {

	public AnalCraftMobsItemGroup(AnalCraftModElements instance) {
		super(instance, 235);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabanal_craft_mobs") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.CHICKEN_SPAWN_EGG, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
