package net.tearpelato.deco_lib.platform;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.tearpelato.deco_lib.platform.services.FluidRenderHelper;

public class NeoForgeFluidRenderHelper implements FluidRenderHelper {

    @Override
    public TextureAtlasSprite getStillTexture(Fluid fluid) {
        IClientFluidTypeExtensions ext = IClientFluidTypeExtensions.of(fluid);
        ResourceLocation loc = ext.getStillTexture();
        return Minecraft.getInstance()
                .getTextureAtlas(TextureAtlas.LOCATION_BLOCKS)
                .apply(loc);
    }

    @Override
    public int getTintColor(Fluid fluid, Level level, BlockPos pos) {
        IClientFluidTypeExtensions ext = IClientFluidTypeExtensions.of(fluid);
        return ext.getTintColor(fluid.defaultFluidState(), level, pos);
    }

    @Override
    public RenderType getRenderLayer(Fluid fluid) {
        return ItemBlockRenderTypes.getRenderLayer(fluid.defaultFluidState());
    }
}
