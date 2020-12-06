
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class SuckmironItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:suckmiron")
	public static final Item block = null;

	public SuckmironItem(AnalCraftModElements instance) {
		super(instance, 216);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:oxsuckmiron")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("suckmiron");
		}

	}

}
