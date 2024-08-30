package com.github.fourmisain.axesareweapons;

import com.github.fourmisain.axesareweapons.config.AxesAreWeaponsConfig;
import com.github.fourmisain.axesareweapons.config.IdentifierGuiProvider;
import com.github.fourmisain.axesareweapons.config.StringSetGuiProvider;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.util.Identifier;

public class AxesAreWeaponsClient {

  public static void clientInit() {
    StringSetGuiProvider<Identifier> guiProvider = new StringSetGuiProvider<>(Identifier.class, Identifier::of);
    AutoConfig.getGuiRegistry(AxesAreWeaponsConfig.class).registerPredicateProvider(guiProvider, guiProvider.getPredicate());
    AutoConfig.getGuiRegistry(AxesAreWeaponsConfig.class).registerTypeProvider(new IdentifierGuiProvider(), Identifier.class);
  }
}