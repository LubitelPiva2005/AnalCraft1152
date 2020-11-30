
package net.mcreator.analcraft.painting;

@AnalCraftModElements.ModElement.Tag
public class GayPaintingPainting extends AnalCraftModElements.ModElement {

	public GayPaintingPainting(AnalCraftModElements instance) {
		super(instance, 92);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("gay_painting"));
	}

}
