package net.tearpelato.deco_lib.core.registries.helper;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

/**
 * Author: MrCrayfish
 */
@FunctionalInterface
public interface BlockEntityRendererRegister
{
    <T extends BlockEntity> void apply(BlockEntityType<? extends T> type, BlockEntityRendererProvider<T> provider);
}
