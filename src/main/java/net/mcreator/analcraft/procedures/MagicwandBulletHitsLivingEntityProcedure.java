package net.mcreator.analcraft.procedures;

@AnalCraftModElements.ModElement.Tag
public class MagicwandBulletHitsLivingEntityProcedure extends AnalCraftModElements.ModElement {

	public MagicwandBulletHitsLivingEntityProcedure(AnalCraftModElements instance) {
		super(instance, 166);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure MagicwandBulletHitsLivingEntity!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 1));

	}

}
