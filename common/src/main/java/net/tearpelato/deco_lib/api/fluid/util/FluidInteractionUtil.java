package net.tearpelato.deco_lib.api.fluid.util;


import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.tearpelato.deco_lib.platform.services.FluidItemHelper;

public class FluidInteractionUtil {
    public static Fluid getFluidFromItemStack(ItemStack stack) {
        return FluidItemHelper.get().getFluidFromItemStack(stack);
    }
}