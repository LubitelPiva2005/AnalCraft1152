
package net.mcreator.analcraft.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.analcraft.item.AncientseemenpickaxeItem;
import net.mcreator.analcraft.AnalCraftModElements;

@AnalCraftModElements.ModElement.Tag
public class AnalToolItemGroup extends AnalCraftModElements.ModElement {
	public AnalToolItemGroup(AnalCraftModElements instance) {
		super(instance, 302);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabanal_tool") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AncientseemenpickaxeItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
