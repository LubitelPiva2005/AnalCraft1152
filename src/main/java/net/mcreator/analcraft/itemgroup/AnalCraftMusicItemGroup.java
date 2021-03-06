
package net.mcreator.analcraft.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.analcraft.item.OfitsieryItem;
import net.mcreator.analcraft.AnalCraftModElements;

@AnalCraftModElements.ModElement.Tag
public class AnalCraftMusicItemGroup extends AnalCraftModElements.ModElement {
	public AnalCraftMusicItemGroup(AnalCraftModElements instance) {
		super(instance, 286);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabanal_craft_music") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(OfitsieryItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
