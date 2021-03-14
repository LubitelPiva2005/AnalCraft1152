
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class EnderseemeningotItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:enderseemeningot")
	public static final Item block = null;

	public EnderseemeningotItem(AnalCraftModElements instance) {
		super(instance, 345);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ANALTABItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("enderseemeningot");
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
