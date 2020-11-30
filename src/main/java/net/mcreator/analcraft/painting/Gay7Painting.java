
package net.mcreator.analcraft.painting;

@AnalCraftModElements.ModElement.Tag
public class Gay7Painting extends AnalCraftModElements.ModElement {

	public Gay7Painting(AnalCraftModElements instance) {
		super(instance, 98);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(32, 16).setRegistryName("gay_7"));
	}

}
