
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class SemenmeatItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:semenmeat")
	public static final Item block = null;

	public SemenmeatItem(AnalCraftModElements instance) {
		super(instance, 129);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ANALTABItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(7).saturation(1.1f).setAlwaysEdible().meat().build()));
			setRegistryName("semenmeat");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 42;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
