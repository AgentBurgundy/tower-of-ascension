package com.ronoso.towerofascension.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class MoonglowMapleTreeGrower extends AbstractTreeGrower {

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean pLargeHive) {
        return ModConfiguredFeatures.MOONGLOW_MAPLE.getHolder().get();
    }
}
