
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class BomzhItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:bomzh")
	public static final Item block = null;

	public BomzhItem(AnalCraftModElements instance) {
		super(instance, 89);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:bomj")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("bomzh");
		}

	}

}
