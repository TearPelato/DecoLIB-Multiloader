package net.tearpelato.deco_lib.platform;


import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.tearpelato.deco_lib.platform.services.FluidRenderHelper;

public class FabricFluidRenderHelper implements FluidRenderHelper {

    @Override
    public TextureAtlasSprite getStillTexture(Fluid fluid) {
        FluidRenderHandler handler = FluidRenderHandlerRegistry.INSTANCE.get(fluid);
      /*  if (handler == null) {
            return Minecraft.getInstance()
                    .getTextureAtlas(TextureAtlas.LOCATION_BLOCKS)
                    .apply(new ResourceLocation("minecraft", "block/water_still"));
        }*/
        return Minecraft.getInstance()
                .getTextureAtlas(TextureAtlas.LOCATION_BLOCKS)
                .apply(handler.getFluidSprites(null, null, fluid.defaultFluidState())[0].contents().name());
    }

    @Override
    public int getTintColor(Fluid fluid, Level level, BlockPos pos) {
        FluidRenderHandler handler = FluidRenderHandlerRegistry.INSTANCE.get(fluid);
        if (handler == null) return -1;
        return handler.getFluidColor(level, pos, fluid.defaultFluidState());
    }

    @Override
    public RenderType getRenderLayer(Fluid fluid) {
        return ItemBlockRenderTypes.getRenderLayer(fluid.defaultFluidState());
    }
}
