
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class BriemienskiieItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:briemienskiie")
	public static final Item block = null;

	public BriemienskiieItem(AnalCraftModElements instance) {
		super(instance, 84);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:bremenskiemuzicanti")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("briemienskiie");
		}

	}

}
