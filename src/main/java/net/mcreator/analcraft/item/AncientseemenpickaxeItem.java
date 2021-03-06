
package net.mcreator.analcraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.analcraft.itemgroup.AnalToolItemGroup;
import net.mcreator.analcraft.AnalCraftModElements;

@AnalCraftModElements.ModElement.Tag
public class AncientseemenpickaxeItem extends AnalCraftModElements.ModElement {
	@ObjectHolder("anal_craft:ancientseemenpickaxe")
	public static final Item block = null;
	public AncientseemenpickaxeItem(AnalCraftModElements instance) {
		super(instance, 97);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1561;
			}

			public float getEfficiency() {
				return 22f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(AncientseemeningotItem.block, (int) (1)));
			}
		}, 1, -2.7999999999999998f, new Item.Properties().group(AnalToolItemGroup.tab)) {
		}.setRegistryName("ancientseemenpickaxe"));
	}
}
