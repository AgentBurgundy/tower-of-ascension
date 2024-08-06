package com.ronoso.towerofascension.blocks.plants;

import com.ronoso.towerofascension.worldgen.MoonglowMapleTreeGrower;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MoonglowMapleSapling extends SaplingBlock {
    public MoonglowMapleSapling() {
        super(new MoonglowMapleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
                .noCollission()
                .randomTicks()
                .instabreak());
    }
}
