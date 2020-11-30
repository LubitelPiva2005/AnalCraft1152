
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class OlieghGazmanovIesaulItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:oliegh_gazmanov_iesaul")
	public static final Item block = null;

	public OlieghGazmanovIesaulItem(AnalCraftModElements instance) {
		super(instance, 87);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:esaul")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("oliegh_gazmanov_iesaul");
		}

	}

}
