
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class NurminskiiValimItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:nurminskii_valim")
	public static final Item block = null;

	public NurminskiiValimItem(AnalCraftModElements instance) {
		super(instance, 79);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:valim")),
					new Item.Properties().group(PlastinkiItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("nurminskii_valim");
		}

	}

}
