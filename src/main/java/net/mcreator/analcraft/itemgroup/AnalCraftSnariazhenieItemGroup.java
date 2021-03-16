
package net.mcreator.analcraft.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.analcraft.item.GachiItem;
import net.mcreator.analcraft.AnalCraftModElements;

@AnalCraftModElements.ModElement.Tag
public class AnalCraftSnariazhenieItemGroup extends AnalCraftModElements.ModElement {
	public AnalCraftSnariazhenieItemGroup(AnalCraftModElements instance) {
		super(instance, 282);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabanal_craft_snariazhenie") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GachiItem.helmet, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
