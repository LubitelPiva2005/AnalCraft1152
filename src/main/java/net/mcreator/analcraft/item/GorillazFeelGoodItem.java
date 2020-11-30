
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class GorillazFeelGoodItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:gorillaz_feel_good")
	public static final Item block = null;

	public GorillazFeelGoodItem(AnalCraftModElements instance) {
		super(instance, 81);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:feelgood")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("gorillaz_feel_good");
		}

	}

}
