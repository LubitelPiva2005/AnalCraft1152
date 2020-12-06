
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class BulletItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:bullet")
	public static final Item block = null;

	public BulletItem(AnalCraftModElements instance) {
		super(instance, 168);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(null).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("bullet");
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
