package net.mcreator.analcraft.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.analcraft.AnalCraftModElements;

import java.util.Map;

@AnalCraftModElements.ModElement.Tag
public class TrusiLeggingsTickEventProcedure extends AnalCraftModElements.ModElement {
	public TrusiLeggingsTickEventProcedure(AnalCraftModElements instance) {
		super(instance, 141);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure TrusiLeggingsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 60, (int) 1));
	}
}
