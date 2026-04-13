package net.tier1234.deco_lib.api.fluid.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.FastColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.tier1234.deco_lib.api.fluid.block_entity.FluidContainerBlockEntity;
import org.joml.Matrix4f;

public class FluidContainerRenderer {

    public static void drawContainer(
            Level world, BlockPos pos,
            FluidContainerBlockEntity be,
            AABB box,
            PoseStack ms, MultiBufferSource buf, int light) {

        Fluid fluid = be.getFluid();
        if (fluid == Fluids.EMPTY) return;

        FluidRenderData data = FluidRenderHelperRegistry.get()
                .getFluidRenderData(fluid, be.getStoredAmount(), world, pos);
        if (data == null || data.still() == null) return;

        TextureAtlasSprite still = data.still();
        int color = data.color();

        float r = ((color >> 16) & 0xFF) / 255f;
        float g = ((color >> 8)  & 0xFF) / 255f;
        float b = ( color        & 0xFF) / 255f;
        // alpha dal canale ARGB, fallback 1.0
        int rawA = (color >> 24) & 0xFF;
        float a = rawA == 0 ? 1.0f : rawA / 255f;

        float fullness = (float) be.getStoredAmount() / be.getCapacity();
        float y = (float) box.minY + (float)(box.maxY - box.minY) * fullness;
        y = Math.min((float) box.maxY, Math.max((float) box.minY, y));

        float u0 = still.getU((float)(box.minX - Math.floor(box.minX)));
        float u1 = still.getU((float)(box.maxX - Math.floor(box.minX)));
        float v0 = still.getV((float)(box.minZ - Math.floor(box.minZ)));
        float v1 = still.getV((float)(box.maxZ - Math.floor(box.minZ)));

        // translucentMovingBlock non esiste su vanilla — usiamo translucent
        // Le implementazioni platform possono override il RenderType se necessario
        VertexConsumer vc = buf.getBuffer(getFluidRenderType());
        Matrix4f mat = ms.last().pose();

        vc.addVertex(mat, (float) box.minX, y, (float) box.minZ).setColor(r,g,b,a).setUv(u0,v0).setLight(light).setNormal(ms.last(), 0,1,0);
        vc.addVertex(mat, (float) box.minX, y, (float) box.maxZ).setColor(r,g,b,a).setUv(u0,v1).setLight(light).setNormal(ms.last(), 0,1,0);
        vc.addVertex(mat, (float) box.maxX, y, (float) box.maxZ).setColor(r,g,b,a).setUv(u1,v1).setLight(light).setNormal(ms.last(), 0,1,0);
        vc.addVertex(mat, (float) box.maxX, y, (float) box.minZ).setColor(r,g,b,a).setUv(u1,v0).setLight(light).setNormal(ms.last(), 0,1,0);
    }

    protected static RenderType getFluidRenderType() {
        return RenderType.translucent();
    }

    public static AABB createRotatedBox(
            Direction dir,
            double minX, double minY, double minZ,
            double maxX, double maxY, double maxZ) {

        minX /= 16.0; minY /= 16.0; minZ /= 16.0;
        maxX /= 16.0; maxY /= 17.0; maxZ /= 16.0;

        return switch (dir) {
            case WEST  -> new AABB(1-maxX, minY, 1-maxZ, 1-minX, maxY, 1-minZ);
            case NORTH -> new AABB(  minZ, minY, 1-maxX,   maxZ, maxY, 1-minX);
            case SOUTH -> new AABB(1-minZ, minY,   minX, 1-maxZ, maxY,   maxX);
            default    -> new AABB(  minX, minY,   minZ,   maxX, maxY,   maxZ);
        };
    }
}