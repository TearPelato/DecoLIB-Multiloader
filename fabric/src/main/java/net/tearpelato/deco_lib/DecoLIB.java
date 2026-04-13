package net.tier1234.deco_lib;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.tier1234.deco_lib.api.fluid.renderer.FluidRenderHelperRegistry;
import net.tier1234.deco_lib.fluid.FabricFluidRenderHelper;

public class DecoLIB implements ModInitializer, ClientModInitializer {
    @Override
    public void onInitialize() {

    }

    @Override
    public void onInitializeClient() {
        FluidRenderHelperRegistry.register(new FabricFluidRenderHelper());
    }
}
