
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class RattvItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:rattv")
	public static final Item block = null;

	public RattvItem(AnalCraftModElements instance) {
		super(instance, 353);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:rat-gachi")),
					new Item.Properties().group(AnalCraftMusicItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("rattv");
		}

	}

}
