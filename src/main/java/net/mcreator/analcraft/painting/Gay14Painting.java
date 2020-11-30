
package net.mcreator.analcraft.painting;

@AnalCraftModElements.ModElement.Tag
public class Gay14Painting extends AnalCraftModElements.ModElement {

	public Gay14Painting(AnalCraftModElements instance) {
		super(instance, 105);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(64, 48).setRegistryName("gay_14"));
	}

}
