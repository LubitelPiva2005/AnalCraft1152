
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class AssClapItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:ass_clap")
	public static final Item block = null;

	public AssClapItem(AnalCraftModElements instance) {
		super(instance, 77);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:assclap")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("ass_clap");
		}

	}

}