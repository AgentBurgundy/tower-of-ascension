package com.ronoso.towerofascension.blocks;

import com.ronoso.towerofascension.initialization.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

public class BlueGrassBlock extends GrassBlock {
    public BlueGrassBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK));
    }


    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!canBeGrass(state, world, pos)) {
            world.setBlock(pos, BlockInit.PURP_DIRT.get().defaultBlockState(), 3);
        } else {
            // Check for block spreading as normal grass does
            spreadGrass(state, world, pos, random, 3, 1);
        }
    }

    // Custom method to check if this block can be grass under current conditions
    private boolean canBeGrass(BlockState state, ServerLevel world, BlockPos pos) {
        BlockPos blockpos = pos.above();
        return world.getRawBrightness(blockpos, 0) >= 9;
    }

    // Custom method to handle spreading of grass
    private void spreadGrass(BlockState state, ServerLevel world, BlockPos pos, RandomSource random, int spreadChance, int spreadCount) {
        if (!world.isAreaLoaded(pos, 3)) return; // Prevent loading unloaded chunks when checking neighbor's light
        if (world.getMaxLocalRawBrightness(pos.above()) >= 9) {
            // Try to spread the grass multiple times
            for (int i = 0; i < spreadChance * spreadCount; ++i) {
                BlockPos targetPos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                BlockState targetBlockState = world.getBlockState(targetPos);
                BlockPos aboveTargetPos = targetPos.above();
                BlockState aboveTargetBlockState = world.getBlockState(aboveTargetPos);

                // Check if target block is PurpDirt and above it is air and light is sufficient
                if (targetBlockState.getBlock() == BlockInit.PURP_DIRT.get() &&
                        aboveTargetBlockState.isAir() &&
                        world.getRawBrightness(aboveTargetPos, 0) >= 4) {
                    world.setBlock(targetPos, this.defaultBlockState(), 3);
                }
            }
        }
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, net.minecraft.core.Direction facing, IPlantable plantable) {
        PlantType type = plantable.getPlantType(world, pos.relative(facing));
        if (type == PlantType.PLAINS) return true;
        // Additional conditions can be added here based on what types of plants you want to support
        return super.canSustainPlant(state, world, pos, facing, plantable);
    }


    // Check conditions to spread grass to the target block
    private boolean canSpreadGrassTo(ServerLevel world, BlockPos pos) {
        BlockState state = world.getBlockState(pos.above());
        return state.isAir() && state.getLightBlock(world, pos.above()) <= 4;
    }
}
