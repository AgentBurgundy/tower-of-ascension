package com.ronoso.towerofascension.blocks.plants;

import com.ronoso.towerofascension.TowerOfAscension;
import com.ronoso.towerofascension.initialization.BlockInit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class MoonFlowerBlock extends DoublePlantBlock {
    public MoonFlowerBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.SUNFLOWER));
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos) {
        return state.is(BlockInit.PURP_DIRT.get()) || state.is(BlockInit.BLUE_GRASS_BLOCK.get());
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            // For the upper part of the plant, check the block below is the lower part of the same plant
            BlockState blockBelow = world.getBlockState(pos.below());
            return blockBelow.getBlock() == this && blockBelow.getValue(HALF) == DoubleBlockHalf.LOWER;
        } else {
            // For the lower part of the plant, check it's on a valid soil block
            BlockState groundState = world.getBlockState(pos.below());
            return groundState.is(BlockInit.PURP_DIRT.get()) || groundState.is(BlockInit.BLUE_GRASS_BLOCK.get());
        }
    }
}
