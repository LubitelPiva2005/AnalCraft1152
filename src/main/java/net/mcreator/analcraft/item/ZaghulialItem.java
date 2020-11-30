
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class ZaghulialItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:zaghulial")
	public static final Item block = null;

	public ZaghulialItem(AnalCraftModElements instance) {
		super(instance, 88);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:zagulyal")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("zaghulial");
		}

	}

}
