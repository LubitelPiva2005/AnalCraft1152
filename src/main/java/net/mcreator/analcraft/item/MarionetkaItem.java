
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class MarionetkaItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:marionetka")
	public static final Item block = null;

	public MarionetkaItem(AnalCraftModElements instance) {
		super(instance, 218);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:marionetka")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("marionetka");
		}

	}

}
