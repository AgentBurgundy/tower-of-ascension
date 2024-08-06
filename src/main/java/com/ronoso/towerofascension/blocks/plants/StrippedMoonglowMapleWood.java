package com.ronoso.towerofascension.blocks.plants;

import com.ronoso.towerofascension.blocks.ModFlammableRotatedPillarBlock;
import net.minecraft.world.level.block.Blocks;

public class StrippedMoonglowMapleWood extends ModFlammableRotatedPillarBlock {
    public StrippedMoonglowMapleWood() {
        super(Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(5f).requiresCorrectToolForDrops());
    }
}
