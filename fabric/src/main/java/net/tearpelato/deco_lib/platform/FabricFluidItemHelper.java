package net.tearpelato.deco_lib.platform;

import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageView;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.tearpelato.deco_lib.platform.services.FluidItemHelper;

public class FabricFluidItemHelper implements FluidItemHelper {

    @Override
    public Fluid getFluidFromItemStack(ItemStack stack) {
        if (stack.isEmpty()) return Fluids.EMPTY;
        Storage<FluidVariant> storage = FluidStorage.ITEM.find(stack, ContainerItemContext.withConstant(stack));
        if (storage == null) return Fluids.EMPTY;
        for (StorageView<FluidVariant> view : storage) {
            if (view.isResourceBlank()) continue;
            FluidVariant variant = view.getResource();
            if (!variant.isBlank()) {
                return variant.getFluid();
            }
        }

        return Fluids.EMPTY;
    }
}