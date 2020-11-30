
package net.mcreator.analcraft.painting;

@AnalCraftModElements.ModElement.Tag
public class Gay4Painting extends AnalCraftModElements.ModElement {

	public Gay4Painting(AnalCraftModElements instance) {
		super(instance, 95);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(64, 32).setRegistryName("gay_4"));
	}

}
