package com.github.fourmisain.axesareweapons.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@SuppressWarnings("CanBeFinal")
@Config(name = "axesareweapons")
public class AxesAreWeaponsConfig implements ConfigData {

  @ConfigEntry.Gui.Tooltip
  public volatile boolean fastCobWebBreaking = false;

}
