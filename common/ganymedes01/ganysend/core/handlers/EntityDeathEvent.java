package ganymedes01.ganysend.core.handlers;

import ganymedes01.ganysend.core.utils.CustomDamageSources;
import ganymedes01.ganysend.core.utils.HeadsHelper;

import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

/**
 * Gany's End
 * 
 * @author ganymedes01
 * 
 */

public class EntityDeathEvent {

	@ForgeSubscribe
	public void modDeathEvent(LivingDeathEvent event) {
		if (event.entityLiving.worldObj.isRemote)
			return;
		Random rand = new Random();
		ItemStack stack = HeadsHelper.getHeadfromEntity(event.entityLiving);
		if (stack != null)
			if (event.source == CustomDamageSources.beheading || rand.nextInt(100) == 50) {
				event.entityLiving.entityDropItem(stack, rand.nextFloat());
				if (event.isCancelable())
					event.setCanceled(true);
			}
	}
}
