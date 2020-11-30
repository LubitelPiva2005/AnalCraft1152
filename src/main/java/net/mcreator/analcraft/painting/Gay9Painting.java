
package net.mcreator.analcraft.painting;

@AnalCraftModElements.ModElement.Tag
public class Gay9Painting extends AnalCraftModElements.ModElement {

	public Gay9Painting(AnalCraftModElements instance) {
		super(instance, 100);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(32, 64).setRegistryName("gay_9"));
	}

}
