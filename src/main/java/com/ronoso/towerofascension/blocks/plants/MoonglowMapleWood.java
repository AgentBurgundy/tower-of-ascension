package com.ronoso.towerofascension.blocks.plants;

import com.ronoso.towerofascension.blocks.ModFlammableRotatedPillarBlock;
import net.minecraft.world.level.block.Blocks;

public class MoonglowMapleWood extends ModFlammableRotatedPillarBlock {
    public MoonglowMapleWood() {
        super(Properties.copy(Blocks.OAK_WOOD).strength(5f).requiresCorrectToolForDrops());
    }
}
