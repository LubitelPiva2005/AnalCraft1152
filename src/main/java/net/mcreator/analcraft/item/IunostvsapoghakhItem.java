
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class IunostvsapoghakhItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:iunostvsapoghakh")
	public static final Item block = null;

	public IunostvsapoghakhItem(AnalCraftModElements instance) {
		super(instance, 90);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:yunostvsapogah")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("iunostvsapoghakh");
		}

	}

}
