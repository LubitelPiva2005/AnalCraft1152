
package net.mcreator.analcraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.mcreator.analcraft.itemgroup.AnalCraftMusicItemGroup;
import net.mcreator.analcraft.AnalCraftModElements;

@AnalCraftModElements.ModElement.Tag
public class IunostvsapoghakhItem extends AnalCraftModElements.ModElement {
	@ObjectHolder("anal_craft:iunostvsapoghakh")
	public static final Item block = null;
	public IunostvsapoghakhItem(AnalCraftModElements instance) {
		super(instance, 118);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, AnalCraftModElements.sounds.get(new ResourceLocation("anal_craft:yunostvsapogah")),
					new Item.Properties().group(AnalCraftMusicItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("iunostvsapoghakh");
		}
	}
}
