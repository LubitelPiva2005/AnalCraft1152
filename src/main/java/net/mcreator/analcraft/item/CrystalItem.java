
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class CrystalItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:crystal")
	public static final Item block = null;

	public CrystalItem(AnalCraftModElements instance) {
		super(instance, 158);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ANALTABItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("crystal");
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
