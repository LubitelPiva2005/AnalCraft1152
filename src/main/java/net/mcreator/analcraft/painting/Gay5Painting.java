
package net.mcreator.analcraft.painting;

@AnalCraftModElements.ModElement.Tag
public class Gay5Painting extends AnalCraftModElements.ModElement {

	public Gay5Painting(AnalCraftModElements instance) {
		super(instance, 96);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(64, 64).setRegistryName("gay_5"));
	}

}
