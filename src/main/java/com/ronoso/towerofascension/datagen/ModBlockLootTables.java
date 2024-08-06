package com.ronoso.towerofascension.datagen;

import com.ronoso.towerofascension.initialization.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {
        // Here is where we define loot tables. There's a fancy helper method to make some of these easier.
        this.dropSelf(BlockInit.MOONGLOW_MAPLE_LOG.get());
        this.dropSelf(BlockInit.MOONGLOW_MAPLE_WOOD.get());
        this.dropSelf(BlockInit.MOONGLOW_MAPLE_PLANKS.get());
        this.dropSelf(BlockInit.STRIPPED_MOONGLOW_MAPLE_WOOD.get());
        this.dropSelf(BlockInit.STRIPPED_MOONGLOW_MAPLE_LOG.get());
        this.dropSelf(BlockInit.MOONGLOW_MAPLE_SAPLING.get());

        this.add(BlockInit.MOONGLOW_MAPLE_LEAVES.get(), (block) ->
                createLeavesDrops(block, BlockInit.MOONGLOW_MAPLE_LEAVES.get(), 0.05f));

        this.dropSelf(BlockInit.BLUE_GRASS_BLOCK.get());
        this.dropSelf(BlockInit.PURP_DIRT.get());
        this.dropSelf(BlockInit.MOONFLOWER.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        // This magical line of code seems to map all the entries to an iterable from the blocks we define in BlockInit
        // This means ALL blocks must define a loot table
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
