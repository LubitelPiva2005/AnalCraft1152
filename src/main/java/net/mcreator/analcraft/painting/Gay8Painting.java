
package net.mcreator.analcraft.painting;

@AnalCraftModElements.ModElement.Tag
public class Gay8Painting extends AnalCraftModElements.ModElement {

	public Gay8Painting(AnalCraftModElements instance) {
		super(instance, 99);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(32, 16).setRegistryName("gay_8"));
	}

}
