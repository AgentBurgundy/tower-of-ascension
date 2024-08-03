package com.ronoso.towerofascension.initialization;

import com.ronoso.towerofascension.TowerOfAscension;
import com.ronoso.towerofascension.blocks.BlueGrassBlock;
import com.ronoso.towerofascension.blocks.PurpDirt;
import com.ronoso.towerofascension.blocks.plants.MoonFlowerBlock;
import com.ronoso.towerofascension.blocks.plants.MoonglowMapleLog;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TowerOfAscension.MODID);

    // BLUE GRASS AND PURP DIRT
    public static final RegistryObject<Block> BLUE_GRASS_BLOCK = BLOCKS.register("blue_grass_block",
            BlueGrassBlock::new);
    public static final RegistryObject<Block> PURP_DIRT = BLOCKS.register("purp_dirt",
            PurpDirt::new);

    public static final RegistryObject<Block> MOONFLOWER = BLOCKS.register("moonflower", MoonFlowerBlock::new);

    // Moonglow Maple
    public static final RegistryObject<Block> MOONGLOW_MAPLE_LOG = BLOCKS.register("moonglow_maple_log", MoonglowMapleLog::new);

    @SubscribeEvent
    public static void onRegisterItems(final RegisterEvent event) {
        if (event.getRegistryKey().equals(ForgeRegistries.Keys.ITEMS)){
            BLOCKS.getEntries().forEach( (blockRegistryObject) -> {
                Block block = blockRegistryObject.get();
                Item.Properties properties = new Item.Properties().tab(ItemInit.ModCreativeTab.instance);
                Supplier<Item> blockItemFactory = () -> new BlockItem(block, properties);
                event.register(ForgeRegistries.Keys.ITEMS, blockRegistryObject.getId(), blockItemFactory);
            });
        }
    }
}
