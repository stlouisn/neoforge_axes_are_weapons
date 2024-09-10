package dev.axesareweapons.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "axesareweapons")
public class AxesAreWeaponsConfigData implements ConfigData {

  @ConfigEntry.Gui.Tooltip
  public volatile boolean fastCobWebBreaking = false;
}
