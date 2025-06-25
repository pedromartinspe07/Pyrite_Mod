package net.pedromartss.pyritemod.datagen;

import net.pedromartss.pyritemod.PyriteMod;
import net.pedromartss.pyritemod.block.ModBlocks;
import net.pedromartss.pyritemod.block.custom.PyriteLampBlock;
import net.pedromartss.pyritemod.block.custom.PeachCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PyriteMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.PYRITE_BLOCK);
        blockWithItem(ModBlocks.RAW_PYRITE_BLOCK);

        blockWithItem(ModBlocks.PYRITE_ORE);
        blockWithItem(ModBlocks.PYRITE_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.PYRITE_END_ORE);
        blockWithItem(ModBlocks.PYRITE_NETHER_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock(ModBlocks.PYRITE_STAIRS.get(), blockTexture(ModBlocks.PYRITE_BLOCK.get()));
        slabBlock(ModBlocks.PYRITE_SLAB.get(), blockTexture(ModBlocks.PYRITE_BLOCK.get()), blockTexture(ModBlocks.PYRITE_BLOCK.get()));

        buttonBlock(ModBlocks.PYRITE_BUTTON.get(), blockTexture(ModBlocks.PYRITE_BLOCK.get()));
        pressurePlateBlock(ModBlocks.PYRITE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.PYRITE_BLOCK.get()));

        fenceBlock(ModBlocks.PYRITE_FENCE.get(), blockTexture(ModBlocks.PYRITE_BLOCK.get()));
        fenceGateBlock(ModBlocks.PYRITE_FENCE_GATE.get(), blockTexture(ModBlocks.PYRITE_BLOCK.get()));
        wallBlock(ModBlocks.PYRITE_WALL.get(), blockTexture(ModBlocks.PYRITE_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.PYRITE_DOOR.get(), modLoc("block/pyrite_door_bottom"), modLoc("block/pyrite_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.PYRITE_TRAPDOOR.get(), modLoc("block/pyrite_trapdoor"), true, "cutout");

        blockItem(ModBlocks.PYRITE_STAIRS);
        blockItem(ModBlocks.PYRITE_SLAB);
        blockItem(ModBlocks.PYRITE_PRESSURE_PLATE);
        blockItem(ModBlocks.PYRITE_FENCE_GATE);
        blockItem(ModBlocks.PYRITE_TRAPDOOR, "_bottom");

        customLamp();

        makeCrop(((CropBlock) ModBlocks.PEACH_CROP.get()), "peach_crop_stage", "peach_crop_stage");
        makeBush(((SweetBerryBushBlock) ModBlocks.GOLDEN_RASPBERRY_BUSH.get()), "golden_raspberry_bush_stage", "golden_raspberry_bush_stage");

        logBlock(ModBlocks.BRAZILWOOD_LOG.get());
        axisBlock(ModBlocks.BRAZILWOOD_WOOD.get(), blockTexture(ModBlocks.BRAZILWOOD_LOG.get()), blockTexture(ModBlocks.BRAZILWOOD_LOG.get()));
        logBlock(ModBlocks.STRIPPED_BRAZILWOOD_LOG.get());
        axisBlock(ModBlocks.STRIPPED_BRAZILWOOD_WOOD.get(), blockTexture(ModBlocks.STRIPPED_BRAZILWOOD_LOG.get()), blockTexture(ModBlocks.STRIPPED_BRAZILWOOD_LOG.get()));

        blockItem(ModBlocks.BRAZILWOOD_LOG);
        blockItem(ModBlocks.BRAZILWOOD_WOOD);
        blockItem(ModBlocks.STRIPPED_BRAZILWOOD_LOG);
        blockItem(ModBlocks.STRIPPED_BRAZILWOOD_WOOD);

        blockWithItem(ModBlocks.BRAZILWOOD_PLANKS);

        leavesBlock(ModBlocks.BRAZILWOOD_LEAVES);
        saplingBlock(ModBlocks.BRAZILWOOD_SAPLING);
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> {
            int age = state.getValue(SweetBerryBushBlock.AGE);
            return new ConfiguredModel[] {
                new ConfiguredModel(models().crop(modelName + age,
                    ResourceLocation.fromNamespaceAndPath(PyriteMod.MOD_ID, "block/" + textureName + age)).renderType("cutout"))
            };
        };
        getVariantBuilder(block).forAllStates(function);
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((PeachCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(PyriteMod.MOD_ID, "block/" + textureName + state.getValue(((PeachCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private ConfiguredModel[] states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cubeAll(modelName, 
            ResourceLocation.fromNamespaceAndPath(PyriteMod.MOD_ID, "block/" + textureName)).renderType("cutout"));
        return models;
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.PYRITE_LAMP.get()).forAllStates(state -> {
            if(state.getValue(PyriteLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("pyrite_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(PyriteMod.MOD_ID, "block/" + "pyrite_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("pyrite_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(PyriteMod.MOD_ID, "block/" + "pyrite_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.PYRITE_LAMP.get(), models().cubeAll("pyrite_lamp_on",
                ResourceLocation.fromNamespaceAndPath(PyriteMod.MOD_ID, "block/" + "pyrite_lamp_on")));
    }

    private void buttonBlock(Block block, ResourceLocation texture) {
        simpleBlock(block, models().button(
            ForgeRegistries.BLOCKS.getKey(block).getPath(),
            texture
        ));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("pyritemod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("pyritemod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
