
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class NotrDamDiePariItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:notr_dam_die_pari")
	public static final Item block = null;

	public NotrDamDiePariItem(AnalCraftModElements instance) {
		super(instance, 82);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:notrdam")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("notr_dam_die_pari");
		}

	}

}
