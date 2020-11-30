
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class TraktorItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:traktor")
	public static final Item block = null;

	public TraktorItem(AnalCraftModElements instance) {
		super(instance, 85);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:kozhanyjtraktor")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("traktor");
		}

	}

}
