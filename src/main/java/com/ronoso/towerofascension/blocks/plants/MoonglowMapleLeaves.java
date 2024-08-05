package com.ronoso.towerofascension.blocks.plants;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MoonglowMapleLeaves extends LeavesBlock {
    public MoonglowMapleLeaves() {
        super(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                .isSuffocating((state, world, pos) -> false)
                .isViewBlocking((state, world, pos) -> false));
    }
}
