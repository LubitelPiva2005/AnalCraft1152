package net.mcreator.analcraft.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.analcraft.AnalCraftModElements;

import java.util.Map;

@AnalCraftModElements.ModElement.Tag
public class RicardoEntityIsHurtProcedure extends AnalCraftModElements.ModElement {
	public RicardoEntityIsHurtProcedure(AnalCraftModElements instance) {
		super(instance, 142);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure RicardoEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 3, (int) 1));
	}
}
