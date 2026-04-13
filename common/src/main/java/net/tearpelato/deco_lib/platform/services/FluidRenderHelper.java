package net.tearpelato.deco_lib.platform.services;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.tearpelato.deco_lib.platform.Services;

public interface FluidRenderHelper {
    ResourceLocation getStillTexture(Fluid fluid);
    int getTintColor(Fluid fluid, Level level, BlockPos pos);
    RenderType getRenderLayer(FluidState state);

    static FluidRenderHelper get() {
        return Services.load(FluidRenderHelper.class);
    }
}