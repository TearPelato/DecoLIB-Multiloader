package net.tearpelato.deco_lib.fluid.impl;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;
import net.tearpelato.deco_lib.platform.services.FluidItemHelper;

public class NeoForgeFluidItemHelper implements FluidItemHelper {
    @Override
    public Fluid getFluidFromItemStack(ItemStack stack) {
        IFluidHandlerItem handler = FluidUtil.getFluidHandler(stack).orElse(null);
        if (handler != null) {
            FluidStack fluidInHandler = handler.getFluidInTank(0);
            if (!fluidInHandler.isEmpty()) return fluidInHandler.getFluid();
        }
        return Fluids.EMPTY;
    }
}
