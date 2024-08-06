package com.ronoso.towerofascension.worldgen;

import com.ronoso.towerofascension.TowerOfAscension;
import com.ronoso.towerofascension.initialization.BlockInit;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, TowerOfAscension.MODID);

    public static final RegistryObject<PlacedFeature> MOONGLOW_MAPLE_CHECKED = PLACED_FEATURES.register("moonglow_maple_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.MOONGLOW_MAPLE.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(BlockInit.MOONGLOW_MAPLE_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> MOONGLOW_MAPLE_PLACED = PLACED_FEATURES.register("moonglow_maple_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MOONGLOW_MAPLE_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2))));

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
