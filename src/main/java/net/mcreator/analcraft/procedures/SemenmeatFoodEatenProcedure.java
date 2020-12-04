package net.mcreator.analcraft.procedures;

@AnalCraftModElements.ModElement.Tag
public class SemenmeatFoodEatenProcedure extends AnalCraftModElements.ModElement {

	public SemenmeatFoodEatenProcedure(AnalCraftModElements instance) {
		super(instance, 137);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SemenmeatFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 60, (int) 2));

	}

}
