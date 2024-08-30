package com.github.fourmisain.axesareweapons.mixin;

import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static com.github.fourmisain.axesareweapons.AxesAreWeapons.isAxe;

@Mixin(value = MiningToolItem.class)
public abstract class MiningToolItemMixin extends ToolItem {

  public MiningToolItemMixin(ToolMaterial toolMaterial, Settings settings) {
    super(toolMaterial, settings);
  }

  @ModifyExpressionValue(method = "postDamageEntity", at = @At(value = "CONSTANT", args = "intValue=2"))
  public int axesareweapons$disableIncreasedAxeDurabilityLoss(int damageAmount) {
		if (isAxe(this)) {
			return 1;
		}
    return damageAmount;
  }
}