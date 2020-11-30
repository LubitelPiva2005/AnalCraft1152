
package net.mcreator.analcraft.painting;

@AnalCraftModElements.ModElement.Tag
public class Gay15Painting extends AnalCraftModElements.ModElement {

	public Gay15Painting(AnalCraftModElements instance) {
		super(instance, 106);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 32).setRegistryName("gay_15"));
	}

}
