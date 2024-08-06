package com.ronoso.towerofascension.blocks.plants;

import com.ronoso.towerofascension.blocks.ModFlammableRotatedPillarBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;

public class MoonglowMapleLog extends ModFlammableRotatedPillarBlock {
    public MoonglowMapleLog() {
        super(Properties.copy(Blocks.OAK_LOG).strength(5f).requiresCorrectToolForDrops());
    }
}
