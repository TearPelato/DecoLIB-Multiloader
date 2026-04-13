package net.tearpelato.deco_lib.api.fluid.util;


import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.tearpelato.deco_lib.platform.services.FluidItemHelper;

public class FluidInteractionUtil {
    public static Fluid getFluidFromItemStack(ItemStack stack) {
        if (stack.isEmpty()) return Fluids.EMPTY;
        return FluidItemHelper.get().getFluidFromItemStack(stack);
    }
}