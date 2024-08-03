package com.ronoso.towerofascension.initialization;

import com.ronoso.towerofascension.TowerOfAscension;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.world.item.Items.DIAMOND_SWORD;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TowerOfAscension.MODID);

    // Register Items Here

    public static class ModCreativeTab extends CreativeModeTab {
        private ModCreativeTab(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DIAMOND_SWORD);
        }

        public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.TABS.length, "tower_of_ascension");
    }
}
