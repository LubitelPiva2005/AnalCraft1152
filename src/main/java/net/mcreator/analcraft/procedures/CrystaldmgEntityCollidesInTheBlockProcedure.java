package net.mcreator.analcraft.procedures;

@AnalCraftModElements.ModElement.Tag
public class CrystaldmgEntityCollidesInTheBlockProcedure extends AnalCraftModElements.ModElement {

	public CrystaldmgEntityCollidesInTheBlockProcedure(AnalCraftModElements instance) {
		super(instance, 163);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CrystaldmgEntityCollidesInTheBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		entity.attackEntityFrom(DamageSource.GENERIC, (float) 5);

	}

}
