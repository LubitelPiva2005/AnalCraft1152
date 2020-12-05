
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class DomItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:dom")
	public static final Item block = null;

	public DomItem(AnalCraftModElements instance) {
		super(instance, 217);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:gachimuch")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("dom");
		}

	}

}
