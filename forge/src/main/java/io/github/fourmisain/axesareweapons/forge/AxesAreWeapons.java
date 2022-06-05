package io.github.fourmisain.axesareweapons.forge;

import io.github.fourmisain.axesareweapons.common.AxesAreWeaponsCommon;
import io.github.fourmisain.axesareweapons.common.config.AxesAreWeaponsConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import org.apache.commons.lang3.tuple.Pair;

import static io.github.fourmisain.axesareweapons.common.AxesAreWeaponsCommon.CONFIG;

@Mod(AxesAreWeaponsCommon.MOD_ID)
public class AxesAreWeapons {
	public AxesAreWeapons() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);

		// Make sure the mod being absent on the other network side does not cause the client to display the server as incompatible
		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST,
				() -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));

		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.CONFIGGUIFACTORY,
				() -> (client, parent) -> AutoConfig.getConfigScreen(AxesAreWeaponsConfig.class, parent).get());
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			// TODO: on a physical server, this executes on main but the config is read on the Server Thread
			// this might be okay since the Server Thread is most likely created afterwards
			CONFIG = AutoConfig.register(AxesAreWeaponsConfig.class, JanksonConfigSerializer::new).getConfig();
		});
	}
}
