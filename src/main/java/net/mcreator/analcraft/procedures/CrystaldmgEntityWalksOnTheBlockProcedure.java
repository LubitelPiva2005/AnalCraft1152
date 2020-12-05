package net.mcreator.analcraft.procedures;

@AnalCraftModElements.ModElement.Tag
public class CrystaldmgEntityWalksOnTheBlockProcedure extends AnalCraftModElements.ModElement {

	public CrystaldmgEntityWalksOnTheBlockProcedure(AnalCraftModElements instance) {
		super(instance, 164);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CrystaldmgEntityWalksOnTheBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		entity.attackEntityFrom(DamageSource.GENERIC, (float) 5);

	}

}
