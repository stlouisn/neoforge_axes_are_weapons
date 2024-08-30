package com.github.fourmisain.axesareweapons.neoforge.events;

import static com.github.fourmisain.axesareweapons.AxesAreWeaponsCommon.isSpeedyWeb;

import net.minecraft.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@EventBusSubscriber
public class CobWebEvent {

  @SubscribeEvent
  public static void harvestCheck(PlayerEvent.HarvestCheck event) {
    Item item = event.getEntity().getMainHandStack().getItem();
    if (isSpeedyWeb(item, event.getTargetBlock())) {
      event.setCanHarvest(true);
    }
  }

  @SubscribeEvent
  public static void breakSpeed(PlayerEvent.BreakSpeed event) {
    Item item = event.getEntity().getMainHandStack().getItem();
    if (isSpeedyWeb(item, event.getState())) {
      event.setNewSpeed(Math.max(event.getOriginalSpeed(), 15f));
    }
  }
}