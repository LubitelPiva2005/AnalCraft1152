
package net.mcreator.analcraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.analcraft.itemgroup.ANALTABItemGroup;
import net.mcreator.analcraft.AnalCraftModElements;

@AnalCraftModElements.ModElement.Tag
public class YuutltghieItem extends AnalCraftModElements.ModElement {
	@ObjectHolder("anal_craft:yuutltghie")
	public static final Item block = null;
	public YuutltghieItem(AnalCraftModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 200;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 5f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SemenItem.block, (int) (1)), new ItemStack(KnutItem.block, (int) (1)),
						new ItemStack(BlackleatherItem.block, (int) (1)));
			}
		}, 3, -3.4f, new Item.Properties().group(ANALTABItemGroup.tab)) {
		}.setRegistryName("yuutltghie"));
	}
}
