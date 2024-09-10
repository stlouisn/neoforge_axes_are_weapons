package dev.axesareweapons;

import dev.axesareweapons.config.AxesAreWeaponsConfigData;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Jankson;
import net.minecraft.util.Identifier;

public final class AxesAreWeaponsConfig {

  public final static AxesAreWeaponsConfigData CONFIG;

  static {
    Jankson jankson = new Jankson.Builder().registerSerializer(Identifier.class, ((identifier, marshaller) -> marshaller.serialize(identifier.toString())))
                                           .registerDeserializer(String.class, Identifier.class, (object, marshaller) -> Identifier.of(object))
                                           .build();
    ConfigHolder<AxesAreWeaponsConfigData> configHolder = AutoConfig.register(AxesAreWeaponsConfigData.class, (config, configClass) -> new JanksonConfigSerializer<>(config, configClass, jankson));
    CONFIG = configHolder.getConfig();
  }

  public static void configInit() {
  }
}