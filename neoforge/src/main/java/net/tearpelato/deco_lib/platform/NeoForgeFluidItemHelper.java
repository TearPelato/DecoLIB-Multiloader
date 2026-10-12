package net.tearpelato.deco_lib.platform;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.fluid.FluidResource;
import net.tearpelato.deco_lib.platform.services.FluidItemHelper;

public class NeoForgeFluidItemHelper implements FluidItemHelper {

    @Override
    public Fluid getFluidFromItemStack(ItemStack stack) {
        if (stack.isEmpty()) return Fluids.EMPTY;

        ResourceHandler<FluidResource> handler = ItemAccess.forStack(stack).getCapability(Capabilities.Fluid.ITEM);

        if (handler == null) return Fluids.EMPTY;

        for (int i = 0; i < handler.size(); i++) {
            FluidResource resource = handler.getResource(i);
            if (!resource.isEmpty() && handler.getAmountAsLong(i) > 0) {
                return resource.getFluid();
            }
        }
        return Fluids.EMPTY;
    }
}