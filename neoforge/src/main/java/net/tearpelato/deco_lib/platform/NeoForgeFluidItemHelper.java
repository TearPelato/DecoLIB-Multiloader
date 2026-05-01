package net.tearpelato.deco_lib.platform;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;
import net.tearpelato.deco_lib.platform.services.FluidItemHelper;

public class NeoForgeFluidItemHelper implements FluidItemHelper {

    @Override
    public Fluid getFluidFromItemStack(ItemStack stack) {
        if (stack.isEmpty()) return Fluids.EMPTY;

        IFluidHandlerItem handler = stack.getCapability(Capabilities.FluidHandler.ITEM);
        if (handler == null) return Fluids.EMPTY;

        FluidStack fluidStack = handler.getFluidInTank(0);
        return fluidStack.isEmpty() ? Fluids.EMPTY : fluidStack.getFluid();
    }
}