package com.github.fourmisain.axesareweapons;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Jankson;
import com.github.fourmisain.axesareweapons.config.AxesAreWeaponsConfig;

public final class AxesAreWeapons {

  public static final String MOD_ID = "axesareweapons";
  @SuppressWarnings("unused")
  public static final Logger LOGGER = LogUtils.getLogger();
  public static volatile DynamicRegistryManager serverRegistryManager = null, clientRegistryManager = null;

  public final static AxesAreWeaponsConfig CONFIG;

  static {
    Jankson jankson = new Jankson.Builder().registerSerializer(Identifier.class, ((identifier, marshaller) -> marshaller.serialize(identifier.toString()))).registerDeserializer(String.class, Identifier.class, (object, marshaller) -> Identifier.of(object)).build();
    ConfigHolder<AxesAreWeaponsConfig> configHolder = AutoConfig.register(AxesAreWeaponsConfig.class, (config, configClass) -> new JanksonConfigSerializer<>(config, configClass, jankson));
    CONFIG = configHolder.getConfig();
  }

  public static void commonInit() {
  }

  public static boolean isAxe(Item item) {
    return item instanceof AxeItem;
  }

  public static boolean isSpeedyWeb(Item item, BlockState state) {
    return CONFIG.fastCobWebBreaking && state.getBlock() == Blocks.COBWEB && isAxe(item);
  }
}