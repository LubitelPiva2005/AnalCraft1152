
package net.mcreator.analcraft.painting;

@AnalCraftModElements.ModElement.Tag
public class Gay10Painting extends AnalCraftModElements.ModElement {

	public Gay10Painting(AnalCraftModElements instance) {
		super(instance, 101);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(64, 64).setRegistryName("gay_10"));
	}

}
