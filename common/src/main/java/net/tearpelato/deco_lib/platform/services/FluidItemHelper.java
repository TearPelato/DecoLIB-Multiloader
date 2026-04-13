package net.tearpelato.deco_lib.platform.services;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.tearpelato.deco_lib.platform.Services;

public interface FluidItemHelper {
    Fluid getFluidFromItemStack(ItemStack stack);

    static FluidItemHelper get() {
        return Services.load(FluidItemHelper.class);
    }
}
