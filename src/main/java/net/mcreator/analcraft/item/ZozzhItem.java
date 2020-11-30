
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class ZozzhItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:zozzh")
	public static final Item block = null;

	public ZozzhItem(AnalCraftModElements instance) {
		super(instance, 83);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:zozh")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("zozzh");
		}

	}

}