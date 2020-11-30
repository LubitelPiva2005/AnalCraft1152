
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class OfitsieryItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:ofitsiery")
	public static final Item block = null;

	public OfitsieryItem(AnalCraftModElements instance) {
		super(instance, 78);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:oficeri")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("ofitsiery");
		}

	}

}
