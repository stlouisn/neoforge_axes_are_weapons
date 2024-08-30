package com.github.fourmisain.axesareweapons.fabric;

import com.github.fourmisain.axesareweapons.AxesAreWeaponsClient;
import com.github.fourmisain.axesareweapons.AxesAreWeaponsCommon;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

public final class AxesAreWeapons implements ModInitializer, ClientModInitializer {

  @Override
  public void onInitialize() {
    AxesAreWeaponsCommon.commonInit();
  }

  @Override
  public void onInitializeClient() {
    AxesAreWeaponsClient.clientInit();
  }
}