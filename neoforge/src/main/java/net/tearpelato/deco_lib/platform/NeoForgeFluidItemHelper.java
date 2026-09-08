package net.tearpelato.deco_lib.platform;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.tearpelato.deco_lib.platform.services.FluidItemHelper;

public class NeoForgeFluidItemHelper implements FluidItemHelper {

    @Override
    public Fluid getFluidFromItemStack(ItemStack stack) {
        if (stack.isEmpty()) return Fluids.EMPTY;

        return FluidUtil.getFluidHandler(stack)
                .map(handler -> {
                    FluidStack fluidStack = handler.getFluidInTank(0);
                    return fluidStack.isEmpty() ? Fluids.EMPTY : fluidStack.getFluid();
                })
                .orElse(Fluids.EMPTY);
    }
}