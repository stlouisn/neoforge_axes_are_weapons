package dev.axesareweapons;

import dev.axesareweapons.config.AxesAreWeaponsConfigData;
import dev.axesareweapons.config.IdentifierGuiProvider;
import dev.axesareweapons.config.StringSetGuiProvider;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.util.Identifier;

public class AxesAreWeaponsClient {

  public static void clientInit() {
    StringSetGuiProvider<Identifier> guiProvider = new StringSetGuiProvider<>(Identifier.class, Identifier::of);
    AutoConfig.getGuiRegistry(AxesAreWeaponsConfigData.class).registerPredicateProvider(guiProvider, guiProvider.getPredicate());
    AutoConfig.getGuiRegistry(AxesAreWeaponsConfigData.class).registerTypeProvider(new IdentifierGuiProvider(), Identifier.class);
  }
}