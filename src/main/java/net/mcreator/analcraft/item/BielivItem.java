
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class BielivItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:bieliv")
	public static final Item block = null;

	public BielivItem(AnalCraftModElements instance) {
		super(instance, 91);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:ibelieve")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("bieliv");
		}

	}

}
