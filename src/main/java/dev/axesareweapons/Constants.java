package dev.axesareweapons;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;

public final class Constants {

  public static final String MOD_ID = "axesareweapons";

  public static boolean isAxe(Item item) { return item instanceof AxeItem; }
}
