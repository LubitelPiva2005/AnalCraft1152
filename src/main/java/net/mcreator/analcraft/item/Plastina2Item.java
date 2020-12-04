
package net.mcreator.analcraft.item;

@AnalCraftModElements.ModElement.Tag
public class Plastina2Item extends AnalCraftModElements.ModElement {

	@ObjectHolder("anal_craft:plastina_2")
	public static final Item block = null;

	public Plastina2Item(AnalCraftModElements instance) {
		super(instance, 132);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("plastina_2");
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
