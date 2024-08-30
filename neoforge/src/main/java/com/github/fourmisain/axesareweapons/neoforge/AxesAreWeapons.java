package com.github.fourmisain.axesareweapons.neoforge;

import com.github.fourmisain.axesareweapons.AxesAreWeaponsClient;
import com.github.fourmisain.axesareweapons.AxesAreWeaponsCommon;
import com.github.fourmisain.axesareweapons.config.AxesAreWeaponsConfig;
import com.github.fourmisain.axesareweapons.neoforge.events.CobWebEventHandler;
import me.shedaniel.autoconfig.AutoConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;

@Mod(AxesAreWeaponsCommon.MOD_ID)
public final class AxesAreWeapons {

  public AxesAreWeapons(IEventBus modEventBus) {
    AxesAreWeaponsCommon.commonInit();
    AxesAreWeaponsClient.clientInit();

    ModLoadingContext.get()
        .registerExtensionPoint(IConfigScreenFactory.class, () -> (client, parent) -> AutoConfig.getConfigScreen(AxesAreWeaponsConfig.class, parent).get());

    modEventBus.addListener(this::loadComplete);
  }

  private void loadComplete(final FMLLoadCompleteEvent event) {
    NeoForge.EVENT_BUS.register(CobWebEventHandler.class);
  }
}