package com.ronoso.towerofascension.blocks.plants;

import com.ronoso.towerofascension.blocks.ModFlammableRotatedPillarBlock;
import net.minecraft.world.level.block.Blocks;

public class StrippedMoonglowMapleLog extends ModFlammableRotatedPillarBlock {
    public StrippedMoonglowMapleLog() {
        super(Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(5f).requiresCorrectToolForDrops());
    }
}
