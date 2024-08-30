package com.github.fourmisain.axesareweapons.neoforge;

import static com.github.fourmisain.axesareweapons.AxesAreWeapons.isSpeedyWeb;

import com.github.fourmisain.axesareweapons.AxesAreWeaponsClient;
import com.github.fourmisain.axesareweapons.config.AxesAreWeaponsConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@Mod(com.github.fourmisain.axesareweapons.AxesAreWeapons.MOD_ID)
public class AxesAreWeapons {

  public static class CobWebEventHandler {

    @SubscribeEvent
    public void harvestCheck(PlayerEvent.HarvestCheck event) {
      Item item = event.getEntity().getMainHandStack().getItem();
      if (isSpeedyWeb(item, event.getTargetBlock())) {
        event.setCanHarvest(true);
      }
    }

    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
      Item item = event.getEntity().getMainHandStack().getItem();
      if (isSpeedyWeb(item, event.getState())) {
        event.setNewSpeed(Math.max(event.getOriginalSpeed(), 15f));
      }
    }
  }

  public AxesAreWeapons(IEventBus modBus) {
    modBus.addListener(this::commonSetup);
    modBus.addListener(this::clientSetup);
    NeoForge.EVENT_BUS.register(new CobWebEventHandler());
    ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> (client, parent) -> AutoConfig.getConfigScreen(AxesAreWeaponsConfig.class, parent).get());
  }

  private void commonSetup(FMLCommonSetupEvent event) {
    event.enqueueWork(com.github.fourmisain.axesareweapons.AxesAreWeapons::commonInit);
  }

  private void clientSetup(FMLClientSetupEvent event) {
    event.enqueueWork(AxesAreWeaponsClient::clientInit);
  }
}