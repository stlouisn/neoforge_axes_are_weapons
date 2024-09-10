package dev.axesareweapons;

import dev.axesareweapons.config.AxesAreWeaponsConfigData;
import dev.axesareweapons.events.CobWebEvent;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.registry.DynamicRegistryManager;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
@Mod(Constants.MOD_ID)
public final class AxesAreWeapons {

  public static final Logger LOGGER = LoggerFactory.getLogger(Constants.MOD_ID);

  public static volatile DynamicRegistryManager serverRegistryManager = null;
  public static volatile DynamicRegistryManager clientRegistryManager = null;

  public AxesAreWeapons(IEventBus modBus) {
    modBus.addListener(this::commonSetup);
    modBus.addListener(this::clientSetup);
    ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> (client, parent) -> AutoConfig.getConfigScreen(AxesAreWeaponsConfigData.class, parent).get());
    modBus.addListener(this::loadComplete);
  }

  public static boolean isAxe(Item item) {
    return item instanceof AxeItem;
  }

  public static boolean isSpeedyWeb(Item item, BlockState state) {
    return AxesAreWeaponsConfig.CONFIG.fastCobWebBreaking && state.getBlock() == Blocks.COBWEB && isAxe(item);
  }

  private void commonSetup(FMLCommonSetupEvent event) {
    event.enqueueWork(AxesAreWeaponsConfig::configInit);
  }

  private void clientSetup(FMLCommonSetupEvent event) {
    event.enqueueWork(AxesAreWeaponsClient::clientInit);
  }

  private void loadComplete(final FMLLoadCompleteEvent event) {
    NeoForge.EVENT_BUS.register(CobWebEvent.class);
  }
}