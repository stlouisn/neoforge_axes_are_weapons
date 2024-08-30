package com.github.fourmisain.axesareweapons.mixin;

import com.github.fourmisain.axesareweapons.AxesAreWeaponsCommon;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {

  @Shadow
  public abstract DynamicRegistryManager.Immutable getRegistryManager();

  @Inject(method = "runServer", at = @At("HEAD"))
  private void setRegistryManager(CallbackInfo ci) {
    AxesAreWeaponsCommon.serverRegistryManager = getRegistryManager();
  }

  @Inject(method = "runServer", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;exit()V"))
  private void unsetRegistryManager(CallbackInfo ci) {
    AxesAreWeaponsCommon.serverRegistryManager = null;
  }
}