
package net.mcreator.analcraft.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.analcraft.item.NurminskiiValimItem;
import net.mcreator.analcraft.AnalCraftModElements;

@AnalCraftModElements.ModElement.Tag
public class PlastinkiItemGroup extends AnalCraftModElements.ModElement {
	public PlastinkiItemGroup(AnalCraftModElements instance) {
		super(instance, 80);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabplastinki") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(NurminskiiValimItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
