
package net.mcreator.analcraft.painting;

@AnalCraftModElements.ModElement.Tag
public class Gay3Painting extends AnalCraftModElements.ModElement {

	public Gay3Painting(AnalCraftModElements instance) {
		super(instance, 94);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(64, 64).setRegistryName("gay_3"));
	}

}
