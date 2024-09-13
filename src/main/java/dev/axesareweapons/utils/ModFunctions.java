package dev.axesareweapons.utils;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;

public final class ModFunctions {

  public static boolean isAxe(Item item) {
    return item instanceof AxeItem;
  }
}
