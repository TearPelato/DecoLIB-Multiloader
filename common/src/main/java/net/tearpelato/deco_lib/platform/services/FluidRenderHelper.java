package net.tearpelato.deco_lib.platform.services;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.tearpelato.deco_lib.platform.Services;

public interface FluidRenderHelper {

    TextureAtlasSprite getStillTexture(Fluid fluid);
    int getTintColor(Fluid fluid, Level level, BlockPos pos);
    RenderType getRenderLayer(Fluid fluid);

    static FluidRenderHelper get() {
        return Services.FLUID_RENDER_HELPER;
    }
}