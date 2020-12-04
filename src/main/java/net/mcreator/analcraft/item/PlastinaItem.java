
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class PlastinaItem extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:plastina")
	public static final Item block = null;

	public PlastinaItem(AnalCraftModElements instance) {
		super(instance, 112);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ANALTABItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("plastina");
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
