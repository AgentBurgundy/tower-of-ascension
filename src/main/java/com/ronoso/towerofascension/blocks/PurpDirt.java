package com.ronoso.towerofascension.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SpreadingSnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

public class PurpDirt extends SpreadingSnowyDirtBlock {
    public PurpDirt() {
        super(BlockBehaviour.Properties.copy(Blocks.DIRT));
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, net.minecraft.core.Direction facing, IPlantable plantable) {
        PlantType type = plantable.getPlantType(world, pos.relative(facing));
        if (type == PlantType.PLAINS) return true;
        // Additional conditions can be added here based on what types of plants you want to support
        return super.canSustainPlant(state, world, pos, facing, plantable);
    }
}
