
package net.mcreator.analcraft.painting;

@AnalCraftModElements.ModElement.Tag
public class Gay2Painting extends AnalCraftModElements.ModElement {

	public Gay2Painting(AnalCraftModElements instance) {
		super(instance, 93);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("gay_2"));
	}

}
