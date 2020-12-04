package net.mcreator.analcraft.procedures;

@AnalCraftModElements.ModElement.Tag
public class BigtreeOnStructureInstanceGeneratedProcedure extends AnalCraftModElements.ModElement {

	public BigtreeOnStructureInstanceGeneratedProcedure(AnalCraftModElements instance) {
		super(instance, 128);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BigtreeOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BigtreeOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BigtreeOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BigtreeOnStructureInstanceGenerated!");
			return;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if (((((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock()))
				&& (!((world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())))
				&& ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 3), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock()))
						&& (!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.WATER.getDefaultState()
								.getBlock()))))
				&& (((!((world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock() == Blocks.WATER.getDefaultState().getBlock()))
						&& (!((world.getBlockState(new BlockPos((int) x, (int) (y - 3), (int) z))).getBlock() == Blocks.WATER.getDefaultState()
								.getBlock())))
						&& ((!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.WATER.getDefaultState()
								.getBlock()))
								&& (!((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getBlock() == Blocks.WATER
										.getDefaultState().getBlock())))))) {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("anal_craft", "bigtree"));

				if (template != null) {
					template.addBlocksToWorld(world, new BlockPos((int) x, (int) y, (int) z),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		}

	}

}
