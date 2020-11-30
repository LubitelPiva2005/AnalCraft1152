
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class Plastina1Item extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:plastina_1")
	public static final Item block = null;

	public Plastina1Item(AnalCraftModElements instance) {
		super(instance, 107);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ANALTABItemGroup.tab).maxStackSize(8).rarity(Rarity.EPIC));
			setRegistryName("plastina_1");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}