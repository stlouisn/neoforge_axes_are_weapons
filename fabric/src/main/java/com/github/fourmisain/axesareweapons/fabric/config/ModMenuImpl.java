package com.github.fourmisain.axesareweapons.fabric.config;

import com.github.fourmisain.axesareweapons.config.AxesAreWeaponsConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;

public class ModMenuImpl implements ModMenuApi {

  @Override
  public ConfigScreenFactory<?> getModConfigScreenFactory() {
    return parent -> AutoConfig.getConfigScreen(AxesAreWeaponsConfig.class, parent).get();
  }
}