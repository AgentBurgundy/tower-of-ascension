package com.ronoso.towerofascension.blocks.plants;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MoonglowMapleSapling extends SaplingBlock {
    public MoonglowMapleSapling(AbstractTreeGrower grower) {
        super(grower, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
                .noCollission()
                .randomTicks()
                .instabreak());
    }
}
