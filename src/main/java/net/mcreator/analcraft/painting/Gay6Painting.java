
package net.mcreator.analcraft.painting;

@AnalCraftModElements.ModElement.Tag
public class Gay6Painting extends AnalCraftModElements.ModElement {

	public Gay6Painting(AnalCraftModElements instance) {
		super(instance, 97);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(32, 32).setRegistryName("gay_6"));
	}

}
