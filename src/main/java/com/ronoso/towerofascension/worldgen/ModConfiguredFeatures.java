package com.ronoso.towerofascension.worldgen;

import com.ronoso.towerofascension.TowerOfAscension;
import com.ronoso.towerofascension.initialization.BlockInit;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, TowerOfAscension.MODID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> MOONGLOW_MAPLE =
            CONFIGURED_FEATURES.register("moonglow_maple", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(BlockInit.MOONGLOW_MAPLE_LOG.get()),
                            new StraightTrunkPlacer(5, 6, 3),
                            BlockStateProvider.simple(BlockInit.MOONGLOW_MAPLE_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)
                    ).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> MOONGLOW_MAPLE_SPAWN =
            CONFIGURED_FEATURES.register("moonglow_maple_spawn", () ->
                    new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                            new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                                    ModPlacedFeatures.MOONGLOW_MAPLE_CHECKED.getHolder().get(),
                                    0.5F)), ModPlacedFeatures.MOONGLOW_MAPLE_CHECKED.getHolder().get()))
                    );

    public static void register(IEventBus bus) {
        CONFIGURED_FEATURES.register(bus);
    }
}
