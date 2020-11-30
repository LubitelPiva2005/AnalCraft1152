
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class MotyliekItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:motyliek")
	public static final Item block = null;

	public MotyliekItem(AnalCraftModElements instance) {
		super(instance, 86);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:motilek")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("motyliek");
		}

	}

}
