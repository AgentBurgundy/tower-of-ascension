package com.ronoso.towerofascension.datagen;

import com.ronoso.towerofascension.TowerOfAscension;
import com.ronoso.towerofascension.initialization.BlockInit;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.data.models.model.TextureMapping.cubeBottomTop;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, TowerOfAscension.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock(BlockInit.MOONGLOW_MAPLE_LOG);
        simpleBlockWithItem(BlockInit.PURP_DIRT, cubeAll(BlockInit.PURP_DIRT.get()));
        simpleBlockWithItem(BlockInit.MOONGLOW_MAPLE_LEAVES, cubeAll(BlockInit.MOONGLOW_MAPLE_LEAVES.get()));

        registerTallFlower(BlockInit.MOONFLOWER, "moonflower_bottom", "moonflower_top");
        cubeBottomTopBlock(BlockInit.BLUE_GRASS_BLOCK, modLoc("block/purp_dirt"), modLoc("block/blue_grass_block_top"), modLoc("block/blue_grass_block_side"));

    }

    private void logBlock(RegistryObject<Block> block) {
        axisBlock((RotatedPillarBlock) block.get(), modLoc("block/" + block.getId().getPath()), modLoc("block/" + block.getId().getPath() + "_top"));
        simpleBlockItem(block.get(), models().getExistingFile(block.getId()));
    }

    // Helper method to create a cube model with different textures for bottom, top, and sides
    private void cubeBottomTopBlock(RegistryObject<Block> block, ResourceLocation bottom, ResourceLocation top, ResourceLocation sides) {
        simpleBlock(block.get(), models().cubeBottomTop(block.getId().getPath(), sides, bottom, top ));
        simpleBlockItem(block.get(), models().getExistingFile(block.getId()));
    }

    private void simpleBlockWithItem(RegistryObject<Block> block, ModelFile model) {
        simpleBlock(block.get(), model);
        simpleBlockItem(block.get(), models().getExistingFile(block.getId()));
    }

    // I hate this fucking method, but it creates the correct JSON structure we need for double tall flowers...
    private void registerTallFlower(RegistryObject<Block> block, String bottomTexture, String topTexture) {
        // Register bottom part
        getVariantBuilder(block.get())
                .partialState().with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER)
                .modelForState().modelFile(models().cross(block.getId().getPath() + "_bottom", modLoc("block/" + bottomTexture)))
                .addModel();

        // Register top part
        getVariantBuilder(block.get())
                .partialState().with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER)
                .modelForState().modelFile(models().withExistingParent(block.getId().getPath() + "_top", modLoc("block/" + topTexture))
                        .texture("particle", modLoc("block/" + topTexture + "_front"))
                        .texture("cross", modLoc("block/" + topTexture))
                        .texture("front", modLoc("block/" + topTexture + "_front"))
                        .texture("back", modLoc("block/" + topTexture + "_back"))
                        .element().from(0.8f, 0f, 8f).to(15.2f, 8f, 8f)
                            .rotation().origin(8f, 8f, 8f).axis(Direction.Axis.Y).angle(45f).rescale(true).end()
                            .shade(false)
                            .face(Direction.NORTH).uvs(0, 8, 16, 16).texture("#cross").end()
                            .face(Direction.SOUTH).uvs(0, 8, 16, 16).texture("#cross").end()
                            .end()
                        .element().from(8f, 0f, .8f).to(8f, 8f, 15.2f)
                            .rotation().origin(8f,8f,8f).axis(Direction.Axis.Y).angle(45f).rescale(true).end()
                            .shade(false)
                            .face(Direction.WEST).uvs(0, 8, 16, 16).texture("#cross").end()
                            .face(Direction.EAST).uvs(0, 8, 16, 16).texture("#cross").end()
                            .end()
                        .element().from(9.6f, -1, 1).to(9.6f, 15f, 15f)
                            .rotation().origin(8f,8f,8f).axis(Direction.Axis.Y).angle(22.5f).rescale(true).end()
                            .shade(false)
                            .face(Direction.WEST).uvs(0, 0, 16, 16).texture("#back").end()
                            .face(Direction.EAST).uvs(0, 0, 16, 16).texture("#front").end()
                            .end()
                )
                .addModel();

        // Build the item for the flower
        itemModels().withExistingParent(block.getId().getPath(), modLoc("item/moonflower"))
                .texture("layer0", modLoc("block/" + block.getId().getPath() + "_top_front"));
    }

}
